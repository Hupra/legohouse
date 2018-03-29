    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action
{

    private static HashMap<String, Action> actions;

    public static Action getAction(HttpServletRequest request)
    {
        String desiredAction = request.getParameter("action");
        if (actions == null)
        {
            generateActions();
        }
        
        return actions.getOrDefault(desiredAction, new UnknownAction());
    }

    public static Action getActionFromName(String name){
        if (actions == null)
        {
            generateActions();
        }
        
        return actions.getOrDefault(name, new UnknownAction());
    }
    
    private static void generateActions()
    {
        actions = new HashMap<>();

        actions.put("login", new LoginAction());
        actions.put("insertOrder", new newOrderAction());
        actions.put("register", new RegisterAction());
        actions.put("buildHouse", new BuildHouseAction());
        actions.put("massdestruction", new UnknownAction());
        
    }

    public abstract String getView(HttpServletRequest request, HttpServletResponse response) throws UserException;

}
