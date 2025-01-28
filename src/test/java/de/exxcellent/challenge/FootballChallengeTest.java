package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


class FootballChallengeTest {

    private List<String[]> goalArrays;

    @BeforeEach
    void setUp() {
        goalArrays = new ArrayList<>(Arrays.asList(
                new String[]{"Arsenal", "38", "26", "9", "3", "79", "36"},
                new String[]{"Tottenham", "38", "14", "8", "16", "49", "53"},
                new String[]{"Aston_Villa", "38", "12", "14", "12", "46", "47"}
        ));
    }


    @Test
    void testCalculateAbsoluteGoalDifferences() {
        FootballChallenge footballChallenge = new FootballChallenge();

        int[] expected = new int[]{43, 4, 1};

        int[] result = footballChallenge.calculateAbsoluteGoalDifferences(goalArrays);
        assertArrayEquals(expected, result, "Test calculates right AbsoluteGoalDifferences");
    }


    @Test
    void testFindTeamWithSmallestGoalDifference() {
        FootballChallenge footballChallenge = new FootballChallenge();

        int[] calculatedGoalDifferenceArray = new int[]{43, 4, 1};
        String expectedTeam = "Aston_Villa";

        String result = footballChallenge.findTeamWithSmallestGoalDifference(calculatedGoalDifferenceArray, goalArrays);

        assertEquals(expectedTeam, result, "Test finds right team");
    }
}

