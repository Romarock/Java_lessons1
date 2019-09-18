package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    

    public void submitContactCreation(String s) {
        clickContact(By.xpath(s));

    }

    public void fillContactsFields(ContactData contactData) {
        typeContactData(By.name("firstname"), contactData.getName());
        typeContactData(By.name("lastname"), contactData.getSecondName());
        typeContactData(By.name("mobile"), contactData.getPhone());
        typeContactData(By.name("email"), contactData.getEmail());
    }


}
