package com.info.infoprimeraapp.mapper.impl;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.domain.Category;
import com.info.infoprimeraapp.mapper.BookResponseMapper;
import com.info.infoprimeraapp.mapper.CategoryResponseMapper;
import com.info.infoprimeraapp.model.dto.response.BookResponseDTO;
import com.info.infoprimeraapp.model.dto.response.CategoryResponseDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookResponseMapperService implements BookResponseMapper {

    private final CategoryResponseMapper categoryResponseMapper;

    public BookResponseMapperService(CategoryResponseMapper categoryResponseMapper) {
        this.categoryResponseMapper = categoryResponseMapper;
    }

    @Override
    public BookResponseDTO bookToBookResponseDTO(Book book) {

        BookResponseDTO bookResponseDTO = BookResponseDTO.builder()
                .nombreAuthor(book.getAuthor().getName())
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .numberPages(book.getNumberPage())
                .build();

        List<CategoryResponseDTO> categoryResponseDTOS = new ArrayList<>();

        for (Category category:book.getCategories()) {
            categoryResponseDTOS.add(categoryResponseMapper.categoryToCategoryResponseDTO(category));
        }
        bookResponseDTO.setCategoryResponseDTOS(categoryResponseDTOS);

        return bookResponseDTO;
    }
}