package za.co.mecer.DB.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_con 
{
    private Connection conn;
    final private String username = "mecer";
    final private String password = "mecer";
    
    public Database_con(){}
    
    public Connection getConn()
    {
        if (conn==null)
        {
            String url = "jdbc:mysql://localhost:3306/library?useSSL=false"; 
            try 
            {
                conn = DriverManager.getConnection(url, username, "mecer");        
            } 
            catch (SQLException ex) 
            {
                System.out.println("Error => "+ex.getMessage());
                System.exit(0);
            }
        }
        return conn;
    }
    
}
