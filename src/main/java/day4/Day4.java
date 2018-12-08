
package day4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import utils.FileUtils;

public class Day4 {

    private static final String DAY4_INPUT_TXT = "day4/input.txt";

    private static final String GUARD          = "Guard";
    private static final String WAKES_UP       = "wakes up";
    private static final String FALLS_ASLEEP   = "falls asleep";

    private static InputHelper  helper         = new InputHelper();

    public static void main(String[] args) {
        FileUtils fileHelper = new FileUtils();
        List<String> input = fileHelper.readStringLines(DAY4_INPUT_TXT);

        Map<Date, String> timeline = helper.getTimeline(input);
        List<Guard> guards = transferToGuard(timeline);

        int solution = calculateMostLazyGuard(guards);
        System.out.println(String.format("The solution for part 1 is %s.", solution));

        int sleep = calculateMostSleepMinutes(guards);
        System.out.println(String.format("The solution for part 2 is %s.", sleep));
    }

    public static int calculateMostSleepMinutes(List<Guard> guards) {
        for (Guard guard : guards) {
            Map<Integer, Long> collect = guard.getSleep().stream().collect(Collectors.groupingBy(g -> g, Collectors.counting()));

            if (collect.isEmpty()) {
                continue;
            }

            Entry<Integer, Long> max = Collections.max(collect.entrySet(),
                (entry1, entry2) -> new BigDecimal(entry1.getValue() - entry2.getValue()).intValueExact());
            guard.setMaxSleep(new BigDecimal(max.getValue()).intValueExact());
            guard.setMaxSleepMinute(max.getKey());
        }

        Guard guard = guards.stream().max(Comparator.comparing(Guard::getMaxSleep)).get();
        return guard.getId() * guard.getMaxSleepMinute();
    }

    public static int calculateMostLazyGuard(List<Guard> guards) {
        Comparator<Guard> guardCmp = Comparator.comparing(Guard::getSleep, (g1, g2) -> {
            return Integer.compare(g1.size(), g2.size());
        });

        Guard guard = guards.stream().max(guardCmp).orElse(null);

        int guardId = guard.getId();
        int minute = findMostOccurences(guard);

        System.out.println(String.format("The guard with the maximum sleep has id %s and sleeps most in minute %s.", guardId, minute));

        return guardId * minute;
    }

    private static Integer findMostOccurences(Guard guard) {
        return guard.getSleep().stream()
            .reduce(BinaryOperator.maxBy((g1, g2) -> Collections.frequency(guard.getSleep(), g1) - Collections.frequency(guard.getSleep(), g2)))
            .orElse(null);
    }

    public static List<Guard> transferToGuard(Map<Date, String> timeline) {
        List<Guard> guards = new ArrayList<>();

        Guard guard = null;
        int startSleep = 0;
        int endSleep = 0;

        for (Map.Entry<Date, String> entry : timeline.entrySet()) {
            boolean newGuard = true;
            Date date = entry.getKey();
            String value = entry.getValue();

            if (value.startsWith(GUARD)) {
                if (guard != null && newGuard) {
                    guards.add(guard);
                }

                int id = helper.getId(value);
                guard = findOrCreateGuard(guards, id);
                if (guard == null) {
                    guard = new Guard();
                    guard.setId(id);
                } else {
                    newGuard = false;
                }
            }

            if (value.equals(FALLS_ASLEEP)) {
                startSleep = helper.getMinute(date);
            }

            if (value.equals(WAKES_UP)) {
                endSleep = helper.getMinute(date);
                if (guard != null) {
                    guard.getSleep().addAll(getSleepMinutes(startSleep, endSleep));
                }
            }
        }

        return guards;
    }

    private static Guard findOrCreateGuard(List<Guard> guards, int id) {
        return guards.stream().filter(guard -> guard.getId() == id).findFirst().orElse(null);
    }

    private static List<Integer> getSleepMinutes(int startSleep, int endSleep) {
        List<Integer> minutes = new ArrayList<>();

        for (int index = 1; index <= 60; index++) {
            if (index >= startSleep && index < endSleep) {
                minutes.add(index);
            }
        }

        return minutes;
    }

}
