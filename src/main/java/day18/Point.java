/**
* (C) Copyright 2004 - 2017 CPB Software AG
* 1020 Wien, Vorgartenstrasse 206c
* All rights reserved.
* 
* Created on : 6 Dec 2018
* Created by : mawe
*/

package day18;

public class Point {

    private int  x;
    private int  y;

    private Type type;

    enum Type {
        GROUND, TREE, LUMBERYARD
    }

    public Point(int x, int y, Type type) {
        this.x = x;
        this.y = y;
        this.type = type;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + ", type=" + type + "]";
    }

}
