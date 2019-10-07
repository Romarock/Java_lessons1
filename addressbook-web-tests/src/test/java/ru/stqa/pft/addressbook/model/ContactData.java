package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    public void setId(int id) {
        this.id = id;
    }

    private  int id;
    private final String name;
    private final String secondName;
    private final String phone;
    private final String email;
    private final String address;


    public ContactData( String name, String secondName, String phone, String email, String address) {
        this.id = 0;
        this.name = name;
        this.secondName = secondName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public ContactData(int id, String name, String secondName, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getId() { return id;}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(secondName, that.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, secondName);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }

}
