package com.info.infoprimeraapp.repository;

import com.info.infoprimeraapp.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthorRepository extends CrudRepository<Author, UUID> {
    //Query Methods
    Optional<Author> findByNameAndLastNameEqualsIgnoreCase(String name, String lastName);
}