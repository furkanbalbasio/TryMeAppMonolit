package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.BrandSaveRequestDto;
import com.bilgeadam.repository.entity.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BrandMapper {


    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    Brand fromSaveRequestToBrand (BrandSaveRequestDto dto);
}
