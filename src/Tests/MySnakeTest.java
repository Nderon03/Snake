package Tests;


import classHolder.MySnake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MySnakeTest {
    int x,y;
    MySnake snake = new MySnake(x,y);

    @Test
    void is_red_zero(){
        Assertions.assertTrue(snake.isRed==0);
    }

    @Test
    void initial_score_is_zero(){
        Assertions.assertEquals(0,snake.score);
    }
    @Test
    void get_length(){
        Assertions.assertNotNull(snake.GetLength());
    }

    @Test
    void get_initial_speed(){
        Assertions.assertTrue(snake.SetNormalSpeed()==5);
    }

    @Test
    void up_is_false(){
        Assertions.assertFalse(snake.GetUp());
    }
    @Test
    void down_is_false(){
        Assertions.assertFalse(snake.GetDown());
    }
    @Test
    void left_is_false(){
        Assertions.assertFalse(snake.GetLeft());
    }
    @Test
    void right_is_true(){
        Assertions.assertTrue(snake.GetRight());
    }
}