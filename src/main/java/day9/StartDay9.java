
package day9;

import java.util.List;

public class StartDay9 {

    private static final String DAY9_INPUT_TXT  = "day9/input.txt";
    private static final String DAY9_INPUT2_TXT = "day9/input2.txt";
    private static Day9         challenge       = new Day9();

    public static void main(String[] args) {
        List<String> lines = challenge.getLines(DAY9_INPUT_TXT);
        challenge.initGame(lines.get(0));
        // int highScore = challenge.getPartOne();
        // System.out.println(String.format("The bestHighScore is %s.", highScore));

        challenge = new Day9();
        lines = challenge.getLines(DAY9_INPUT2_TXT);
        challenge.initGame(lines.get(0));
        Long highScore2 = challenge.getPartOne();
        System.out.println(String.format("The bestHighScore is %s.", highScore2));
    }

}
