
package day16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import utils.FileUtils;

public class Day16 {

    private FileUtils            helper       = new FileUtils();
    private List<Sample>         samples      = new ArrayList<>();
    private OpcodeChecker        checker      = new OpcodeChecker();
    private OpcodeCalculator     calculator   = new OpcodeCalculator();

    private Map<Integer, Opcode> opcodes      = new HashMap<>();
    private List<List<Integer>>  instructions = new ArrayList<>();

    public void initGame(String file, String file2) {
        List<String> lines = helper.readStringLines(file);
        List<String> lines2 = helper.readStringLines(file2);

        parseInput(lines);
        parseInput2(lines2);
    }

    private void parseInput2(List<String> lines) {
        for (String line : lines) {
            List<Integer> instruction = extractInstruction(line);
            instructions.add(instruction);
        }
    }

    private void parseInput(List<String> lines) {
        int index = 0;
        while (index < lines.size() - 2) {
            String inputLine = lines.get(index);
            String instructionLine = lines.get(index + 1);
            String outputLine = lines.get(index + 2);

            Sample sample = new Sample();
            sample.setInput(extractValues(inputLine));
            sample.setInstructions(extractInstruction(instructionLine));
            sample.setOutput(extractValues(outputLine));

            samples.add(sample);

            index += 4;
        }
    }

    private List<Integer> extractInstruction(String instructionLine) {
        List<Integer> values = new ArrayList<>();
        String[] split = instructionLine.split(" ");
        for (String string : split) {
            values.add(Integer.parseInt(string.trim()));
        }

        return values;
    }

    private List<Integer> extractValues(String line) {
        List<Integer> values = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            String location = matcher.group(1);
            String[] split = location.split(",");
            for (String string : split) {
                values.add(Integer.parseInt(string.trim()));
            }
        }

        return values;
    }

    public int getPartOne() {
        for (Sample sample : samples) {
            calculatePossibleOpcodes(sample);
        }

        return getResult();
    }

    public int getPartTwo() {
        initOpcodes();

        for (List<Integer> instruction : instructions) {
            executeInstruction(instruction);
        }

        return calculator.getRegister().get(0);
    }

    private void executeInstruction(List<Integer> instruction) {
        Integer opCodeNumber = instruction.get(0);
        Opcode opcode = opcodes.get(opCodeNumber);
        calculator.calculate(opcode, instruction);
    }

    private void initOpcodes() {
        List<Sample> sampleCopy = new ArrayList<>(samples);

        while (opcodes.size() < Opcode.values().length) {
            for (Iterator<Sample> iterator = sampleCopy.iterator(); iterator.hasNext();) {
                Sample sample = iterator.next();

                if (sample.getOpcodes().size() == 1) {
                    Opcode code = sample.getOpcodes().get(0);
                    Integer number = sample.getInstructions().get(0);
                    opcodes.put(number, code);
                    removeOpcode(code);
                }
            }
        }

        System.out.println(opcodes);
    }

    private void removeOpcode(Opcode code) {
        for (Sample sample : samples) {
            sample.getOpcodes().remove(code);
        }
    }

    private int getResult() {
        return samples.stream().filter(sample -> sample.getOpcodes().size() >= 3).collect(Collectors.toList()).size();
    }

    private void calculatePossibleOpcodes(Sample sample) {
        Opcode addr = checker.checkAddr(sample);
        if (addr != null) {
            sample.getOpcodes().add(addr);
        }

        Opcode addi = checker.checkAddi(sample);
        if (addi != null) {
            sample.getOpcodes().add(addi);
        }

        Opcode mulr = checker.checkMulr(sample);
        if (mulr != null) {
            sample.getOpcodes().add(mulr);
        }

        Opcode muli = checker.checkMuli(sample);
        if (muli != null) {
            sample.getOpcodes().add(muli);
        }

        Opcode banr = checker.checkBanr(sample);
        if (banr != null) {
            sample.getOpcodes().add(banr);
        }

        Opcode bani = checker.checkBani(sample);
        if (bani != null) {
            sample.getOpcodes().add(bani);
        }

        Opcode borr = checker.checkBorr(sample);
        if (borr != null) {
            sample.getOpcodes().add(borr);
        }

        Opcode bori = checker.checkBori(sample);
        if (bori != null) {
            sample.getOpcodes().add(bori);
        }

        Opcode setr = checker.checkSetr(sample);
        if (setr != null) {
            sample.getOpcodes().add(setr);
        }

        Opcode seti = checker.checkSeti(sample);
        if (seti != null) {
            sample.getOpcodes().add(seti);
        }

        Opcode gtir = checker.checkGtir(sample);
        if (gtir != null) {
            sample.getOpcodes().add(gtir);
        }

        Opcode gtri = checker.checkGtri(sample);
        if (gtri != null) {
            sample.getOpcodes().add(gtri);
        }

        Opcode gtrr = checker.checkGtrr(sample);
        if (gtrr != null) {
            sample.getOpcodes().add(gtrr);
        }

        Opcode eqir = checker.checkEqir(sample);
        if (eqir != null) {
            sample.getOpcodes().add(eqir);
        }

        Opcode eqri = checker.checkEqri(sample);
        if (eqri != null) {
            sample.getOpcodes().add(eqri);
        }

        Opcode eqrr = checker.checkEqrr(sample);
        if (eqrr != null) {
            sample.getOpcodes().add(eqrr);
        }
    }

}
