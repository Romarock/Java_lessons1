package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreation2 extends TestBase {




  @Test
  public void testContactCreation2() throws Exception {

    app.goTo().HomePage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData()
            .withName("ivan").withAddress("ttt").withSecondName("hkhk").withEmail("666@uuu").withPhone("555");
    app.contact().create(contact);
    app.goTo().HomePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() +1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
  Assert.assertEquals(before, after);
  }




}

