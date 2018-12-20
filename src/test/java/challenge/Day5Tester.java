
package challenge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import day5.Day5;

public class Day5Tester {

    @Test
    public void testCalculate() {
        String input = "dabAcCaCBAcCcaDA";
        String reduced = Day5.calculateReduced(input);
        assertEquals("dabCBAcaDA", reduced);
    }

    @Test
    public void testReaction() {
        String input = "dabAcCaCBAcCcaDA";
        int numOfUnits = Day5.calculateResult(input);
        assertEquals(4, numOfUnits);
    }

}
