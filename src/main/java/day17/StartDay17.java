
package day17;

import java.util.List;

import utils.FileUtils;

public class StartDay17 {

    private static final String DAY16_INPUT_TXT = "day16/input.txt";

    private static FileUtils    fileHelper      = new FileUtils();

    public static void main(String[] args) {
        Day17 challenge = new Day17();

        List<String> lines = fileHelper.readStringLines(DAY16_INPUT_TXT);
        for (String string : lines) {
            System.out.println(string);
        }
    }

}
