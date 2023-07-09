package com.info.infoprimeraapp.bootstrap;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateConverter extends AbstractBeanField<String, LocalDate> {

    private final DateTimeFormatter dateFormatter;

    public LocalDateConverter() {
        this.dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    @Override
    protected LocalDate convert(String value) throws CsvDataTypeMismatchException {
        try {
            return LocalDate.parse(value, dateFormatter);
        } catch (Exception e) {
            throw new CsvDataTypeMismatchException(value, LocalDate.class, e.getMessage());
        }
    }
}
