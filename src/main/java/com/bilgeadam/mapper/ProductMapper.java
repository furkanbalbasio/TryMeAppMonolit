package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.ProductSaveRequestDto;
import com.bilgeadam.dto.response.ProductSaveResponseDto;
import com.bilgeadam.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {


    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product fromSaveRequestToProduct(ProductSaveRequestDto dto);

    ProductSaveResponseDto fromProductToSaveResponse(Product product);
}
