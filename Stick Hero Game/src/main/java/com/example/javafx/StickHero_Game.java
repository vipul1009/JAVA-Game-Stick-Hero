package com.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StickHero_Game extends Application {

    private Stickman player;
    private String currPlayer;
    private int highestScore;
    private StickHero_Scenes scenes;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Stick Hero ");
        stage.show();
    }

    // Other methods remain the same

    private void start_Game() {
        scenes.draw_Player(player);
        scenes.draw_Platform();  // Draw initial platform

        // Example of polymorphism: Drawing a specific reward
        Reward reward = new Reward(new Point2D(100, 100));
        scenes.drawReward(reward);

        // Set up game logic, event handlers, etc.
    }
    public static void main(){
        launch();
    }
}
