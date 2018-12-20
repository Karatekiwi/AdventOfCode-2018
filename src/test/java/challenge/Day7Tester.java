
package challenge;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import day7.Day7;
import utils.FileUtils;

public class Day7Tester {

    private static final String DAY7_TEST_INPUT = "day7/test.txt";

    @Test
    public void testCalculate() {
        FileUtils fileHelper = new FileUtils();
        List<String> input = fileHelper.readStringLines(DAY7_TEST_INPUT);
        Day7.prepareSteps(input, 0);
        Day7.getSequence();
        assertEquals("CABDFE", Day7.getResult());
    }

    @Test
    public void testTotalDuration() {
        FileUtils fileHelper = new FileUtils();
        List<String> input = fileHelper.readStringLines(DAY7_TEST_INPUT);
        Day7.prepareSteps(input, 0);
        int duration = Day7.calculateTotalDuration(2);
        assertEquals(15, duration);
    }

}
