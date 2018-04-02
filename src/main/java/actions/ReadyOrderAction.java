
package actions;

import data.OrderMapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadyOrderAction extends Action {

    public ReadyOrderAction() {
    }

    @Override
    public String getView(HttpServletRequest request, HttpServletResponse response) throws UserException {
        
        
        OrderMapper.setReady(Integer.parseInt(request.getParameter("id")));
        return "adminPage";
        
        
    }

}
