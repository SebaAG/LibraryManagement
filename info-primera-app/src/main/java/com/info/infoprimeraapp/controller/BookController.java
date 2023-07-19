package com.info.infoprimeraapp.controller;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.exceptions.NotFoundException;
import com.info.infoprimeraapp.model.dto.BookDTO;
import com.info.infoprimeraapp.model.dto.response.BookResponseDTO;
import com.info.infoprimeraapp.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController // Anotación a nivel Clase
@RequestMapping("/api/v1/book") // Todos los endpoints comparten mismo URI
@Slf4j
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<BookResponseDTO> getAllBooks(@RequestParam(required = false,name = "nameBook") String nameBook){
        log.info("Se esta haciendo una consulta por los libros");
        return bookService.getAllBooks();
    }

    @PostMapping()
    public ResponseEntity createBook(@RequestBody BookDTO book) throws NotFoundException {
        log.info("Creating a new book");
        Book bookCreated = bookService.createBook(book);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/book/"+bookCreated.getUuid());

        return new ResponseEntity(headers,HttpStatus.CREATED);

    }

    @PutMapping("{idBook}")
    public ResponseEntity updateBook(@PathVariable(value = "idBook")UUID idBook,@RequestBody BookDTO bookUpdated)
            throws NotFoundException {
        Optional<BookDTO> book = bookService.updateBook(idBook,bookUpdated);

        if(book.isEmpty()){
            log.info("Book not found");
            throw new NotFoundException();
        }else {
            log.info("Book updated");
            return  new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("{UUID}")
    public ResponseEntity deleteBook(@PathVariable(value = "UUID") UUID idBook) throws NotFoundException {
        boolean deleted = bookService.deleteBook(idBook);

        if (deleted) {
            log.info("Book deleted");
            throw new NotFoundException();
        } else {
            log.info("Book not found");
            throw new NotFoundException();
        }
    }

}