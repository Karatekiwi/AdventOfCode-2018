
package day9;

public class Player {

    private int  id;
    private Long score = 0L;

    public Player(int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player [id=" + id + ", score=" + score + "]";
    }

}
