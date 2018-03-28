package data;

import actions.UserException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import logic.User;

public class UserMapper {

    public static User login(String name, String pw) throws UserException {

        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT id, role FROM users "
                    + "WHERE name=? AND pw=?";

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, name);
            ps.setString(2, pw);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                int id = rs.getInt("id");
                String role = rs.getString("role");

                User user = new User(name, pw, role);
                user.setId(id);

                return user;
            } else {
                throw new UserException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public static void registerUser(User user) throws UserException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO users (name, pw, role) VALUES (?, ?, ?)";
            
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPw());
            ps.setString(3, user.getRole());
            
            ps.executeUpdate();
            
            
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
            
        } catch (SQLException | ClassNotFoundException ex) {
            throw new UserException(ex.getMessage());
        }
    }

}
