package com.info.infoprimeraapp.service.csv.publisher.impl;

import com.info.infoprimeraapp.model.PublisherCsvRecord;
import com.info.infoprimeraapp.service.csv.publisher.PublisherCsvService;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Slf4j
@Service
public class PublisherCsvServiceImpl implements PublisherCsvService {

    public List<PublisherCsvRecord> convertCSV(File file) throws FileNotFoundException {
        List<PublisherCsvRecord> publisherCsvRecordsList = new CsvToBeanBuilder<PublisherCsvRecord>(new FileReader(file))
                .withType(PublisherCsvRecord.class)
                .build()
                .parse();
        log.info("Converting CSV to publisher List");
        return publisherCsvRecordsList;
    }
}
