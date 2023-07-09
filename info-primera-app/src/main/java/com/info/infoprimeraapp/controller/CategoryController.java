package com.info.infoprimeraapp.controller;

import com.info.infoprimeraapp.domain.Category;
import com.info.infoprimeraapp.service.category.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/category")
@Slf4j
public class CategoryController {

    private final CategoryService cs;


    public CategoryController(CategoryService cs) {
        this.cs = cs;
    }

    @GetMapping()
    public List<Category> getAllCategories() {
        log.info("Requesting categories");
        return cs.getAllCategories();
    }

    @GetMapping("search")
    public Optional<Category> searchCategoryById(@RequestParam("id") UUID id) {
        log.info("Searching category by UUID");
        return cs.findCategoryByUUID(id);
    }
}
