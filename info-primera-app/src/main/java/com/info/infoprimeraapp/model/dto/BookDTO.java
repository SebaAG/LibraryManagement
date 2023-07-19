package com.info.infoprimeraapp.model.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    private String title;
    private String isbn;
    private int numberPage;
    private String idAuthor;
    private List<String> listCategoriesIds = new ArrayList<>();
}
