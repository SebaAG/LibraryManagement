package com.info.infoprimeraapp.mapper;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.model.dto.response.BookResponseDTO;

public interface BookResponseMapper {
    BookResponseDTO bookToBookResponseDTO(Book book);
}
