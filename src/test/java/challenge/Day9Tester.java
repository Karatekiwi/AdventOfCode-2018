
package challenge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import day9.Day9;

public class Day9Tester {

    private static final String DAY9_TEST_INPUT = "day9/test.txt";

    @Test
    public void testPartOne() {
        Day9 challenge = new Day9();
        challenge.initGame(DAY9_TEST_INPUT);
        Long highScore = challenge.getPartOne();
        assertEquals(challenge.getResult(), highScore);
    }

}
