/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.LogicFacade;
import logic.User;



public class LoginAction extends Action{

    @Override
    public String getView(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        
        
        String name = request.getParameter("name");
        String pw = request.getParameter("pw");
        
        User user = LogicFacade.login( name, pw );
        
        HttpSession session = request.getSession();
        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        
        return "buildPage";
        
    }


}
