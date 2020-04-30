package rest;

import data.ToDoDAO;
import data.ToDoElem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
    public String addToDo(@FormParam("inputId") String idString, @FormParam("inputString") String input)
    {
        int id = Integer.parseInt(idString);

        ToDoElem ingredient = new ToDoElem(id, input);
        ToDoDAO.getInstance().addElement(ingredient);

        return ToDoDAO.getInstance().getListAsString();
    }

    @POST
    @Path("query")
    /*Variablerne tages fra URL'en
     * Eksempel på HTTP kald: POST localhost:8080/Lektion10/rest/ingredient/query?id=4&name=sukker&amount=45 */
    public String addIngredientQuery(@QueryParam("id") String id, @QueryParam("name") String name) {
        ToDoElem todo = new ToDoElem(Integer.parseInt(id), name);
        ToDoDAO.getInstance().addElement(todo);

        return "Ingredient added";
    }

    @POST
    @Path("{id}/{name}")
    /*Variablerne tages fra URL'en
     * Eksempel på HTTP kald: POST localhost:8080/Lektion10/rest/ingredient/4/sukker/45 */
    public String addIngredientPath(@PathParam("id") String id, @PathParam("name") String name) {
        ToDoElem todo = new ToDoElem(Integer.parseInt(id), name);
        ToDoDAO.getInstance().addElement(todo);

        return "Ingredient added";
    }

}
