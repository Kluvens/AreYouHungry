package test;

import main.address.PersonAddress;
import main.address.RestaurantAddress;
import main.controller.*;
import main.person.Customer;
import main.restaurant.Restaurant;
import main.dish.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class TestCustomer {
    @Test
    @DisplayName("Test customer addresses")
    public void TestCustomerAddresses() {
        Controller controller = new Controller();
        Customer newCustomer = controller.generateCustomer(1, "Justin", "Justin", "Yang", "040", "young@outlook.com", "Male");
        assertEquals(newCustomer.getAddresses().size(), 0);
        assertEquals(newCustomer.getDefaultAddress(), null);
        PersonAddress addressFirst = newCustomer.generateAddress(1, "NSW", "Sydney", "2036", "Eastgarden", "M st.");
        assertEquals(newCustomer.getAddresses().size(), 1);
        assertEquals(newCustomer.getDefaultAddress(), addressFirst);
        PersonAddress addressSec = newCustomer.generateAddress(2, "VIC", "Mel", "2050", "Box Hill", "M st.");
        assertEquals(newCustomer.getAddresses().size(), 2);
        assertEquals(newCustomer.getDefaultAddress(), addressFirst);
        newCustomer.updateDefaultAddress(addressSec);
        assertEquals(newCustomer.getAddresses().size(), 2);
        assertEquals(newCustomer.getDefaultAddress(), addressSec);
        PersonAddress addressThird = newCustomer.generateAddress(3, "NSW", "Syd", "2036", "May", "O st.");
        newCustomer.updateDefaultAddress(addressSec);
        assertEquals(newCustomer.getAddresses().size(), 3);
        newCustomer.removeAddress(addressThird);
        assertEquals(newCustomer.getAddresses().size(), 2);
        PersonAddress addressFourth = newCustomer.generateAddress(4, "NSW", "Syd", "2036", "Hills", "h st.", "Home");
        assertEquals(newCustomer.getAddresses().size(), 3);
        newCustomer.updateDefaultAddress(addressFourth);
        assertEquals(newCustomer.getDefaultAddress(), addressFourth);
        assertEquals(newCustomer.getDefaultAddress().getLabel(), "Home");
    }

    @Test
    @DisplayName("Test putting dishes to shopping carts")
    public void TestShoppingCarts() {
        Controller controller = new Controller();
        RestaurantAddress address = new RestaurantAddress(1, "NSW", "Sydney", "2036", "Hillsdale", "D st.");
        Restaurant newRestaurant = controller.generateRestaurant(1, "pizza hut", "a place for good pizza", "0405522521", "pizzahut@outlook.com", "123456", address, 0, LocalDateTime.now());
        Dish dishFirst = newRestaurant.addDish(1, "seafood pizza", 15, "with pawns");
        newRestaurant.addDish(2, "pawn", 20, "King Pawn");
        newRestaurant.addDish(3, "burger", 10, "Better than Maccas");
        Dish dishFourth = newRestaurant.addDish(4, "milktea", 5, "sweat");
        Customer newCustomer = controller.generateCustomer(1, "Justin", "Justin", "Yang", "0405522522", "young.jiapeng@gmail.com", "Male");
        newCustomer.putToShoppingCart(newRestaurant, dishFirst);
        newCustomer.putToShoppingCart(newRestaurant, dishFourth);
        assertEquals(newCustomer.getShoppingCarts().size(), 1);
        assertEquals(newCustomer.getShoppingCarts().get(newRestaurant).size(), 2);
        newCustomer.removeFromShoppingCart(newRestaurant, dishFourth);
        assertEquals(newCustomer.getShoppingCarts().get(newRestaurant).size(), 1);

        RestaurantAddress addressSec = new RestaurantAddress(1, "NSW", "Sydney", "2036", "Hillsdale", "D st.");
        Restaurant restaurantSec = controller.generateRestaurant(1, "pizza hut", "a place for good pizza", "0405522521", "pizzahut@outlook.com", "123456", addressSec, 0, LocalDateTime.now());
        Dish dishFifth = newRestaurant.addDish(1, "seafood pizza", 15, "with pawns");
        Dish dishSixth = newRestaurant.addDish(2, "pawn", 20, "King Pawn");
        Dish dishSeventh = newRestaurant.addDish(3, "burger", 10, "Better than Maccas");
        Dish dishEighth = newRestaurant.addDish(4, "milktea", 5, "sweat");
        newCustomer.putToShoppingCart(restaurantSec, dishFifth);
        newCustomer.putToShoppingCart(restaurantSec, dishSixth);
        newCustomer.putToShoppingCart(restaurantSec, dishSeventh);
        newCustomer.putToShoppingCart(restaurantSec, dishEighth);
        assertEquals(newCustomer.getShoppingCarts().size(), 2);
        assertEquals(newCustomer.getShoppingCarts().get(restaurantSec).size(), 4);

        newCustomer.removeFromShoppingCart(newRestaurant, dishFirst);
        assertEquals(newCustomer.getShoppingCarts().size(), 1);
        assertEquals(newCustomer.getShoppingCarts().get(restaurantSec).size(), 4);

        newCustomer.removeFromShoppingCart(restaurantSec, dishFifth);
        newCustomer.removeFromShoppingCart(restaurantSec, dishSixth);
        newCustomer.removeFromShoppingCart(restaurantSec, dishSeventh);
        newCustomer.removeFromShoppingCart(restaurantSec, dishEighth);
        assertEquals(newCustomer.getShoppingCarts().size(), 0);
    }

    @Test
    @DisplayName("Test customers can make pending orders")
    public void TestMakingPendingOrders() {
        
    }

    @Test
    @DisplayName("Test customers can make cancel pending orders")
    public void TestCancellingPendingOrders() {

    }

    @Test
    @DisplayName("Test customers can complete pending orders")
    public void TestCompletingPendingOrders() {

    }

    @Test
    @DisplayName("Test customers can cancel completed orders")
    public void TestCancellingCompletedOrders() {

    }

    @Test
    @DisplayName("Test customers can search resturants")
    public void TestSearchingRestaurants() {
        Controller controller = new Controller();
        RestaurantAddress address = new RestaurantAddress(1, "NSW", "Sydney", "2036", "Hillsdale", "D st.");
        controller.generateRestaurant(1, "pizza hut", "a place for good pizza", "0405522521", "pizzahut@outlook.com", "123456", address, 0, LocalDateTime.now());
        RestaurantAddress addressSec = new RestaurantAddress(1, "NSW", "Sydney", "2036", "Hillsdale", "D st.");
        controller.generateRestaurant(1, "pizza hub", "a place for good pizza", "0405522521", "pizzahut@outlook.com", "123456", addressSec, 0, LocalDateTime.now());
        Customer newCustomer = controller.generateCustomer(1, "Justin", "Justin", "Yang", "0405522522", "young.jiapeng@gmail.com", "Male");
        List<Restaurant> searchRestaurants = newCustomer.search(controller, "pizza");
        assertEquals(searchRestaurants.size(), 2);
    }

    @Test
    @DisplayName("Test customers searching history")
    public void TestSearchingHistory() {
        Controller controller = new Controller();
        RestaurantAddress address = new RestaurantAddress(1, "NSW", "Sydney", "2036", "Hillsdale", "D st.");
        controller.generateRestaurant(1, "pizza hut", "a place for good pizza", "0405522521", "pizzahut@outlook.com", "123456", address, 0, LocalDateTime.now());
        RestaurantAddress addressSec = new RestaurantAddress(1, "NSW", "Sydney", "2036", "Hillsdale", "D st.");
        controller.generateRestaurant(1, "pizza hub", "a place for good pizza", "0405522521", "pizzahut@outlook.com", "123456", addressSec, 0, LocalDateTime.now());
        Customer newCustomer = controller.generateCustomer(1, "Justin", "Justin", "Yang", "0405522522", "young.jiapeng@gmail.com", "Male");
        newCustomer.search(controller, "pizza");
        assertEquals(newCustomer.getSearchHistory().size(), 1);

        for (int i = 0; i < 30; i++) {
            newCustomer.search(controller, Integer.toString(i));
        }
        assertEquals(newCustomer.getSearchHistory().size(), 20);
        assertEquals(newCustomer.getSearchHistory().get(0), "29");

        newCustomer.clearSearchHistory();
        assertEquals(newCustomer.getSearchHistory().size(), 0);
    }
}
