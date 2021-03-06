package tests;

import model.ListData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListAddingTest extends TestBase {

    @Test
    public void listAddingTest() {
        int boardCount = app.getBoardHelper().getBoardCount();
        if (boardCount == 0) {
            app.getBoardHelper().boardCreation("New board Title");
        }
        app.getNavigationHelper().openBoard();
        int before = app.getListHelper().getListCount();
        app.getListHelper().initListAdding();
        app.getListHelper().typeListTitle(new ListData("List Title"));
        app.getListHelper().submitListCreation();
        int after = app.getListHelper().getListCount();
        Assert.assertEquals(before, after - 1);

    }
}
