
package day13;

public class MovementHelper {

    public void changeDirection(Cart cart, String guide) {
        Direction direction = cart.getMovementDirection();

        switch (guide) {
            case "\\":
                if (Direction.RIGHT == direction) {
                    cart.setMovementDirection(Direction.DOWN);
                }
                if (Direction.LEFT == direction) {
                    cart.setMovementDirection(Direction.UP);
                }
                if (Direction.DOWN == direction) {
                    cart.setMovementDirection(Direction.RIGHT);
                }
                if (Direction.UP == direction) {
                    cart.setMovementDirection(Direction.LEFT);
                }
                break;
            case "/":
                if (Direction.LEFT == direction) {
                    cart.setMovementDirection(Direction.DOWN);
                }
                if (Direction.RIGHT == direction) {
                    cart.setMovementDirection(Direction.UP);
                }
                if (Direction.DOWN == direction) {
                    cart.setMovementDirection(Direction.LEFT);
                }
                if (Direction.UP == direction) {
                    cart.setMovementDirection(Direction.RIGHT);
                }
                break;
            case "+":
                handleCrossing(cart, direction);
                break;
            default:
                break;
        }
    }

    private void handleCrossing(Cart cart, Direction direction) {
        Direction crossingDirection = cart.getCrossingDirection();

        switch (direction) {
            case RIGHT:
                switch (crossingDirection) {
                    case RIGHT:
                        cart.setMovementDirection(Direction.DOWN);
                        break;
                    case LEFT:
                        cart.setMovementDirection(Direction.UP);
                        break;
                    case STRAIGHT:
                        cart.setMovementDirection(Direction.RIGHT);
                        break;
                    default:
                        break;
                }
                break;
            case LEFT:
                switch (crossingDirection) {
                    case RIGHT:
                        cart.setMovementDirection(Direction.UP);
                        break;
                    case LEFT:
                        cart.setMovementDirection(Direction.DOWN);
                        break;
                    case STRAIGHT:
                        cart.setMovementDirection(Direction.LEFT);
                        break;
                    default:
                        break;
                }
                break;
            case DOWN:
                switch (crossingDirection) {
                    case RIGHT:
                        cart.setMovementDirection(Direction.LEFT);
                        break;
                    case LEFT:
                        cart.setMovementDirection(Direction.RIGHT);
                        break;
                    case STRAIGHT:
                        cart.setMovementDirection(Direction.DOWN);
                        break;
                    default:
                        break;
                }
                break;
            case UP:
                switch (crossingDirection) {
                    case RIGHT:
                        cart.setMovementDirection(Direction.RIGHT);
                        break;
                    case LEFT:
                        cart.setMovementDirection(Direction.LEFT);
                        break;
                    case STRAIGHT:
                        cart.setMovementDirection(Direction.UP);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        updateCrossingDirection(cart, crossingDirection);
    }

    private void updateCrossingDirection(Cart cart, Direction crossingDirection) {
        switch (crossingDirection) {
            case RIGHT:
                cart.setCrossingDirection(Direction.LEFT);
                break;
            case LEFT:
                cart.setCrossingDirection(Direction.STRAIGHT);
                break;
            case STRAIGHT:
                cart.setCrossingDirection(Direction.RIGHT);
                break;
            default:
                break;
        }
    }

}
