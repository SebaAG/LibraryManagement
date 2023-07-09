package com.info.infoprimeraapp.model;


import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookCsvRecord {

    @CsvBindByName(column = "isbn") // Se emplea para que Spring inyecte los valores del CSV
    private String isbn;

    @CsvBindByName(column = "title") // Se tiene que agregar el nombre de la columna correspondiente con el CSV
    private String title;

    @CsvBindByName(column = "author")
    private String author;

    @CsvBindByName(column = "number_page")
    private String numberPage;
}