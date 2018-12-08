/**
* (C) Copyright 2004 - 2017 CPB Software AG
* 1020 Wien, Vorgartenstrasse 206c
* All rights reserved.
* 
* Created on : 6 Dec 2018
* Created by : mawe
*/

package day6;

public class Point {

    private String id;
    private int    x;
    private int    y;
    private int    numNeighbours;

    public Point(String id, int x, int y) {
        super();
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getNumNeighbours() {
        return numNeighbours;
    }

    public void setNumNeighbours(int numNeighbours) {
        this.numNeighbours = numNeighbours;
    }

    @Override
    public String toString() {
        return "Point [id=" + id + ", x=" + x + ", y=" + y + ", numNeighbours=" + numNeighbours + "]";
    }

}
