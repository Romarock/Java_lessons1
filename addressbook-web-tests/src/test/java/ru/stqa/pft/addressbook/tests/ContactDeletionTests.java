package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

@Test

    public void contactDeletionTests() {

    app.goTo().HomePage();

    if (! app.contact(). isThereAContact()) {

        app.contact().create(new ContactData("Wader", "Darth", "777777777", "papavaider@sith.com", "death star"));
        app.goTo().HomePage();

    }
    List<ContactData> before = app.contact().getContactList();

    int index = before.size() - 1;

    app.contact().delete(index);
    app.goTo().HomePage();

    List<ContactData> after = app.contact().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);


        Assert.assertEquals(before, after);


 }


}
