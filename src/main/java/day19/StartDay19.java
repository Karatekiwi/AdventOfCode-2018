
package day19;

import java.util.List;

import utils.FileUtils;

public class StartDay19 {

    private static final String DAY16_INPUT_TXT = "day16/input.txt";

    private static FileUtils    fileHelper      = new FileUtils();

    public static void main(String[] args) {
        Day19 challenge = new Day19();

        List<String> lines = fileHelper.readStringLines(DAY16_INPUT_TXT);
        for (String string : lines) {
            System.out.println(string);
        }
    }

}
