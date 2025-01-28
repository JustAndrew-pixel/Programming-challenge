package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


class WeatherChallengeTest {

    private List<String[]> temperatureArrays;

    @BeforeEach
    void setUp() {
        temperatureArrays = new ArrayList<>(Arrays.asList(
                new String[]{"1", "88", "59"},
                new String[]{"2", "79", "63"},
                new String[]{"3", "77", "55"}
        ));
    }


    @Test
    void testCalculateTemperatureSpreads() {
        WeatherChallenge weatherChallenge = new WeatherChallenge();

        double[] expected = new double[]{29.0, 16.0, 22.0};

        double[] result = weatherChallenge.calculateTemperatureSpreads(temperatureArrays);
        assertArrayEquals(expected, result, "Test calculates right TemperatureSpreads");
    }


    @Test
    void testFindDayWithMinSpread() {
        WeatherChallenge weatherChallenge = new WeatherChallenge();

        double[] temperatureSpreadResult = new double[]{29.0, 16.0, 22.0};
        String expectedDay = "2";

        String result = weatherChallenge.findDayWithMinSpread(temperatureSpreadResult, temperatureArrays);

        assertEquals(expectedDay, result, "Test finds right day");
    }
}