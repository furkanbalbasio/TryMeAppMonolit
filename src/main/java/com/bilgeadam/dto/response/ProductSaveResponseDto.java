package com.bilgeadam.dto.response;

import com.bilgeadam.repository.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSaveResponseDto {

    private String productName;
    private Long modelId;
    private Long propertyId;
    private Long quantity;
    private Double price;
    private Long imageId;
    private Image image;


}
