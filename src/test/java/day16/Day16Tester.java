
package day16;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day16Tester {

    private static final String DAY16_TEST_INPUT = "day16/test.txt";

    @Test
    public void testPartOne() {
        Day16 challenge = new Day16();
        challenge.initGame(DAY16_TEST_INPUT, "");
        int numSamples = challenge.getPartOne();
        assertEquals(1, numSamples);
    }

}
