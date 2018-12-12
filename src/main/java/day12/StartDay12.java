
package day12;

public class StartDay12 {

    private static final String DAY12_INPUT_TXT = "day12/input.txt";

    public static void main(String[] args) {
        Day12 challenge = new Day12();

        challenge.initGame(DAY12_INPUT_TXT);
        int partOne = challenge.getPartOne();
        System.out.println(String.format("The sum of the numbers of all pots which contain a plant is %s.", partOne));

        long value = 50000000000L;
        long raise = 102; // data from the part one run
        long start = 103377; // data from the part one run
        long result = (value - 1000) * raise + start;

        System.out.println(String.format("After fifty billion generations, the sum of the numbers of all pots is %s.", result));

    }

}
