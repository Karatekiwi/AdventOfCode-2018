/**
* (C) Copyright 2004 - 2017 CPB Software AG
* 1020 Wien, Vorgartenstrasse 206c
* All rights reserved.
* 
* Created on : 6 Dec 2018
* Created by : mawe
*/

package day6;

public class Neighbours {
    private int   distance;
    private Point point;

    public Neighbours(int distance, Point point) {
        super();
        this.distance = distance;
        this.point = point;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

}
