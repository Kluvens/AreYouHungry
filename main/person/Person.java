package main.person;

public abstract class Person {
    private int id;
    private String displayName;
    private String givenName;
    private String surname;
    private String phoneNumber;
    private String emailAddress;
    private String gender;
    private boolean isActive;

    public Person(int id, String displayName, String givenName, String surname,
                    String phoneNumber, String emailAddress, String gender) {
        this.id = id;
        this.displayName = displayName;
        this.givenName = givenName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.gender = gender;
        this. isActive = true;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
}
