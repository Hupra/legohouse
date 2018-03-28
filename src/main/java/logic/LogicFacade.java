package logic;

import actions.UserException;
import data.UserMapper;

public class LogicFacade {

    public static User login(String name, String pw) throws UserException {

        return UserMapper.login(name.toLowerCase(), pw);
    }

    public static User registerUser(String name, String pw) throws UserException {

        User user = new User(name.toLowerCase(), pw, "customer");
        UserMapper.registerUser(user);
        return user;
    }
}
