package com.bilgeadam.repository.enums;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter

public enum ESubCategory {
    TSHIRT(ECategory.TOP_WEARING),
    SHIRT(ECategory.TOP_WEARING),
    SWEATSHIRT(ECategory.TOP_WEARING),
    PANTS(ECategory.BOTTOM_WEARING),
    SWEATPANTS(ECategory.BOTTOM_WEARING),
    BOOTS(ECategory.SHOES),
    COAT(ECategory.OUTERWEAR);
    private ECategory category;
}
