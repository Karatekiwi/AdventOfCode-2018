
package day9;

import java.util.List;

import utils.FileUtils;

public class StartDay9 {

    private static final String DAY9_INPUT_TXT  = "day9/input.txt";
    private static final String DAY9_INPUT2_TXT = "day9/input2.txt";

    private static FileUtils    fileHelper      = new FileUtils();

    public static void main(String[] args) {
        Day9 challenge = new Day9();

        List<String> lines = fileHelper.readStringLines(DAY9_INPUT_TXT);
        challenge.initGame(lines.get(0));
        Long highScore1 = challenge.getPartOne();
        System.out.println(String.format("The bestHighScore in part one is %s.", highScore1));

        lines = fileHelper.readStringLines(DAY9_INPUT2_TXT);
        challenge.initGame(lines.get(0));
        Long highScore2 = challenge.getPartOne();
        System.out.println(String.format("The bestHighScore in part two is %s.", highScore2));
    }

}
