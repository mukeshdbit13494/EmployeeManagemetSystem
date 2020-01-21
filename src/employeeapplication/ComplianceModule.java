/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeapplication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ComplianceModule {
    public static void addCompliance()
    {
        String rltype=null;
        String rl=null;
        int id=0;
        Scanner sc=new Scanner(System.in);
        while(true)
        {
           System.out.print("Enter depatrment id to compliance : ");
           String tid=sc.nextLine();
            if(tid.matches("^[0-9]*"))
            {
                id=Integer.parseInt(tid);
                break;
            }
            else{
                tid=null;
                System.err.println("Please Enter valid id  ");
                continue;
            }
        }    
        while(true)
        {
           System.out.print("Enter Regulations Type              ");
           String trlType=sc.nextLine();
            if(trlType.length()<=15)
            {
               rltype=trlType;
                break;
            }
            else{
                trlType=null;
                System.err.println("Please Enter less than 15 characters ");
                continue;
            }
        }   
        while(true)
        {
            System.out.print("Enter Regulations/Legislation       ");
            String trl=sc.nextLine();
            if(trl.length()<=250)
            {
                rl=trl;
                break;
            }
            else{
                trl=null;
                System.err.println("Please Enter less than 250 characters ");
                continue;
            }
        }   
        
        try {
            PreparedStatement st=DBConnection.getConnection().prepareStatement("insert into compliance values(NEXT VALUE FOR compliance_seq,?,?,NOW(),?)");
            st.setString(1, rltype);
            st.setString(2, rl);
            st.setInt(3, id);
            if(st.executeUpdate()>0)
            {
                System.out.println("Compliance successfully created for department id "+id);
            }
            else{
                System.err.println("OOP's something is wrong please try again.");
            }
        } catch (SQLException ex) {
            LogFile.logger().log(Level.SEVERE, null, ex);
        }
    }
    public static void viewRl(Session sess)
    {
        int id=Integer.parseInt(sess.getId());
        int deprt_id=0;
        try {
//            Statement st1=DBConnection.getConnection().createStatement();
            Statement st=DBConnection.getConnection().createStatement();
            ResultSet rs1=st.executeQuery("Select department_id from employees where empid="+id);
            if(rs1.next())
            {
                deprt_id=rs1.getInt("department_id");
            }
            ResultSet rs=st.executeQuery("Select * from compliance where department_id="+(deprt_id));
            if(rs!=null)
            {
                System.out.println("-------------------------------------------------------------------------------------------------");
                System.out.format("%-12s","Comp_Id");
                System.out.format("%-17s","RL_Types");
                System.out.format("%-12s","CreateDate");
                System.out.format("%-257s","Details");
                System.out.println("");
                System.out.println("-------------------------------------------------------------------------------------------------");
                while(rs.next())
                {
                    System.out.format("%-12d",rs.getInt("complianceid"));
                    System.out.format("%-17s",rs.getString("rlType"));
                    System.out.format("%-12s",rs.getString("createDate"));
                    System.out.format("%-257s",rs.getString("Details"));
                    System.out.println("");
                }
                System.out.println("-------------------------------------------------------------------------------------------------");
            }
            else{
                System.err.println("OOP's No record found please try again!");
            }
        } catch (SQLException ex) {
            LogFile.logger().log(Level.SEVERE, null, ex);
        }
    }
     public static void viewAllRl()
    {
        try {
           PreparedStatement st=DBConnection.getConnection().prepareCall("call getAllRL_sp()");
            ResultSet rs=st.executeQuery();
            if(rs!=null)
            {
                System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                System.out.format("%-12s","Comp_Id");
                System.out.format("%-15s","Department_Id");
                System.out.format("%-27s","Department_nm");
                System.out.format("%-17s","RL_Types");
                System.out.format("%-12s","CreateDate");
                System.out.format("%-12s","Emp_count");
                System.out.format("%-14s","Status_count");
                System.out.format("%-257s","Details");
                System.out.println("");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
                while(rs.next())
                {
                    System.out.format("%-12d",rs.getInt("complianceid"));
                    System.out.format("%-15d",rs.getInt("department_id"));
                    System.out.format("%-27s",rs.getString("department_nm"));
                    System.out.format("%-17s",rs.getString("rlType"));
                    System.out.format("%-12s",rs.getString("createDate"));
                    System.out.format("%-12d",rs.getInt("empcount"));
                    System.out.format("%-14d",rs.getInt("statuscount"));
                    System.out.format("%-257s",rs.getString("Details"));
                    System.out.println("");
                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            }
            else{
                System.err.println("OOP's No records found please try again!");
            }
           
        } catch (SQLException ex) {
            LogFile.logger().log(Level.SEVERE, null, ex);
        }
    }
}
