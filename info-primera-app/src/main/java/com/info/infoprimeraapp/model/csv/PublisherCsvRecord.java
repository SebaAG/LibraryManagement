package com.info.infoprimeraapp.model.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublisherCsvRecord {

    @CsvBindByName(column = "publisherName")
    private String publisherName;

    @CsvBindByName(column = "address")
    private String address;

    @CsvBindByName(column = "city")
    private String city;

    @CsvBindByName(column = "country")
    private String country;

    @CsvBindByName(column = "phone")
    private String phone;

    @CsvBindByName(column = "web")
    private String web;
}
