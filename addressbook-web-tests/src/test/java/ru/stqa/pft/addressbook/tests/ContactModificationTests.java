package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void contactModificationTests(){

        app.goTo().HomePage();

        if (! app.contact(). isThereAContact()) {

            app.contact().create(new ContactData("Wader", "Darth", "777777777", "papavaider@sith.com", "death star"));
            app.goTo().HomePage();

        }
        List<ContactData> before = app.contact().getContactList();
        int index = before.size()-1;
        ContactData contact = new ContactData((before.get(index).getId()),"Wa88", "Dar78th", "66666", "papavaider@sith.com", "Hot");
        app.contact().modify(index, contact);
        app.goTo().HomePage();

        List<ContactData> after = app.contact().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
      }


    }

