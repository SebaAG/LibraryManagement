package com.info.infoprimeraapp.service.sql;

import com.info.infoprimeraapp.domain.Author;
import com.info.infoprimeraapp.mapper.AuthorMapper;
import com.info.infoprimeraapp.model.dto.AuthorDTO;
import com.info.infoprimeraapp.repository.AuthorRepository;
import com.info.infoprimeraapp.service.AuthorService;
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
public class AuthorSQLService implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public List<AuthorDTO> getAllAuthors() {
        List<AuthorDTO> listAuthors = new ArrayList<>();
        for (Author author: authorRepository.findAll()) {
            listAuthors.add(authorMapper.authorToAuthorDto(author));
        }
        return listAuthors;
    }

    @Override
    public Author createAuthor(AuthorDTO authorDTO) {
        Author author = authorMapper.authorDtoToAuthor(authorDTO);
        return authorRepository.save(author);
    }

    @Override
    public boolean deleteAuthor(UUID uuid) {
        if (authorRepository.existsById(uuid)){
            authorRepository.deleteById(uuid);
            return true;
        }
        return false;
    }

    @Override
    public Optional<AuthorDTO> findAuthorById(UUID uuid) {

        Optional<Author> author = authorRepository.findById(uuid);

        if (author.isPresent()){
            return Optional.of(authorMapper.authorToAuthorDto(author.get()));
        }

        return Optional.empty();
    }

    @Override
    public Optional<AuthorDTO> findAuthorByNameAndLastName(String name, String lastName) {
        Optional<Author> author = authorRepository.findByNameAndLastNameEqualsIgnoreCase(name, lastName);

        if (author.isPresent()){
            return Optional.of(authorMapper.authorToAuthorDto(author.get()));
        }

        return Optional.empty();
    }

    @Override
    public Optional<Author> updateAuthor(UUID uuid, AuthorDTO authorDTO) {
        Optional<Author> author = authorRepository.findById(uuid);

        if (author.isPresent()){
            Author authorUpdated = authorMapper.authorDtoToAuthor(authorDTO);
            updatingAuthor(author.get(),authorUpdated);
            authorRepository.save(author.get());
            return author;
        }

        return Optional.empty();
    }

    private void updatingAuthor(Author author,Author authorUpdated){
        if (!authorUpdated.getName().isBlank()){
            author.setName(authorUpdated.getName());
        }

        if (!authorUpdated.getLastName().isBlank()){
            author.setLastName(authorUpdated.getLastName());
        }

        if (authorUpdated.getBirth() != null){
            author.setBirth(authorUpdated.getBirth());
        }
    }

}