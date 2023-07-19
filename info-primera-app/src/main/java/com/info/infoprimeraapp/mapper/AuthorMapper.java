package com.info.infoprimeraapp.mapper;

import com.info.infoprimeraapp.domain.Author;
import com.info.infoprimeraapp.model.dto.AuthorDTO;

public interface AuthorMapper {

    Author authorDtoToAuthor(AuthorDTO author);

    AuthorDTO authorToAuthorDto(Author author);
}
