
package day17;

import org.junit.Test;

public class Day17Tester {

    private static final String DAY17_TEST_INPUT = "day17/test.txt";

    @Test
    public void testPartOne() {
        Day17 challenge = new Day17();
        challenge.initGame(DAY17_TEST_INPUT, 7, 7);
    }

}
