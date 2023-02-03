package main.person;

import java.util.ArrayList;

import main.address.PersonAddress;
import main.restaurant.*;

public class Customer extends Person {
    private ArrayList<PersonAddress> addresses;

    public Customer(int id, String displayName, String givenName, String surname,
                    String phoneNumber, String emailAddress, String gender) {
        super(id, displayName, givenName, surname, phoneNumber, emailAddress, gender);
        this.addresses = new ArrayList<>();
    }

    public ArrayList<PersonAddress> getAddresses() {
        return addresses;
    }

    public void addAddress(PersonAddress address) {
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
