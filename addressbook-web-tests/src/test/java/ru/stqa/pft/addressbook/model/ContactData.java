package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String name;
    private final String secondName;
    private final String phone;
    private final String email;
    private final String address;

    public ContactData(String name, String secondName, String phone, String email, String address) {
        this.name = name;
        this.secondName = secondName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
