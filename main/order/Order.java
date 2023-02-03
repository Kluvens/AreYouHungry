package main.order;

import java.time.LocalDateTime;

import main.address.*;

public abstract class Order {
    private int id;
    private int customerId;
    private int restaurantId;
    private PersonAddress receivingAddress;
    private LocalDateTime orderTime;
    private double totalPrice;
    private String remark;

    public Order(int id, int customerId, int restaurantId, PersonAddress receivingAddress,
            LocalDateTime orderTime, double totalPrice,
            String remark) {
        this.id = id;
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.receivingAddress = receivingAddress;
        this.orderTime = orderTime;
        this.totalPrice = totalPrice;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public PersonAddress getReceivingAddress() {
        return receivingAddress;
    }

    public void setReceivingAddress(PersonAddress receivingAddress) {
        this.receivingAddress = receivingAddress;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getRemark() {
        return remark;
    }
}
