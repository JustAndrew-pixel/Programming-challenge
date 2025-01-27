package de.exxcellent.challenge;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.OptionalDouble;

public class WeatherChallenge {

    public static double[] calculateTemperatureSpreads(List<String[]> temperatureArrays) {
        if (temperatureArrays == null) {
            throw new IllegalArgumentException("Input list cannot be null");
        }

        double[] result = new double[temperatureArrays.size()];

        for (int i = 0; i < temperatureArrays.size(); i++) {
            String[] temperatureRow = temperatureArrays.get(i);

            double maxTemperature = Double.parseDouble(temperatureRow[1]);
            double minTemperature = Double.parseDouble(temperatureRow[2]);
            result[i] = maxTemperature - minTemperature;
        }

        return result;
    }

    
    public static String findDayWithMinSpread(double[] temperatureSpreads, List<String[]> dayStatisticsArrays) {
        if (temperatureSpreads == null || temperatureSpreads.length == 0) {
            return "Temperature spread array is empty";
        }

        int dayIndexWithMinTempSpread = -1;

        OptionalDouble minSpread = Arrays.stream(temperatureSpreads).min();
        if (minSpread.isEmpty()) {
            return "Error: No minimum spread found";
        }

        for (int index = 0; index < temperatureSpreads.length; index++) {
            if (temperatureSpreads[index] == minSpread.getAsDouble()) {
                dayIndexWithMinTempSpread = index;
                break;
            }
        }

        return dayStatisticsArrays.get(dayIndexWithMinTempSpread)[0];

    }
}


