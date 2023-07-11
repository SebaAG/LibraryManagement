package com.info.infoprimeraapp.service.csv.impl;

import com.info.infoprimeraapp.model.PublisherCsvRecord;
import com.info.infoprimeraapp.service.csv.PublisherCsvService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;


@Slf4j
@Service
public class PublisherCsvServiceFile implements PublisherCsvService {
    private final CsvServiceCommonFile<PublisherCsvRecord> csvServiceCommonFile;

    public PublisherCsvServiceFile(CsvServiceCommonFile<PublisherCsvRecord> csvServiceCommonFile) {
        this.csvServiceCommonFile = csvServiceCommonFile;
    }

    public List<PublisherCsvRecord> convertCSV(File file) throws FileNotFoundException {
        return csvServiceCommonFile.convertCSV(file, PublisherCsvRecord.class);
    }
}