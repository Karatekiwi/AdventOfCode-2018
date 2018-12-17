
package day16;

public class StartDay16 {

    private static final String DAY16_INPUT_TXT  = "day16/input.txt";
    private static final String DAY16_INPUT2_TXT = "day16/input2.txt";

    public static void main(String[] args) {
        Day16 challenge = new Day16();

        challenge.initGame(DAY16_INPUT_TXT, DAY16_INPUT2_TXT);

        int partOne = challenge.getPartOne();
        System.out.println(String.format("The number of samples behaving like three or more opcodes is %s.", partOne));

        int value = challenge.getPartTwo();
        System.out.println(String.format("The value contained in register 0 after executing the test program is %s.", value));
    }

}
