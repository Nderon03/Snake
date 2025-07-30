package Tests;

import classHolder.AllTimeScores;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AllTimeScoresTest {

    AllTimeScores scores = new AllTimeScores();
    @Test
    void text_area_is_null(){
        Assertions.assertNull(scores.getTextArea());
    }

}