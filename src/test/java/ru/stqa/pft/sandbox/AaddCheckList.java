package ru.stqa.pft.sandbox;

import org.testng.annotations.Test;


public class AaddCheckList extends TestBase {

    @Test
    public void testAddProject() {
        String rndString = getRandomString(6);
        clickAddCheckList();
        fillAddCheckListForm(rndString, rndString);
        submitCheckListCreation();
        returnListCheckList();
    }


}
