package main.person;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.Map;

import java.util.List;

import main.address.PersonAddress;
import main.restaurant.*;
import main.review.DeliverReview;
import main.review.RestaurantReview;
import main.review.Review;
import main.voucher.GeneralVoucher;
import main.voucher.RestaurantVoucher;
import main.voucher.Voucher;
import main.dish.*;
import main.order.*;
import main.controller.*;

public class Customer extends Person {
    private PersonAddress defaultAddress;
    private List<PersonAddress> addresses;
    private Map<Restaurant, List<Dish>> shoppingCarts;
    private List<PendingOrder> pendingOrders;
    private List<CompletedOrder> orders;
    private List<String> searchHistory;
    private List<Voucher> vouchers;
    private List<Review> reviews;

    public Customer(int id, String displayName, String givenName, String surname,
                    String phoneNumber, String emailAddress, String gender) {
        super(id, displayName, givenName, surname, phoneNumber, emailAddress, gender);
        this.addresses = new ArrayList<>();
        this.defaultAddress = null;
        this.shoppingCarts = new HashMap<Restaurant, List<Dish>>();
        this.orders = new ArrayList<>();
        this.searchHistory = new ArrayList<>();
        this.reviews = new ArrayList<>();
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

    public List<PersonAddress> getAddresses() {
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

    public void writeReviewRestaurant(Restaurant restaurant, int rating) {
        RestaurantReview rView = new RestaurantReview(restaurant, rating);
        reviews.add(rView);
        restaurant.addReview(rView);
    }

    public void writeReviewRestaurant(Restaurant restaurant, int rating, String comments) {
        RestaurantReview rView = new RestaurantReview(restaurant, rating, comments);
        reviews.add(rView);
        restaurant.addReview(rView);
    }

    public void writeReviewDeliver(Deliver deliver, int rating) {
        DeliverReview dView = new DeliverReview(deliver, rating);
        reviews.add(dView);
        deliver.addReview(dView);
    }

    public void writeReviewDeliver(Deliver deliver, int rating, String comments) {
        DeliverReview dView = new DeliverReview(deliver, rating, comments);
        reviews.add(dView);
        deliver.addReview(dView);
    }

    public Map<Restaurant, List<Dish>> getShoppingCarts() {
        return shoppingCarts;
    }

    public void putToShoppingCart(Restaurant restaurant, Dish dish) {
        List<Dish> dishesInCart = this.shoppingCarts.get(restaurant);
        if (dishesInCart != null) {
            dishesInCart.add(dish);
            this.shoppingCarts.put(restaurant, dishesInCart);
        } else {
            List<Dish> dishList = new ArrayList<>();
            dishList.add(dish);
            this.shoppingCarts.put(restaurant, dishList);
        }
    }

    public void removeFromShoppingCart(Restaurant restaurant, Dish dish) {
        List<Dish> dishesInCart = this.shoppingCarts.get(restaurant);
        dishesInCart.remove(dish);
        if (dishesInCart.size() == 0) {
            this.shoppingCarts.remove(restaurant);
        } else {
            this.shoppingCarts.put(restaurant, dishesInCart);
        }
    }

    public List<PendingOrder> getPendingOrders() {
        return pendingOrders;
    }

    public List<CompletedOrder> getOrders() {
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

    public CompletedOrder completedOrder(PendingOrder pendingOrder) {
        CompletedOrder order = new CompletedOrder(pendingOrder, LocalDateTime.now(), "WeChat");
        this.pendingOrders.remove(pendingOrder);
        this.orders.add(order);
        return order;
    }
    
    public CompletedOrder completeOrder(PendingOrder pendingOrder, Voucher voucher) {
        CompletedOrder order = new CompletedOrder(pendingOrder, LocalDateTime.now(), "WeChat", voucher);
        this.pendingOrders.remove(pendingOrder);
        this.orders.add(order);
        return order;
    }

    public void cancelOrder(CompletedOrder order) {
        this.orders.remove(order);
        order.cancelOrder();
    }

    public List<Restaurant> filter(Controller controller, RestaurantCategory... categories) {
        return controller.filter(categories);
    }

    public List<Restaurant> search(Controller controller, String info) {
        this.searchHistory.add(0, info);
        return controller.search(info);
    }

    public List<Restaurant> filterIncludingNotOpen(Controller controller, RestaurantCategory... categories) {
        return controller.filterIncludingNotOpen(categories);
    }

    public List<Restaurant> searchIncludingNotOpen(Controller controller, String info) {
        this.searchHistory.add(0, info);
        return controller.searchIncludingNotOpen(info);
    }

    public List<String> getSearchHistory() {
        return searchHistory.stream().limit(20).collect(Collectors.toList());
    }

    public void clearSearchHistory() {
        searchHistory.clear();
    }

    public List<Voucher> getAvailableVouchers() {
        return vouchers.stream().filter(i -> LocalDateTime.now().isBefore(i.getExpireTime())).collect(Collectors.toList());
    }

    public List<Voucher> getUnavailableVouchers() {
        return vouchers.stream().filter(i -> i.getExpireTime().isBefore(LocalDateTime.now())).collect(Collectors.toList());
    }

    public List<Voucher> getValidVoucher(Restaurant restaurant) {
        List<Voucher> availableVouchers = getAvailableVouchers();
        List<Voucher> validVouchers = new ArrayList<>();
        for (Voucher v: availableVouchers) {
            if (v instanceof GeneralVoucher) {
                validVouchers.add(v);
            } else {
                RestaurantVoucher rVoucher = (RestaurantVoucher)v;
                if (rVoucher.getRestaurant().equals(restaurant)) {
                    validVouchers.add(rVoucher);
                }
            }
        }
        return validVouchers;
    }
}
