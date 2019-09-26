package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreation2 extends TestBase {




  @Test
  public void testContactCreation2() throws Exception {
    app.getNavigationHelper().goToCreateUserPage();
    app.getContactHelper().fillContactsFields(new ContactData("Wader", "Darth", "777777777", "papavaider@sith.com", "death star"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().goToHomePage();
  }


}

