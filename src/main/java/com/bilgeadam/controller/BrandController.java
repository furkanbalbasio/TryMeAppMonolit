package com.bilgeadam.controller;

import com.bilgeadam.dto.request.BrandSaveRequestDto;
import com.bilgeadam.repository.entity.Brand;
import com.bilgeadam.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.bilgeadam.constants.RestApi.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(BRAND)
public class BrandController {

    private final BrandService brandService;

    @PostMapping(value = SAVE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Brand> saveBrand(@RequestBody @ModelAttribute BrandSaveRequestDto dto){
        return ResponseEntity.ok(brandService.saveBrand(dto));
    }

    @GetMapping("/findByBrandName")
    public ResponseEntity<Optional<Brand>> findByBrandName(@RequestParam("name") String name) {
        return ResponseEntity.ok(brandService.findByBrandName(name));
    }
}
