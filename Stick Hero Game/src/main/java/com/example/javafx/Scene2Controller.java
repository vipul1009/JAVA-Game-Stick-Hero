package com.example.javafx;

import javafx.animation.*;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Scene2Controller extends ActionEvent implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    Score sc = new Score();

    private Stick stick;

    Timeline t;

    double first_piller_random_width;
    private Piller fixedPillar; // Declare fixedPillar as a class variable
    public static int points;

    double stickX;
    double stickY;
    public void stickadd(Stick s){
        anchorPane.getChildren().add(s);
    }
    public void sound1(){

        // Create a Media object
        Media media = new Media(new File("src/main/resources/com/example/javafx/stick_grow.wav").toURI().toString());
        // Create a MediaPlayer
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
    public void sound5(){

        // Create a Media object
        Media media = new Media(new File("src/main/resources/com/example/javafx/sound5.wav").toURI().toString());
        // Create a MediaPlayer
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
    public void handleMouseClick(MouseEvent event){
        System.out.println("clicked");
        stick = new Stick(stickX,stickY);
        stick.setLayoutX(fixedPillar.getLayoutX()+110+fixedPillar.getWidth());

        stick.setStrokeWidth(2);
        stick.setStroke(Color.BLACK);
        stick.setId("stick");
        anchorPane.getChildren().add(stick);
        //stickadd(stick);
        t.play();
    }

    public void handleMouseRelease(){
        stopGeneratingStick();
    }
    public void increaseStickHeight(ActionEvent event){
        stick.increaseHeight(20);
    }
    public void stopGeneratingStick(){

        if(stick!= null){
            stick.stopGenerating();
        }
    }

    public void backToHome(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void restart(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private AnchorPane pause;

//    public void pause(){
//        pause.setVisible(true);
//    }
    public void pillersAdd(Piller p){
        anchorPane.getChildren().add(p);
    }
    public void winGame(ActionEvent event){
    }
    public void loseGame(ActionEvent event){
    }

    private double fixedPillarWidth = 150.0; // Adjust the width of the fixed pillar as needed
    private double fixedPillarHeight = 200; // Adjust the height of the fixed pillar as needed
    private Piller randomPillar;
    private ImageView imageView;
    public void setPillars() {
        // Add the fixed pillar on the left side
        fixedPillar = new Piller(10.0, 175.0, generateRandomWidth(), fixedPillarHeight);
        pillersAdd(fixedPillar);
        double randomWidth = generateRandomWidth();


        Image image = NinjaImageFactory.getNinjaImage();
//        Image image = new Image(getClass().getResource("ninja.png").toExternalForm());
        imageView = new ImageView(image);


        imageView.setLayoutX(((fixedPillar.getLayoutX()+fixedPillar.getWidth())/2)-5);
        imageView.setLayoutY(140);
        imageView.setFitWidth(46);
        imageView.setFitHeight(39);
        // Add the ImageView to the anchorPane
        anchorPane.getChildren().add(imageView);



        double randomXPosition = generateRandomXPosition(fixedPillar.getLayoutX()+fixedPillar.getWidth(), anchorPane.getWidth());
        randomPillar = new Piller(randomXPosition, 175.0 , randomWidth, 200);
        pillersAdd(randomPillar);
    }
    private double generateRandomWidth() {
        // Adjust the range of random widths as needed
        Random random = new Random();
        double random_w = random.nextDouble() * 100 + 100;
        if(random_w< 606/2){
            first_piller_random_width = random_w;
            return random_w;
        }
        else{
            random_w = 606/3;
            first_piller_random_width = random_w;
            return random_w;
        }
    }
    private double generateRandomXPosition(double lastPillarWidth, double anchorPaneWidth) {
        // Adjust the range of random positions as needed
        Random random = new Random();
        double maxWidth = Math.max(0, anchorPaneWidth - lastPillarWidth - 10.0);

        return random.nextDouble() * maxWidth + lastPillarWidth + 10.0;
    }
//        // Random position within the remaining width with a gap from the last pillar
//
//    private double generateRandomXPosition(double firstPillartak, double anchorPaneWidth) {
//        Random random = new Random();
//     double maxWidth = Math.max(40, anchorPaneWidth - firstPillartak-10);
//
////        return random.nextDouble() * maxWidth + firstPillartak + 10.0;
//
//
//    }
// Flyweight Factory
class NinjaImageFactory {
    private static final Map<String, Image> ninjaImages = new HashMap<>();

    // Flyweight method to get or create a ninja image
    static Image getNinjaImage() {
        return ninjaImages.computeIfAbsent("ninja", k ->
                new Image(Scene2Controller.class.getResource("ninja.png").toExternalForm())
        );
    }
}


    @Override
    public void initialize() {
        setPillars();
        anchorPane.setOnMousePressed(this::handleMouseClick);
        t = new Timeline(new KeyFrame(Duration.seconds(0.2), e -> length()
        ));
        t.setCycleCount(Timeline.INDEFINITE);
        anchorPane.setOnMouseReleased(this::print);
    }

    private TranslateTransition fallTransition;

    private Stage stage;
    private Scene scene;
    private Parent root;
    public void print(MouseEvent event) {

        System.out.println("released");
        t.stop();

        Line line = (Line) stick;

        double midPointY = (line.getStartY()+line.getEndY()) / 2;
        RotateTransition rt = new RotateTransition(Duration.millis(500), line);
        rt.setByAngle(90);


        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), line);
        translateTransition.setByY(midPointY - line.getEndY());
        translateTransition.setByX(-((line.getStartY()+line.getEndY())/2));


        ParallelTransition parallelTransition = new ParallelTransition(rt, translateTransition);
        parallelTransition.play();




        //calculating length of a stick
        double length = Math.abs(line.getStartY()+line.getEndY());
        System.out.println(length);
        length+=fixedPillar.getLayoutX()+fixedPillar.getWidth()+fixedPillar.getX();
        System.out.println(length);
        System.out.println(randomPillar.getLayoutX()+randomPillar.getX());

        double target = 0;
        double rightX = 0;

        if((randomPillar.getLayoutX()+randomPillar.getX() <= length) && (length <= randomPillar.getLayoutX()+randomPillar.getWidth()+randomPillar.getX()) ){
            System.out.println("true");
            System.out.println("ksdfjsfhdjfhdskjfklsajldskfjdskfh"+sc.points);
            sc.points++;
            target = Math.abs(line.getStartY()+line.getEndY());
            rightX = fixedPillar.getLayoutX()+fixedPillar.getWidth();
            rightX=rightX-imageView.getLayoutX();
            TranslateTransition translate = new TranslateTransition();
            translate.setNode(imageView);
            translate.setDuration(Duration.millis(3000));
            translate.setByX(target+rightX-10);
            translate.play();
            //moveNinjaImageToStickEnd(target+rightX-10);
            translate.setOnFinished(even-> {
                //logic to remove stick
                ObservableList<Node> children = anchorPane.getChildren();
                anchorPane.getChildren().removeIf(node -> node.getId() != null && node.getId().equals("stick"));
                randomPillar.setLayoutX(10);
                randomPillar.setX(10);
                fixedPillar.setLayoutX(-300);
                fixedPillar=null;
                fixedPillar=randomPillar;
                randomPillar = new Piller(giveX(fixedPillar), 175.0 , generateRandomWidth(), 200);
                System.out.println(randomPillar.getLayoutX());
                anchorPane.getChildren().add(randomPillar);

                anchorPane.getChildren().remove(imageView);

                //Setting ninja agiain to the plattform
                Image image = new Image(getClass().getResource("ninja.png").toExternalForm());
                imageView = new ImageView(image);
                imageView.setLayoutX(((fixedPillar.getLayoutX()+fixedPillar.getWidth())/2)-5);
                imageView.setLayoutY(140);
                imageView.setFitWidth(46);
                imageView.setFitHeight(39);
                // Add the ImageView to the anchorPane
                anchorPane.getChildren().add(imageView);

            });
            System.out.println("kdjfskfjsdd");
        }
        else{
            target = Math.abs(line.getStartY()+line.getEndY());
            rightX = fixedPillar.getLayoutX()+fixedPillar.getWidth();
            rightX=rightX-imageView.getLayoutX();
//            moveNinjaImageToStickEnd(target+rightX-10);
            TranslateTransition translate = new TranslateTransition();
            translate.setNode(imageView);
            translate.setDuration(Duration.millis(3000));
            translate.setByX(target+rightX-10);
            translate.play();
//            TranslateTransition translate = new TranslateTransition();
            translate.setNode(imageView);
            translate.setDuration(Duration.millis(3000));
            translate.setByY(Animation.INDEFINITE);
            translate.play();

            System.out.println("false");
            SequentialTransition sequentialTransition = new SequentialTransition(translate);

            TranslateTransition fdt = new TranslateTransition();
            fdt.setNode(imageView);
            fdt.setToY(anchorPane.getHeight());
            fdt.setDuration(Duration.millis(500));  // Adjust the duration as needed
            sequentialTransition.getChildren().add(fdt);
            sequentialTransition.play();

            //For falling sound
            fdt.setOnFinished(event1 -> {
                    sound5();
            });
            //Serializing
            ObjectOutputStream out = null;
            try {
                out = new ObjectOutputStream(new FileOutputStream("ForScore.bin"));
                out.writeObject(sc);
                out.flush();
//                System.out.println("kjhgfd");
            } catch (IOException e) {
                e.printStackTrace();
            }

            ObjectInputStream in = null;
            Score sc1;
            try{
                in = new ObjectInputStream(new FileInputStream("ForScore.bin"));
                System.out.println("hello1");
                sc1 = (Score) in.readObject();
//                System.out.println(sc1.points);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println(sc1.points);
            System.out.println("hello");
            sequentialTransition.setOnFinished(e -> {
                try {
                thirdScreen();
            } catch (IOException ec) {
                // exception here
            }
            });
            System.out.println("false");
        }

    }
    public void thirdScreen() throws IOException {
        ObjectInputStream in = null;
        Score sc1;
        try{
            in = new ObjectInputStream(new FileInputStream("ForScore.bin"));
            System.out.println("hello1");
            sc1 = (Score) in.readObject();
//                System.out.println(sc1.points);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene3.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) anchorPane.getScene().getWindow();
            if (stage != null && stage.isShowing()) {
                stage.setScene(scene);
                stage.show();
            }
            ObservableList<Node> childs = root.getChildrenUnmodifiable();
            for(Node n : childs){
                if(Objects.equals(n.getId(),"myscore")){
                    ((Label)n).setText("Score: "+sc1.points);
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    // ... (existing code)

    public void length(){
//        stick.startGenerating();
        System.out.println("inc");
        System.out.println(stick.getEndY());
        sound1();
        stick.setEndY(stick.getEndY()-10);

    }

    public double giveX(Piller p){
        Random random = new Random();
        double bufferX = p.getWidth()+10;
        double finalX = random.nextDouble(bufferX,200);
        return finalX;
    }
    // Example: Call setPillars on initialization or event trigger
}

