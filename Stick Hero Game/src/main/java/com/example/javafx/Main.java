package com.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
       Parent parent = FXMLLoader.load(getClass().getResource("Scene1.fxml"));

       Scene scene = new Scene(parent);
       stage.setScene(scene);
       stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }

}