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
}


