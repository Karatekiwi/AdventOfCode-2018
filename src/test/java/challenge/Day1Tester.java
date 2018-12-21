
package challenge;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import day1.Day1;

public class Day1Tester {

    @Test
    public void testFrequencyCalculator1() {
        Day1 challenge = new Day1();
        List<Integer> list = Arrays.asList(1, -2, 3, 1);
        int calculateFrequency = challenge.calculateFrequency(0, list);
        assertEquals(3, calculateFrequency);
    }

    @Test
    public void testFrequencyCalculator2() {
        Day1 challenge = new Day1();
        List<Integer> list = Arrays.asList(1, 1, 1);
        int calculateFrequency = challenge.calculateFrequency(0, list);
        assertEquals(3, calculateFrequency);
    }

    @Test
    public void testFrequencyCalculator3() {
        Day1 challenge = new Day1();
        List<Integer> list = Arrays.asList(1, 1, -2);
        int calculateFrequency = challenge.calculateFrequency(0, list);
        assertEquals(0, calculateFrequency);
    }

    @Test
    public void testFrequencyCalculator4() {
        Day1 challenge = new Day1();
        List<Integer> list = Arrays.asList(-1, -2, -3);
        int calculateFrequency = challenge.calculateFrequency(0, list);
        assertEquals(-6, calculateFrequency);
    }

    @Test
    public void testDuplicate1() {
        Day1 challenge = new Day1();
        List<Integer> list = Arrays.asList(1, -2, 3, 1);
        int duplicate = challenge.findFirstDuplicate(0, list);
        assertEquals(2, duplicate);
    }

}
