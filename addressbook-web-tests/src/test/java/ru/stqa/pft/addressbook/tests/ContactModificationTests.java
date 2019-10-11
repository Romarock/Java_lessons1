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

            app.contact().create(new ContactData().withName("Ivan").withSecondName("Ivanov").withEmail("888@uuu").withAddress("yyyy").withPhone("888"));
            app.goTo().HomePage();

        }
        List<ContactData> before = app.contact().getContactList();
        int index = before.size()-1;
        ContactData contact = new ContactData()
                .withId(before.get(index).getId()).withName("Vasya").withSecondName("ttt").withPhone("3956").withAddress("756").withEmail("sjgf@hh");
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

