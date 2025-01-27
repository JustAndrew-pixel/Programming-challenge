package de.exxcellent.challenge;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FileUtils {


    public static List<String[]> readCSVfile(String filePath) {
        List<String[]> fileRows = new ArrayList<>();

        InputStream inputStream = App.class.getResourceAsStream(filePath);

        try (CSVReader reader = new CSVReader(new InputStreamReader(inputStream))) {
            fileRows = reader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return fileRows;
    }


    public static List<String[]> removeCSVfileHeader(List<String[]> fileData) {
        if (fileData != null && !fileData.isEmpty()) {
            List<String[]> result = new ArrayList<>(fileData.subList(1, fileData.size()));
            return result;
        } else {
            throw new IllegalArgumentException("Input list is null or empty");
        }
    }

}