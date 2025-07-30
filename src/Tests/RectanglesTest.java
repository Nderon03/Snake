package Tests;

import classHolder.Rectangles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class RectanglesTest {
    int a, b, c, d;
    Rectangles r = new Rectangles(a,b,c,d);

    @Test
    void x_velocity_is_4(){
        Assertions.assertTrue(r.GetXVelocity()==4);
    }

    @Test
    void y_velocity_is_2(){
        Assertions.assertTrue(r.GetYVelocity()==2);
    }

    @Test
    void x_is_not_null(){
        Assertions.assertNotNull(r.getX());
    }
    @Test
    void y_is_not_null(){
        Assertions.assertNotNull(r.getY());
    }


}