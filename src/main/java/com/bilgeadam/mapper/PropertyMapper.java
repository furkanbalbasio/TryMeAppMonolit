package com.bilgeadam.mapper;


import com.bilgeadam.dto.request.ProductSaveRequestDto;
import com.bilgeadam.dto.request.PropertySaveRequestDto;
import com.bilgeadam.repository.entity.Property;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PropertyMapper {


    PropertyMapper INSTANCE = Mappers.getMapper(PropertyMapper.class);

    Property fromSaveRequestToProperty (PropertySaveRequestDto dto);
    PropertySaveRequestDto fromSaveRequestToProperty (ProductSaveRequestDto dto);
}
