
package day18;

import org.junit.Test;

public class Day18Tester {

    private static final String DAY18_TEST_INPUT = "day18/test.txt";

    @Test
    public void testPartOne() {
        Day18 challenge = new Day18();
        challenge.initGame(DAY18_TEST_INPUT, 7, 7);
    }

}
