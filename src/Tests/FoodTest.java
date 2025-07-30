package Tests;

import classHolder.Food;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FoodTest {
    Food food = new Food();

    @Test
    void food_boundaries_below_18(){
        Assertions.assertTrue(food.fd<=18);
    }

}