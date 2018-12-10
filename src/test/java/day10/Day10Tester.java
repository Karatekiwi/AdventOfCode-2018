
package day10;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import utils.FileUtils;

public class Day10Tester {

    private static final String DAY10_TEST_INPUT = "day10/test.txt";
    private FileUtils           fileHelper       = new FileUtils();
    private Day10               challenge        = new Day10();

    @Test
    public void testExtractPoint() {
        List<String> lines = fileHelper.readStringLines(DAY10_TEST_INPUT);
        Point extractPoint = challenge.extractPoint(lines.get(0));
        assertEquals(9, extractPoint.getPosX());
        assertEquals(1, extractPoint.getPosY());
        assertEquals(0, extractPoint.getVelocityX());
        assertEquals(2, extractPoint.getVelocityY());
    }

    @Test
    public void testPartOne() {
        List<String> lines = fileHelper.readStringLines(DAY10_TEST_INPUT);
        challenge.initChallenge(lines);
        challenge.getPartOne();
    }

}
