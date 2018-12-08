
package day1;

import java.util.ArrayList;
import java.util.List;

import utils.FileUtils;

public class Day1 {

    private static final String  DAY1_INPUT_TXT = "day1/input.txt";
    private static List<Integer> existing       = new ArrayList<>();

    public static void main(String[] args) {
        int fequency = 0;

        FileUtils fileHelper = new FileUtils();
        List<Integer> numbers = fileHelper.readIntLines(DAY1_INPUT_TXT);

        int newFrequency = calculateFrequency(fequency, numbers);
        int duplicate = findFirstDuplicate(fequency, numbers);

        System.out.println("The resulting frequency is: " + newFrequency);
        System.out.println("The first duplicate is : " + duplicate);
    }

    public static int calculateFrequency(int start, List<Integer> numbers) {
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        return start + sum;
    }

    public static int findFirstDuplicate(int start, List<Integer> numbers) {
        int calculateStart = start;

        for (Integer num : numbers) {
            calculateStart += num;

            if (existing.contains(calculateStart)) {
                return calculateStart;
            }

            existing.add(calculateStart);
        }

        return findFirstDuplicate(calculateStart, numbers);
    }

}
