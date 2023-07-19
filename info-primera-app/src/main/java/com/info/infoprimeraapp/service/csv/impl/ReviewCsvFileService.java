package com.info.infoprimeraapp.service.csv.impl;

import com.info.infoprimeraapp.model.csv.ReviewCsvRecord;
import com.info.infoprimeraapp.service.csv.ReviewCsvService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Slf4j
@Service
public class ReviewCsvFileService implements ReviewCsvService {
    public List<ReviewCsvRecord> convertCSV(File file) throws FileNotFoundException {
        return CsvCommonFileService.convertCSV(file, ReviewCsvRecord.class);
    }
}