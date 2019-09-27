package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void contactModificationTests(){

        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper(). isThereAContact()) {

            app.getContactHelper().createContact(new ContactData("Wader", "Darth", "777777777", "papavaider@sith.com", "death star"));
            app.getNavigationHelper().goToHomePage();

        }
        app.getContactHelper().contactSelect();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactsFields(new ContactData("Wader", "Darth", "66666", "papavaider@sith.com", "Hot"));
        app.getContactHelper().SubmitContactModification();
        app.getNavigationHelper().goToHomePage();

    }
}
