
package day2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import utils.FileUtils;

public class Day2 {

    private static final String DAY2_INPUT_TXT = "day2/input.txt";

    public static void main(String[] args) {
        FileUtils fileHelper = new FileUtils();
        List<String> list = fileHelper.readStringLines(DAY2_INPUT_TXT);

        int sum = getCheckSum(list);
        System.out.println("The resulting checksum is: " + sum);

        String match = getCommonLetters(list);
        System.out.println("The common letters are: " + match);
    }

    public static int getCheckSum(List<String> boxIds) {
        int countTwice = 0;
        int countThrice = 0;

        for (String boxId : boxIds) {
            List<Character> characters = getCharList(boxId);
            List<Character> alreadyCounted = new ArrayList<>();
            boolean twice = false;
            boolean thrice = false;

            for (Character character : characters) {
                if (alreadyCounted.contains(character)) {
                    continue;
                }

                int count = StringUtils.countMatches(boxId, character);

                if (count == 2) {
                    twice = true;
                }

                if (count == 3) {
                    thrice = true;
                }

                alreadyCounted.add(character);
            }

            if (twice) {
                countTwice += 1;
            }

            if (thrice) {
                countThrice += 1;
            }

        }

        return countTwice * countThrice;
    }

    private static List<Character> getCharList(String boxId) {
        return boxId.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
    }

    public static String getCommonLetters(List<String> boxIds) {
        for (String boxId1 : boxIds) {

            for (String boxId2 : boxIds) {
                if (boxId1.equals(boxId2)) {
                    continue;
                }

                String matching = getMatching(boxId1, boxId2);
                if (matching != "") {
                    return matching;
                }
            }
        }

        return "";
    }

    private static String getMatching(String boxId1, String boxId2) {
        List<Character> characters1 = getCharList(boxId1);
        List<Character> characters2 = getCharList(boxId2);
        int indexOfMismatch = 0;
        int misMatchCount = 0;

        for (int index = 0; index < characters1.size(); index++) {
            Character character1 = characters1.get(index);
            Character character2 = characters2.get(index);

            if (character1.equals(character2)) {
                continue;
            } else {
                misMatchCount++;
                if (misMatchCount == 1) {
                    indexOfMismatch = index;
                }
            }
        }

        if (misMatchCount == 1) {
            StringBuilder result = new StringBuilder(boxId1);
            result.deleteCharAt(indexOfMismatch);
            return result.toString();
        }

        return "";

    }

}
