package dao;

import java.sql.*;

/**
 *
 * @author silviacb
 */
public class ConnectionFactory {
    public Connection getConnection() throws ClassNotFoundException, SQLException{
           Class.forName("com.mysql.jdbc.Driver");
           String urlBD="jdbc:mysql://localhost:3306/bd";
           return DriverManager.getConnection(urlBD, "root", "");
    }
}
