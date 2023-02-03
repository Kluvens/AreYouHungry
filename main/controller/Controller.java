package main.controller;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Random;

import main.person.Customer;
import main.person.Deliver;
import main.restaurant.Restaurant;
import main.address.*;

public class Controller {
    private ArrayList<Customer> customers;
    private ArrayList<Deliver> delivers;
    private ArrayList<Restaurant> restaurants;

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Deliver> getDelivers() {
        return delivers;
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public Controller() {
        customers = new ArrayList<>();
        delivers = new ArrayList<>();
        restaurants = new ArrayList<>();
    }

    public Customer generateCustomer(int id, String displayName, String givenName, String surname,
                                        String phoneNumber, String emailAddress, String gender) {
        Customer newCustomer = new Customer(id, displayName, givenName, surname, phoneNumber, emailAddress, gender);
        customers.add(newCustomer);
        return newCustomer;
    }

    public Deliver generateDeliver(int id, String displayName, String givenName, String surname,
                                        String phoneNumber, String emailAddress, String gender, int licenseNumber) {
        Deliver newDeliver = new Deliver(id, displayName, givenName, surname, phoneNumber, emailAddress, gender, licenseNumber);
        delivers.add(newDeliver);
        return newDeliver;
    }

    public Restaurant generateRestaurant(int id, String restaurantName, String description, String phoneNumber, String emailAddress,
                                        String licenseNumber, RestaurantAddress restaurantAddress, int freeDeliveryStarts, LocalDateTime createTime) {
        Restaurant newRestaurant = new Restaurant(id, restaurantName, description, phoneNumber, emailAddress, licenseNumber, restaurantAddress, freeDeliveryStarts, LocalDateTime.now());
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Deliver assignDeliverForOrder() {
        Random rand = new Random();
        int size = delivers.size();
        int intRandom = rand.nextInt(size);
        return delivers.get(intRandom);
    }
}
