
package day4;

import java.util.ArrayList;
import java.util.List;

public class Guard {

    private int           id;
    private List<Integer> sleep = new ArrayList<>();

    private int           maxSleep;
    private int           maxSleepMinute;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getSleep() {
        return sleep;
    }

    public void setSleep(List<Integer> sleep) {
        this.sleep = sleep;
    }

    public int getMaxSleep() {
        return maxSleep;
    }

    public void setMaxSleep(int maxSleep) {
        this.maxSleep = maxSleep;
    }

    public int getMaxSleepMinute() {
        return maxSleepMinute;
    }

    public void setMaxSleepMinute(int maxSleepMinute) {
        this.maxSleepMinute = maxSleepMinute;
    }

    @Override
    public String toString() {
        return "Guard [id=" + id + ", sleep=" + sleep + "]";
    }

}
