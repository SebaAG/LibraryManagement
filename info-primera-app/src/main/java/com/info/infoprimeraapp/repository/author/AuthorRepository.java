package com.info.infoprimeraapp.repository.author;

import com.info.infoprimeraapp.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Optional<Author> findByNameEqualsIgnoreCase(String name);
    Optional<Author> findByNameAndLastNameEqualsIgnoreCase(String name, String lastName);
}