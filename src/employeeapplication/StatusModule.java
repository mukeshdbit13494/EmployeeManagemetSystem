/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeapplication;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class StatusModule {
    public static void addComment(Session sess)
    {
        try {
            System.out.print("Please Enter regulation id  ");
            int reg_id=Integer.parseInt(new Scanner(System.in).nextLine());
            System.out.println("Please write comment for regulation id "+reg_id+" -");
            String comment=new Scanner(System.in).nextLine();
            int empid=Integer.parseInt(sess.getId());
            int dept_id=0;
            Statement st=DBConnection.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select department_id from employees where empid="+empid);
            if(rs.next())
            {
                dept_id=rs.getInt("department_id");
            }
            String sql="insert into statusreport values(?,NEXT VALUE FOR statusreport_seq,?,?,NOW(),?)";
            PreparedStatement pst=DBConnection.getConnection().prepareStatement(sql);
            pst.setInt(1, reg_id);
            pst.setInt(2, empid);
            pst.setString(3, comment);
            pst.setInt(4, dept_id);
            if(pst.execute())
            {
                System.out.println("Comment Successfully saved.");
            }
            else{
                System.out.println("Something is wrong please try again!");
            }
            
        } catch (SQLException ex) {
            LogFile.logger().log(Level.SEVERE, null, ex);
        }
    }
    public static void viewComment(Session sess)
    {
        try {
            int id=Integer.parseInt(sess.getId());
            Statement st=DBConnection.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from statusreport where empid="+id);
            if(rs!=null)
            {
                System.out.println("-------------------------------------------------------------------------------------------------");
                System.out.format("%-13s","Statusrptid");
                System.out.format("%-12s","Comp_Id");
                System.out.format("%-15s","Department_Id");
                System.out.format("%-12s","CreateDate");
                System.out.format("%-257s","Comments");
                System.out.println("");
                System.out.println("-------------------------------------------------------------------------------------------------");
                while(rs.next())
                {
                    System.out.format("%-13d",rs.getInt("statusrptid"));
                    System.out.format("%-12d",rs.getInt("complianceid"));
                    System.out.format("%-15d",rs.getInt("department_id"));
                    System.out.format("%-12s",rs.getString("createDate"));
                    System.out.format("%-257s",rs.getString("comments"));
                    System.out.println("");
                }
            }
            else{
                System.err.println("OOP's No records found please try again!");
            }
        } catch (SQLException ex) {
           LogFile.logger().log(Level.SEVERE, null, ex);
        }
    }
     public static void viewAllComment(Session sess)
    {
        try {
            System.out.println("Please Enter compliance Id ");
            int id=Integer.parseInt(new Scanner(System.in).nextLine());
            Statement st=DBConnection.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from statusreport where complianceid="+id);
            if(rs!=null)
            {
                System.out.println("-------------------------------------------------------------------------------------------------");
                System.out.format("%-13s","statusrptid");
                System.out.format("%-12s","empid");
                System.out.format("%-15s","Department_Id");
                System.out.format("%-12s","CreateDate");
                System.out.format("%-257s","Comments");
                System.out.println("");
                System.out.println("-------------------------------------------------------------------------------------------------");
                while(rs.next())
                {
                    System.out.format("%-13d",rs.getInt("statusrptid"));
                    System.out.format("%-12d",rs.getInt("empid"));
                    System.out.format("%-15d",rs.getInt("department_id"));
                    System.out.format("%-12s",rs.getString("createDate"));
                    System.out.format("%-257s",rs.getString("comments"));
                    System.out.println("");
                }
                System.out.println("-------------------------------------------------------------------------------------------------");
            }
            else{
                System.err.println("OOP's No records found please try again!");
            }
        } catch (SQLException ex) {
            LogFile.logger().log(Level.SEVERE, null, ex);
        }
    }
      public static void updateComment(Session sess)
    {
        try {
            System.out.println("Please write comment -");
            String comment=new Scanner(System.in).nextLine();
            int empid=Integer.parseInt(sess.getId());
            Statement st=DBConnection.getConnection().createStatement();
            String sql="update statusreport set commentss='"+comment+"',createDate=NOW() where empid="+empid;
            if(st.executeUpdate(sql)>0)
            {
                System.out.println("Comment successfully Updated..");
            }
            else{
                System.err.println("OOP's something is wrong please try again!");
            }
        } catch (SQLException ex) {
            LogFile.logger().log(Level.SEVERE, null, ex);
        }
    }
}
