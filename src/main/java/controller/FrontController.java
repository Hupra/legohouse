package controller;

import actions.Action;
import actions.UserException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utilities.UrlControl;

/**
 *
 * @author Hupra Laptop
 */
@WebServlet(name = "Home", urlPatterns
        = {
            "/"
        })
public class FrontController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UrlControl urlController = new UrlControl(request);

        request.getRequestDispatcher("/WEB-INF/views/" + urlController.getPage() + ".jsp").forward(request, response);

    }
    
    
    public void prepareSite(HttpServletRequest request){
        
        request.setAttribute("baseUrl", request.getContextPath() +"/");
        request.setAttribute("fullUrl", request.getRequestURL());
        
        UrlControl urlController = new UrlControl(request);
        
        try {
            request.setAttribute("content", urlController.getContent());
        } catch (Exception ex) {
            request.setAttribute("test", ex.getMessage());
        }

        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        prepareSite(request);

        UrlControl urlController = new UrlControl(request);

        if (urlController.hasParams()) {

            try {
                // get desired action from urlController -> becuase we have params we know we need an action
                Action action = urlController.getAction();

                // execute action to get the view
                String view = action.getView(request, response);

                //check if redirect
                if (view.contains("redirect")) {

                    response.sendRedirect(request.getContextPath() + "/" + view.substring(8));

                } // load page from view
                else {

                    request.getRequestDispatcher("/WEB-INF/views/" + view + ".jsp").forward(request, response);
                }

            } catch (UserException ex) {
                request.setAttribute("test", ex.getMessage());
                processRequest(request, response);
            }

        } else {
            //request.setAttribute("test", "der blevqwe ");
            request.getRequestDispatcher("/WEB-INF/views/" + urlController.getPage() + ".jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        prepareSite(request);
        
        
        
        try {
            // get desired action from request (get or post)
            Action action = Action.getAction(request);

            // execute action to get the view
            String view = action.getView(request, response);
            request.setAttribute("test", "PostMalonie!");

            //check if redirect
            if (view.contains("redirect")) {

                response.sendRedirect(request.getContextPath() + "/" + view.substring(8));

            } // load page from view
            else {

                request.getRequestDispatcher("/WEB-INF/views/" + view + ".jsp").forward(request, response);
            }

        } catch (UserException ex) {
            request.setAttribute("test", ex.getMessage());
            processRequest(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
