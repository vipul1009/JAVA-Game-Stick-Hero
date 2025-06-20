package com.example.javafx;

import javafx.scene.shape.Line;
import org.junit.jupiter.api.Test;

import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
//
public class Scene2ControllerTest {

    @Test
    public void testGenerateRandomWidth() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Scene2Controller controller = new Scene2Controller();

        // Use reflection to access the private method
        Method method = Scene2Controller.class.getDeclaredMethod("generateRandomWidth");
        method.setAccessible(true);
        double randomWidth = (double) method.invoke(controller);

        assertTrue(randomWidth >= 100 && randomWidth <= 200);
    }

    @Test
    public void testGenerateRandomXPosition() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Scene2Controller controller = new Scene2Controller();
        // Use reflection to access the private method
        Method method = Scene2Controller.class.getDeclaredMethod("generateRandomXPosition", double.class, double.class);
        method.setAccessible(true);
        double randomXPosition = (double) method.invoke(controller, 50.0, 500.0);
        assertTrue(randomXPosition >= 60 && randomXPosition <= 450);
    }

    @Test
    public void testGiveX() {
        Scene2Controller controller = new Scene2Controller();
        Piller piller = new Piller(0, 0, 50, 100);
        double x = controller.giveX(piller);
        assertNotNull(x);
    }


}