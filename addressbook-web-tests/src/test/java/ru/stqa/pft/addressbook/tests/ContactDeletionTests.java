package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTests extends TestBase {

@Test

    public void contactDeletionTests() {

    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper(). isThereAContact()) {

        app.getContactHelper().createContact(new ContactData("Wader", "Darth", "777777777", "papavaider@sith.com", "death star"));
        app.getNavigationHelper().goToHomePage();

    }

    app.getContactHelper().contactSelect();
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().goToHomePage();

 }
}
