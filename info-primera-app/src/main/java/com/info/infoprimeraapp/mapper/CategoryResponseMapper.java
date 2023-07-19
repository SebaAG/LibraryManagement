package com.info.infoprimeraapp.mapper;

import com.info.infoprimeraapp.domain.Category;
import com.info.infoprimeraapp.model.dto.response.CategoryResponseDTO;

public interface CategoryResponseMapper {
    CategoryResponseDTO categoryToCategoryResponseDTO(Category category);
}
