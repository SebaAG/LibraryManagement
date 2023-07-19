package com.info.infoprimeraapp.service.csv.impl;

import com.info.infoprimeraapp.model.csv.BookCsvRecord;
import com.info.infoprimeraapp.service.csv.BookCsvService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;


@Slf4j
@Service
public class BookCsvFileService implements BookCsvService {

    public List<BookCsvRecord> convertCSV(File file) throws FileNotFoundException {
        return CsvCommonFileService.convertCSV(file, BookCsvRecord.class);
    }
}
