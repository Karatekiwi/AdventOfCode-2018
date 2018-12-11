
package day9;

import java.util.List;
import java.util.logging.Logger;

import utils.FileUtils;

public class StartDay9 {

	private final static Logger LOGGER = Logger.getLogger(StartDay9.class.getName());

	private static final String DAY9_INPUT_TXT = "day9/input.txt";
	private static final String DAY9_INPUT2_TXT = "day9/input2.txt";

	private static FileUtils fileHelper = new FileUtils();

	public static void main(String[] args) {
		Day9 challenge = new Day9();

		LOGGER.info("Starting Day9...");
		List<String> lines = fileHelper.readStringLines(DAY9_INPUT_TXT);
		challenge.initGame(lines.get(0));
		Long highScore1 = challenge.getPartOne();
		LOGGER.info(String.format("The best highScore in part one is %s.", highScore1));

		lines = fileHelper.readStringLines(DAY9_INPUT2_TXT);
		challenge.initGame(lines.get(0));
		Long highScore2 = challenge.getPartOne();
		LOGGER.info(String.format("The best highScore in part two is %s.", highScore2));
	}

}
