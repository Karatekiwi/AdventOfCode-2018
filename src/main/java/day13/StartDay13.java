
package day13;

public class StartDay13 {

    private static final String DAY13_INPUT_TXT = "day13/input.txt";

    public static void main(String[] args) {
        Day13 challenge = new Day13();

        // init
        challenge.initGame(DAY13_INPUT_TXT, 150, 150);
        String crashLocation = challenge.getPartOne();
        System.out.println(String.format("The location for the first crash is %s.", crashLocation));

        // // init again
        challenge = new Day13();
        challenge.initGame(DAY13_INPUT_TXT, 150, 150);
        String lastCartLocation = challenge.getPartTwo();
        System.out.println(String.format("The last cart's location is %s.", lastCartLocation));
    }

}
