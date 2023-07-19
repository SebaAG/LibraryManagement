package com.info.infoprimeraapp.service;

import com.info.infoprimeraapp.domain.Author;
import com.info.infoprimeraapp.model.dto.AuthorDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorService {
    Author createAuthor(AuthorDTO author);
    boolean deleteAuthor(UUID uuid);
    Optional<Author> updateAuthor(UUID uuid, AuthorDTO authorUpdated);
    Optional<AuthorDTO> findAuthorById(UUID uuid);
    Optional<AuthorDTO> findAuthorByNameAndLastName(String name, String lastName);
    List<AuthorDTO> getAllAuthors();
}