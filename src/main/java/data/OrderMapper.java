
package data;
import actions.UserException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import logic.House;
import logic.Order;
import logic.User;


public class OrderMapper {

    public static int newOrder(House h, User u) throws UserException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO orders (height, width, depth, users_id) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, h.getHeight());
            ps.setInt(2, h.getWidth());
            ps.setInt(3, h.getDepth());
            ps.setInt(4, u.getId());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            
            return id;

        } catch (SQLException | ClassNotFoundException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public static ArrayList<Order> getOrders(int id) throws UserException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT * FROM orders WHERE users_id = ?";

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            
            ArrayList<Order> orders = new ArrayList<>();
            
            boolean ready = false;
            
            while(rs.next()){
                
                if(rs.getInt("ready") == 1){
                    ready = true;
                }else{
                    ready = false;
                }
                
                orders.add(new Order(rs.getInt("id"), rs.getInt("height"), rs.getInt("width"), rs.getInt("depth"), ready));
                
            }
            
            return orders;

        } catch (SQLException | ClassNotFoundException ex) {
            throw new UserException(ex.getMessage());
        }
    }
    
    public static Order getOrder(int id) throws UserException {

        try {
            Connection con = DBConnector.connection();
            
            String SQL = "SELECT * FROM orders WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();
            
            boolean ready = false;
            
            if(rs.getInt("ready") == 1){
                    ready = true;
            }else{
                ready = false;
            }
            
            return new Order(rs.getInt("id"), rs.getInt("height"), rs.getInt("width"), rs.getInt("depth"), ready);
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }
    
}
