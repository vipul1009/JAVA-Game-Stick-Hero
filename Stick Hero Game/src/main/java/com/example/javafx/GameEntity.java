package com.example.javafx;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Point2D;
import javafx.stage.Stage;

public class GameEntity {
    protected ImageView imageView;
    protected Point2D location;

    public GameEntity(String imagePath, Point2D initialLocation) {
        this.imageView = new ImageView(new Image(imagePath));
        this.location = initialLocation;
//        initialize();
    }

    // Abstract method to be implemented by subclasses
//    public abstract void initialize();

    // Getter for location
    public Point2D getLocation() {
        return location;
    }

    // Setter for location
    public void setLocation(Point2D location) {
        this.location = location;
        imageView.relocate(location.getX(), location.getY());
    }
}
