package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import javafx.scene.media.MediaPlayer;


public class Scene1Controller {

    @FXML
    private AnchorPane about;

    public void aboutp(){
        about.setVisible(true);
    }

    public void okGot(){
        about.setVisible(false);
    }


    @FXML
    public Button click;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void onPlayButtonClick  (ActionEvent event) throws IOException {
        sound();
//        click.autosize();
        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void sound(){

        // Create a Media object
        Media media = new Media(new File("src/main/resources/com/example/javafx/button_click.wav").toURI().toString());
        // Create a MediaPlayer
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
    @FXML
    private AnchorPane online;

    public void online(){
        sound();
        online.setVisible(true);

    }

    public void ok(){
        online.setVisible(false);
    }


    @FXML
    private AnchorPane aboutPane;

    public void about(){
        sound();
        aboutPane.setVisible(true);
    }

    public void okGotIt(){
        sound();
        aboutPane.setVisible(false);
    }

    @FXML
    public void cherry(){
        sound();
        aboutPane.setVisible(true);
    }
    public void backButton(){
        sound();
        aboutPane.setVisible(false);
    }


}