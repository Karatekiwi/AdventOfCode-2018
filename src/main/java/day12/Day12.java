
package day12;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import utils.FileUtils;

public class Day12 {

    private FileUtils     helper       = new FileUtils();

    private int           generations  = 20;

    private List<Pattern> plantPattern = new ArrayList<>();
    private List<Plant>   plants       = new ArrayList<>();

    public void initGame(String file) {
        List<String> input = helper.readStringLines(file);
        initInitialState(input.get(0));
        initPlantPattern(input);
    }

    private void initPlantPattern(List<String> input) {
        for (int index = 2; index < input.size(); index++) {
            String[] split = input.get(index).split("=>");
            plantPattern.add(new Pattern(split[0].trim(), split[1].trim()));
        }
    }

    private void initInitialState(String line) {
        String initState = line.replace("initial state: ", "");
        List<Plant> initialPlants = convertToPlants(initState);

        plants.addAll(addPlants(-5, 0));
        plants.addAll(initialPlants);
    }

    private List<Plant> addPlants(int from, int until) {
        List<Plant> additional = new ArrayList<>();

        for (int index = from; index < until; index++) {
            additional.add(new Plant(index, "."));
        }

        return additional;
    }

    public int getPartOne() {
        for (int index = 0; index < generations; index++) {
            calculatePlantGrowth(index);
        }

        print(generations);
        return countPlants();
    }

    private int countPlants() {
        int num = 0;
        for (Plant plant : plants) {
            if (plant.getPlant().equals("#")) {
                num += plant.getIndex();
            }
        }

        return num;
    }

    private void print(int index) {
        System.out.println(String.format("%s: %s (%s)", index, getPlantsAsString(), countPlants()));
    }

    private String getPlantsAsString() {
        String result = "";
        for (Plant plant : plants) {
            result += plant.getPlant();
        }
        return result;
    }

    private void calculatePlantGrowth(int plantIndex) {
        List<Plant> nextGen = new ArrayList<>(plants);

        for (int index = 0; index < nextGen.size(); index++) {
            addAdditionalPlants(nextGen);

            String plantPattern = calculatePattern(index);
            String newPlant = calculateNewPlant(plantPattern);
            nextGen.set(index, new Plant(nextGen.get(index).getIndex(), newPlant));
        }

        print(plantIndex);
        plants = nextGen;
    }

    private void addAdditionalPlants(List<Plant> nextGen) {
        boolean add = shouldWeAdd(nextGen);

        if (add) {
            nextGen.add(new Plant(nextGen.get(nextGen.size() - 1).getIndex() + 1, "."));
            nextGen.add(new Plant(nextGen.get(nextGen.size() - 1).getIndex() + 1, "."));
            nextGen.add(new Plant(nextGen.get(nextGen.size() - 1).getIndex() + 1, "."));
            nextGen.add(new Plant(nextGen.get(nextGen.size() - 1).getIndex() + 1, "."));
            nextGen.add(new Plant(nextGen.get(nextGen.size() - 1).getIndex() + 1, "."));
        }
    }

    private boolean shouldWeAdd(List<Plant> nextGen) {
        Plant plant = nextGen.get(nextGen.size() - 2);

        if (plant.getPlant().equals("#")) {
            return true;
        }

        return false;
    }

    private String calculateNewPlant(String pattern) {
        Optional<Pattern> found = plantPattern.stream().filter(pat -> pat.getPattern().equals(pattern)).findFirst();
        if (found.isPresent()) {
            return found.get().getNextGen();
        }

        return ".";
    }

    private String calculatePattern(int index) {
        int left2 = index - 2;
        int left1 = index - 1;
        int right1 = index + 1;
        int right2 = index + 2;

        String l2 = getPlantAtIndex(left2);
        String l1 = getPlantAtIndex(left1);
        String current = getPlantAtIndex(index);
        String r1 = getPlantAtIndex(right1);
        String r2 = getPlantAtIndex(right2);

        return l2 + l1 + current + r1 + r2;
    }

    private String getPlantAtIndex(int index) {
        try {
            return plants.get(index).getPlant();
        } catch (Exception ex) {
            // noop
        }

        return ".";
    }

    public List<Plant> convertToPlants(String input) {
        List<Plant> resultList = new ArrayList<>();

        for (int index = 0; index < input.length(); index++) {
            String value = Character.toString(input.charAt(index));
            resultList.add(new Plant(index, value));
        }

        return resultList;
    }

}
