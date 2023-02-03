package test;

import main.address.RestaurantAddress;
import main.controller.*;
import main.person.Customer;
import main.restaurant.Restaurant;
import main.person.Deliver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class TestController {
    @Test
    @DisplayName("Test controller can generate lists")
    public void TestListsGeneration() {
        Controller controller = new Controller();
        ArrayList<Customer> customers = controller.getCustomers();
        ArrayList<Deliver> delivers = controller.getDelivers();
        ArrayList<Restaurant> restaurants = controller.getRestaurants();
        assertEquals(customers.size(), 0);
        assertEquals(delivers.size(), 0);
        assertEquals(restaurants.size(), 0);
    }

    @Test
    @DisplayName("Test controller members generating")
    public void TestGeneratingMembers() {
        Controller controller = new Controller();
        RestaurantAddress address = new RestaurantAddress(1, "NSW", "Sydney", "2036", "Hillsdale", "D st.");
        Restaurant newRestaurant = controller.generateRestaurant(1, "pizza hut", "a place for good pizza", "0405522521", "pizzahut@outlook.com", "123456", address, 0, LocalDateTime.now());
        assertEquals(newRestaurant, controller.getRestaurants().get(0));
        assertEquals(newRestaurant.getAddress(), address);
        assertEquals(newRestaurant.getEmailAddress(), "pizzahut@outlook.com");
    }

}
