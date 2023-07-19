package com.info.infoprimeraapp.mapper;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.model.dto.BookDTO;

public interface BookMapper {

    public Book bookDTOtoBook(BookDTO bookDTO);

    BookDTO bookToBookDTO(Book book);
}
