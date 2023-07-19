package com.info.infoprimeraapp.service;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.exceptions.NotFoundException;
import com.info.infoprimeraapp.model.dto.BookDTO;
import com.info.infoprimeraapp.model.dto.response.BookResponseDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {
    List<BookResponseDTO> getAllBooks();

    Book createBook(BookDTO book) throws NotFoundException;

    Optional<BookDTO> updateBook(UUID uuidBook, BookDTO bookUpdated);

    boolean deleteBook(UUID uuidBook);

    Optional<BookDTO> getBookById(UUID uuid);
}