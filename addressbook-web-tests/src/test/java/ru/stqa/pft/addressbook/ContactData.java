package ru.stqa.pft.addressbook;

public class ContactData {
    private final String name;
    private final String secondName;
    private final String phone;
    private final String email;

    public ContactData(String name, String secondName, String phone, String email) {
        this.name = name;
        this.secondName = secondName;
        this.phone = phone;
        this.email = email;
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
}
