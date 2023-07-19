package com.info.infoprimeraapp.controller;

import com.info.infoprimeraapp.domain.Author;
import com.info.infoprimeraapp.exceptions.NotFoundException;
import com.info.infoprimeraapp.model.dto.AuthorDTO;
import com.info.infoprimeraapp.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public List<AuthorDTO> getAllAuthors() {
        log.info("Requesting authors");
        return as.getAllAuthors();
    }

    @PostMapping()
    public ResponseEntity createAuthor(@RequestBody AuthorDTO authorDTO) {
        log.info("Creating a new author");
        Author authorCreated = as.createAuthor(authorDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/author/"+ authorCreated.getUuid());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{idAuthor}")
    public ResponseEntity deleteAuthor(@PathVariable(value = "idAuthor")UUID idAuthor) throws NotFoundException{
        boolean isDeletedAuthor = as.deleteAuthor(idAuthor);

        if (isDeletedAuthor){
            log.warn("Author eliminated");
            return new ResponseEntity(HttpStatus.NO_CONTENT);

        }else {
            log.info("Author not found");
            throw new NotFoundException();
        }
    }

    @GetMapping("search")
    public Optional<AuthorDTO> searchAuthorByName(@RequestParam UUID uuid) {
        log.info("Searching author by name");
        return as.findAuthorById(uuid);
    }

    @GetMapping("searchFullName")
    public Optional<AuthorDTO> searchAuthorFullName(@RequestParam String name, @RequestParam String lastName) {
        log.info("Searching author by full name");
        return as.findAuthorByNameAndLastName(name, lastName);
    }

    @PutMapping("/{idAuthor}")
    public ResponseEntity updateAuthor(@PathVariable(value = "idAuthor") UUID idAuthor,
                                       @RequestBody AuthorDTO authorUpdated)
            throws NotFoundException {
        Optional<Author> book = as.updateAuthor(idAuthor,authorUpdated);

        if(book.isEmpty()){
            log.warn("Author not found");
            throw new NotFoundException();
        }else {
            log.info("Author updated");
            return  new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}