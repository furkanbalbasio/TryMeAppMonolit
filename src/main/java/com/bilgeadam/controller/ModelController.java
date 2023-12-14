package com.bilgeadam.controller;

import com.bilgeadam.dto.request.ModelSaveRequestDto;
import com.bilgeadam.repository.entity.Model;
import com.bilgeadam.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.bilgeadam.constants.RestApi.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(MODEL)
public class ModelController {

    private final ModelService modelService;

    @PostMapping(value = SAVE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Model> saveModel(@RequestBody @ModelAttribute ModelSaveRequestDto dto){
        return ResponseEntity.ok(modelService.saveModel(dto));
    }

    @GetMapping("/findByModelName")
    public ResponseEntity<Optional<Model>> findByModelName(@RequestParam("name") String name){
        return ResponseEntity.ok(modelService.findByModelName(name));
    }
}
