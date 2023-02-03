package main.person;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.stream.*;

import main.address.PersonAddress;
import main.restaurant.*;
import main.dish.*;
import main.order.*;

public class Customer extends Person {
    private PersonAddress defaultAddress;
    private ArrayList<PersonAddress> addresses;
    private HashMap<Restaurant, ArrayList<Dish>> shoppingCarts;
    private ArrayList<PendingOrder> pendingOrders;
    private ArrayList<CompletedOrder> orders;

    public Customer(int id, String displayName, String givenName, String surname,
                    String phoneNumber, String emailAddress, String gender) {
        super(id, displayName, givenName, surname, phoneNumber, emailAddress, gender);
        this.addresses = new ArrayList<>();
        this.defaultAddress = null;
        this.shoppingCarts = new HashMap<Restaurant, ArrayList<Dish>>();
        this.orders = new ArrayList<>();
    }

    public PersonAddress generateAddress(int id, String stateName, String cityName, 
                                        String postalCode, String suburbName, String addressDetail) {
        PersonAddress address = new PersonAddress(id, stateName, cityName, postalCode, suburbName, addressDetail, this.getDisplayName(), this.getPhoneNumber());
        addAddress(address);
        return address;
    }

    public PersonAddress generateAddress(int id, String stateName, String cityName, 
                                        String postalCode, String suburbName, String addressDetail, String label) {
        PersonAddress address = new PersonAddress(id, stateName, cityName, postalCode, suburbName, addressDetail, this.getDisplayName(), this.getPhoneNumber(), label);
        addAddress(address);
        return address;
    }

    public PersonAddress getDefaultAddress() {
        return defaultAddress;
    }

    public void updateDefaultAddress(PersonAddress address) {
        this.defaultAddress = address;
    }

    public ArrayList<PersonAddress> getAddresses() {
        return addresses;
    }

    public void addAddress(PersonAddress address) {
        if (this.addresses.size() == 0) {
            defaultAddress = address;
        }
        this.addresses.add(address);
    }

    public void removeAddress(PersonAddress address) {
        this.addresses.remove(address);
    }

    public void rateRestaurant(Restaurant restaurant, int rating) {
        restaurant.updateRating(rating);
    }

    public void rateDeliver(Deliver deliver, int rating) {
        deliver.updateRating(rating);
    }

    public HashMap<Restaurant, ArrayList<Dish>> getShoppingCarts() {
        return shoppingCarts;
    }

    public void putToShoppingCart(Restaurant restaurant, Dish dish) {
        ArrayList<Dish> dishesInCart = this.shoppingCarts.get(restaurant);
        if (dishesInCart != null) {
            dishesInCart.add(dish);
            this.shoppingCarts.put(restaurant, dishesInCart);
        } else {
            ArrayList<Dish> dishList = new ArrayList<>();
            dishList.add(dish);
            this.shoppingCarts.put(restaurant, dishList);
        }
    }

    public void removeFromShoppingCart(Restaurant restaurant, Dish dish) {
        ArrayList<Dish> dishesInCart = this.shoppingCarts.get(restaurant);
        dishesInCart.remove(dish);
        if (dishesInCart.size() == 0) {
            this.shoppingCarts.remove(restaurant);
        } else {
            this.shoppingCarts.put(restaurant, dishesInCart);
        }
    }

    public ArrayList<PendingOrder> getPendingOrders() {
        return pendingOrders;
    }

    public ArrayList<CompletedOrder> getOrders() {
        return orders;
    }

    public PendingOrder makeOrder(int orderId, Restaurant restaurant, Dish... dishes) {
        double totalPrice = 0;
        for (Dish i: dishes) {
            totalPrice += i.getPrice();
        }
        PendingOrder newPendingOrder = new PendingOrder(orderId, this.getId(), restaurant.getId(), this.getDefaultAddress(), LocalDateTime.now(), totalPrice, "");
        this.pendingOrders.add(newPendingOrder);
        return newPendingOrder;
    }

    public void cancelPendingOrder(PendingOrder pendingOrder) {
        this.pendingOrders.remove(pendingOrder);
    }

    public CompletedOrder completeOrder(PendingOrder pendingOrder) {
        CompletedOrder order = new CompletedOrder(pendingOrder, LocalDateTime.now(), "WeChat");
        this.pendingOrders.remove(pendingOrder);
        this.orders.add(order);
        return order;
    }

    public void cancelOrder(CompletedOrder order) {
        this.orders.remove(order);
    }
}
