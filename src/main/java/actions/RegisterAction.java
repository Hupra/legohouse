package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.LogicFacade;
import logic.User;

public class RegisterAction extends Action {

    @Override
    public String getView(HttpServletRequest request, HttpServletResponse response) throws UserException {

        String name = request.getParameter("name");
        String pw1 = request.getParameter("pw");
        String pw2 = request.getParameter("pw2");

        if (pw1.equals(pw2) && !pw1.equals("") && !name.equals("")) {

            User user = LogicFacade.registerUser(name, pw1);

            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());

            return "buildPage";

        } else {
            throw new UserException("Passwords don't match");
        }
    }
}
