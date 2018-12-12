/**
* (C) Copyright 2004 - 2017 CPB Software AG
* 1020 Wien, Vorgartenstrasse 206c
* All rights reserved.
* 
* Created on : 12 Dec 2018
* Created by : mawe
*/

package day12;

public class Pattern {

    private String pattern;
    private String nextGen;

    public Pattern(String pattern, String nextGen) {
        super();
        this.pattern = pattern;
        this.nextGen = nextGen;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getNextGen() {
        return nextGen;
    }

    public void setNextGen(String nextGen) {
        this.nextGen = nextGen;
    }

    @Override
    public String toString() {
        return "Pattern [pattern=" + pattern + ", nextGen=" + nextGen + "]";
    }

}
