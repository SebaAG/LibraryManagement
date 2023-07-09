package com.info.infoprimeraapp.service.author.impl;

import com.info.infoprimeraapp.domain.Author;
import com.info.infoprimeraapp.repository.author.AuthorRepository;
import com.info.infoprimeraapp.service.author.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
@AllArgsConstructor
public class AuthorServiceJPAImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return (List<Author>) authorRepository.findAll();
    }

    @Override
    public Author createAuthor(Author author) {
        authorRepository.save(author);
        return author;
    }

    @Override
    public boolean deleteAuthor(String name) {
        Optional<Author> optionalAuthor = authorRepository.findByNameEqualsIgnoreCase(name);
        if (optionalAuthor.isPresent()) {
            authorRepository.delete(optionalAuthor.get());
            return true;
        }
        return false;
    }

    @Override
    public Optional<Author> findAuthorByName(String name) {
        return authorRepository.findByNameEqualsIgnoreCase(name);
    }

    @Override
    public Optional<Author> findAuthorByNameAndLastName(String name, String lastName) {
        return authorRepository.findByNameAndLastNameEqualsIgnoreCase(name, lastName);
    }

}