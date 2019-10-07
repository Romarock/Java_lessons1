package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

@Test

    public void contactDeletionTests() {

    app.getNavigationHelper().goToHomePage();

    if (! app.getContactHelper(). isThereAContact()) {

        app.getContactHelper().createContact(new ContactData("Wader", "Darth", "777777777", "papavaider@sith.com", "death star"));
        app.getNavigationHelper().goToHomePage();

    }
    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().contactSelect(before.size() - 1);
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() -1);


        Assert.assertEquals(before, after);


 }
}
