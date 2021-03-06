
package day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import challenge.AdventOfCode;

public class Day5 extends AdventOfCode {

    public void initGame(String path) {
        List<String> input = readStringLines(path);
        String start = input.get(0);

        String finalString = calculateReduced(start);
        System.out.println(String.format("After the polymer reactions, there are %s units remaining.", finalString.length()));

        int numOfUnits = calculateResult(start);
        System.out.println(String.format("Length of shortest polymere is %s.", numOfUnits));
    }

    public String calculateReduced(String input) {
        List<Integer> indexToReplace = new ArrayList<>();
        boolean reduceFound = false;

        char[] charArray = input.toCharArray();
        for (int index = 0; index < charArray.length - 1; index++) {
            char currentChar = charArray[index];
            char nextChar = charArray[index + 1];
            String current = String.valueOf(currentChar);
            String next = String.valueOf(nextChar);

            if (!isSameChar(current, next)) {
                continue;
            }

            if (isOppositeCase(currentChar, nextChar)) {
                indexToReplace.add(index);
                indexToReplace.add(index + 1);
                index++;
                reduceFound = true;
            }
        }

        if (!reduceFound) {
            return input;
        }

        StringBuilder cutInput = new StringBuilder(input);
        Collections.sort(indexToReplace, Collections.reverseOrder());

        for (Integer replaceIndex : indexToReplace) {
            cutInput.deleteCharAt(replaceIndex);
        }

        return calculateReduced(cutInput.toString());
    }

    private boolean isOppositeCase(Character current, Character next) {
        return Character.isLowerCase(current) != Character.isLowerCase(next);
    }

    private boolean isSameChar(String current, String next) {
        return current.equalsIgnoreCase(next);
    }

    public int calculateResult(String input) {
        Map<String, Integer> count = new HashMap<>();
        List<String> chars = getCharacters(input);

        for (String character : chars) {
            String removed = getRemoved(input, character);
            count.put(character, calculateReduced(removed).length());
        }

        int shortest = count.values().stream().mapToInt(v -> v).min().getAsInt();
        return shortest;
    }

    private String getRemoved(String input, String character) {
        String upper = character.toUpperCase();
        String lower = character.toLowerCase();
        input = input.replaceAll(upper, "");
        input = input.replaceAll(lower, "");
        return input;
    }

    private List<String> getCharacters(String input) {
        List<String> chars = new ArrayList<>();

        for (char character : input.toCharArray()) {
            String current = String.valueOf(character);
            current = current.toLowerCase();
            if (!chars.contains(current)) {
                chars.add(current);
            }
        }

        return chars;
    }

}
