package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


class FileUtilsTest {

    private String weatherFilePath;
    private String unsupportedFilePath;

    @BeforeEach
    void setUp() {
        weatherFilePath = "/de/exxcellent/challenge/weather.json";
        unsupportedFilePath = "/de/exxcellent/challenge/weather.txt";
    }

    @Test
    void testGetfileDataWithoutHeader() {
        FileUtils fileUtils = new FileUtils();

        List<String[]> expectedWeatherArrays = new ArrayList<>(Arrays.asList(
                new String[]{"1", "88", "59"},
                new String[]{"2", "79", "63"},
                new String[]{"3", "77", "55"}
        ));

        List<String[]> result = fileUtils.readFile(weatherFilePath);
        assertTrue(
                areListsEqual(expectedWeatherArrays, result),
                "File data are equal after header deletion"
        );
    }

    private boolean areListsEqual(List<String[]> expected, List<String[]> actual) {
        if (expected.size() != actual.size()) {
            return false;
        }
        for (int i = 0; i < expected.size(); i++) {
            if (!Arrays.equals(expected.get(i), actual.get(i))) {
                return false;
            }
        }
        return true;
    }


    @Test
    void testGetInfoIfFileIsNotSupported() {
        FileUtils fileUtils = new FileUtils();

        assertThrows(IllegalArgumentException.class, () -> {
            fileUtils.readFile(unsupportedFilePath);
        }, "Expected IllegalArgumentException for unsupported file type");
    }
}