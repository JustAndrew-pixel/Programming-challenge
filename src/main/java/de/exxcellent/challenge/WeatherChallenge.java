package de.exxcellent.challenge;

import java.util.Arrays;
import java.util.List;

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


    public static String findDayWithMinSpread(double[] temperatureSpreadResult, List<String[]> dayStatisticsArrays) {

        return GeneralUtils.findItemWithMinValue(temperatureSpreadResult, dayStatisticsArrays);
    }
}


