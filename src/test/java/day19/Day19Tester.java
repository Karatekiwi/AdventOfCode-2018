
package day19;

import org.junit.Test;

public class Day19Tester {

    private static final String DAY19_TEST_INPUT = "day19/test.txt";

    @Test
    public void testPartOne() {
        Day19 challenge = new Day19();
        challenge.initGame(DAY19_TEST_INPUT, 7, 7);
    }

}
