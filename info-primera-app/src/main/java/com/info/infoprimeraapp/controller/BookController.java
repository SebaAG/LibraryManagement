package com.info.infoprimeraapp.controller;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController // Anotación a nivel Clase
@RequestMapping("/api/v1/book") // Todas las dependencias comparten mismo URI
@Slf4j
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> getAllBooks(){
        log.info("Requesting books");
        return bookService.getAllBooks();
    }

    @PostMapping()
    public Book createBook(@RequestBody Book book){
        log.info("Creating a new book");
        return bookService.createBook(book);
    }

    @PutMapping("{idBook}")
    public String updateBook(@PathVariable(value = "idBook")UUID idBook,@RequestBody Book bookUpdated){
        Optional<Book> book = bookService.updateBook(idBook,bookUpdated);

        if(book.isEmpty()){
            log.info("Book not found");
            return "Book not found";
        }else {
            log.info("Book updated");
            return "/api/v1/book/"+book.get().getUuid();
        }
    }

    @DeleteMapping("{UUID}")
    public String deleteBook(@PathVariable(value = "UUID") UUID idBook) {
        boolean deleted = bookService.deleteBook(idBook);

        if (deleted) {
            log.info("Book deleted");
            return "Book deleted";
        } else {
            log.info("Book not found");
            return "Book not found";
        }
    }

}