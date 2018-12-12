/**
* (C) Copyright 2004 - 2017 CPB Software AG
* 1020 Wien, Vorgartenstrasse 206c
* All rights reserved.
* 
* Created on : 12 Dec 2018
* Created by : mawe
*/

package day12;

public class Plant {

    private int    index;
    private String plant;

    public Plant(int index, String plant) {
        this.index = index;
        this.plant = plant;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    @Override
    public String toString() {
        return "Plant [index=" + index + ", plant=" + plant + "]";
    }

}
