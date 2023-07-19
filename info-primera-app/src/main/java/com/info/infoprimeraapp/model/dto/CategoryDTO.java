package com.info.infoprimeraapp.model.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryDTO {
    private String id;
    private String name;
    private List<BookDTO> bookDTOS;
}
