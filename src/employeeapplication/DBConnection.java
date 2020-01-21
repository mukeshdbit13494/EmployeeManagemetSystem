/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeapplication;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class DBConnection {
    public static java.sql.Connection getConnection()
    { 
        java.sql.Connection con=null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/empdb","root","mukesh@123");
        } catch(SQLException e)
        {
            LogFile.logger().log(Level.SEVERE, null, e);
        }
        catch (ClassNotFoundException ex) {
            LogFile.logger().log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
