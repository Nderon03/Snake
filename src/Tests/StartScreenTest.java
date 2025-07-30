package Tests;

import classHolder.StartScreen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StartScreenTest {

    @Test
    void basicLevel() {
        var level = new StartScreen();
        assertEquals(0,level.basicLevel());
    }


    @Test
    void playGreenSnake() {
        var snake = new StartScreen();
        assertEquals(0,snake.playGreenSnake());
    }

    @Test
    void playRedSnake() {
        var snake = new StartScreen();
        assertEquals(1,snake.playRedSnake());
    }

    @Test
    void getChoice(){
        var snake = new StartScreen();
        assertTrue(snake.getChoice()<=6);
    }

    @Test
    void getBg(){
        var snake = new StartScreen();
        assertTrue(snake.getBg()<=6);
    }

}
