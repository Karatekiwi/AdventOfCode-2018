
package day15;

import java.util.List;

import utils.FileUtils;

public class StartDay15 {

	private static final String DAY15_INPUT_TXT = "day15/input.txt";

	private static FileUtils fileHelper = new FileUtils();

	public static void main(String[] args) {
		Day15 challenge = new Day15();

		List<String> lines = fileHelper.readStringLines(DAY15_INPUT_TXT);
		for (String string : lines) {
			System.out.println(string);
		}
	}

}
