package de.exxcellent.challenge;

import java.util.List;
import java.util.Arrays;
import java.util.OptionalDouble;

public class GeneralUtils {


    public static String findItemWithMinValue(double[] valuesArray, List<String[]> statisticsArrays) {
        if (valuesArray == null || valuesArray.length == 0) {
            return "Array is empty";
        }

        int ItemIndexWithMinValue = -1;

        OptionalDouble minValue = Arrays.stream(valuesArray).min();
        if (minValue.isEmpty()) {
            return "Error: No minimum value found";
        }

        for (int index = 0; index < valuesArray.length; index++) {
            if (valuesArray[index] == minValue.getAsDouble()) {
                ItemIndexWithMinValue = index;
                break;
            }
        }

        return statisticsArrays.get(ItemIndexWithMinValue)[0];
    }

}