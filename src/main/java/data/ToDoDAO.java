package data;


import java.util.ArrayList;
import java.util.List;

public class ToDoDAO {

    private static ToDoDAO insance;
    private List<ToDoElem> list;

    public  ToDoDAO() {

        list = new ArrayList<ToDoElem>();
        list.add(new ToDoElem(1,"Støvsuge"));


    }

    public static ToDoDAO getInstance() {
        if (insance == null)
            return new ToDoDAO();
        return insance;
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

}
