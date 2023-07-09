package com.info.infoprimeraapp.service.csv.review.impl;

import com.info.infoprimeraapp.model.ReviewCsvRecord;
import com.info.infoprimeraapp.service.csv.review.ReviewCsvService;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Slf4j
@Service
public class ReviewCsvServiceImpl implements ReviewCsvService {
    public List<ReviewCsvRecord> convertCSV(File file) throws FileNotFoundException {
        List<ReviewCsvRecord> reviewCsvRecordsList = new CsvToBeanBuilder<ReviewCsvRecord>(new FileReader(file))
                .withType(ReviewCsvRecord.class)
                .build()
                .parse();
        log.info("Converting CSV to review List");
        return reviewCsvRecordsList;
    }
}
