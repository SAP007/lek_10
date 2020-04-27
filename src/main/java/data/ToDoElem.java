package data;

public class ToDoElem {

    private int id;
    private String todo;

    public ToDoElem(int id, String todo) {
        this.id = id;
        this.todo = todo;
    }

    public String getTodo() {
        return todo;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "{" + id + "," + todo + "}";
    }
}
