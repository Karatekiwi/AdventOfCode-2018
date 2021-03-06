
package day17;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import challenge.AdventOfCode;

public class Day17 extends AdventOfCode {

    private List<Point> points = new ArrayList<>();

    private Point[][]   area;
    private Point       waterStart;

    public void initGame(String file) {
        List<String> lines = readStringLines(file);
        area = new Point[1000][1000];
        initPoints(lines);
        addSpring();
    }

    public int getPartOne() {
        print();

        waterFlows();

        return 0;
    }

    private void waterFlows() {
        int x = waterStart.getX();
        int y = waterStart.getY();

        for (int ys = y; ys < 15; ys++) {
            Point next = area[ys + 1][x];

            if (isWall(next)) {
                createWater(x, ys, "~");
                break;
            } else {
                createWater(x, ys, "|");
            }

            print();
        }
    }

    private boolean isWall(Point point) {
        if (point != null && point.getValue().equals("#")) {
            return true;
        }

        return false;
    }

    private Point createWater(int x, int y, String symbol) {
        Point waterPoint = new Point(symbol);
        waterPoint.setX(x);
        waterPoint.setY(y);

        points.add(waterPoint);
        return waterPoint;
    }

    private void addSpring() {
        waterStart = new Point("+");
        waterStart.setX(500);
        waterStart.setY(0);

        area[waterStart.getY()][waterStart.getX()] = waterStart;
        points.add(waterStart);
    }

    private void initPoints(List<String> lines) {
        for (String line : lines) {
            List<Integer> xs = extractPoints(line, "x");
            List<Integer> ys = extractPoints(line, "y");

            for (Integer x : xs) {
                for (Integer y : ys) {
                    Point point = new Point("#");
                    point.setX(x);
                    point.setY(y);

                    area[y][x] = point;
                    points.add(point);
                }
            }
        }

    }

    private List<Integer> extractPoints(String line, String axis) {
        List<Integer> values = new ArrayList<>();
        Pattern pattern = null;
        if (line.startsWith(axis)) {
            pattern = Pattern.compile(axis + "=(.*),");
        } else {
            pattern = Pattern.compile(axis + "=(.*)$");
        }
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            String location = matcher.group(1);
            String[] split = location.split("\\.\\.");
            if (split.length > 1) {
                int start = Integer.parseInt(split[0]);
                int end = Integer.parseInt(split[1]);
                for (int index = start; index <= end; index++) {
                    values.add(index);
                }
            } else {
                String trim = location.replaceAll(",", "").trim();
                values.add(Integer.parseInt(trim));
            }
        }

        return values;
    }

    public void print() {
        for (Point point : points) {
            int x = point.getX();
            int y = point.getY();

            area[y][x] = point;
        }

        for (int ys = 0; ys < 15; ys++) {
            for (int xs = 494; xs < 508; xs++) {
                Point location = area[ys][xs];
                if (location != null) {
                    System.out.print(location.getValue());
                } else {
                    System.out.print(".");
                }
            }

            System.out.println("");
        }

        System.out.println("");
    }

}
