package de.exxcellent.challenge;

import java.util.Arrays;
import java.util.List;


public class FootballChallenge {

    public static int[] calculateAbsoluteGoalDifferences(List<String[]> goalArrays) {
        if (goalArrays == null) {
            throw new IllegalArgumentException("Input list cannot be null");
        }

        int[] result = new int[goalArrays.size()];

        for (int i = 0; i < goalArrays.size(); i++) {
            String[] goalRow = goalArrays.get(i);

            int goal = Integer.parseInt(goalRow[5]);
            int goalAllowed = Integer.parseInt(goalRow[6]);
            result[i] = Math.abs(goal - goalAllowed);
        }

        return result;
    }


    public static String findTeamWithSmallestGoalDifference(int[] calculatedGoalDifferenceArray, List<String[]> teamStatisticsArrays) {

        double[] convertedArray = Arrays.stream(calculatedGoalDifferenceArray).asDoubleStream().toArray();
        return GeneralUtils.findItemWithMinValue(convertedArray, teamStatisticsArrays);
    }
}