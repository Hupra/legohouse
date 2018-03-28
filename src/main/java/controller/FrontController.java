package controller;

import actions.Action;
import actions.UserException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilities.UrlControl;

/**
 *
 * @author Hupra Laptop
 */
@WebServlet(name = "Home", urlPatterns =
{
    "/"
})
public class FrontController extends HttpServlet
{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        UrlControl urlController = new UrlControl(request);
      
        request.getRequestDispatcher("/WEB-INF/views/" + urlController.getPage() + ".jsp").forward(request, response);
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //doPost(request, response);
        //processRequest(request, response);
        
        UrlControl urlController = new UrlControl(request);
        
        if(urlController.hasParams()){
            
            try
            {
                // get desired action from urlController -> becuase we have params we know we need an action
                Action action = urlController.getAction();

                // execute action to get the view
                String view = action.getView(request, response);
                request.setAttribute("test", "VI ER PÅ GET!");

                // load page from view
                request.getRequestDispatcher("/WEB-INF/views/" + view + ".jsp").forward(request, response);
            } catch (UserException ex)
            {
                request.setAttribute("test", ex.getMessage());
                processRequest(request, response);
            }
            
        }else{
            request.setAttribute("test", "der blevqwe ");
            request.getRequestDispatcher("/WEB-INF/views/" + urlController.getPage() + ".jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            // get desired action from request (get or post)
            Action action = Action.getAction(request);
            
            // execute action to get the view
            String view = action.getView(request, response);
            request.setAttribute("test", "PostMalonie!");
            
            // load page from view
            request.getRequestDispatcher("/WEB-INF/views/" + view + ".jsp").forward(request, response);
        } catch (UserException ex)
        {
            request.setAttribute("test", ex.getMessage());
            processRequest(request, response);
        }
        
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
