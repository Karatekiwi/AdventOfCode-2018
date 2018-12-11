/**
* (C) Copyright 2004 - 2017 CPB Software AG
* 1020 Wien, Vorgartenstrasse 206c
* All rights reserved.
* 
* Created on : 11 Dec 2018
* Created by : mawe
*/

package day11;

public class Square {

    private int topX  = 0;
    private int topY  = 0;

    private int size  = 0;

    private int power = 0;

    public int getTopX() {
        return topX;
    }

    public void setTopX(int topX) {
        this.topX = topX;
    }

    public int getTopY() {
        return topY;
    }

    public void setTopY(int topY) {
        this.topY = topY;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Square [topX=" + topX + ", topY=" + topY + ", size=" + size + ", power=" + power + "]";
    }

}
