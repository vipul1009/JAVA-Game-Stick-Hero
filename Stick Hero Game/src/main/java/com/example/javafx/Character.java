package com.example.javafx;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

public class Character extends ImageView implements Initializable{
    private String charName;

    public Character(String charImage, String charName, Point2D initialLocation) {
        super(charImage);
        this.charName = charName;
    }

    @Override
    public void initialize() {
        // Character-specific initialization, if any
    }
}
