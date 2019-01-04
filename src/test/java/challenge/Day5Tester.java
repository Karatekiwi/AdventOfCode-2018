
package challenge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import day5.Day5;

public class Day5Tester {

    @Test
    public void testCalculate() {
        Day5 challenge = new Day5();
        String input = "dabAcCaCBAcCcaDA";
        String reduced = challenge.calculateReduced(input);
        assertEquals("dabCBAcaDA", reduced);
    }

    @Test
    public void testReaction() {
        Day5 challenge = new Day5();
        String input = "dabAcCaCBAcCcaDA";
        int numOfUnits = challenge.calculateResult(input);
        assertEquals(4, numOfUnits);
    }

}
