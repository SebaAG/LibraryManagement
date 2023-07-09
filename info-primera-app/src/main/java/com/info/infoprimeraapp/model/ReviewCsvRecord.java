package com.info.infoprimeraapp.model;

import com.info.infoprimeraapp.bootstrap.LocalDateConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
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

    @CsvCustomBindByName(column = "date", converter = LocalDateConverter.class)
    private LocalDate date;
}
