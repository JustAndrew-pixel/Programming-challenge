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
        List<String[]> weatherFileData = FileUtils.readFile(weatherFilePath);
        double[] calculatedTemperatureSpreads = WeatherChallenge.calculateTemperatureSpreads(weatherFileData);

        String dayWithSmallestTempSpread = WeatherChallenge.findDayWithMinSpread(calculatedTemperatureSpreads, weatherFileData);     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);


        String footballFilePath = "/de/exxcellent/challenge/football.csv";
        List<String[]> footballFileData = FileUtils.readFile(footballFilePath);
        int[] calculatedGoalDifferences = FootballChallenge.calculateAbsoluteGoalDifferences(footballFileData);


        String teamWithSmallestGoalSpread = FootballChallenge.findTeamWithSmallestGoalDifference(calculatedGoalDifferences, footballFileData); // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
