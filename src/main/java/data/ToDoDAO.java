package data;


import java.util.ArrayList;
import java.util.List;

public class ToDoDAO {

    private static ToDoDAO instance;
    private List<ToDoElem> list;

    public  ToDoDAO() {

        list = new ArrayList<ToDoElem>();
        list.add(new ToDoElem(1,"handel"));


    }

    public static ToDoDAO getInstance() {
        if (instance == null)
            instance = new ToDoDAO();
        return instance;
    }

    public String getTodoById(int id) {
        for (ToDoElem curr : list) {

            if (curr.getId() == id)
                return curr.getTodo();

        }

        return "ID eksisterer ikke i listen";
    }

    public void addElement(ToDoElem elem) {
        list.add(elem);
    }

    public List<ToDoElem> getList() {
        return list;
    }

    public String getListAsString() {
        String totalString = "";

        for (ToDoElem elem : list) {
            totalString = totalString + "{" + elem.getId() + "," + elem.getTodo() + "}";
        }

        return totalString;
    }

}
