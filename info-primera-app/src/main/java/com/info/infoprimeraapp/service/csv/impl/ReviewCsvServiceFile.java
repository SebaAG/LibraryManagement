package com.info.infoprimeraapp.service.csv.impl;

import com.info.infoprimeraapp.model.ReviewCsvRecord;
import com.info.infoprimeraapp.service.csv.ReviewCsvService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Slf4j
@Service
public class ReviewCsvServiceFile implements ReviewCsvService {
    private final CsvServiceCommonFile<ReviewCsvRecord> csvServiceCommonFile;

    public ReviewCsvServiceFile(CsvServiceCommonFile<ReviewCsvRecord> csvServiceCommonFile) {
        this.csvServiceCommonFile = csvServiceCommonFile;
    }

    public List<ReviewCsvRecord> convertCSV(File file) throws FileNotFoundException {
        return csvServiceCommonFile.convertCSV(file, ReviewCsvRecord.class);
    }
}