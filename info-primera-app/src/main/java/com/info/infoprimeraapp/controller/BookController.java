package com.info.infoprimeraapp.controller;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/v1/book")
    public List<Book> getAllBooks(){

        return bookService.getAllBooks();
    }

    @PostMapping("/api/v1/book")
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @PutMapping("/api/v1/book/{idBook}")
    public String updateBook(@PathVariable(value = "idBook")UUID idBook,@RequestBody Book bookUpdated){
        Optional<Book> book = bookService.updateBook(idBook,bookUpdated);

        if(book.isEmpty()){
            System.out.println("Book not found");
            return "Book not found";
        }else {
            System.out.println("Book updated");
            return "/api/v1/book/"+book.get().getUuid();
        }
    }

    @DeleteMapping("/api/v1/book/{UUID}")
    public String deleteBook(@PathVariable(value = "UUID") UUID idBook) {
        boolean deleted = bookService.deleteBook(idBook);

        if (deleted) {
            System.out.println("Book deleted");
            return "Book deleted";
        } else {
            System.out.println("Book not found");
            return "Book not found";
        }
    }

}
