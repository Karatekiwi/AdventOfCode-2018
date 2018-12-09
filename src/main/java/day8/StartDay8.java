
package day8;

public class StartDay8 {

    private static final String DAY8_INPUT_TXT = "day8/input.txt";
    private static Day8         challenge      = new Day8();

    public static void main(String[] args) {
        challenge.initInput(DAY8_INPUT_TXT);

        int sum = challenge.getPartOne();
        System.out.println(String.format("The sum of the metadata is %s.", sum));

        int valueOfRoot = challenge.getPartTwo();
        System.out.println(String.format("The value of the root node is %s.", valueOfRoot));
    }

}
