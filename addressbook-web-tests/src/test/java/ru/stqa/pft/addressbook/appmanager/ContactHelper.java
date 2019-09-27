package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void goToCreateUserPage() {
        wd.findElement(By.linkText("add new")).click();

    }
    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));

    }

    public void fillContactsFields(ContactData contactData) {
        typeContactData(By.name("firstname"), contactData.getName());
        typeContactData(By.name("lastname"), contactData.getSecondName());
        typeContactData(By.name("mobile"), contactData.getPhone());
        typeContactData(By.name("email"), contactData.getEmail());
    }


    public void contactSelect () {
        click(By.name("selected[]"));
    }

    public void deleteContact () {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void goToContactModificationPage() {

        click(By.xpath("//tr[3]/td[7]/a/img"));
    }

    public void initContactModification() {

        click(By.name("modifiy"));
    }

    public void createContact(ContactData contact) {

        goToCreateUserPage();
        fillContactsFields(new ContactData("Wader", "Darth", "777777777", "papavaider@sith.com", "death star"));
        submitContactCreation();

    }

    public boolean isThereAContact() {

        return isElementPresent(By.name("selected[]"));
    }
}


