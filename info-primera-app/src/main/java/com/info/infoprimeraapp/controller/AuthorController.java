package com.info.infoprimeraapp.controller;

import com.info.infoprimeraapp.domain.Author;
import com.info.infoprimeraapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {
    private final AuthorService as;

    @Autowired
    public AuthorController(AuthorService as) {
        this.as = as;
    }

    @GetMapping("/api/v1/author")
    public List<Author> getAllAuthors() {
        return as.getAllAuthors();
    }

    @PostMapping("/api/v1/author")
    public Author createAuthor(@RequestBody Author author) {
        return as.createAuthor(author);
    }

    @DeleteMapping("/api/v1/author/{name}")
    public String deleteAuthor(@PathVariable String name) {
        boolean del = as.deleteAuthor(name);

        if (del) {
            return "Author deleted";
        } else {
            return "Author not found";
        }
    }

    @GetMapping("/api/v1/author/search")
    public Optional<Author> searchAuthorByName(@RequestParam String name) {
        return as.findAuthorByName(name);
    }

    @GetMapping("/api/v1/author/searchFullName")
    public Optional<Author> searchAuthorFullName(@RequestParam String name, @RequestParam String lastName) {
        return as.findAuthorByNameAndLastName(name, lastName);
    }
}
