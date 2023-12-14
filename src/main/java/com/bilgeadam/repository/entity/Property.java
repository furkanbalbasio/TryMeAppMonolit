package com.bilgeadam.repository.entity;

import com.bilgeadam.repository.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="tbl_property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ECategory category;

    @Enumerated(EnumType.STRING)
    private ESubCategory subCategory;

    @Enumerated(EnumType.STRING)
    private EColor color;

    @Enumerated(EnumType.STRING)
    private ESize size;

    @Enumerated(EnumType.STRING)
    private EGender gender;
}
