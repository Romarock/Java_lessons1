package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {





  @Test
  public void testGroupDeletion() throws Exception {

    app.getNavigationHelper().goToGroupPage("groups");
    app.getGroupHelper().selectGroup("selected[]");
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage("group page");
    }


}



