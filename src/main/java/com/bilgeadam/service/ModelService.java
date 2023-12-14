package com.bilgeadam.service;

import com.bilgeadam.dto.request.ModelSaveRequestDto;
import com.bilgeadam.mapper.ModelMapper;
import com.bilgeadam.repository.ModelRepository;
import com.bilgeadam.repository.entity.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModelService {

    private final ModelRepository modelRepository;


    public Model saveModel(ModelSaveRequestDto dto){
        return modelRepository.save(ModelMapper.INSTANCE.fromSaveRequestToModel(dto));
    }

    public Optional<Model> findByModelName(String name) {
        return modelRepository.findByModelName(name);
    }
}
