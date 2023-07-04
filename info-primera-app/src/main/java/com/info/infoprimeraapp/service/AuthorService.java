package com.info.infoprimeraapp.service;

import com.info.infoprimeraapp.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author createAuthor(Author author);
    boolean deleteAuthor(String name);
    Optional<Author> findAuthorByName(String name);
    Optional<Author> findAuthorByNameAndLastName(String name, String lastName);
    List<Author> getAllAuthors();
}
