package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToGroupPage() {

        if (isElementPresent(By.tagName("h1")))


            wd.findElement(By.linkText("groups")).click();
    }


    public void goToCreateUserPage() {
        wd.findElement(By.linkText("add new")).click();
    }
    public void goToHomePage() {
        wd.findElement(By.linkText("home")).click();
    }
}