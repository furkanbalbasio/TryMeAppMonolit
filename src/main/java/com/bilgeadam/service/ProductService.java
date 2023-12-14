package com.bilgeadam.service;

import com.bilgeadam.dto.request.BrandSaveRequestDto;
import com.bilgeadam.dto.request.ModelSaveRequestDto;
import com.bilgeadam.dto.request.ProductSaveRequestDto;
import com.bilgeadam.dto.request.PropertySaveRequestDto;
import com.bilgeadam.dto.response.ProductSaveResponseDto;
import com.bilgeadam.mapper.ModelMapper;
import com.bilgeadam.mapper.ProductMapper;
import com.bilgeadam.mapper.PropertyMapper;
import com.bilgeadam.repository.ProductRepository;
import com.bilgeadam.repository.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final PropertyService propertyService;
    private final ModelService modelService;
    private final BrandService brandService;
    private final ImageService imageService;

    public ProductSaveResponseDto saveProduct(ProductSaveRequestDto dto) throws IOException {
        Product product = ProductMapper.INSTANCE.fromSaveRequestToProduct(dto);
        Model model = null;
        Brand brand = null;
        PropertySaveRequestDto propertySaveRequestDto = PropertyMapper.INSTANCE.fromSaveRequestToProperty(dto);
        Property property = propertyService.saveProperty(propertySaveRequestDto);
        Image image = imageService.saveImage(dto);
        Optional<Model> modelOptional = modelService.findByModelName(dto.getModelName());
        Optional<Brand> brandOptional = brandService.findByBrandName(dto.getBrandName());
        if(brandOptional.isPresent()){
            if(modelOptional.isPresent()){
                product.setModelId(modelOptional.get().getId());
            } else {
               model= modelService.saveModel(ModelSaveRequestDto.builder()
                                .brandId(brandOptional.get().getId())
                                .modelName(dto.getModelName())
                        .build());
               product.setModelId(model.getId());
            }

        } else {
          brand =  brandService.saveBrand(BrandSaveRequestDto.builder().brandName(dto.getBrandName()).build());
          model = modelService.saveModel(ModelSaveRequestDto.builder()
                  .brandId(brand.getId())
                  .modelName(dto.getModelName())
                  .build());
          product.setModelId(model.getId());
        }
        product.setPropertyId(property.getId());
        product.setImageId(image.getId());
        product = productRepository.save(product);
        ProductSaveResponseDto productSaveResponseDto = ProductMapper.INSTANCE.fromProductToSaveResponse(product);
        productSaveResponseDto.setImage(image);
        return productSaveResponseDto;
    }
}
