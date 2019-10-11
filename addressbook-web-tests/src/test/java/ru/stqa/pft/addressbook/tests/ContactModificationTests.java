package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

    @Test
    public void contactModificationTests(){

        app.goTo().HomePage();

        if (! app.contact(). isThereAContact()) {

            app.contact().create(new ContactData().withName("Ivan").withSecondName("Ivanov").withEmail("888@uuu").withAddress("yyyy").withPhone("888"));
            app.goTo().HomePage();

        }
       Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();

        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withName("Vasya").withSecondName("ttt").withPhone("3956").withAddress("756").withEmail("sjgf@hh");
        app.contact().modify(contact);
        app.goTo().HomePage();

        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());
        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(before, after);
      }


    }

