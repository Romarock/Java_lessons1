package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {





  @Test
  public void testGroupDeletion() throws Exception {

   app.goToGroupPage("groups");
    app.selectGroup("selected[]");
    app.deleteSelectedGroups("delete");
    app.returnToGroupPage("group page");
    }


}



