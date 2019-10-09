package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void contactModificationTests(){

        app.goTo().goToHomePage();

        if (! app.getContactHelper(). isThereAContact()) {

            app.getContactHelper().createContact(new ContactData("Wader", "Darth", "777777777", "papavaider@sith.com", "death star"));
            app.goTo().goToHomePage();

        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().contactSelect(before.size() -1);
        app.getContactHelper().initContactModification(before.size()- 1);
        ContactData contact = new ContactData((before.get(before.size()-1).getId()),"Wa88", "Dar78th", "66666", "papavaider@sith.com", "Hot");
        app.getContactHelper().fillContactsFields(contact);
        app.getContactHelper().SubmitContactModification();
        app.goTo().goToHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
       // System.out.println(new HashSet<Object>(before));
       // System.out.println(new HashSet<Object>(after));
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
