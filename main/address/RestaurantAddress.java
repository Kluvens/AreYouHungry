package main.address;

import java.time.LocalDateTime;

public class RestaurantAddress extends Address {
    public RestaurantAddress(int id, String stateName, String cityName, 
                String postalCode, String suburbName, String addressDetail, LocalDateTime createTime) {
        super(id, stateName, cityName, postalCode, suburbName, addressDetail, createTime);
    }
}
