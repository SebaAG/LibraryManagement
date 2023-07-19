package com.info.infoprimeraapp.mapper.impl;

import com.info.infoprimeraapp.domain.Category;
import com.info.infoprimeraapp.mapper.CategoryResponseMapper;
import com.info.infoprimeraapp.model.dto.response.CategoryResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class CategoryResponseMapperService implements CategoryResponseMapper {
    @Override
    public CategoryResponseDTO categoryToCategoryResponseDTO(Category category) {
        return CategoryResponseDTO
                .builder()
                .id(category.getId().toString())
                .name(category.getCategoryName())
                .build();
    }
}
