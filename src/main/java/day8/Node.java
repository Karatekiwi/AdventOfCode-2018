
package day8;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String        id;
    private int           numChildren;
    private int           numMetadata;
    private List<Node>    children = new ArrayList<>();
    private List<Integer> metadata = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public List<Integer> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Integer> metadata) {
        this.metadata = metadata;
    }

    public int getNumChildren() {
        return numChildren;
    }

    public void setNumChildren(int numChildren) {
        this.numChildren = numChildren;
    }

    public int getNumMetadata() {
        return numMetadata;
    }

    public void setNumMetadata(int numMetadata) {
        this.numMetadata = numMetadata;
    }

    @Override
    public String toString() {
        return "Node [id=" + id + ", numChildren=" + numChildren + ", numMetadata=" + numMetadata + ", children=" + children + ", metadata="
            + metadata + "]";
    }

}
