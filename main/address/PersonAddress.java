package main.address;

public class PersonAddress extends Address {
    private String name;
    private String phoneNumber;
    private String label;

    public PersonAddress(int id, String stateName, String cityName, 
                String postalCode, String suburbName, String addressDetail, String name, String phoneNumber) {
        super(id, stateName, cityName, postalCode, suburbName, addressDetail);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.label = null;
    }

    public PersonAddress(int id, String stateName, String cityName, 
                String postalCode, String suburbName, String addressDetail, String name, String phoneNumber, String label) {
        super(id, stateName, cityName, postalCode, suburbName, addressDetail);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLabel() {
        return label;
    }

    public void updateLabel(String label) {
        this.label = label;
    }

}
