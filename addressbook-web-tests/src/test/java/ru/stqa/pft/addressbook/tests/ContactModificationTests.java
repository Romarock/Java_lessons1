package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void contactModificationTests(){

        app.getNavigationHelper().goToHomePage();

        if (! app.getContactHelper(). isThereAContact()) {

            app.getContactHelper().createContact(new ContactData("Wader", "Darth", "777777777", "papavaider@sith.com", "death star"));
            app.getNavigationHelper().goToHomePage();

        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().contactSelect(before.size() -1);
        app.getContactHelper().initContactModification();
        ContactData contact = new ContactData((before.get(before.size()-1).getId()),"Wader", "Darth", "66666", "papavaider@sith.com", "Hot");
        app.getContactHelper().fillContactsFields(contact);
        app.getContactHelper().SubmitContactModification();
        app.getNavigationHelper().goToHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        System.out.println(new HashSet<Object>(before));
        System.out.println(new HashSet<Object>(after));

      //  Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
