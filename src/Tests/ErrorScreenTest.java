package Tests;

import classHolder.ErrorScreen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ErrorScreenTest {
    ErrorScreen error = new ErrorScreen();

    @Test
    void name_label_is_null(){
        Assertions.assertNull(error.getNameLabel());
    }

}