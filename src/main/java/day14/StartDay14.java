
package day14;

public class StartDay14 {

    private static final int DAY14_INPUT = 380621;

    public static void main(String[] args) {

        // init part one
        // Day14 challenge = new Day14();
        // challenge.initGame();
        // long score = challenge.getPartOne(DAY14_INPUT);
        // System.out.println(String.format("After %s the score is %s.", DAY14_INPUT, score));

        // init part two
        Day14 challenge = new Day14();
        challenge.initGame();
        long numReceipts = challenge.getPartTwo(DAY14_INPUT + "");
        System.out.println(String.format("%s appears first after %s receipts.", DAY14_INPUT, numReceipts));
    }

}
