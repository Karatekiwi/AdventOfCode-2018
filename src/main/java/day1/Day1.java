
package day1;

import java.util.ArrayList;
import java.util.List;

import challenge.AdventOfCode;

public class Day1 extends AdventOfCode {

    private List<Integer> existing = new ArrayList<>();

    public void initGame(String path) {
        int fequency = 0;

        List<Integer> numbers = readIntLines(path);

        int newFrequency = calculateFrequency(fequency, numbers);
        int duplicate = findFirstDuplicate(fequency, numbers);

        System.out.println("The resulting frequency is: " + newFrequency);
        System.out.println("The first duplicate is : " + duplicate);
    }

    public int calculateFrequency(int start, List<Integer> numbers) {
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        return start + sum;
    }

    public int findFirstDuplicate(int start, List<Integer> numbers) {
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
