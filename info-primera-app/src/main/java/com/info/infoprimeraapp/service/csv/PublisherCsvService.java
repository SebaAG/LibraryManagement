package com.info.infoprimeraapp.service.csv;

import com.info.infoprimeraapp.model.csv.PublisherCsvRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface PublisherCsvService extends CsvService<PublisherCsvRecord> {
    List<PublisherCsvRecord> convertCSV(File file) throws FileNotFoundException;
}
