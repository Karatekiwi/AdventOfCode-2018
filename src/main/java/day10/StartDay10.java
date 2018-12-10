
package day10;

import java.util.List;

import utils.FileUtils;

public class StartDay10 {

    private static final String DAY10_INPUT_TXT = "day10/input.txt";

    private static FileUtils    fileHelper      = new FileUtils();

    public static void main(String[] args) {
        Day10 challenge = new Day10();

        List<String> lines = fileHelper.readStringLines(DAY10_INPUT_TXT);
        challenge.initChallenge(lines);
        challenge.getPartOne();
    }

}
