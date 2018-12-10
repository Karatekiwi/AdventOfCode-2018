/**
* (C) Copyright 2004 - 2017 CPB Software AG
* 1020 Wien, Vorgartenstrasse 206c
* All rights reserved.
* 
* Created on : 10 Dec 2018
* Created by : mawe
*/

package day10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHelper {

    public Point extractPoint(String line) {
        Pattern pattern = Pattern.compile("position=\\<(.*?)\\>");
        Matcher matcher = pattern.matcher(line);
        Point point = new Point();

        if (matcher.find()) {
            String location = matcher.group(1);
            String[] split = location.split(",");
            point.setPosX(Integer.parseInt(split[0].trim()));
            point.setPosY(Integer.parseInt(split[1].trim()));
        }

        pattern = Pattern.compile("velocity=\\<(.*?)\\>");
        matcher = pattern.matcher(line);

        if (matcher.find()) {
            String velocity = matcher.group(1);
            String[] split = velocity.split(",");
            point.setVelocityX(Integer.parseInt(split[0].trim()));
            point.setVelocityY(Integer.parseInt(split[1].trim()));
        }

        return point;
    }
}
