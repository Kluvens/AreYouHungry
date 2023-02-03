package main.address;

public class RestaurantAddress extends Address {
    public RestaurantAddress(int id, String stateName, String cityName, 
                String postalCode, String suburbName, String addressDetail) {
        super(id, stateName, cityName, postalCode, suburbName, addressDetail);
    }
}
