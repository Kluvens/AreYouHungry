package main.voucher;

import java.time.LocalDateTime;

import main.restaurant.Restaurant;

public class RestaurantVoucher extends Voucher {
    private Restaurant restaurant;

    public RestaurantVoucher(int percentDiscount, LocalDateTime expireTime, Restaurant restaurant) {
        super(percentDiscount, expireTime);
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
