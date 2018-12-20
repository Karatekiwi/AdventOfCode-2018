
package challenge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import day13.Day13;

public class Day13Tester {

    private static final String DAY13_TEST_INPUT  = "day13/test.txt";
    private static final String DAY13_TEST2_INPUT = "day13/test2.txt";

    @Test
    public void testPartOne() {
        Day13 challenge = new Day13();
        challenge.initGame(DAY13_TEST_INPUT, 6, 14);
        String resultLocation = challenge.getPartOne();
        assertEquals("7,3", resultLocation);
    }

    @Test
    public void testPartTwo() {
        Day13 challenge = new Day13();
        challenge.initGame(DAY13_TEST2_INPUT, 8, 7);
        String resultLocation = challenge.getPartTwo();
        assertEquals("6,4", resultLocation);
    }

}
