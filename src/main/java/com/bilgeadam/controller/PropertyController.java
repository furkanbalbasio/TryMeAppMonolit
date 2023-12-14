package com.bilgeadam.controller;

import com.bilgeadam.dto.request.ProductSaveRequestDto;
import com.bilgeadam.dto.request.PropertySaveRequestDto;
import com.bilgeadam.dto.response.ProductSaveResponseDto;
import com.bilgeadam.repository.entity.Property;
import com.bilgeadam.service.ProductService;
import com.bilgeadam.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static com.bilgeadam.constants.RestApi.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PROPERTY)
public class PropertyController {
    private final PropertyService propertyService;

    @PostMapping(value = SAVE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Property> saveProperty(@RequestBody @ModelAttribute PropertySaveRequestDto dto) throws IOException {
        return ResponseEntity.ok(propertyService.saveProperty(dto));
    }


}
