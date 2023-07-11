package com.info.infoprimeraapp.service.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface CsvService<T> {
    List<T> convertCSV(File file) throws FileNotFoundException;
}
