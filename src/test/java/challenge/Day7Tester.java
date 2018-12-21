
package challenge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import day7.Day7;

public class Day7Tester {

    private static final String DAY7_TEST_INPUT = "day7/test.txt";

    @Test
    public void testCalculate() {
        Day7 challenge = new Day7();
        challenge.initGame(DAY7_TEST_INPUT, 60);
        String order = challenge.getPartOne();
        assertEquals("CABDFE", order);
    }

    @Test
    public void testTotalDuration() {
        Day7 challenge = new Day7();
        challenge.initGame(DAY7_TEST_INPUT, 60);
        int duration = challenge.getPartTwo(2);
        assertEquals(15, duration);
    }

}
