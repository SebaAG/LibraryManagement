package com.info.infoprimeraapp.model.dto.response;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookResponseDTO {
    private String title;
    private String isbn;
    private int numberPages;
    private String nombreAuthor;
    private List<CategoryResponseDTO> categoryResponseDTOS;
}
