package com.info.infoprimeraapp.service.category;

import com.info.infoprimeraapp.domain.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
    List<Category> getAllCategories();

    Optional<Category> findCategoryByUUID(UUID id);
}
