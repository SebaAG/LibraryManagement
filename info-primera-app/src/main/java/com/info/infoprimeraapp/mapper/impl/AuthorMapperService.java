package com.info.infoprimeraapp.mapper.impl;

import com.info.infoprimeraapp.domain.Author;
import com.info.infoprimeraapp.mapper.AuthorMapper;
import com.info.infoprimeraapp.model.dto.AuthorDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class AuthorMapperService implements AuthorMapper {

    @Override
    public Author authorDtoToAuthor(AuthorDTO author) {
        return Author.builder()
                .uuid(UUID.randomUUID())
                .name(author.getName())
                .lastName(author.getLastName())
                .birth(getLocalDateTime(author.getBirth()))
                .build();
    }

    @Override
    public AuthorDTO authorToAuthorDto(Author author) {
        return AuthorDTO.builder()
                .lastName(author.getLastName())
                .name(author.getName())
                .birth(getFormattedDate(LocalDate.from((author.getBirth()))))
                .build();
    }

    private LocalDateTime getLocalDateTime(String date){
        if (!date.isBlank()){
            String[] parts = date.split("/");
            return LocalDateTime.of(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),0,0);
        }
        return null;
    }

    private String getFormattedDate(LocalDate date) {
        if (date != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return date.format(formatter);
        }
        return null;
    }
}
