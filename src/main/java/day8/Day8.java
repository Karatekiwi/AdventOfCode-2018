
package day8;

import java.util.ArrayList;
import java.util.List;

import utils.FileUtils;

public class Day8 {

    private List<Integer> numbers;
    private List<Node>    nodes = new ArrayList<>();
    private int           index = 0;
    private int           rootValue;

    public void initInput(String input) {
        FileUtils fileHelper = new FileUtils();
        List<String> lines = fileHelper.readStringLines(input);

        numbers = getNumbers(lines.get(0));
        createNode(null);
    }

    public int getPartOne() {
        int solution = calculateSum(nodes);
        return solution;
    }

    private int calculateSum(List<Node> nodes) {
        int sum = 0;
        for (Node node : nodes) {
            sum += node.getMetadata().stream().mapToInt(i -> i.intValue()).sum();
        }

        return sum;
    }

    private void createNode(Node parent) {
        Node node = new Node();
        nodes.add(node);
        node.setNumChildren(numbers.get(index));
        index++;
        node.setNumMetadata(numbers.get(index));

        if (parent != null) {
            parent.getChildren().add(node);
        }

        for (int childIndex = 0; childIndex < node.getNumChildren(); childIndex++) {
            index++;
            createNode(node);
        }

        if (index == numbers.size()) {
            return;
        }

        for (int metaIndex = 0; metaIndex < node.getNumMetadata(); metaIndex++) {
            index++;
            node.getMetadata().add(numbers.get(index));
        }
    }

    private List<Integer> getNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] split = input.split(" ");
        for (String number : split) {
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }

    public int getPartTwo() {
        calculateValueForNode(nodes.get(0));

        return rootValue;
    }

    private void calculateValueForNode(Node node) {
        if (node.getChildren().isEmpty()) {
            rootValue += node.getMetadata().stream().mapToInt(i -> i.intValue()).sum();
            return;
        }

        List<Integer> metadata = node.getMetadata();
        for (Integer index : metadata) {
            index = index - 1;
            if (index < node.getChildren().size()) {
                Node child = node.getChildren().get(index);
                calculateValueForNode(child);
            }
        }
    }
}
