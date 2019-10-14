package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactCreation2 extends TestBase {




  @Test
  public void testContactCreation2() throws Exception {

    app.goTo().HomePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withName("ivan").withAddress("ttt").withSecondName("hkhk").withEmail("666@uuu").withPhone("555");
    app.contact().create(contact);
    app.goTo().HomePage();
   Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() +1));
    assertThat(after, equalTo(
            before.withAdded( contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }




}

