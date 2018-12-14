
package day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day14 {

    private List<Integer> receipts = new ArrayList<>();
    private List<Elf>     elfs     = new ArrayList<>();
    private boolean       partTwo;
    private String        toCheck;
    private String        sequence = "37";

    public void initGame() {
        // init receipts
        receipts.addAll(Arrays.asList(3, 7));

        // init elfs
        elfs.add(new Elf(0, 0));
        elfs.add(new Elf(1, 1));

    }

    public long getPartOne(int input) {
        // print();

        while (true) {
            addNewReceipts();
            // print();

            if (receipts.size() > input + 10) {
                break;
            }
        }

        return calculateScore(input);
    }

    private long calculateScore(int start) {
        String result = "";

        for (int index = 0; index < 10; index++) {
            result += receipts.get(start + index);
        }

        return Long.valueOf(result);
    }

    private void addNewReceipts() {
        createNewReceipts();
        moveElfIndex();
    }

    private void moveElfIndex() {
        Elf elf0 = elfs.get(0);
        int elf0Index = elf0.getIndex();
        Elf elf1 = elfs.get(1);
        int elf1Index = elf1.getIndex();

        int elf0IndexNew = elf0Index + 1 + receipts.get(elf0Index);
        int elf1IndexNew = elf1Index + 1 + receipts.get(elf1Index);

        while (elf0IndexNew >= receipts.size()) {
            elf0IndexNew = elf0IndexNew - receipts.size();
        }

        while (elf1IndexNew >= receipts.size()) {
            elf1IndexNew = elf1IndexNew - receipts.size();
        }

        elf0.setIndex(elf0IndexNew);
        elf1.setIndex(elf1IndexNew);
    }

    private void createNewReceipts() {
        int elf0Index = elfs.get(0).getIndex();
        int elf1Index = elfs.get(1).getIndex();

        int sum = receipts.get(elf0Index) + receipts.get(elf1Index);
        String sumString = String.valueOf(sum);

        if (partTwo && sumString.equals(toCheck)) {
            print();
            System.exit(0);
        }

        char[] newReceipts = sumString.toCharArray();
        for (char receipt : newReceipts) {
            String score = String.valueOf(receipt);
            sequence += score;
            receipts.add(Integer.parseInt(score));
        }
    }

    private void print() {
        int elf0Index = elfs.get(0).getIndex();
        int elf1Index = elfs.get(1).getIndex();

        for (int index = 0; index < receipts.size(); index++) {
            Integer score = receipts.get(index);

            if (index == elf0Index) {
                System.out.print(String.format("(%s)", score));
            }

            else if (index == elf1Index) {
                System.out.print(String.format("[%s]", score));
            }

            else {
                System.out.print(String.format("%s", score));
            }
        }

        System.out.println("");
    }

    public long getPartTwo(String input) {
        this.partTwo = true;
        // print();

        while (true) {
            addNewReceipts();
            if (findSequence(input)) {
                break;
            }
        }

        return calculateResult(input);
    }

    private long calculateResult(String input) {
        sequence = sequence.replace(input, "");
        return sequence.length();
    }

    private boolean findSequence(String input) {
        if (sequence.indexOf(input) != -1) {
            return true;
        }

        return false;
    }

}
