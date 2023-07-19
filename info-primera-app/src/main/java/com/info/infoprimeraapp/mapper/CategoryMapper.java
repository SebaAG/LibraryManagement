package com.info.infoprimeraapp.mapper;

import com.info.infoprimeraapp.domain.Category;
import com.info.infoprimeraapp.model.dto.CategoryDTO;

public interface CategoryMapper {
    CategoryDTO categoryToCategoryDTO(Category category);
}
