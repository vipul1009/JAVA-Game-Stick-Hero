package com.example.javafx;

import javafx.geometry.Point2D;

public class Stickman extends GameEntity implements Initializable{
    private int numberOfRewards;
    private int score;
    private int stickLength;

    public Stickman() {
        super("stickman_image.png", new Point2D(0, 0));
        // Initialize Stickman-specific attributes
        numberOfRewards = 0;
        score = 0;
        stickLength = 0;
    }
    @Override
    public void initialize() {
        // Stickman-specific initialization, if any
    }
}
