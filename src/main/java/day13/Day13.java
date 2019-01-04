
package day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import challenge.AdventOfCode;

public class Day13 extends AdventOfCode {

    private String[][]     grid;
    private MovementHelper movement         = new MovementHelper();
    private List<Cart>     carts            = new ArrayList<>();
    boolean                noCrash          = true;

    private String         crashLocation;
    private boolean        partTwo;
    private List<Cart>     toRemove         = new ArrayList<>();
    private boolean        multipleCarsLeft = true;
    private int            cartId           = 0;

    public void initGame(String file, int sizeX, int sizeY) {
        grid = new String[sizeX][sizeY];

        List<String> lines = readStringLines(file);
        initGrid(lines);
        initCarts();
    }

    public String getPartOne() {
        print();

        while (noCrash) {
            sortCarts();
            moveCarts();
            // print();
        }

        return crashLocation;
    }

    private void sortCarts() {
        Collections.sort(carts, new Comparator<Cart>() {

            @Override
            public int compare(Cart c1, Cart c2) {
                if (c1.getY() < c2.getY()) {
                    return -1;
                }

                if (c1.getY() > c2.getY()) {
                    return 1;
                }

                return Integer.compare(c1.getX(), c2.getX());

            }
        });

    }

    private void initCarts() {
        for (int ys = 0; ys < grid.length; ys++) {
            String[] row = grid[ys];

            for (int xs = 0; xs < row.length; xs++) {
                String letter = grid[ys][xs];

                if (">".equals(letter)) {
                    createCart(Direction.RIGHT, xs, ys);
                }
                if ("v".equals(letter)) {
                    createCart(Direction.DOWN, xs, ys);
                }
                if ("^".equals(letter)) {
                    createCart(Direction.UP, xs, ys);
                }
                if ("<".equals(letter)) {
                    createCart(Direction.LEFT, xs, ys);
                }
            }
        }
    }

    private void createCart(Direction dir, int xs, int ys) {
        Cart cart = new Cart(cartId);
        cart.setX(xs);
        cart.setY(ys);
        cart.setMovementDirection(dir);
        carts.add(cart);
        cartId++;
    }

    private void moveCarts() {
        for (Cart cart : carts) {
            if (!toRemove.contains(cart)) {
                moveCart(cart);
            }
        }
    }

    private void moveCart(Cart cart) {
        int x = cart.getX();
        int y = cart.getY();
        String current = grid[y][x];
        movement.changeDirection(cart, current);
        Direction movementDirection = cart.getMovementDirection();

        switch (movementDirection) {
            case RIGHT:
                setAndCheck(cart, cart.getX() + 1, cart.getY());
                break;
            case DOWN:
                setAndCheck(cart, cart.getX(), cart.getY() + 1);
                break;
            case LEFT:
                setAndCheck(cart, cart.getX() - 1, cart.getY());
                break;
            case UP:
                setAndCheck(cart, cart.getX(), cart.getY() - 1);
                break;
            default:
                break;
        }
    }

    private void setAndCheck(Cart cart, int x, int y) {
        Cart findCartAt = findCartAt(x, y);

        for (Cart existing : carts) {
            if (toRemove.contains(cart) || toRemove.contains(findCartAt)) {
                continue;
            }

            if (existing.getX() == x && existing.getY() == y) {
                noCrash = false;
                crashLocation = x + "," + y;

                if (partTwo) {
                    toRemove.add(cart);
                    toRemove.add(findCartAt);

                    if (toRemove.size() == carts.size() - 1) {
                        multipleCarsLeft = false;
                        break;
                    }
                }

                break;
            }
        }

        cart.setX(x);
        cart.setY(y);
    }

    private Cart findCartAt(int x, int y) {
        Optional<Cart> found = carts.stream().filter(cart -> cart.getX() == x && cart.getY() == y).findFirst();
        if (found.isPresent()) {
            return found.get();
        }

        return null;
    }

    private void initGrid(List<String> lines) {
        int row = 0;
        for (String line : lines) {
            char[] charArray = line.toCharArray();
            for (int index = 0; index < charArray.length; index++) {
                char letter = charArray[index];
                grid[row][index] = String.valueOf(letter);
            }
            row++;
        }

        // print();

    }

    public void print() {
        System.out.println("");
        String[][] toPrint = Arrays.stream(grid).map(r -> r.clone()).toArray(String[][]::new);

        for (Cart cart : carts) {
            if (toRemove.contains(cart)) {
                continue;
            }
            int x = cart.getX();
            int y = cart.getY();

            toPrint[y][x] = cart.getId() + "";
        }

        for (String[] name : toPrint) {
            for (String string : name) {
                if (string == null) {
                    System.out.print("");
                } else {
                    System.out.print(string);
                }
            }
            System.out.println("");
        }
    }

    public String getPartTwo() {
        partTwo = true;

        print();

        while (multipleCarsLeft) {
            sortCarts();
            moveCarts();
            // print();
        }

        print();

        return calculateLastCart();
    }

    private String calculateLastCart() {
        for (Cart cart : carts) {
            if (toRemove.contains(cart)) {
                continue;
            }

            System.out.println(cart);
            return cart.getX() + "," + cart.getY();
        }

        return "No Cart found";
    }

}
