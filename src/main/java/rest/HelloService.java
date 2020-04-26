package rest;

import data.ToDoDAO;
import data.ToDoElem;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("hello")
public class HelloService {

    @GET
    public String getHello() {
        return "Hello World!";
    }


    @POST
    @Path("/form")
    public String addToDo(@FormParam("inputString") String input, @FormParam("inputId") String idString)
    {
        int id = Integer.parseInt(idString);


        ToDoElem ingredient = new ToDoElem(id, input);
        ToDoDAO.getInstance().addElement(ingredient);

        return "To Do Element: " + id + ", " + input;
    }

}
