package ru.stqa.pft.addressbook.tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests {
  private WebDriver wd;


  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();

    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");

    login("user", "admin", "pass", "secret", "(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]");
  }

  private void login(String user, String admin, String pass, String secret, String s) {
    wd.findElement(By.name(user)).click();
    wd.findElement(By.name(user)).clear();
    wd.findElement(By.name(user)).sendKeys(admin);
    wd.findElement(By.name(pass)).click();
    wd.findElement(By.name(pass)).clear();
    wd.findElement(By.name(pass)).sendKeys(secret);
    wd.findElement(By.xpath(s)).click();
  }

  @Test
  public void testContactCreationTests() throws Exception {

    goToAddContact("add new");
    fillContactData(new ContactData("Luke", "Skywalker", "777777777", "papavaider@sith.com"));
    submitContactCreation("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]");
    goToHomePage("home");
    logout("Logout");
  }

  private void logout(String logout) {
    wd.findElement(By.linkText(logout)).click();
  }

  private void goToHomePage(String home) {
    wd.findElement(By.linkText(home)).click();
  }

  private void submitContactCreation(String s) {
    wd.findElement(By.xpath(s)).click();
  }

  private void fillContactData(ContactData contactData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contactData.getName());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactData.getSecondName());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(contactData.getPhone());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
  }

  private void goToAddContact(String s) {
    wd.findElement(By.linkText(s)).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();




  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }


  }

