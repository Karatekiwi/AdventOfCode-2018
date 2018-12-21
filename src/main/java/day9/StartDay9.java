
package day9;

import java.util.logging.Logger;

public class StartDay9 {

    private final static Logger LOGGER         = Logger.getLogger(StartDay9.class.getName());

    private static final String DAY9_INPUT_TXT = "day9/input.txt";

    public static void main(String[] args) {
        Day9 challenge = new Day9();

        challenge.initGame(DAY9_INPUT_TXT);
        Long highScore1 = challenge.getPartOne();
        LOGGER.info(String.format("The best highScore in part one is %s.", highScore1));

        challenge = new Day9();
        challenge.initGame(DAY9_INPUT_TXT, 100);
        Long highScore2 = challenge.getPartOne();
        LOGGER.info(String.format("The best highScore in part two is %s.", highScore2));
    }

}
