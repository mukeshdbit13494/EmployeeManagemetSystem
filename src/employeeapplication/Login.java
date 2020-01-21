
package employeeapplication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login { 
    
    public int login(int userid,String password,String role){
            try {
            String pass=Encryption.getMd5(password);
            Statement st=DBConnection.getConnection().createStatement();
            String sql="Select * from login_master where role='"+role.toUpperCase()+"'";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                if(userid==rs.getInt("userid")&&pass.equals(rs.getString("password")))
                {
                    return rs.getInt("userid");
                }
            }
           
            } catch (SQLException ex) {
                LogFile.logger().log(Level.SEVERE, null, ex);
            }
            System.err.println("Please enter correct userid and password !");
            return 0;
        
    }
    public int login(String password){
            try {
            String pass=Encryption.getMd5(password);
            Statement st=DBConnection.getConnection().createStatement();
            String sql="Select * from admin";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                if(pass.equals(rs.getString("admin_password")))
                {
                    return rs.getInt("admin_id");
                }
            }
           
            } catch (SQLException ex) {
               LogFile.logger().log(Level.SEVERE, null, ex);
            }
            System.err.println("Please enter correct password !");
            return 0;
    }
}
