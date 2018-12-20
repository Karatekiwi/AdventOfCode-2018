
package challenge;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import day4.Day4;
import day4.Guard;
import day4.InputHelper;
import utils.FileUtils;

public class Day4Tester {

    private static final String DAY4_TEST_INPUT = "day4/test.txt";

    private static InputHelper  helper          = new InputHelper();

    @Test
    public void test1() {
        FileUtils fileHelper = new FileUtils();
        List<String> input = fileHelper.readStringLines(DAY4_TEST_INPUT);
        Map<Date, String> timeline = helper.getTimeline(input);
        List<Guard> guards = Day4.transferToGuard(timeline);

        int solution = Day4.calculateMostLazyGuard(guards);
        assertEquals(240, solution);
    }

    @Test
    public void test2() {
        FileUtils fileHelper = new FileUtils();
        List<String> input = fileHelper.readStringLines(DAY4_TEST_INPUT);
        Map<Date, String> timeline = helper.getTimeline(input);
        List<Guard> guards = Day4.transferToGuard(timeline);

        int sleep = Day4.calculateMostSleepMinutes(guards);
        assertEquals(4455, sleep);
    }
}
