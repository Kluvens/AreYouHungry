package main.person;

import java.util.List;

import java.util.ArrayList;

import main.order.CompletedOrder;
import main.order.Order;
import main.review.DeliverReview;
import main.review.Review;

public class Deliver extends Person {
    private int licenseNumber;
    private List<Order> onDeliveryOrders;
    private List<Order> orders;
    private List<Review> reviews;

    public Deliver(int id, String displayName, String givenName, String surname,
                    String phoneNumber, String emailAddress, String gender, int licenseNumber) {
        super(id, displayName, givenName, surname, phoneNumber, emailAddress, gender);
        this.licenseNumber = licenseNumber;
        this.onDeliveryOrders = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Deliver acceptOrder(CompletedOrder order) {
        orders.add(order);
        onDeliveryOrders.add(order);
        return this;
    }

    public Deliver rejectOrder(CompletedOrder order) {
        return null;
    }

    public List<Order> getonDeliveryOrders() {
        return onDeliveryOrders;
    }

    public void finishDelivery(CompletedOrder order) {
        onDeliveryOrders.remove(order);
        order.finishDelivery();
    }

    public double getAverageRating() {
        return reviews.stream().mapToDouble(d -> d.getRating()).average().orElse(0.0);
    }

    public void addReview(DeliverReview dReview) {
        reviews.add(dReview);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
