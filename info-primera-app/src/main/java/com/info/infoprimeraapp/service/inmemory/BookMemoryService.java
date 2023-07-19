
// SE USA MEMORY PARA ACLARAR QUE ESTA CLASE ANTES SE GUARDABA EN LA MEMORIA
// ANTES DE IMPLEMENTAR BASE DE DATOS SE UTILIZABA COMO METODO DE GUARDADO


package com.info.infoprimeraapp.service.inmemory;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.mapper.BookMapper;
import com.info.infoprimeraapp.mapper.BookResponseMapper;
import com.info.infoprimeraapp.model.dto.BookDTO;
import com.info.infoprimeraapp.model.dto.response.BookResponseDTO;
import com.info.infoprimeraapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookMemoryService implements BookService {
    Map<UUID,Book> bookMap;

    private final BookMapper bookMapper;
    private final BookResponseMapper bookResponseMapper;

    @Autowired
    public BookMemoryService(BookMapper bookMapper, BookResponseMapper bookResponseMapper) {

        this.bookMapper = bookMapper;
        this.bookResponseMapper = bookResponseMapper;
        bookMap = new HashMap<>();

        Book book = new Book();
        book.setUuid(UUID.randomUUID());
        // book.setAuthor("Gabriel Garcia Marquez");
        book.setTitle("Cien años de soledad");

        Book book2 = new Book();
        book2.setUuid(UUID.randomUUID());
        // book2.setAuthor("George Orwell");
        book2.setTitle("1984");

        Book book3 = new Book();
        book3.setUuid(UUID.randomUUID());
        // book3.setAuthor("Antoine de Saint-Exupery");
        book3.setTitle("El principito");

        bookMap.put(book.getUuid(),book);
        bookMap.put(book2.getUuid(),book2);
        bookMap.put(book3.getUuid(),book3);
    }

    @Override
    public List<BookResponseDTO> getAllBooks() {

        List<BookResponseDTO> bookDTOS = new ArrayList<>();

        for (Book book:bookMap.values()) {
            bookDTOS.add(bookResponseMapper.bookToBookResponseDTO(book));
        }

        return bookDTOS;
    }

    @Override
    public Book createBook(BookDTO book) {
        Book newBook = bookMapper.bookDTOtoBook(book);
        //Queda pendiente agregar autores
        bookMap.put(newBook.getUuid(),newBook);
        return newBook;
    }

    @Override
    public Optional<BookDTO> updateBook(UUID uuidBook, BookDTO bookUpdated) {
        //Buscamos libro
        Book book = bookMap.get(uuidBook);

        if(book != null){
            updatingBook(book,bookUpdated);
            return Optional.of(bookMapper.bookToBookDTO(book));
        }else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteBook(UUID uuidBook) {
        return false;
    }

    @Override
    public Optional<BookDTO> getBookById(UUID uuid) {

        return Optional.of(
                bookMapper.bookToBookDTO( bookMap.get(uuid) )
        );
    }

    private void updatingBook(Book book,BookDTO bookUpdated){

        if (!bookUpdated.getTitle().isBlank()){
            book.setTitle(bookUpdated.getTitle());
        }

        if(bookUpdated.getNumberPage() > 0){
            book.setNumberPage(bookUpdated.getNumberPage());
        }

        if (!bookUpdated.getIsbn().isBlank()){
            book.setIsbn(bookUpdated.getIsbn());
        }

    }

    private boolean deleteBookByName(String title) {
        for (Book book : bookMap.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                bookMap.values().remove(book);
                return true;
            }
        }
        return false;
    }
}
