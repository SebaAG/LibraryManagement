/*

ANTES DE IMPLEMENTAR BASE DE DATOS SE UTILIZABA COMO METODO DE GUARDADO

package com.info.infoprimeraapp.service.author.impl;

import com.info.infoprimeraapp.domain.Author;
import com.info.infoprimeraapp.service.author.AuthorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final List<Author> authors;

    public AuthorServiceImpl() {
        this.authors = new ArrayList<>();
    }
    @Override
    public Author createAuthor(Author author) {
        authors.add(author);
        return author;
    }

    @Override
    public boolean deleteAuthor(String name) {
        for (Author author : authors) {
            if (author.getName().equals(name)) {
                authors.remove(author);
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Author> findAuthorByName(String name) {
        for (Author author : authors) {
            if (author.getName().equals(name)) {
                return Optional.of(author);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Author> findAuthorByNameAndLastName(String name, String lastName) {
        for (Author author : authors) {
            if (author.getName().equals(name) && author.getLastName().equals(lastName)) {
                return Optional.of(author);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Author> getAllAuthors() {
        return authors;
    }
}
*/