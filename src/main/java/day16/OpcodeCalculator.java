
package day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpcodeCalculator {

    private List<Integer> register = new ArrayList<>(Arrays.asList(0, 0, 0, 0));

    // stores into register C the result of adding register A and register B
    public void calculateAddr(List<Integer> instructions) {
        int indexA = instructions.get(1);
        int indexB = instructions.get(2);
        int indexOutput = instructions.get(3);

        int calculate = register.get(indexA) + register.get(indexB);
        register.set(indexOutput, calculate);
    }

    // stores into register C the result of adding register A and value B
    public void calculateAddi(List<Integer> instructions) {
        int indexA = instructions.get(1);
        int indexOutput = instructions.get(3);

        int calculate = register.get(indexA) + instructions.get(2);
        register.set(indexOutput, calculate);
    }

    // stores into register C the result of multiplying register A and register B
    public void calculateMulr(List<Integer> instructions) {
        int indexA = instructions.get(1);
        int indexB = instructions.get(2);
        int indexOutput = instructions.get(3);

        int calculate = register.get(indexA) * register.get(indexB);
        register.set(indexOutput, calculate);
    }

    // stores into register C the result of multiplying register A and value B
    public void calculateMuli(List<Integer> instructions) {
        int indexA = instructions.get(1);
        int indexOutput = instructions.get(3);

        int calculate = register.get(indexA) * instructions.get(2);
        register.set(indexOutput, calculate);
    }

    // stores into register C the result of the bitwise AND of register A and register B
    public void calculateBanr(List<Integer> instructions) {
        int indexA = instructions.get(1);
        int indexB = instructions.get(2);
        int indexOutput = instructions.get(3);

        int calculate = register.get(indexA) & register.get(indexB);
        register.set(indexOutput, calculate);
    }

    // stores into register C the result of the bitwise AND of register A and value B
    public void calculateBani(List<Integer> instructions) {
        int indexA = instructions.get(1);
        int indexOutput = instructions.get(3);

        int calculate = register.get(indexA) & instructions.get(2);
        register.set(indexOutput, calculate);
    }

    // stores into register C the result of the bitwise OR of register A and register B
    public void calculateBorr(List<Integer> instructions) {
        int indexA = instructions.get(1);
        int indexB = instructions.get(2);
        int indexOutput = instructions.get(3);

        int calculate = register.get(indexA) | register.get(indexB);
        register.set(indexOutput, calculate);
    }

    // stores into register C the result of the bitwise OR of register A and value B
    public void calculateBori(List<Integer> instructions) {
        int indexA = instructions.get(1);
        int indexOutput = instructions.get(3);

        int calculate = register.get(indexA) | instructions.get(2);
        register.set(indexOutput, calculate);
    }

    // copies the contents of register A into register C (Input B is ignored)
    public void calculateSetr(List<Integer> instructions) {
        int indexA = instructions.get(1);
        int indexOutput = instructions.get(3);

        int calculate = register.get(indexA);
        register.set(indexOutput, calculate);
    }

    // stores value A into register C (Input B is ignored)
    public void calculateSeti(List<Integer> instructions) {
        int indexOutput = instructions.get(3);
        register.set(indexOutput, instructions.get(1));
    }

    // sets register C to 1 if value A is greater than register B. Otherwise, register C is set to 0
    public void calculateGtir(List<Integer> instructions) {
        int indexB = instructions.get(2);
        int indexOutput = instructions.get(3);

        int calculate = instructions.get(1) > register.get(indexB) ? 1 : 0;
        register.set(indexOutput, calculate);
    }

    // sets register C to 1 if register A is greater than value B. Otherwise, register C is set to 0
    public void calculateGtri(List<Integer> instructions) {
        int indexA = instructions.get(1);
        int indexOutput = instructions.get(3);

        int calculate = register.get(indexA) > instructions.get(2) ? 1 : 0;
        register.set(indexOutput, calculate);
    }

    // sets register C to 1 if register A is greater than register B. Otherwise, register C is set to 0
    public void calculateGtrr(List<Integer> instructions) {
        int indexA = instructions.get(1);
        int indexB = instructions.get(2);
        int indexOutput = instructions.get(3);

        int calculate = register.get(indexA) > register.get(indexB) ? 1 : 0;
        register.set(indexOutput, calculate);
    }

    // sets register C to 1 if value A is equal to register B. Otherwise, register C is set to 0
    public void calculateEqir(List<Integer> instructions) {
        int indexB = instructions.get(2);
        int indexOutput = instructions.get(3);

        int calculate = instructions.get(1) == register.get(indexB) ? 1 : 0;
        register.set(indexOutput, calculate);
    }

    // sets register C to 1 if register A is equal to value B. Otherwise, register C is set to 0
    public void calculateEqri(List<Integer> instructions) {
        int indexA = instructions.get(1);
        int indexOutput = instructions.get(3);

        int calculate = register.get(indexA) == instructions.get(2) ? 1 : 0;
        register.set(indexOutput, calculate);
    }

    // sets register C to 1 if register A is equal to register B. Otherwise, register C is set to 0
    public void calculateEqrr(List<Integer> instructions) {
        int indexA = instructions.get(1);
        int indexB = instructions.get(2);
        int indexOutput = instructions.get(3);

        int calculate = register.get(indexA) == register.get(indexB) ? 1 : 0;
        register.set(indexOutput, calculate);
    }

    public void calculate(Opcode opcode, List<Integer> instructions) {
        switch (opcode) {
            case addr:
                calculateAddr(instructions);
                break;
            case addi:
                calculateAddi(instructions);
                break;
            case mulr:
                calculateMulr(instructions);
                break;
            case muli:
                calculateMuli(instructions);
                break;
            case banr:
                calculateBanr(instructions);
                break;
            case bani:
                calculateBani(instructions);
                break;
            case borr:
                calculateBorr(instructions);
                break;
            case bori:
                calculateBori(instructions);
                break;
            case setr:
                calculateSetr(instructions);
                break;
            case seti:
                calculateSeti(instructions);
                break;
            case gtir:
                calculateGtir(instructions);
                break;
            case gtri:
                calculateGtri(instructions);
                break;
            case gtrr:
                calculateGtrr(instructions);
                break;
            case eqir:
                calculateEqir(instructions);
                break;
            case eqri:
                calculateEqri(instructions);
                break;
            case eqrr:
                calculateEqrr(instructions);
                break;
            default:
                break;

        }

    }

    public List<Integer> getRegister() {
        return register;
    }

}
