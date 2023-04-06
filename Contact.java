package org.example;

public class Contact {
    private  int addressbook_id;
    private String addressbook_name;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zipcode;
    private long phonenumber;
    private String emailId;

    public Contact(int addressbook_id, String addressbook_name, String firstName, String lastName, String address, String city, String state, int zipcode, long phonenumber, String emailId) {
        this.addressbook_id = addressbook_id;
        this.addressbook_name = addressbook_name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phonenumber = phonenumber;
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "addressbook_id=" + addressbook_id +
                ", addressbook_name='" + addressbook_name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode=" + zipcode +
                ", phoneNumber=" + phonenumber +
                ", email='" + emailId + '\'' +
                '}';
    }

}