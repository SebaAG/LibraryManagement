package com.info.infoprimeraapp.service.csv.publisher;

import com.info.infoprimeraapp.model.PublisherCsvRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface PublisherCsvService {

    List<PublisherCsvRecord> convertCSV(File file) throws FileNotFoundException;
}
