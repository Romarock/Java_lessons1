package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactCreation2 extends TestBase {




  @Test
  public void testContactCreation2() throws Exception {

    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().goToCreateUserPage();
    app.getContactHelper().fillContactsFields(new ContactData("Wader", "Darth", "777777777", "papavaider@sith.com", "death star"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().goToHomePage();
    int after = app.getContactHelper().getContactCount();

    Assert.assertEquals(after, before +1);

  }


}

