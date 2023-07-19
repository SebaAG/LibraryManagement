package com.info.infoprimeraapp.mapper.impl;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.domain.Category;
import com.info.infoprimeraapp.mapper.BookMapper;
import com.info.infoprimeraapp.mapper.CategoryMapper;
import com.info.infoprimeraapp.model.dto.BookDTO;
import com.info.infoprimeraapp.model.dto.CategoryDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CategoryMapperService implements CategoryMapper {

    private final BookMapper bookMapper;

    @Override
    public CategoryDTO categoryToCategoryDTO(Category category) {
        CategoryDTO categoryDTO = CategoryDTO.builder()
                .id(category.getId().toString())
                .name(category.getCategoryName())
                .build();

        if (!category.getBooks().isEmpty()){
            List<BookDTO> bookDTOS = new ArrayList<>();

            for (Book book:category.getBooks()) {
                bookDTOS.add(bookMapper.bookToBookDTO(book));
            }
            categoryDTO.setBookDTOS(bookDTOS);
        }
        return categoryDTO;
    }
}
