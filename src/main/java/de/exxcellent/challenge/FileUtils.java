package de.exxcellent.challenge;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class FileUtils {

    public static List<String[]> readFile(String filePath) {
        List<String[]> fileRows = new ArrayList<>();


        if (filePath.endsWith(".csv")) {
            fileRows = readCSVfile(filePath);
        } else if (filePath.endsWith(".json")) {
            fileRows = readJSONfile(filePath);
        } else {
            throw new IllegalArgumentException("Unsupported file type: " + filePath);
        }

        return fileRows;
    }


    public static List<String[]> readCSVfile(String filePath) {
        List<String[]> fileRows = new ArrayList<>();

        InputStream inputStream = App.class.getResourceAsStream(filePath);

        try (CSVReader reader = new CSVReader(new InputStreamReader(inputStream))) {
            fileRows = reader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return removeCSVfileHeader(fileRows);
    }

    public static List<String[]> readJSONfile(String filePath) {
        List<String[]> fileRows = new ArrayList<>();

        try (InputStream inputStream = App.class.getResourceAsStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(reader);


            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    String[] row = StreamSupport.stream(node.spliterator(), false)
                            .map(JsonNode::asText)
                            .toArray(String[]::new);
                    fileRows.add(row);
                }
            }
        } catch (IOException e) {
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