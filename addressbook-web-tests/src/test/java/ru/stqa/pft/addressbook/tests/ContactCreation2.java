package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactCreation2 extends TestBase {




  @Test
  public void testContactCreation2() throws Exception {

    app.getNavigationHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().goToCreateUserPage();
    ContactData contact = new ContactData("Wader", "Darth", "777777777", "papavaider@sith.com", "death star");
    app.getContactHelper().fillContactsFields(contact);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
  //  System.out.println(before.size());
  //  System.out.println(after.size());
    Assert.assertEquals(after.size(), before.size() +1);


  int max = 0;
  for (ContactData g : after) {

    if (g.getId() > max) {
      max = g.getId();
    }

  }
    contact.setId(max);
    before.add(contact);
  Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }


}

