package main.order;

import java.time.LocalDateTime;

import main.address.PersonAddress;

public class PendingOrder extends Order {
    public PendingOrder(int id, int customerId, int restaurantId, PersonAddress receivingAddress, LocalDateTime orderTime, double totalPrice, String remark) {
        super(id, customerId, restaurantId, receivingAddress, orderTime, totalPrice, remark);
    }
}
