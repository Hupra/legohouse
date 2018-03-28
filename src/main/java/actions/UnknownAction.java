/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UnknownAction extends Action{
    
    public String getView( HttpServletRequest request, HttpServletResponse response ) throws UserException {
        throw new UserException("Bomb has been detonated succesfully!");
    }
}
