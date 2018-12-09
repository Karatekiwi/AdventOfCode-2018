
package day9;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class Day9Tester {

    private static final String DAY9_TEST_INPUT = "day9/test.txt";
    private Day9                challenge       = new Day9();

    @Test
    public void testPartOne() {
        List<String> lines = challenge.getLines(DAY9_TEST_INPUT);

        for (String line : lines) {
            challenge = new Day9();
            challenge.initGame(line);
            Long highScore = challenge.getPartOne();
            assertEquals(challenge.getResult(), highScore);
        }
    }

}
