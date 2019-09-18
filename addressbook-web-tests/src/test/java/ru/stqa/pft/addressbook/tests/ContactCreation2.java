package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class ContactCreation2 extends TestBase {




  @Test
  public void testContactCreation2() throws Exception {
    app.getNavigationHelper().goToCreateUserPage();
    app.getContactHelper().fillUsersFields();
    app.getContactHelper().submitUserCreation();
    app.getNavigationHelper().goToHomePage();
  }


}

