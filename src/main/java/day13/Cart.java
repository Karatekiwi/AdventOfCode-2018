/**
* (C) Copyright 2004 - 2017 CPB Software AG
* 1020 Wien, Vorgartenstrasse 206c
* All rights reserved.
* 
* Created on : 13 Dec 2018
* Created by : mawe
*/

package day13;

public class Cart {

    private int       id;
    private Direction movementDirection;
    private Direction crossingDirection;
    private int       x;
    private int       y;

    public Cart(int id) {
        this.id = id;
        crossingDirection = Direction.LEFT;
    }

    public Direction getCrossingDirection() {
        return crossingDirection;
    }

    public void setCrossingDirection(Direction crossingDirection) {
        this.crossingDirection = crossingDirection;
    }

    public Direction getMovementDirection() {
        return movementDirection;
    }

    public void setMovementDirection(Direction movementDirection) {
        this.movementDirection = movementDirection;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cart [id=" + id + ", direction=" + movementDirection + ", x=" + x + ", y=" + y + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cart other = (Cart) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
