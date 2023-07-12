package com.info.infoprimeraapp.service.sql;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.repository.BookRepository;
import com.info.infoprimeraapp.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service
@AllArgsConstructor
public class BookSQLService implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll(); //trae todos los libros de la BD
    }

    @Override
    public Book createBook(Book book) {
        book.setUuid(UUID.randomUUID());
        bookRepository.save(book); //guarda en la BD
        return book;
    }

    @Override
    public Optional<Book> updateBook(UUID uuidBook, Book bookUpdated) {
        //Buscamos libro por ID
        Optional<Book> bookOptional = bookRepository.findById(uuidBook);

        if(bookOptional.isPresent()){
            updatingBook(bookOptional.get(),bookUpdated);
            //.save = Si existe lo actualiza, si no existe lo CREA
            return Optional.of(bookRepository.save(bookOptional.get()));
        }else {
            return Optional.empty();
        }
    }

    private void updatingBook(Book book,Book bookUpdated){

        if (bookUpdated.getTitle() != null){
            book.setTitle(bookUpdated.getTitle());
        }

        if (bookUpdated.getAuthor() != null){
            book.setAuthor(bookUpdated.getAuthor());
        }

    }

    @Override
    public boolean deleteBook(UUID idBook) {
        Optional<Book> optionalBook = bookRepository.findById(idBook);
        if (optionalBook.isPresent()) {
            bookRepository.delete(optionalBook.get());
            return true;
        }
        return false;
    }
}