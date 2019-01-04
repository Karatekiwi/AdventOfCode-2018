
package day16;

import java.util.ArrayList;
import java.util.List;

public class Sample {

    private List<Integer> input;
    private List<Integer> output;
    private List<Integer> instructions;
    private List<Opcode>  opcodes = new ArrayList<>();

    public List<Integer> getInput() {
        return input;
    }

    public void setInput(List<Integer> input) {
        this.input = input;
    }

    public List<Integer> getOutput() {
        return output;
    }

    public void setOutput(List<Integer> output) {
        this.output = output;
    }

    public List<Integer> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Integer> instructions) {
        this.instructions = instructions;
    }

    public List<Opcode> getOpcodes() {
        return opcodes;
    }

    public void setOpcodes(List<Opcode> opcodes) {
        this.opcodes = opcodes;
    }

    @Override
    public String toString() {
        return "Sample [input=" + input + ", output=" + output + ", instructions=" + instructions + ", opcodes=" + opcodes + "]";
    }

}
