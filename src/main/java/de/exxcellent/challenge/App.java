package de.exxcellent.challenge;

import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     *
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        String weatherFilePath = "/de/exxcellent/challenge/weather.csv";
        List<String[]> weatherFileData = FileUtils.readCSVfile(weatherFilePath);
        List<String[]> weatherDataWithoutHeader = FileUtils.removeCSVfileHeader(weatherFileData);
        double[] calculatedTemperatureSpreads = WeatherChallenge.calculateTemperatureSpreads(weatherDataWithoutHeader);


        String dayWithSmallestTempSpread = WeatherChallenge.findDayWithMinSpread(calculatedTemperatureSpreads, weatherDataWithoutHeader);     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);


        String footballFilePath = "/de/exxcellent/challenge/football.csv";
        List<String[]> footballFileData = FileUtils.readCSVfile(footballFilePath);
        List<String[]> footballDataWithoutHeader = FileUtils.removeCSVfileHeader(footballFileData);
        int[] calculatedGoalDifferences = FootballChallenge.calculateAbsoluteGoalDifferences(footballDataWithoutHeader);


        String teamWithSmallestGoalSpread = FootballChallenge.findTeamWithSmallestGoalDifference(calculatedGoalDifferences, footballDataWithoutHeader); // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
