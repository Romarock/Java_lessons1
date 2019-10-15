package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().HomePage();
        if (!app.contact().isThereAContact()) {

            app.contact().create(new ContactData().withName("Ivan").withSecondName("Ivanov").withEmail("888@uuu").withAddress("yyyy").withPhone("888").withHomePhone("555").withWorkPhone("666"));
            app.goTo().HomePage();

        }
    }

    @Test

    public void  testContactPhones() {

        app.goTo().HomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getHomePhone())));
        assertThat(contact.getPhone(), equalTo(cleaned(contactInfoFromEditForm.getPhone())));
        assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));

    }
        public String cleaned (String phone)  {

        return phone.replaceAll("\\s", "").replaceAll("[- ()]", "");
        }

}



