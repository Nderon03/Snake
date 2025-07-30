package Tests;

import classHolder.MyFrame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MyFrameTest {

    @Test
    void loadFrame() {
        var frame = new MyFrame();
        assertTrue(frame.LoadFrame());

    }


}