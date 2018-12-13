
package day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import utils.FileUtils;

public class Day13 {

    private String[][]     grid;
    private FileUtils      helper           = new FileUtils();
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

        List<String> lines = helper.readStringLines(file);
        initGrid(lines);
        initCarts();
    }

    public String getPartOne() {
        while (noCrash) {
            moveCarts();
            // print();
        }

        return crashLocation;
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
        Direction movementDirection = cart.getMovementDirection();
        int x = cart.getX();
        int y = cart.getY();
        String current = grid[y][x];

        switch (movementDirection) {
            case RIGHT:
                try {
                    String guide1 = grid[y][x + 1];
                    movement.changeDirection(cart, guide1, movementDirection);
                    setAndCheck(cart, cart.getX() + 1, cart.getY());
                } catch (Exception ex) {
                    if ("/".equals(current)) {
                        cart.setMovementDirection(Direction.UP);
                        cart.setY(cart.getY() - 1);
                    } else {
                        cart.setMovementDirection(Direction.DOWN);
                        cart.setY(cart.getY() + 1);
                    }
                }
                break;
            case DOWN:
                try {
                    String guide2 = grid[y + 1][x];
                    movement.changeDirection(cart, guide2, movementDirection);
                    setAndCheck(cart, cart.getX(), cart.getY() + 1);
                } catch (Exception ex) {
                    if ("/".equals(current)) {
                        cart.setMovementDirection(Direction.LEFT);
                        cart.setX(cart.getX() - 1);
                    } else {
                        cart.setMovementDirection(Direction.RIGHT);
                        cart.setX(cart.getX() + 1);
                    }
                }
                break;
            case LEFT:
                try {
                    String guide3 = grid[y][x - 1];
                    movement.changeDirection(cart, guide3, movementDirection);
                    setAndCheck(cart, cart.getX() - 1, cart.getY());
                } catch (Exception ex) {
                    if ("\\".equals(current)) {
                        cart.setMovementDirection(Direction.UP);
                        cart.setY(cart.getY() - 1);
                    } else {
                        cart.setMovementDirection(Direction.DOWN);
                        cart.setY(cart.getY() + 1);
                    }
                }
                break;
            case UP:
                try {
                    String guide4 = grid[y - 1][x];
                    movement.changeDirection(cart, guide4, movementDirection);
                    setAndCheck(cart, cart.getX(), cart.getY() - 1);
                } catch (Exception ex) {
                    if ("\\".equals(current)) {
                        cart.setMovementDirection(Direction.LEFT);
                        cart.setX(cart.getX() - 1);
                    } else {
                        cart.setMovementDirection(Direction.RIGHT);
                        cart.setX(cart.getX() + 1);
                    }
                }
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
