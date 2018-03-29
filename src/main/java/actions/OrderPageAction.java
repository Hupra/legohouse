
package actions;

import data.OrderMapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilities.Render;
import utilities.UrlControl;

public class OrderPageAction extends Action{

    @Override
    public String getView(HttpServletRequest request, HttpServletResponse response) throws UserException {
        
        
        try {
            
            UrlControl urlc = new UrlControl(request);
            int orderId = Integer.parseInt(urlc.getParam(1));
            
            request.setAttribute("orderDetails", Render.orderDetails(OrderMapper.getOrder(orderId)));
            
            return "orderFromId";
            
        } catch (Exception e) {
            request.setAttribute("test", e.getMessage());
            return "index";
        }
        
        
        
        
        
        
    }

}
