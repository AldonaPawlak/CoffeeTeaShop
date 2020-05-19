package model;

public class Customer {
    private String phone;
    private String address;

    public Customer(String phone, String address){
        this.phone = phone;
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}

