package actions;

import data.OrderMapper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.House;
import logic.User;

public class newOrderAction extends Action {

    @Override
    public String getView(HttpServletRequest request, HttpServletResponse response) throws UserException {

        int height, width, depth;
        try {

            height = Integer.parseInt(request.getParameter("height"));
            width = Integer.parseInt(request.getParameter("width"));
            depth = Integer.parseInt(request.getParameter("depth"));

        } catch (NumberFormatException e) {
            throw new UserException("Those are not real numbers!");
        }

        //build house
        House h = new House();
        h.build(width, height, depth);

        //get user
        HttpSession session = request.getSession();
        User u = (User)session.getAttribute("user");
        
        int orderId = OrderMapper.newOrder(h, u);
      
        String redirectTo = "redirect";
        
        return redirectTo + "test/" + Integer.toString(orderId);
    }

}
