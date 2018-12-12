
package day12;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day12Tester {

    private static final String DAY12_TEST_INPUT = "day12/test.txt";

    @Test
    public void testPartOne() {
        Day12 challenge = new Day12();

        challenge.initGame(DAY12_TEST_INPUT);
        int numPlants = challenge.getPartOne();
        assertEquals(325, numPlants);
    }

}
