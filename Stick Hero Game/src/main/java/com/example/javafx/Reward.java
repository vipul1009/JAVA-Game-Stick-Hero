package com.example.javafx;

import javafx.geometry.Point2D;

public class Reward extends GameEntity implements Initializable{
    public Reward(Point2D initialLocation) {
        super("reward_image.png", initialLocation);
    }

    @Override
    public void initialize() {
        // Reward-specific initialization, if any
    }

}
