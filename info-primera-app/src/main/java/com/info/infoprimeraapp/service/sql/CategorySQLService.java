package com.info.infoprimeraapp.service.sql;

import com.info.infoprimeraapp.domain.Category;
import com.info.infoprimeraapp.mapper.CategoryMapper;
import com.info.infoprimeraapp.model.dto.CategoryDTO;
import com.info.infoprimeraapp.repository.CategoryRepository;
import com.info.infoprimeraapp.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service
@AllArgsConstructor
public class CategorySQLService implements CategoryService {
    private final CategoryRepository cr;
    private final CategoryMapper categoryMapper;

    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();

        for (Category category:cr.findAll()) {
            categoryDTOS.add(categoryMapper.categoryToCategoryDTO(category));
        }

        return categoryDTOS;
    }

    @Override
    public Optional<CategoryDTO> findCategoryByUUID(UUID id) {
        Optional<Category> category = cr.findById(id);
        return category.map(categoryMapper::categoryToCategoryDTO);
    }

}
