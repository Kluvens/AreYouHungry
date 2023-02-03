package main.person;

import java.util.ArrayList;

import main.address.PersonAddress;
import main.restaurant.*;

public class Customer extends Person {
    private PersonAddress defaultAddress;
    private ArrayList<PersonAddress> addresses;

    public Customer(int id, String displayName, String givenName, String surname,
                    String phoneNumber, String emailAddress, String gender) {
        super(id, displayName, givenName, surname, phoneNumber, emailAddress, gender);
        this.addresses = new ArrayList<>();
        this.defaultAddress = null;
    }

    public PersonAddress generateAddress(int id, String stateName, String cityName, 
                                        String postalCode, String suburbName, String addressDetail) {
        PersonAddress address = new PersonAddress(id, stateName, cityName, postalCode, suburbName, addressDetail, this.getDisplayName(), this.getPhoneNumber());
        addAddress(address);
        return address;
    }

    public PersonAddress generateAddress(int id, String stateName, String cityName, 
                                        String postalCode, String suburbName, String addressDetail, String label) {
        PersonAddress address = new PersonAddress(id, stateName, cityName, postalCode, suburbName, addressDetail, this.getDisplayName(), this.getPhoneNumber(), label);
        addAddress(address);
        return address;
    }

    public PersonAddress getDefaultAddress() {
        return defaultAddress;
    }

    public void updateDefaultAddress(PersonAddress address) {
        this.defaultAddress = address;
    }

    public ArrayList<PersonAddress> getAddresses() {
        return addresses;
    }

    public void addAddress(PersonAddress address) {
        if (this.addresses.size() == 0) {
            defaultAddress = address;
        }
        this.addresses.add(address);
    }

    public void removeAddress(PersonAddress address) {
        this.addresses.remove(address);
    }

    public void rateRestaurant(Restaurant restaurant, int rating) {
        restaurant.updateRating(rating);
    }

    public void rateDeliver(Deliver deliver, int rating) {
        deliver.updateRating(rating);
    }
}
