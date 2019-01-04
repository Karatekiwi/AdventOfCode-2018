
package challenge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import day10.Day10;
import day10.Point;

public class Day10Tester {

    private static final String DAY10_TEST_INPUT = "day10/test.txt";

    @Test
    public void testExtractPoint() {
        Day10 challenge = new Day10();
        challenge.initChallenge(DAY10_TEST_INPUT);

        Point extractPoint = challenge.getPoints().get(0);
        assertEquals(9, extractPoint.getPosX());
        assertEquals(1, extractPoint.getPosY());
        assertEquals(0, extractPoint.getVelocityX());
        assertEquals(2, extractPoint.getVelocityY());
    }

}
