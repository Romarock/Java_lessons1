package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {





  @Test
  public void testGroupDeletion() throws Exception {

   goToGroupPage("groups");
    selectGroup("selected[]");
    deleteSelectedGroups("delete");
    returnToGroupPage("group page");
    }


}



