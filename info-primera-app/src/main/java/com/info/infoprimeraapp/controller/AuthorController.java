package com.info.infoprimeraapp.controller;

import com.info.infoprimeraapp.domain.Author;
import com.info.infoprimeraapp.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/author")
@Slf4j
public class AuthorController {
    private final AuthorService as;

    @Autowired
    public AuthorController(AuthorService as) {
        this.as = as;
    }

    @GetMapping()
    public List<Author> getAllAuthors() {
        log.info("Requesting authors");
        return as.getAllAuthors();
    }

    @PostMapping()
    public Author createAuthor(@RequestBody Author author) {
        log.info("Creating a new author");
        return as.createAuthor(author);
    }

    @DeleteMapping("{name}")
    public String deleteAuthor(@PathVariable String name) {
        boolean del = as.deleteAuthor(name);

        if (del) {
            log.info("Author deleted");
            return "Author deleted";
        } else {
            log.info("Author not found");
            return "Author not found";
        }
    }

    @GetMapping("search")
    public Optional<Author> searchAuthorByName(@RequestParam String name) {
        log.info("Searching author by name");
        return as.findAuthorByName(name);
    }

    @GetMapping("searchFullName")
    public Optional<Author> searchAuthorFullName(@RequestParam String name, @RequestParam String lastName) {
        log.info("Searching author by full name");
        return as.findAuthorByNameAndLastName(name, lastName);
    }
}