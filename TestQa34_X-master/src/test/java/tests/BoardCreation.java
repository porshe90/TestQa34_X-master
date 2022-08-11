package tests;

import manage.MyDataProvider;
import model.Board;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase{

    @BeforeMethod
    public void  preConditions(){
        User user= new User().setEmail("juliakliot.jk@gmail.com").setPassword("misha240613");
        app.getUser().initLogin();
        app.getUser().fillInLoginForm(user);
        app.getUser().submitLogin();
    }

    @Test(dataProvider = "boardDataModel", dataProviderClass = MyDataProvider.class)
    public void boardCreation1(Board board){

        int boardCountBeforeCreation= app.getBoard().getBoardCount();
        //Board board = new Board().setTitle("testQa34");
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillboardCreationForm(board);
        app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();

        int boardCountAfterCreation= app.getBoard().getBoardCount();
        Assert.assertEquals(boardCountAfterCreation,boardCountBeforeCreation+1);
    }
}
