package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import static javax.accessibility.AccessibleAction.INCREMENT;

public class Stick extends Line {
    private boolean isGenerating;

    public Stick(double x, double y) {
        this.setStartX(-100);
        this.setStartY(0);
        this.setEndX(-100);
        this.setEndY(0);
        this.setLayoutY(175);
        this.isGenerating = false;
    }

    public void startGenerating() {
        isGenerating = true;
    }

    public void stopGenerating() {
        isGenerating = false;
    }

    public boolean isGenerating() {
        return isGenerating;
    }

    public void increaseHeight(double increment) {
        if (isGenerating) {
            this.setEndY(Double.parseDouble(getStartY()+INCREMENT));
        }
    }


//    Rotate rotation = new Rotate();
//
//// Set the angle of rotation
//    rotation.setAngle(45);
//
//    // Set the pivot point for the rotation
//    rotation.setPivotX(100);
//    rotation.setPivotY(100);
//
//    // Apply the rotation to a node (e.g., a line)
//    line.getTransforms().add(rotation);


}
