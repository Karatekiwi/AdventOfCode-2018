/**
* (C) Copyright 2004 - 2017 CPB Software AG
* 1020 Wien, Vorgartenstrasse 206c
* All rights reserved.
* 
* Created on : 7 Dec 2018
* Created by : mawe
*/

package day7;

import java.util.ArrayList;
import java.util.List;

public class Step {

    private String     id;
    private List<Step> preSteps = new ArrayList<>();
    private int        start;
    private int        duration;

    public Step(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Step> getPreStep() {
        return preSteps;
    }

    public void setPreStep(List<Step> preSteps) {
        this.preSteps = preSteps;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "Step [id=" + id + ", preSteps=" + preSteps + ", start=" + start + ", duration=" + duration + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Step other = (Step) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
