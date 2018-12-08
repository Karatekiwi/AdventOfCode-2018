
package day6;

import java.util.List;

import utils.FileUtils;

public class Day6 {

    private static final String DAY6_INPUT_TXT = "day6/input.txt";

    public static void main(String[] args) {
        FileUtils fileHelper = new FileUtils();
        List<String> input = fileHelper.readStringLines(DAY6_INPUT_TXT);
    }

}
