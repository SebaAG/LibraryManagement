package com.info.infoprimeraapp.service.csv;

import com.info.infoprimeraapp.model.csv.BookCsvRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface BookCsvService extends CsvService<BookCsvRecord> {
    List<BookCsvRecord> convertCSV(File file) throws FileNotFoundException;
}