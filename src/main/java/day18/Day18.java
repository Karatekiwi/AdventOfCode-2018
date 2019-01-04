
package day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import challenge.AdventOfCode;
import day18.Point.Type;

public class Day18 extends AdventOfCode {

    private Point[][] area;

    private Point[][] cloned;

    public void initGame(String file, int sizeX, int sizeY) {
        List<String> lines = readStringLines(file);

        area = new Point[sizeX][sizeY];

        initArea(lines);
    }

    private void initArea(List<String> lines) {
        for (int y = 0; y < lines.size(); y++) {
            char[] lineArray = lines.get(y).toCharArray();

            for (int x = 0; x < lineArray.length; x++) {
                area[x][y] = createPoint(lineArray[x], x, y);
            }
        }
    }

    private Point createPoint(char symbol, int x, int y) {
        Type type = null;
        if (symbol == '.') {
            type = Type.GROUND;
        }
        if (symbol == '#') {
            type = Type.LUMBERYARD;
        }
        if (symbol == '|') {
            type = Type.TREE;
        }

        return new Point(x, y, type);
    }

    private void print() {
        for (int y = 0; y < area.length; y++) {

            for (int x = 0; x < area[y].length; x++) {
                Point point = area[x][y];

                Type type = point.getType();
                if (type == Type.GROUND) {
                    System.out.print(".");
                }
                if (type == Type.TREE) {
                    System.out.print("|");
                }
                if (type == Type.LUMBERYARD) {
                    System.out.print("#");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public int getPartOne(int numMinutes) {
        for (int index = 1; index <= numMinutes; index++) {
            adaptChanges();

            int result = getResult();
            if (index % 28 == 20) {
                System.out.println(index + ": " + result);
            }
        }

        return 0;
    }

    private int getResult() {
        int numTrees = 0;
        int numLumber = 0;
        for (int y = 0; y < area.length; y++) {

            for (int x = 0; x < area[y].length; x++) {
                Point point = area[x][y];

                Type type = point.getType();
                if (type == Type.TREE) {
                    numTrees++;
                }
                if (type == Type.LUMBERYARD) {
                    numLumber++;
                }
            }
        }

        return numTrees * numLumber;
    }

    private void adaptChanges() {
        cloned = Arrays.stream(area).map(el -> el.clone()).toArray($ -> area.clone());

        for (int y = 0; y < area.length; y++) {
            for (int x = 0; x < area[y].length; x++) {
                updatePoint(x, y);
            }
        }

        area = cloned;
    }

    private void updatePoint(int x, int y) {
        Type type = area[x][y].getType();

        switch (type) {
            case GROUND:
                updateGround(x, y);
                break;
            case TREE:
                updateTree(x, y);
                break;
            case LUMBERYARD:
                updateLumberyard(x, y);
                break;
            default:
                break;
        }
    }

    private void updateLumberyard(int x, int y) {
        List<Point> nearBy = getNearbyPoints(x, y);
        long nearLumberyards = nearBy.stream().filter(p -> p.getType() == Type.LUMBERYARD).count();
        long nearTrees = nearBy.stream().filter(p -> p.getType() == Type.TREE).count();

        if (nearLumberyards >= 1 && nearTrees >= 1) {
            return;
        }

        cloned[x][y] = new Point(x, y, Type.GROUND);
    }

    private void updateTree(int x, int y) {
        List<Point> nearBy = getNearbyPoints(x, y);
        long nearLumberyards = nearBy.stream().filter(p -> p.getType() == Type.LUMBERYARD).count();

        if (nearLumberyards >= 3) {
            cloned[x][y] = new Point(x, y, Type.LUMBERYARD);
        }
    }

    private void updateGround(int x, int y) {
        List<Point> nearBy = getNearbyPoints(x, y);
        long nearTrees = nearBy.stream().filter(p -> p.getType() == Type.TREE).count();

        if (nearTrees >= 3) {
            cloned[x][y] = new Point(x, y, Type.TREE);
        }
    }

    private List<Point> getNearbyPoints(int x, int y) {
        List<Point> nearby = new ArrayList<>();

        for (int ys = y - 1; ys <= y + 1; ys++) {

            for (int xs = x - 1; xs <= x + 1; xs++) {
                try {
                    Point curr = area[xs][ys];

                    // do not count myself
                    if (xs == x && ys == y) {
                        continue;
                    }
                    nearby.add(curr);

                } catch (IndexOutOfBoundsException ex) {
                    // noop
                }
            }
        }

        return nearby;
    }
}
