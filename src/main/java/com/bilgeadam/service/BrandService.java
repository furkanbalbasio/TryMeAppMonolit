package com.bilgeadam.service;

import com.bilgeadam.dto.request.BrandSaveRequestDto;
import com.bilgeadam.mapper.BrandMapper;
import com.bilgeadam.repository.BrandRepository;
import com.bilgeadam.repository.entity.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;



    public Brand saveBrand(BrandSaveRequestDto dto){
        return brandRepository.save(BrandMapper.INSTANCE.fromSaveRequestToBrand(dto));
    }

    public Optional<Brand> findByBrandName(String name){
        return brandRepository.findByBrandName(name);
    }
}
