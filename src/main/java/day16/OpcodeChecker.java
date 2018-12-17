
package day16;

import java.util.List;

public class OpcodeChecker {

    // stores into register C the result of adding register A and register B
    public Opcode checkAddr(Sample sample) {
        List<Integer> input = sample.getInput();
        List<Integer> instructions = sample.getInstructions();
        List<Integer> output = sample.getOutput();

        int indexA = instructions.get(1);
        int indexB = instructions.get(2);
        int indexOutput = instructions.get(3);

        int calculate = input.get(indexA) + input.get(indexB);
        if (calculate == output.get(indexOutput)) {
            return Opcode.addr;
        }

        return null;
    }

    // stores into register C the result of adding register A and value B
    public Opcode checkAddi(Sample sample) {
        List<Integer> input = sample.getInput();
        List<Integer> instructions = sample.getInstructions();
        List<Integer> output = sample.getOutput();

        int indexA = instructions.get(1);
        int indexOutput = instructions.get(3);

        int calculate = input.get(indexA) + instructions.get(2);
        if (calculate == output.get(indexOutput)) {
            return Opcode.addi;
        }

        return null;
    }

    // stores into register C the result of multiplying register A and register B
    public Opcode checkMulr(Sample sample) {
        List<Integer> input = sample.getInput();
        List<Integer> instructions = sample.getInstructions();
        List<Integer> output = sample.getOutput();

        int indexA = instructions.get(1);
        int indexB = instructions.get(2);
        int indexOutput = instructions.get(3);

        int calculate = input.get(indexA) * input.get(indexB);
        if (calculate == output.get(indexOutput)) {
            return Opcode.mulr;
        }

        return null;
    }

    // stores into register C the result of multiplying register A and value B
    public Opcode checkMuli(Sample sample) {
        List<Integer> input = sample.getInput();
        List<Integer> instructions = sample.getInstructions();
        List<Integer> output = sample.getOutput();

        int indexA = instructions.get(1);
        int indexOutput = instructions.get(3);

        int calculate = input.get(indexA) * instructions.get(2);
        if (calculate == output.get(indexOutput)) {
            return Opcode.muli;
        }

        return null;
    }

    // stores into register C the result of the bitwise AND of register A and register B
    public Opcode checkBanr(Sample sample) {
        List<Integer> input = sample.getInput();
        List<Integer> instructions = sample.getInstructions();
        List<Integer> output = sample.getOutput();

        int indexA = instructions.get(1);
        int indexB = instructions.get(2);
        int indexOutput = instructions.get(3);

        int calculate = input.get(indexA) & input.get(indexB);
        if (calculate == output.get(indexOutput)) {
            return Opcode.banr;
        }

        return null;
    }

    // stores into register C the result of the bitwise AND of register A and value B
    public Opcode checkBani(Sample sample) {
        List<Integer> input = sample.getInput();
        List<Integer> instructions = sample.getInstructions();
        List<Integer> output = sample.getOutput();

        int indexA = instructions.get(1);
        int indexOutput = instructions.get(3);

        int calculate = input.get(indexA) & instructions.get(2);
        if (calculate == output.get(indexOutput)) {
            return Opcode.bani;
        }

        return null;
    }

    // stores into register C the result of the bitwise OR of register A and register B
    public Opcode checkBorr(Sample sample) {
        List<Integer> input = sample.getInput();
        List<Integer> instructions = sample.getInstructions();
        List<Integer> output = sample.getOutput();

        int indexA = instructions.get(1);
        int indexB = instructions.get(2);
        int indexOutput = instructions.get(3);

        int calculate = input.get(indexA) | input.get(indexB);
        if (calculate == output.get(indexOutput)) {
            return Opcode.borr;
        }

        return null;
    }

    // stores into register C the result of the bitwise OR of register A and value B
    public Opcode checkBori(Sample sample) {
        List<Integer> input = sample.getInput();
        List<Integer> instructions = sample.getInstructions();
        List<Integer> output = sample.getOutput();

        int indexA = instructions.get(1);
        int indexOutput = instructions.get(3);

        int calculate = input.get(indexA) | instructions.get(2);
        if (calculate == output.get(indexOutput)) {
            return Opcode.bori;
        }

        return null;
    }

    // copies the contents of register A into register C (Input B is ignored)
    public Opcode checkSetr(Sample sample) {
        List<Integer> input = sample.getInput();
        List<Integer> instructions = sample.getInstructions();
        List<Integer> output = sample.getOutput();

        int indexA = instructions.get(1);
        int indexOutput = instructions.get(3);

        int calculate = input.get(indexA);
        if (calculate == output.get(indexOutput)) {
            return Opcode.setr;
        }

        return null;
    }

    // stores value A into register C (Input B is ignored)
    public Opcode checkSeti(Sample sample) {
        List<Integer> instructions = sample.getInstructions();
        List<Integer> output = sample.getOutput();

        int indexOutput = instructions.get(3);

        if (instructions.get(1) == output.get(indexOutput)) {
            return Opcode.seti;
        }

        return null;
    }

    // sets register C to 1 if value A is greater than register B. Otherwise, register C is set to 0
    public Opcode checkGtir(Sample sample) {
        List<Integer> input = sample.getInput();
        List<Integer> instructions = sample.getInstructions();
        List<Integer> output = sample.getOutput();

        int indexB = instructions.get(2);
        int indexOutput = instructions.get(3);

        int calculate = instructions.get(1) > input.get(indexB) ? 1 : 0;
        if (calculate == output.get(indexOutput)) {
            return Opcode.gtir;
        }

        return null;
    }

    // sets register C to 1 if register A is greater than value B. Otherwise, register C is set to 0
    public Opcode checkGtri(Sample sample) {
        List<Integer> input = sample.getInput();
        List<Integer> instructions = sample.getInstructions();
        List<Integer> output = sample.getOutput();

        int indexA = instructions.get(1);
        int indexOutput = instructions.get(3);

        int calculate = input.get(indexA) > instructions.get(2) ? 1 : 0;
        if (calculate == output.get(indexOutput)) {
            return Opcode.gtri;
        }

        return null;
    }

    // sets register C to 1 if register A is greater than register B. Otherwise, register C is set to 0
    public Opcode checkGtrr(Sample sample) {
        List<Integer> input = sample.getInput();
        List<Integer> instructions = sample.getInstructions();
        List<Integer> output = sample.getOutput();

        int indexA = instructions.get(1);
        int indexB = instructions.get(2);
        int indexOutput = instructions.get(3);

        int calculate = input.get(indexA) > input.get(indexB) ? 1 : 0;
        if (calculate == output.get(indexOutput)) {
            return Opcode.gtrr;
        }

        return null;
    }

    // sets register C to 1 if value A is equal to register B. Otherwise, register C is set to 0
    public Opcode checkEqir(Sample sample) {
        List<Integer> input = sample.getInput();
        List<Integer> instructions = sample.getInstructions();
        List<Integer> output = sample.getOutput();

        int indexB = instructions.get(2);
        int indexOutput = instructions.get(3);

        int calculate = instructions.get(1) == input.get(indexB) ? 1 : 0;
        if (calculate == output.get(indexOutput)) {
            return Opcode.eqir;
        }

        return null;
    }

    // sets register C to 1 if register A is equal to value B. Otherwise, register C is set to 0
    public Opcode checkEqri(Sample sample) {
        List<Integer> input = sample.getInput();
        List<Integer> instructions = sample.getInstructions();
        List<Integer> output = sample.getOutput();

        int indexA = instructions.get(1);
        int indexOutput = instructions.get(3);

        int calculate = input.get(indexA) == instructions.get(2) ? 1 : 0;
        if (calculate == output.get(indexOutput)) {
            return Opcode.eqri;
        }

        return null;
    }

    // sets register C to 1 if register A is equal to register B. Otherwise, register C is set to 0
    public Opcode checkEqrr(Sample sample) {
        List<Integer> input = sample.getInput();
        List<Integer> instructions = sample.getInstructions();
        List<Integer> output = sample.getOutput();

        int indexA = instructions.get(1);
        int indexB = instructions.get(2);
        int indexOutput = instructions.get(3);

        int calculate = input.get(indexA) == input.get(indexB) ? 1 : 0;
        if (calculate == output.get(indexOutput)) {
            return Opcode.eqrr;
        }

        return null;
    }

}
