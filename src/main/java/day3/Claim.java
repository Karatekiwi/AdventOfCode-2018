
package day3;

public class Claim {

    private int id;
    private int leftMargin;
    private int topMargin;
    private int height;
    private int width;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLeftMargin() {
        return leftMargin;
    }

    public void setLeftMargin(int leftMargin) {
        this.leftMargin = leftMargin;
    }

    public int getTopMargin() {
        return topMargin;
    }

    public void setTopMargin(int topMargin) {
        this.topMargin = topMargin;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Claim [id=" + id + ", leftMargin=" + leftMargin + ", topMargin=" + topMargin + ", height=" + height + ", width=" + width + "]";
    }

}
