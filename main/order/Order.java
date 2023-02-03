package main.order;

import java.time.LocalDateTime;

import main.address.*;

public class Order {
    private int id;
    private int customerId;
    private int restaurantId;
    private PersonAddress receivingAddress;
    private int deliverId;
    private LocalDateTime orderTime;
    private LocalDateTime checkoutTime;
    private String paymentMethod;
    private double totalPrice;
    private String remark;

    public Order(int id, int customerId, int restaurantId, PersonAddress receivingAddress, int deliverId,
            LocalDateTime orderTime, LocalDateTime checkoutTime, String paymentMethod, double totalPrice,
            String remark) {
        this.id = id;
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.receivingAddress = receivingAddress;
        this.deliverId = deliverId;
        this.orderTime = orderTime;
        this.checkoutTime = checkoutTime;
        this.paymentMethod = paymentMethod;
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

    public int getDeliverId() {
        return deliverId;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public LocalDateTime getCheckoutTime() {
        return checkoutTime;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getRemark() {
        return remark;
    }
}
