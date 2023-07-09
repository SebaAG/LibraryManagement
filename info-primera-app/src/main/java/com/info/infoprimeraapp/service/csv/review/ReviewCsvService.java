package com.info.infoprimeraapp.service.csv.review;

import com.info.infoprimeraapp.model.ReviewCsvRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface ReviewCsvService {

    List<ReviewCsvRecord> convertCSV(File file) throws FileNotFoundException;
}
