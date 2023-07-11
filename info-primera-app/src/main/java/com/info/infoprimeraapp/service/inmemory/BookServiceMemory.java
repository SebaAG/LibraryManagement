
// SE USA MEMORY PARA ACLARAR QUE ESTA CLASE ANTES SE GUARDABA EN LA MEMORIA
// ANTES DE IMPLEMENTAR BASE DE DATOS SE UTILIZABA COMO METODO DE GUARDADO


package com.info.infoprimeraapp.service.inmemory;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.service.BookService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceMemory implements BookService {
    Map<UUID,Book> bookMap;

    public BookServiceMemory() {
        bookMap = new HashMap<>();

        Book book = new Book();
        book.setUuid(UUID.randomUUID());
        book.setAuthor("Gabriel Garcia Marquez");
        book.setTitle("Cien años de soledad");

        Book book2 = new Book();
        book2.setUuid(UUID.randomUUID());
        book2.setAuthor("George Orwell");
        book2.setTitle("1984");

        Book book3 = new Book();
        book3.setUuid(UUID.randomUUID());
        book3.setAuthor("Antoine de Saint-Exupery");
        book3.setTitle("El principito");

        bookMap.put(book.getUuid(),book);
        bookMap.put(book2.getUuid(),book2);
        bookMap.put(book3.getUuid(),book3);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookMap.values());
    }

    @Override
    public Book createBook(Book book) {
        book.setUuid(UUID.randomUUID());
        bookMap.put(book.getUuid(),book);
        return book;
    }

    @Override
    public Optional<Book> updateBook(UUID uuidBook, Book bookUpdated) {
        //Buscamos libro
        Book book = bookMap.get(uuidBook);

        if(book != null){
            updatingBook(book,bookUpdated);
            return Optional.of(book);
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
        Book book = bookMap.remove(idBook);
        return book != null;
    }

}