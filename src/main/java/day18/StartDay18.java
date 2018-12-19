
package day18;

public class StartDay18 {

    private static final String DAY18_INPUT_TXT = "day18/input.txt";

    public static void main(String[] args) {
        Day18 challenge = new Day18();

        challenge.initGame(DAY18_INPUT_TXT, 50, 50);
        int numGreen = challenge.getPartOne(10);
        System.out.println(numGreen);

        // part two calculated manually
        // numGreen = challenge.getPartOne(1000000000);
    }

}
