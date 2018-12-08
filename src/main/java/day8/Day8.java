
package day8;

import java.util.List;

import utils.FileUtils;

public class Day8 {

    private static final String DAY8_INPUT_TXT = "day8/input.txt";

    public static void main(String[] args) {
        FileUtils fileHelper = new FileUtils();
        List<String> input = fileHelper.readStringLines(DAY8_INPUT_TXT);
    }

}
