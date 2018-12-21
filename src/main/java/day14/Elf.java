
package day14;

public class Elf {

    private int id;
    private int index;

    public Elf(int id, int index) {
        this.id = id;
        this.index = index;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Elf [id=" + id + ", index=" + index + "]";
    }

}
