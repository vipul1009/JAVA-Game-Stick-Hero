package com.example.javafx;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;

public class Piller extends Rectangle{
    public double rap;
    public double h;


    public Piller(double x, double y,double width, double height){
        this.setX(x);
        this.setWidth(width);
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.setHeight(height);
    }
}
