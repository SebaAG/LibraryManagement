package com.info.infoprimeraapp.service.category.impl;

import com.info.infoprimeraapp.domain.Category;
import com.info.infoprimeraapp.repository.category.CategoryRepository;
import com.info.infoprimeraapp.service.category.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service
@AllArgsConstructor
public class CategoryServiceJPAImpl implements CategoryService {
    private CategoryRepository cr;

    public List<Category> getAllCategories() {
        return (List<Category>) cr.findAll();
    }

    @Override
    public Optional<Category> findCategoryByUUID(UUID id) {
        return cr.findById(id);
    }
}
