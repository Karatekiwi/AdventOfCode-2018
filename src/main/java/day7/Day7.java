
package day7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.FileUtils;

public class Day7 {

    private static final String DAY7_INPUT_TXT = "day7/input.txt";

    private static List<Step>   steps;

    private static List<Step>   result         = new ArrayList<>();
    private static List<Step>   tasksFinished  = new ArrayList<>();

    public static void main(String[] args) {
        FileUtils fileHelper = new FileUtils();
        List<String> input = fileHelper.readStringLines(DAY7_INPUT_TXT);
        prepareSteps(input, 60);
        getSequence();
        System.out.println(getResult());
        int completed = calculateTotalDuration(5);
        System.out.println(String.format("It took %s seconds to finish all tasks", completed));
    }

    public static int calculateTotalDuration(int numWorkers) {
        int freeWorkers = numWorkers;
        List<Step> inProgress = new ArrayList<>();

        int second = 0;

        while (true) {

            for (Iterator<Step> iterator = inProgress.iterator(); iterator.hasNext();) {
                Step step = iterator.next();
                if (step.getDuration() + step.getStart() == second) {
                    tasksFinished.add(step);
                    iterator.remove();
                    freeWorkers++;
                }
            }

            List<Step> availableSteps = getAvailableSteps(tasksFinished);

            for (Step step : availableSteps) {
                if (inProgress.contains(step)) {
                    continue;
                }
                if (freeWorkers == 0) {
                    continue;
                }

                step.setStart(second);
                inProgress.add(step);
                freeWorkers--;
            }

            if (tasksFinished.size() >= steps.size()) {
                break;
            }

            second++;
        }

        return second;
    }

    public static void getSequence() {
        while (result.size() < steps.size()) {
            addNextStep();
        }
    }

    public static String getResult() {
        String resultString = "";
        for (Step step : result) {
            resultString = resultString += step.getId();
        }

        return resultString;
    }

    private static void addNextStep() {
        List<Step> availableSteps = getAvailableSteps(result);
        Step chosen = chooseStep(availableSteps);
        result.add(chosen);
    }

    private static Step chooseStep(List<Step> availableSteps) {
        Collections.sort(availableSteps, getComparator());
        return availableSteps.get(0);
    }

    private static List<Step> getAvailableSteps(List<Step> toCheck) {
        List<Step> available = new ArrayList<>();
        for (Step step : steps) {
            if (toCheck.contains(step)) {
                continue;
            }

            boolean allPreSteps = checkPresteps(step, toCheck);
            if (!allPreSteps) {
                continue;
            }

            available.add(step);

        }

        return available;
    }

    private static Comparator<Step> getComparator() {
        return new Comparator<Step>() {

            @Override
            public int compare(Step o1, Step o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };
    }

    private static boolean checkPresteps(Step step, List<Step> toCheck) {
        for (Step preStep : step.getPreStep()) {
            if (!toCheck.contains(preStep)) {
                return false;
            }
        }

        return true;
    }

    public static void prepareSteps(List<String> input, int duration) {
        steps = getAllSteps(input, duration);

        for (Step step : steps) {
            for (String line : input) {
                if (line.contains("before step " + step.getId())) {
                    String stepId = find(line, "Step");
                    Step found = findStepById(stepId);
                    step.getPreStep().add(found);
                }
            }
        }

    }

    private static int calculateDuraction(Step found, int duration) {
        int num = stringToNumber(found.getId());
        return num + duration;
    }

    public static int stringToNumber(String s) {
        char ch = s.charAt(0);
        int result = (int) ch - 64;
        return result;
    }

    private static Step findStepById(String stepId) {
        return steps.stream().filter(step -> step.getId().equals(stepId)).findFirst().get();
    }

    public static List<Step> getAllSteps(List<String> input, int duration) {
        List<Step> steps = new ArrayList<>();
        for (String line : input) {
            String stepId1 = find(line, "Step");
            addStep(steps, stepId1, duration);
            String stepId2 = find(line, "step");
            addStep(steps, stepId2, duration);
        }

        return steps;
    }

    private static void addStep(List<Step> steps, String stepId, int duration) {
        Step step = new Step(stepId);

        if (!steps.contains(step)) {
            step.setDuration(calculateDuraction(step, duration));
            steps.add(step);
        }
    }

    public static String find(String line, String search) {
        Pattern pattern = Pattern.compile(search + "(\\W+(\\w+))");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            String step = matcher.group();
            return step.replace("Step", "").replace("step", "").trim();
        }

        return "";
    }

}
