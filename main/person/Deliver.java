package main.person;

public class Deliver extends Person {
    private int licenseNumber;
    private double totalRating;
    private int numRating;
    private double rating;

    public Deliver(int id, String displayName, String givenName, String surname,
                    String phoneNumber, String emailAddress, String gender, int licenseNumber) {
        super(id, displayName, givenName, surname, phoneNumber, emailAddress, gender);
        this.totalRating = 0;
        this.numRating = 0;
        this.rating = 0;
        this.licenseNumber = licenseNumber;
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
}
