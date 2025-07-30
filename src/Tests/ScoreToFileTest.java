package Tests;


import classHolder.ScoreToFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ScoreToFileTest {

    ScoreToFile score = new ScoreToFile();

    @Test
    void username_is_reset_to_null(){
        Assertions.assertNull(score.getUsername());
    }

}