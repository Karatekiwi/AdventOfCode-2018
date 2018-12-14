
package day14;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day14Tester {

    @Test
    public void testPartOne() {
        Day14 challenge = new Day14();
        challenge.initGame();
        long score = challenge.getPartOne(9);
        assertEquals(5158916779L, score);

        challenge = new Day14();
        challenge.initGame();
        score = challenge.getPartOne(5);
        assertEquals(124515891L, score);

        challenge = new Day14();
        challenge.initGame();
        score = challenge.getPartOne(18);
        assertEquals(9251071085L, score);

        challenge = new Day14();
        challenge.initGame();
        score = challenge.getPartOne(2018);
        assertEquals(5941429882L, score);
    }

    @Test
    public void testPartTwo() {
        Day14 challenge = new Day14();
        challenge.initGame();
        long numReceipts = challenge.getPartTwo("51589");
        assertEquals(9L, numReceipts);

        challenge = new Day14();
        challenge.initGame();
        numReceipts = challenge.getPartTwo("01245");
        assertEquals(5L, numReceipts);

        challenge = new Day14();
        challenge.initGame();
        numReceipts = challenge.getPartTwo("92510");
        assertEquals(18L, numReceipts);

        challenge = new Day14();
        challenge.initGame();
        numReceipts = challenge.getPartTwo("59414");
        assertEquals(2018L, numReceipts);

    }

}
