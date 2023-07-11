package com.info.infoprimeraapp.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCsvRecord {

    @CsvBindByName(column = "title")
    private String title;

    @CsvBindByName(column = "bookName")
    private String bookName;

    @CsvBindByName(column = "content")
    private String content;

    @CsvBindByName(column = "rate")
    private BigDecimal rate;

    @CsvDate("dd/MM/yyyy")
    private LocalDate date;
}

// @CsvCustomBindByName(column = "date", converter = LocalDateConverter.class)
// la clase LocalDateConverter proporciona la lógica necesaria para convertir las fechas en formato de cadena
// especificado por el patrón "dd/MM/yyyy" a objetos LocalDate durante el proceso de lectura o escritura de
// archivos CSV con OpenCSV