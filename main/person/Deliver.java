package main.person;

import java.util.List;
import java.util.ArrayList;

import main.interfaces.Ratable;
import main.order.CompletedOrder;
import main.order.Order;

public class Deliver extends Person implements Ratable {
    private int licenseNumber;
    private double totalRating;
    private int numRating;
    private double rating;
    private List<Order> orders;

    public Deliver(int id, String displayName, String givenName, String surname,
                    String phoneNumber, String emailAddress, String gender, int licenseNumber) {
        super(id, displayName, givenName, surname, phoneNumber, emailAddress, gender);
        this.totalRating = 0;
        this.numRating = 0;
        this.rating = 0;
        this.licenseNumber = licenseNumber;
        this.orders = new ArrayList<>();
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public double getRating() {
        return rating;
    }

    public void updateRating(double rating) {
        this.totalRating += rating;
        this.numRating += 1;
        this.rating = this.totalRating/this.numRating;
    }

    public Deliver acceptOrder(CompletedOrder order) {
        orders.add(order);
        return this;
    }

    public Deliver rejectOrder(CompletedOrder order) {
        return null;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void finishDelivery(CompletedOrder order) {
        orders.remove(order);
        order.finishDelivery();
    }
}
