package utilities;

import java.util.ArrayList;
import logic.House;
import logic.Order;

public class Render {
    

    public static String errorFormMessage(String msg) {

        StringBuilder sb = new StringBuilder();

        sb.append("<div class='form-row mb-2'>");
        sb.append("<div class='col-12 form-error mb-1'>");
        sb.append(msg);
        sb.append("</div>");
        sb.append("</div>");

        return sb.toString();
    }
    
    
    public static String houseDetails(int height, int width, int depth) {
        return height + " : " + width + " : " +  depth;
    }

    public static String generateOrders(ArrayList<Order> orders) {
        
        StringBuilder sb = new StringBuilder();
        
        
        for(Order o : orders){
            
            sb.append("<tr>");
            
            sb.append("<td>" + o.getId() + "</td>");
            sb.append("<td>" + o.getHeight()+ "</td>");
            sb.append("<td>" + o.getWidth() + "</td>");
            sb.append("<td>" + o.getDepth() + "</td>");
            sb.append("<td>" + o.isReady() + "</td>");
            sb.append("<td><a href='order/" + o.getId() + "'>CLICK</a></td>");
            
            sb.append("</tr>");
        }
        
       return sb.toString();
    }
    
    public static String orderDetails(Order o) {
        
        House h = new House();
        h.build(o.getWidth(), o.getHeight(), o.getDepth());
        
        return h.render();
    }
    
    
    public static String generateOrdersWithButtons(ArrayList<Order> orders) {
        
        StringBuilder sb = new StringBuilder();
        
        
        for(Order o : orders){
            
            sb.append("<tr>");
            
            sb.append("<td>" + o.getId() + "</td>");
            sb.append("<td>" + o.getHeight()+ "</td>");
            sb.append("<td>" + o.getWidth() + "</td>");
            sb.append("<td>" + o.getDepth() + "</td>");
            sb.append("<td>" + o.isReady() + "</td>");
            
            
            sb.append("<td>");
            if(!o.isReady()){
                
                Form form = new Form();
                form.addHidden("action", "readyOrder");
                form.addHidden("id", ""+o.getId());
                form.addButton("Ready!");
                
                sb.append(form.getForm());
                
            }
            
            
            sb.append("</td>");
                
            sb.append("</tr>");
        }
        
       return sb.toString();
    }
    

}