
package challenge;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import day9.Day9;
import utils.FileUtils;

public class Day9Tester {

    private static final String DAY9_TEST_INPUT = "day9/test.txt";

    private FileUtils           fileHelper      = new FileUtils();

    @Test
    public void testPartOne() {
        Day9 challenge = new Day9();
        List<String> lines = fileHelper.readStringLines(DAY9_TEST_INPUT);

        for (String line : lines) {
            challenge = new Day9();
            challenge.initGame(line);
            Long highScore = challenge.getPartOne();
            assertEquals(challenge.getResult(), highScore);
        }
    }

}
