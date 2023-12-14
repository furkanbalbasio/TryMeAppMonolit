package com.bilgeadam.dto.request;

import com.bilgeadam.repository.entity.Brand;
import com.bilgeadam.repository.entity.Image;
import com.bilgeadam.repository.entity.Model;
import com.bilgeadam.repository.enums.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSaveRequestDto {

    private String productName;
    private String modelName;
    private String brandName;
    @Enumerated(EnumType.STRING)
    private ECategory category;
    @Enumerated(EnumType.STRING)
    private ESubCategory subCategory;
    @Enumerated(EnumType.STRING)
    private EColor color;
    @Enumerated(EnumType.STRING)
    private ESize size;
    @Enumerated(EnumType.STRING)
    private EGender gender;
    private Long quantity;
    private Double price;
    private List<MultipartFile> images;
}
