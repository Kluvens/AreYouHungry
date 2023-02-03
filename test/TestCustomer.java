package test;

import main.address.PersonAddress;
import main.address.RestaurantAddress;
import main.controller.*;
import main.person.Customer;
import main.restaurant.Restaurant;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

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
    }

    @Test
    @DisplayName("Test rating restaurants")
    public void TestRatingRestaurants() {
        Controller controller = new Controller();
        RestaurantAddress address = new RestaurantAddress(1, "NSW", "Sydney", "2036", "Hillsdale", "D st.");
        Restaurant newRestaurant = controller.generateRestaurant(1, "pizza hut", "a place for good pizza", "0405522521", "pizzahut@outlook.com", "123456", address, 0, LocalDateTime.now());
        Customer newCustomer = controller.generateCustomer(1, "Justin", "Justin", "Yang", "0405522522", "young.jiapeng@gmail.com", "Male");
        newCustomer.rateRestaurant(newRestaurant, 5);
        assertEquals(newRestaurant.getRating(), 5);
        Customer newCustomerSec = controller.generateCustomer(2, "Justin", "Justin", "Yang", "0405522522", "young.jiapeng@gmail.com", "Male");
        newCustomerSec.rateRestaurant(newRestaurant, 6);
        assertEquals(newRestaurant.getRating(), 5.5);
    }

    @Test
    @DisplayName("Test rating delivers")
    public void TestRatingDelivers() {

    }
}
