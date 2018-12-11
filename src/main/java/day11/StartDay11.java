
package day11;

public class StartDay11 {

    private static final int SERIAL_NUMBER = 7989;

    public static void main(String[] args) {
        Day11 challenge = new Day11();
        Square maxSquare = challenge.initPartOne(SERIAL_NUMBER);
        System.out.println(String.format("%s,%s with total power of %s.", maxSquare.getTopX(), maxSquare.getTopY(), maxSquare.getPower()));

        Square maxSquare2 = challenge.initPartTwo(SERIAL_NUMBER);
        System.out.println(String.format("%s,%s,%s with total power of %s.", maxSquare2.getTopX(), maxSquare2.getTopY(), maxSquare2.getSize(),
            maxSquare2.getPower()));
    }

}
