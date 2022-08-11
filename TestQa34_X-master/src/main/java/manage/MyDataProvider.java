package manage;

import model.Board;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public static Iterator<Object[]>boardDataModel(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new Board().setTitle("testqa34_1")});
        list.add(new Object[]{new Board().setTitle("testqa34_2")});
        list.add(new Object[]{new Board().setTitle("testqa34_3")});
        return list.iterator();
    }
}
