package com.info.infoprimeraapp.service;

import com.info.infoprimeraapp.model.dto.CategoryDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();

    Optional<CategoryDTO> findCategoryByUUID(UUID id);
}
