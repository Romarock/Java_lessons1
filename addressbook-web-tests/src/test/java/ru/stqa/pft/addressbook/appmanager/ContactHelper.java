package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        typeContactData(By.name("address"), contactData.getAddress());
    }


    public void contactSelect (int index) {
        wd.findElements(By.name("selected[]")).get(index).click();

    }

    public void contactSelectById (int id) {
        wd.findElement(By.cssSelector("input[value ='" + id + "']")).click();

    }

    public void deleteContact () {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

 //   public void goToContactModificationPage() {

 //       click(By.xpath("//tr[3]/td[7]/a/img"));
  //  }

    public void initContactModification(int index) {

         wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
      //  click(By.xpath("//img[@alt='Edit']"));
    }

    public void initContactModificationById(int id) {

        wd.findElement(By.cssSelector("a[href='edit.php?id="+ id +"']")).click();
        //  click(By.xpath("//img[@alt='Edit']"));
    }

    public void SubmitContactModification() {

        click(By.xpath("(//input[@name='update'])[2]"));

    }



    public boolean isThereAContact() {

        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {

      return  wd.findElements(By.name("selected[]")).size();

    }


    public List<ContactData> getContactList() {

        List<ContactData> contacts = new ArrayList<ContactData>();
        List <WebElement> elements = wd.findElements(By.name("entry"));

        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));

                int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
                String firstName = cells.get(2).getText();
                String lastName = cells.get(1).getText();
                contacts.add(new ContactData().withId(id).withName(firstName).withSecondName(lastName).withEmail("8585@mm").withAddress("2534").withPhone("76557"));
            }



        return contacts;
    }

    public Set<ContactData> all() {

        Set<ContactData> contacts = new HashSet<ContactData>();
        List <WebElement> elements = wd.findElements(By.name("entry"));

        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));

            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String firstName = cells.get(2).getText();
            String lastName = cells.get(1).getText();
            contacts.add(new ContactData().withId(id).withName(firstName).withSecondName(lastName).withEmail("8585@mm").withAddress("2534").withPhone("76557"));
        }



        return contacts;
    }




    public void create(ContactData contact) {
        goToCreateUserPage();
        fillContactsFields(contact);
        submitContactCreation();
    }

   public void delete(int index) {
        contactSelect(index);
        deleteContact();
    }

    public void modify(ContactData contact) {
        contactSelectById(contact.getId());
        initContactModificationById(contact.getId());
        fillContactsFields(contact);
        SubmitContactModification();

    }

    public void delete(ContactData contact) {
        contactSelectById(contact.getId());
        deleteContact();
    }
}



