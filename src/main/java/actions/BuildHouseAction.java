
package actions;
import utilities.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.House;

public class BuildHouseAction extends Action{

    @Override
    public String getView(HttpServletRequest request, HttpServletResponse response) throws UserException {
        
        // sticky parameters in form
        
        UrlControl urlc = new UrlControl(request);
        int height, width, depth;
        
        try {
            if(urlc.hasParams() && urlc.getParamAmount() == 3){
                height = Integer.parseInt(urlc.getParam(1));
                width = Integer.parseInt(urlc.getParam(2));
                depth = Integer.parseInt(urlc.getParam(3));

            }else{
                height = Integer.parseInt(request.getParameter("height"));
                width = Integer.parseInt(request.getParameter("width"));
                depth = Integer.parseInt(request.getParameter("depth"));
            }
        } catch (NumberFormatException e) {
            throw new UserException("Those are not real numbers!");
        }
        
        
        
        request.setAttribute("height", height);
        request.setAttribute("width", width);
        request.setAttribute("depth", depth);
        
        House h = new House();
        h.build(width, height, depth);
        
        //confirm order btn
        Form form = new Form();
        form.addHidden("action", "insertOrder");
        form.addHidden("height", Integer.toString(height));
        form.addHidden("width", Integer.toString(width));
        form.addHidden("depth", Integer.toString(depth));
        form.addButton("Confirm order");
        request.setAttribute("houseConfirm", form.getForm());
        
        request.setAttribute("houseDetails", h.render());
        
        
        return "buildPage";
        
    }

}
