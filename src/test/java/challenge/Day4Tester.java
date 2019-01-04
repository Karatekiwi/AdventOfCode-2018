
package challenge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import day4.Day4;

public class Day4Tester {

    private static final String DAY4_TEST_INPUT = "day4/test.txt";

    @Test
    public void test1() {
        Day4 challenge = new Day4();
        challenge.initGame(DAY4_TEST_INPUT);

        int solution = challenge.getPartOne();
        assertEquals(240, solution);
    }

    @Test
    public void test2() {
        Day4 challenge = new Day4();
        challenge.initGame(DAY4_TEST_INPUT);

        int sleep = challenge.getPartTwo();
        assertEquals(4455, sleep);
    }
}
