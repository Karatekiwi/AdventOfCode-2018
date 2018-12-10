
package day10;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day10 {

    private List<Point> points = new ArrayList<>();
    private InputHelper helper = new InputHelper();

    public void initChallenge(List<String> lines) {
        for (String line : lines) {
            Point point = helper.extractPoint(line);
            points.add(point);
        }
    }

    public void getPartOne() {
        for (int index = 0; index < 50000; index++) {
            for (Point point : points) {
                int posX = point.getPosX();
                int posY = point.getPosY();

                posX += point.getVelocityX();
                posY += point.getVelocityY();

                point.setPosX(posX);
                point.setPosY(posY);
            }

            int width = calculateWidth();
            int height = calculateHeight();

            // in order to get a word - the points must be near each other
            if (width <= 100 && height <= 100) {
                fillAndPrintGrid(index);
            }
        }
    }

    private void fillAndPrintGrid(int index) {
        String grid[][] = new String[500][500];

        for (Point point : points) {
            int posX = point.getPosX();
            int posY = point.getPosY();

            if (posX > 0 && posY > 0) {
                grid[posY][posX] = "#";
            }
        }

        printToFile(grid, index);
    }

    private int calculateHeight() {
        return getMaxY() - getMinY();
    }

    private int calculateWidth() {
        return getMaxX() - getMinX();
    }

    private int getMaxX() {
        return points.stream().mapToInt(point -> point.getPosX()).max().orElse(0) + 1;
    }

    private int getMinX() {
        return points.stream().mapToInt(point -> point.getPosX()).min().orElse(0) + 1;
    }

    private int getMaxY() {
        return points.stream().mapToInt(point -> point.getPosY()).max().orElse(0) + 1;
    }

    private int getMinY() {
        return points.stream().mapToInt(point -> point.getPosY()).max().orElse(0) + 1;
    }

    private void printToFile(String[][] grid, int index) {
        List<String> lines = new ArrayList<>();

        for (String[] line : grid) {
            String toPrint = "";
            for (String string : line) {
                if (string == null) {
                    toPrint += " ";
                } else {
                    toPrint += string;
                }
            }
            lines.add(toPrint);
        }

        Path file = Paths.get("asdf" + index + ".txt");
        try {
            Path path = Files.write(file, lines, Charset.forName("UTF-8"));
            System.out.println(path.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
