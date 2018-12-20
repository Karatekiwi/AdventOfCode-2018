
package challenge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import day11.Day11;
import day11.Square;

public class Day11Tester {

    private static final int SERIAL_NUMBER_TEST_1 = 18;
    private static final int SERIAL_NUMBER_TEST_2 = 42;

    @Test
    public void testPowerLevel() {
        Day11 challenge = new Day11();
        int powerLevel1 = challenge.calculatePowerLevel(8, 3, 5);
        assertEquals(4, powerLevel1);

        int powerLevel2 = challenge.calculatePowerLevel(57, 122, 79);
        assertEquals(-5, powerLevel2);

        int powerLevel3 = challenge.calculatePowerLevel(39, 217, 196);
        assertEquals(0, powerLevel3);

        int powerLevel4 = challenge.calculatePowerLevel(71, 101, 153);
        assertEquals(4, powerLevel4);
    }

    @Test
    public void testPartOne1() {
        Day11 challenge = new Day11();
        Square maxSquare = challenge.initPartOne(SERIAL_NUMBER_TEST_1);
        assertEquals(33, maxSquare.getTopX());
        assertEquals(45, maxSquare.getTopY());
        assertEquals(29, maxSquare.getPower());
    }

    @Test
    public void testPartOne2() {
        Day11 challenge = new Day11();
        Square maxSquare = challenge.initPartOne(SERIAL_NUMBER_TEST_2);
        assertEquals(21, maxSquare.getTopX());
        assertEquals(61, maxSquare.getTopY());
        assertEquals(30, maxSquare.getPower());
    }

    @Test
    public void testPartTwo1() {
        Day11 challenge = new Day11();
        Square maxSquare = challenge.initPartTwo(SERIAL_NUMBER_TEST_1);
        System.out.println(maxSquare);
        assertEquals(90, maxSquare.getTopX());
        assertEquals(269, maxSquare.getTopY());
        assertEquals(16, maxSquare.getSize());
        assertEquals(113, maxSquare.getPower());
    }

    @Test
    public void testPartTwo2() {
        Day11 challenge = new Day11();
        Square maxSquare = challenge.initPartTwo(SERIAL_NUMBER_TEST_2);
        System.out.println(maxSquare);
        assertEquals(232, maxSquare.getTopX());
        assertEquals(251, maxSquare.getTopY());
        assertEquals(12, maxSquare.getSize());
        assertEquals(119, maxSquare.getPower());
    }

}
