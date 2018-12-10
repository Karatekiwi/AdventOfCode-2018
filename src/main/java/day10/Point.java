
package day10;

public class Point {

    private int posX;
    private int posY;

    private int velocityX;
    private int velocityY;

    public Point() {

    }

    public Point(int posX, int posY, int velocityX, int velocityY) {
        super();
        this.posX = posX;
        this.posY = posY;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    @Override
    public String toString() {
        return "Point [posX=" + posX + ", posY=" + posY + ", velocityX=" + velocityX + ", velocityY=" + velocityY + "]";
    }

}
