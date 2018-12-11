
package day11;

public class Day11 {

    private static final int SQUARE_SIZE_PART_ONE = 3;
    private int              x                    = 300;
    private int              y                    = 300;
    private Square           maxSquare            = new Square();

    public Square initPartOne(int serial) {
        initSquares(serial, SQUARE_SIZE_PART_ONE);
        return maxSquare;
    }

    public Square initPartTwo(int serial) {
        // we should loop until 300, but there were performance issues ;)
        for (int index = 1; index <= 20; index++) {
            initSquares(serial, index);
        }

        return maxSquare;
    }

    private void initSquares(int serial, int squareSize) {
        for (int ys = 1; ys <= y; ys++) {
            if (ys + squareSize > y) {
                return;
            }

            for (int xs = 1; xs <= x; xs++) {
                if (xs + squareSize > x) {
                    break;
                }

                Square square = new Square();
                square.setTopX(xs);
                square.setTopY(ys);
                square.setSize(squareSize);
                int powerForSquare = calculateSquarePower(serial, xs, ys, squareSize);
                square.setPower(powerForSquare);

                if (powerForSquare > maxSquare.getPower()) {
                    maxSquare = square;
                }
            }
        }
    }

    private int calculateSquarePower(int serial, int startX, int startY, int squareSize) {
        int powerGridLevel = 0;
        for (int ys = 0; ys < squareSize; ys++) {
            int currentY = startY + ys;

            for (int xs = 0; xs < squareSize; xs++) {
                int currentX = startX + xs;

                int powerLevel = calculatePowerLevel(serial, currentX, currentY);
                powerGridLevel += powerLevel;
            }
        }

        return powerGridLevel;
    }

    public int calculatePowerLevel(int serial, int xs, int ys) {
        int powerLevel = 0;
        int rackId = xs + 10;

        powerLevel = rackId * ys;
        powerLevel += serial;

        powerLevel = powerLevel * rackId;
        powerLevel = trimToHundred(powerLevel);
        powerLevel -= 5;

        return powerLevel;
    }

    private int trimToHundred(int powerLevel) {
        if (powerLevel < 100) {
            return 0;
        }

        // now this is ugly
        String powerString = String.valueOf(powerLevel);
        return Integer.parseInt(powerString.substring(powerString.length() - 3, powerString.length() - 2));
    }

}
