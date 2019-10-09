package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreation2 extends TestBase {




  @Test
  public void testContactCreation2() throws Exception {

    app.goTo().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().goToCreateUserPage();
    ContactData contact = new ContactData("Wader", "Darth", "777777777", "papavaider@sith.com", "death star");
    app.getContactHelper().fillContactsFields(contact);
    app.getContactHelper().submitContactCreation();
    app.goTo().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
  //  System.out.println(before.size());
  //  System.out.println(after.size());
    Assert.assertEquals(after.size(), before.size() +1);


    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
  Assert.assertEquals(before, after);
  }


}

