package main.restaurant;

import main.address.RestaurantAddress;
import main.dish.Dish;
import main.interfaces.Ratable;
import main.order.Order;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Restaurant implements Ratable {
    private int id;
    private String restaurantName;
    private String description;
    private String phoneNumber;
    private String emailAddress;
    private String licenseNumber;
    private RestaurantAddress address;
    private double totalRating;
    private int numRating;
    private double rating;
    private int freeDeliveryStarts;
    private int sellingInMonth;
    private LocalDateTime createTime;
    private boolean isCredited;
    private boolean isOpen;
    private List<Dish> menu;
    private List<Order> orders;
    private RestaurantCategory category;

    public Restaurant(int id, String restaurantName, String description, String phoneNumber, String emailAddress,
                        String licenseNumber, RestaurantAddress restaurantAddress, int freeDeliveryStarts, LocalDateTime createTime) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.licenseNumber = licenseNumber;
        this.address = restaurantAddress;
        this.totalRating = 0;
        this.numRating = 0;
        this.rating = 0;
        this.freeDeliveryStarts = freeDeliveryStarts;
        this.sellingInMonth = 0;
        this.createTime = createTime;
        this.isCredited = false;
        this.isOpen = true;
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public RestaurantAddress getAddress() {
        return address;
    }

    public void setAddress(RestaurantAddress address) {
        this.address = address;
    }

    public double getRating() {
        return rating;
    }

    public void updateRating(double rating) {
        this.totalRating += rating;
        this.numRating += 1;
        this.rating = this.totalRating/this.numRating;
    }

    public int getFreeDeliveryStarts() {
        return freeDeliveryStarts;
    }

    public void setFreeDeliveryStarts(int freeDeliveryStarts) {
        this.freeDeliveryStarts = freeDeliveryStarts;
    }

    public int getSellingInMonth() {
        return sellingInMonth;
    }

    public void setSellingInMonth(int sellingInMonth) {
        this.sellingInMonth = sellingInMonth;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public boolean isCredited() {
        return isCredited;
    }

    public void setCredited(boolean isCredited) {
        this.isCredited = isCredited;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public Dish addDish(int id, String name, double price, String description) {
        Dish newDish = new Dish(id, name, price, description);
        this.menu.add(newDish);
        return newDish;
    }

    public void removeDish(Dish dish) {
        this.menu.remove(dish);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public void remove(Order order) {
        this.orders.remove(order);
    }

    public void assignCategory(RestaurantCategory category) {
        this.category = category;
    }

    public RestaurantCategory getCategory() {
        return category;
    }
}
