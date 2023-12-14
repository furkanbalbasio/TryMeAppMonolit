package com.bilgeadam.controller;

import com.bilgeadam.dto.request.ProductSaveRequestDto;
import com.bilgeadam.dto.response.ProductSaveResponseDto;
import com.bilgeadam.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static com.bilgeadam.constants.RestApi.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PRODUCT)
public class ProductController {
    private final ProductService productService;

    @PostMapping(value = SAVE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductSaveResponseDto> saveProduct(@RequestBody @ModelAttribute ProductSaveRequestDto dto) throws IOException {
        return ResponseEntity.ok(productService.saveProduct(dto));
    }


}
