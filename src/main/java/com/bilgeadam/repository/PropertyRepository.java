package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Property;
import com.bilgeadam.repository.enums.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property,Long> {

////    @Query("SELECT e FROM Property e WHERE e.category =:category AND e.color =:color AND e.gender=:gender AND e.size=:size AND e.subCategory=:subCategory")
//    List<Property> existsPropertyByCategoryAndColorAndSubCategoryAndSizeAndGender(@Param("category")ECategory category,
//                                                                                  @Param("color")EColor color,
//                                                                                  @Param("gender")EGender gender,
//                                                                                  @Param("size")ESize size,
//                                                                                  @Param("subCategory")ESubCategory subCategory);
}
