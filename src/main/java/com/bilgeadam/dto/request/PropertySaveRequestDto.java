package com.bilgeadam.dto.request;

import com.bilgeadam.repository.enums.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertySaveRequestDto {

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
}
