package com.info.infoprimeraapp.mapper.impl;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.mapper.BookMapper;
import com.info.infoprimeraapp.model.dto.BookDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BookMapperService implements BookMapper {
    @Override
    public Book bookDTOtoBook(BookDTO bookDTO) {

        return Book.builder()
                .uuid(UUID.randomUUID())
                .isbn(bookDTO.getIsbn())
                .title(bookDTO.getTitle())
                .numberPage(bookDTO.getNumberPage())
                .build();

    }

    @Override
    public BookDTO bookToBookDTO(Book book) {
        return BookDTO.builder()
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .numberPage(book.getNumberPage())
                .idAuthor(book.getAuthor().getUuid().toString())
                .build();
    }
}
