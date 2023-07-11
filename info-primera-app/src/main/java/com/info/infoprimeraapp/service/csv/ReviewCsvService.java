package com.info.infoprimeraapp.service.csv;

import com.info.infoprimeraapp.model.ReviewCsvRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface ReviewCsvService extends CsvService<ReviewCsvRecord> {
    List<ReviewCsvRecord> convertCSV(File file) throws FileNotFoundException;
}
