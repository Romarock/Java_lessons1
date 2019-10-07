package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

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



   contact.setId( after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
  Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }


}

