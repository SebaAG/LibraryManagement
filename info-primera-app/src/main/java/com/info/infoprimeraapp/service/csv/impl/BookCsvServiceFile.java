package com.info.infoprimeraapp.service.csv.impl;

import com.info.infoprimeraapp.model.BookCsvRecord;
import com.info.infoprimeraapp.service.csv.BookCsvService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;


@Slf4j
@Service
public class BookCsvServiceFile implements BookCsvService {
    private final CsvServiceCommonFile<BookCsvRecord> csvServiceCommonFile;

    public BookCsvServiceFile(CsvServiceCommonFile<BookCsvRecord> csvServiceCommonFile) {
        this.csvServiceCommonFile = csvServiceCommonFile;
    }

    public List<BookCsvRecord> convertCSV(File file) throws FileNotFoundException {
        return csvServiceCommonFile.convertCSV(file, BookCsvRecord.class);
    }
}
