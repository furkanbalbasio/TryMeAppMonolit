package com.bilgeadam.service;

import com.bilgeadam.config.ImgurUploader;
import com.bilgeadam.dto.request.ProductSaveRequestDto;
import com.bilgeadam.repository.ImageRepository;
import com.bilgeadam.repository.entity.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;
    private final ImgurUploader imgurUploader;

    public Image saveImage(ProductSaveRequestDto dto) throws IOException {
        List<String> imageUrls = new ArrayList<>();
        List<MultipartFile> images = dto.getImages();
        if(images.size()>0 && images.size()<5){
            for(int i = 0; i<images.size();i++) {
                String imageUrl = imgurUploader.upload(images.get(i));
                imageUrls.add(imageUrl);
            }
        } else {
            throw new RuntimeException("bir şeyler yanlış gitti...");
        }

       Image image =  Image.builder()
                .mainImageUrl(imageUrls.get(0))
                .additionalImageUrls(imageUrls.subList(1,imageUrls.size()))
                .build();

        return imageRepository.save(image);
    }
}
