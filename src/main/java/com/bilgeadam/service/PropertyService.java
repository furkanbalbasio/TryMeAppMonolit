package com.bilgeadam.service;

import com.bilgeadam.dto.request.PropertySaveRequestDto;
import com.bilgeadam.mapper.PropertyMapper;
import com.bilgeadam.repository.PropertyRepository;
import com.bilgeadam.repository.entity.Property;
import com.bilgeadam.repository.enums.ECategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public Property saveProperty(PropertySaveRequestDto dto) {
        Property property = PropertyMapper.INSTANCE.fromSaveRequestToProperty(dto);


        if (propertyMismatchChecker(dto)) {
            return propertyRepository.save(property);
        } else {
            throw new RuntimeException("Type mismatch Exception");
        }


    }

    public Boolean propertyMismatchChecker(PropertySaveRequestDto dto) {

        if (dto.getCategory().equals(ECategory.TOP_WEARING)) {
            return dto.getSubCategory().getCategory().equals(ECategory.TOP_WEARING);
        } else if (dto.getCategory().equals(ECategory.BOTTOM_WEARING)) {
            return dto.getSubCategory().getCategory().equals(ECategory.BOTTOM_WEARING);
        } else if (dto.getCategory().equals(ECategory.OUTERWEAR)) {
            return dto.getSubCategory().getCategory().equals(ECategory.SHOES);
        } else if (dto.getCategory().equals(ECategory.SHOES)) {
            return dto.getSubCategory().getCategory().equals(ECategory.SHOES);
        } else {
            return false;
        }

    }

}
