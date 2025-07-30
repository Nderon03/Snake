package Tests;

import classHolder.Play;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class PlayTest {

    Play pt = new Play();

    @Test
    void three_choices(){
        Assertions.assertTrue(pt.choice<=3);
    }

    @Test
    void counter_never_above_one(){
        Assertions.assertTrue(pt.GetCounter()==0||pt.GetCounter()==1);
    }

}