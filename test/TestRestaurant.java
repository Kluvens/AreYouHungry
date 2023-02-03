package test;

import main.controller.*;
import main.restaurant.*;
import main.dish.*;
import main.address.RestaurantAddress;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class TestRestaurant {
    @Test
    @DisplayName("Add dishes to the restaurant's menu")
    public void TestAddingDishes() {
        Controller controller = new Controller();
        RestaurantAddress address = new RestaurantAddress(1, "NSW", "Sydney", "2036", "Hillsdale", "D st.");
        Restaurant newRestaurant = controller.generateRestaurant(1, "pizza hut", "a place for good pizza", "0405522521", "pizzahut@outlook.com", "123456", address, 0, LocalDateTime.now());
        Dish newDish = newRestaurant.addDish(1, "seafood pizza", 15, "with pawns");
        assertEquals(newRestaurant.getMenu().size(), 1);
        assertEquals(newRestaurant.getMenu().get(0).getName(), "seafood pizza");
        newRestaurant.removeDish(newDish);
        assertEquals(newRestaurant.getMenu().size(), 0);
    }
}
