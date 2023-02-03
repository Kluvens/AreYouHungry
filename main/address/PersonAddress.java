package main.address;

import java.time.LocalDateTime;

public class PersonAddress extends Address {
    public PersonAddress(int id, String stateName, String cityName, 
                String postalCode, String suburbName, String addressDetail, LocalDateTime createTime) {
        super(id, stateName, cityName, postalCode, suburbName, addressDetail, createTime);
    }
}
