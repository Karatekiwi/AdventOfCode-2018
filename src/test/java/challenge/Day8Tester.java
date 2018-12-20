
package challenge;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import day8.Day8;

public class Day8Tester {

    private static final String DAY8_TEST_INPUT = "day8/test.txt";
    private Day8                challenge       = new Day8();

    @Before
    public void setUp() {
        challenge.initInput(DAY8_TEST_INPUT);
    }

    @Test
    public void testPartOne() {
        int sum = challenge.getPartOne();
        assertEquals(138, sum);
    }

    @Test
    public void testPartTwo() {
        int rootValue = challenge.getPartTwo();
        assertEquals(66, rootValue);
    }

}
