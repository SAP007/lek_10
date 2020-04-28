package rest;

import data.ToDoDAO;
import data.ToDoElem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("hello")
public class HelloService {

    @GET
    public String getHello() {
        ToDoDAO todo = new ToDoDAO();
        todo = ToDoDAO.getInstance();
        return todo.getListAsString();

    }

    @POST
    @Path("/getfromid")
    public String getTodoFromId(@FormParam("getid") String id) {
        ToDoDAO todo = ToDoDAO.getInstance();
        for (ToDoElem elem : todo.getList()) {
            if (elem.getId() == Integer.parseInt(id)) {
                return elem.toString();
            }
        }
        return "Element with id: " + id + "does not exist";
    }


    @POST
    @Path("/form")
    public String addToDo(@FormParam("inputString") String input, @FormParam("inputId") String idString)
    {
        int id = Integer.parseInt(idString);

        ToDoElem ingredient = new ToDoElem(id, input);
        ToDoDAO.getInstance().addElement(ingredient);

        return ToDoDAO.getInstance().getListAsString();
    }

}
