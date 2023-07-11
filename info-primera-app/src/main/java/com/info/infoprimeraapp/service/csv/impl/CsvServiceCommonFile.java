package com.info.infoprimeraapp.service.csv.impl;

import com.info.infoprimeraapp.service.csv.CsvService;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Slf4j
@Component
public class CsvServiceCommonFile<T> implements CsvService<T> {
    public List<T> convertCSV(File file, Class<T> recordClass) throws FileNotFoundException {
        List<T> recordList = new CsvToBeanBuilder<T>(new FileReader(file))
                .withType(recordClass)
                .build()
                .parse();
        log.info("Converting CSV to {} List", recordClass.getSimpleName());
        return recordList;
    }

    @Override
    public List<T> convertCSV(File file) {
        return null;
    }
}