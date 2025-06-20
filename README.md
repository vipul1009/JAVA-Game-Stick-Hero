# Stick Hero Game

This README file provides an overview of the code implementation for the game "STICK HERO" using JavaFX.

## Contents

- **Initializable.java**: Defines an `Initializable` interface that has an `initialize()` method. Used to initialize game entities.
- **Main.java**: The main JavaFX application class that launches the game.
- **Piller.java**: Defines a `Piller` class extending `Rectangle` to represent a pillar game element.
- **Scene1Controller.java**: Controller code behind `Scene1.fxml`. Handles UI events and scene transitions.
- **Scene2Controller.java**: Controller code behind `Scene2.fxml`. Main game logic for generating pillars, detecting hits, animations, etc.
- **Scene3Controller.java**: Controller code `Scene3.fxml`. Placeholder methods for restart and home menu actions.
- **Stick.java**: Represents the stick entity that the player controls. Has methods for increasing/stopping growth.
- In the `Scene2Controller`, functionality related to the stick rotation, fall of the ninja, and the transition of shifting to another screen is implemented.

## Usage

The `Main` class launches the JavaFX application and loads the main UI. `Character` and `Piller` represent game entities that can be positioned on the screen.

- `Scene1Controller` loads the start menu and transitions to the game on play button click. 
- The main game logic has been moved to `Scene2Controller`. It handles pillar generation, stick hit detection, point scoring, and ninja character animations.

## Major Features

- Procedurally generated pillar platforms with gaps
- Extendable stick growth through player input
- Physics for stick rotation and falling
- Collectible rewards with scoring
- Animations and sounds
- JUnit Testing is also available in the code files

## Running the Game

1. Make sure you have Java and JavaFX installed.
2. Import the project into an IDE like Eclipse or IntelliJ IDEA.
3. Add the JavaFX library to the project build path.
4. Run the `Main.java` class to launch the game.
5. Use the mouse or touchscreen to play by stretching the stick and guiding the ninja. Refer to the rest of the README for project details.

### Game Controls

- To increase the length of the stick, click twice on the mouse and on the second press, hold the mouse button to grow the stick upward. If you lift your finger, the stick will fall horizontally.

## Implementation of Design Pattern

The Flyweight design pattern is implemented in the code. The `NinjaImageFactory` class is an example of this pattern. The Flyweight pattern is a structural design pattern that allows objects to share common state, thereby reducing memory usage or computational expenses.

## Command

1. Make your source folder to `/Stick Hero Game`. This is the root directory of all files. 
2. Now, simply run the file `Main.java` which is the main file.
   - `Main.java` is located in the folder: `/Stick Hero Game/src/main/java/com/example/javafx/Main.java`
   - Run the following command:
     ```sh
     mvn exec:java
     ```
