
package day15;

import org.junit.Test;

public class Day15Tester {

	private static final String DAY15_TEST_INPUT = "day15/test.txt";

	@Test
	public void testPartOne() {
		Day15 challenge = new Day15();
		challenge.initGame(DAY15_TEST_INPUT, 7, 7);
	}

}
