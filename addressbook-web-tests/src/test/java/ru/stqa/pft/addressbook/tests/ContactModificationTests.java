package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void contactModificationTests(){

        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().goToContactModificationPage();

        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactsFields(new ContactData("Wader", "Darth", "66666", "papavaider@sith.com"));
        app.getNavigationHelper().goToHomePage();

    }
}
