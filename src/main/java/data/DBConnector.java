package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static final String IP = "159.89.101.186";
    private static final String PORT = "3306";
    private static final String DATABASE = "lego";
    private static final String USERNAME = "daniel";
    private static final String PASSWORD = "1234";

    private static final String URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE + "?autoReconnect=true&useSSL=false";

    
    private static Connection connection;
    
    public static void setConnection( Connection con ) {
        connection = con;
    }
    
    public static Connection connection() throws ClassNotFoundException, SQLException {
        
        if(connection == null){
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        
        return connection;
    }
}
