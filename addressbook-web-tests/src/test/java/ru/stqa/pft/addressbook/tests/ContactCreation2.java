package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreation2 extends TestBase {




  @Test
  public void testContactCreation2() throws Exception {

    app.goTo().HomePage();
    List<ContactData> before = app.contact().getContactList();
    ContactData contact = new ContactData().withName("ivan").withAddress("ttt").withSecondName("hkhk").withEmail("666@uuu").withPhone("555");
    app.contact().create(contact);
    app.goTo().HomePage();
    List<ContactData> after = app.contact().getContactList();

    Assert.assertEquals(after.size(), before.size() +1);


    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
  Assert.assertEquals(before, after);
  }




}

