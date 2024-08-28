package com.project.personalfinancialmanagement.mapper;

import com.project.personalfinancialmanagement.dto.CategoryDTO;
import com.project.personalfinancialmanagement.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toCategory(CategoryDTO categoryDTO);

    CategoryDTO toCategoryDTO(Category category);
}
