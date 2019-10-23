package ru.stqa.pft.addressbook.tests;



import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;

public class TestBase {

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));


    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();

    }



}