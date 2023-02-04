package main.review;

import main.restaurant.Restaurant;

public class RestaurantReview extends Review {
    private Restaurant restaurant;

    public RestaurantReview(Restaurant restaurant, int rating) {
        super(rating);
        this.restaurant = restaurant;
    }

    public RestaurantReview(Restaurant restaurant, int rating, String comments) {
        super(rating, comments);
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
