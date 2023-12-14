package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.ModelSaveRequestDto;
import com.bilgeadam.repository.entity.Model;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ModelMapper {


    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    Model fromSaveRequestToModel (ModelSaveRequestDto dto);
}
