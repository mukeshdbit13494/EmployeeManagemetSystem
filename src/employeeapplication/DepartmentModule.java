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

/**
 *
 * @author user
 */
public class DepartmentModule {
    public static void addDepartment()
    {
        System.out.print("Enter Department Name  ");
        String dept_name=new Scanner(System.in).nextLine();
        try{
            PreparedStatement st=DBConnection.getConnection().prepareStatement("insert into department values(NEXT VALUE FOR department_seq,?)");
            st.setString(1,dept_name);
            if(st.executeUpdate()>0)
            {
                System.out.println("New department inserted.");
            }
            else{
                System.err.println("OOP's something is wrong please try again!");
            }
        }
         catch (SQLException ex) {
            LogFile.logger().log(Level.SEVERE, null, ex);
        }
    }
    public static void viewDepartment(){
        System.out.println("-----------------------------------");
        System.out.print("Department_id  ");
        System.out.println("Department Name");
        System.out.println("-----------------------------------");
        try{
            Statement st=DBConnection.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from department");
            while(rs.next())
            {
                System.out.format("%-15d",rs.getInt("department_id"));
                System.out.format("%-25s",rs.getString("department_nm"));
                System.out.println();
            }
            System.out.println("-----------------------------------");
        }
        catch (SQLException ex) {
            LogFile.logger().log(Level.SEVERE, null, ex);
        }
    }
    public static void DeleteDepartment()
    {
        System.out.print("Enter Department id  ");
        int id=Integer.parseInt(new Scanner(System.in).nextLine());
        try{
            PreparedStatement st=DBConnection.getConnection().prepareStatement("delete from department where department_id=?");
            st.setInt(1, id);
            if(st.executeUpdate()>0)
            {
                System.out.println("1 department deleted .");
            }
            else{
                System.err.println("OOP's something is wrong please try again!");
            }
        }
         catch (SQLException ex) {
            LogFile.logger().log(Level.SEVERE, null, ex);
        }
    }
     public static void updateDepartment()
    {
        System.out.print("Enter Department id  ");
        int id=Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.print("Enter Department Name  ");
        String dept_name=new Scanner(System.in).nextLine();
        try{
            PreparedStatement st=DBConnection.getConnection().prepareStatement("update department set department_nm=? where department_id=?");
            st.setString(1,dept_name);
            st.setInt(2, id);
            if(st.executeUpdate()>0)
            {
                System.out.println("Department name updated.");
            }
            else{
                System.err.println("OOP's something is wrong please try again!");
            }
        }
         catch (SQLException ex) {
            LogFile.logger().log(Level.SEVERE, null, ex);
        }
    }
}
