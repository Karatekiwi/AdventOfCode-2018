
package day7;

public class StartDay7 {

    private static final String DAY7_INPUT_TXT = "day9/input.txt";

    public static void main(String[] args) {
        Day7 challenge = new Day7();

        challenge.initGame(DAY7_INPUT_TXT, 0);
        int completed = challenge.getPartTwo(5);
        System.out.println(String.format("It took %s seconds to finish all tasks", completed));
    }

}
