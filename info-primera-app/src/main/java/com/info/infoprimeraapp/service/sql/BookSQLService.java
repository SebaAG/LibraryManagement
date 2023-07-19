package com.info.infoprimeraapp.service.sql;

import com.info.infoprimeraapp.domain.Author;
import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.domain.Category;
import com.info.infoprimeraapp.exceptions.NotFoundException;
import com.info.infoprimeraapp.mapper.BookMapper;
import com.info.infoprimeraapp.mapper.BookResponseMapper;
import com.info.infoprimeraapp.model.dto.BookDTO;
import com.info.infoprimeraapp.model.dto.response.BookResponseDTO;
import com.info.infoprimeraapp.repository.AuthorRepository;
import com.info.infoprimeraapp.repository.BookRepository;
import com.info.infoprimeraapp.repository.CategoryRepository;
import com.info.infoprimeraapp.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service
@AllArgsConstructor
public class BookSQLService implements BookService {

    private final BookRepository bookRepository;
    private final BookResponseMapper bookResponseMapper;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final BookMapper bookMapper;

    @Override
    public List<BookResponseDTO> getAllBooks() {

        List<BookResponseDTO> bookDTOS = new ArrayList<>();

        for (Book book:bookRepository.findAll()) {
            bookDTOS.add(bookResponseMapper.bookToBookResponseDTO(book));
        }

        return bookDTOS;
    }

    @Override
    public Book createBook(BookDTO book) throws NotFoundException {

        Book newBook = bookMapper.bookDTOtoBook(book);

        //Relacion BOOK - AUTHOR
        Optional<Author> author = authorRepository.findById(UUID.fromString(book.getIdAuthor()));

        if (author.isPresent()){
            newBook.setAuthor(author.get());
            newBook = bookRepository.save(newBook);
        }else {
            throw new NotFoundException();
        }

        // Relacion BOOK - CATEGORY
        updatingCategoriesBook(newBook,book);
        return bookRepository.save(newBook);
    }

    private void updatingCategoriesBook(Book book,BookDTO bookDTO){
        if (!bookDTO.getListCategoriesIds().isEmpty()){

            //TAREA - EVITAR CARGAR DOS CATEGORIAS EN UN LIBRO
            for (String id:bookDTO.getListCategoriesIds()){
                Optional<Category> category = categoryRepository.findById(UUID.fromString(id));
                category.ifPresent(book::addCategories);
            }
        }
    }

    @Override
    public Optional<BookDTO> updateBook(UUID uuidBook, BookDTO bookUpdated) {
        //Buscar libro por ID
        Optional<Book> bookOptional = bookRepository.findById(uuidBook);

        if(bookOptional.isPresent()){
            updatingBook(bookOptional.get(),bookUpdated);
            //Save --> Si existe entonces lo actualiza y si no lo crea.
            bookRepository.saveAndFlush(bookOptional.get());
            return Optional.of(bookMapper.bookToBookDTO(bookOptional.get()));
        }else {
            return Optional.empty();
        }
    }

    private void updatingBook(Book book,BookDTO bookUpdated){

        if (!bookUpdated.getTitle().isBlank()){
            book.setTitle(bookUpdated.getTitle());
        }

        if (!bookUpdated.getIdAuthor().isBlank()){
            Optional<Author> author = authorRepository.findById(UUID.fromString(bookUpdated.getIdAuthor()));

            author.ifPresent(book::setAuthor);
        }

        if(bookUpdated.getNumberPage() > 0){
            book.setNumberPage(bookUpdated.getNumberPage());
        }

        if (!bookUpdated.getIsbn().isBlank()){
            book.setIsbn(bookUpdated.getIsbn());
        }

    }

    @Override
    public boolean deleteBook(UUID uuidBook) {
        if (bookRepository.existsById(uuidBook)){
            bookRepository.deleteById(uuidBook);
            return true;
        }
        return false;
    }

    @Override
    public Optional<BookDTO> getBookById(UUID uuid) {
        Optional<Book> bookOptional = bookRepository.findById(uuid);

        return bookOptional.map(bookMapper::bookToBookDTO);
    }
}