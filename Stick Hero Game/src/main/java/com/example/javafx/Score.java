package com.example.javafx;

import java.io.Serializable;

public class Score implements Serializable {
    public int points = 0;
    public Score(){
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
