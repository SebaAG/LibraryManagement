package com.info.infoprimeraapp.model.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDTO {
    private String name;
    private String lastName;
    private String birth;
}
