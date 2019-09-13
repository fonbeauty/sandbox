package ru.stqa.pft.sandbox;

import org.testng.annotations.Test;

public class DeleteCheckLists extends TestBase{

    @Test
    public void testDeleteCheckLists() throws InterruptedException {
        selectCheckList();
        deleteSelectedCheckList();
//        Thread.sleep(2000);  // Let the user actually see something!
    }

}
