/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeapplication;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mariadb.jdbc.CallableProcedureStatement;

/**
 *
 * @author user
 */
public class EmployeeModule {
        
    public static void  addEmp(){
        String fname=null;
        String  lname=null;
        String dob=null;
        String email=null;
        int deprtment_id=0;
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.print("Enter First name      ");
            fname=sc.nextLine();
            if(fname.matches("[a-zA-Z]+\\.?"))
            {
                break;
            }
            else{
                fname=null;
                 System.err.println("Please Enter correct format Ex. Naredra");
                continue;
            }
        }
        while(true)
        {
             System.out.print("Enter Last name       ");
             lname=sc.nextLine();
            if(lname.matches("[a-zA-Z]+\\.?"))
            {
                break;
            }
            else{
                lname=null;
                 System.err.println("Please Enter correct format Ex. Naredra");
                continue;
            }
        }
        while(true)
        {
           
             System.out.print("Enter DOB(yyyy/mm/dd) ");
             dob=sc.nextLine();
            if(dob.matches("([0-9]{4})/([0-9]{2})/([0-9]{2})"))
            {
                break;
            }
            else{
                dob=null;
                 System.err.println("Please Enter correct format Ex. yyyy/mm/dd");
                continue;
            }
        }
          

        while(true)
        {
            try{
            System.out.print("Enter Email           ");
            email=sc.nextLine();
            if(email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"))
            {
                break;
            }
            else{
                email=null;
                 System.err.println("Please Enter correct format Ex. Abc123@gmail.com");
                continue;
            }
            }
            catch(Exception e)
            {
                System.err.println(e);
            }
        }
        while(true)
        {
           System.out.print("Enter department id   ");
           String no=sc.nextLine();
            if(no.matches("^[0-9]*"))
            {
                deprtment_id=Integer.parseInt(no);
                break;
            }
            else{
                deprtment_id=0;
                 System.err.println("Please Enter correct format Ex. 100");
                continue;
            }
        }
        PreparedStatement st;
        try {
            st = DBConnection.getConnection().prepareCall("Call addEmp_sp(?,?,?,?,?)");
            st.setString(1,fname);
            st.setString(2,lname);
            st.setString(3,dob);
            st.setString(4,email);
            st.setInt(5,deprtment_id);
           if(st.execute())
           {
               System.out.println("Data sucessful inserted!");
           }
           else{
               System.out.println("Data sucessful inserted!");
           } 
        } catch (SQLException ex) {
           LogFile.logger().log(Level.SEVERE, null, ex);
        }
        
}
    public static void deleteEmp()
    {
        int id=0;
        while(true)
        {
           System.out.print("Enter Employee id   ");
           String no=new Scanner(System.in).nextLine();
            if(no.matches("^[0-9]*"))
            {
                id=Integer.parseInt(no);
                break;
            }
            else{
                 no=null;
                 System.err.println("Please Enter correct format Ex. 100");
                continue;
            }
        }
        try {
            PreparedStatement st=DBConnection.getConnection().prepareStatement("Delete from login_master where userid=?");
            st.setInt(1, id);
            st.execute();
            PreparedStatement st2=DBConnection.getConnection().prepareStatement("Delete from employees where empid=?");
            st2.setInt(1, id);
            st2.execute();
            System.out.println("Data successfully deleted!");
        } catch (SQLException ex) {
            LogFile.logger().log(Level.SEVERE, null, ex);
        }
    }
    
    public static void viewEmp()
    {
        try {
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.format("%-12s","EmpId");
            System.out.format("%-20s","First_Name");
            System.out.format("%-20s","Last_Name");
            System.out.format("%-12s","DoB");
            System.out.format("%-100s","Email");
            System.out.println("");
            System.out.println("-------------------------------------------------------------------------------------------------");
            PreparedStatement pst = (CallableProcedureStatement)DBConnection.getConnection().prepareCall("Call getAllEmp_sp()");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
                System.out.format("%-12d",rs.getInt("empid"));
                System.out.format("%-20s",rs.getString("firstname"));
                System.out.format("%-20s",rs.getString("lastname"));
                System.out.format("%-12s",rs.getString("dob"));
                System.out.format("%-100s",rs.getString("email"));
                System.out.println("");
                
            }
            System.out.println("-------------------------------------------------------------------------------------------------");
        } catch (SQLException ex) {
           LogFile.logger().log(Level.SEVERE, null, ex);
        }
    }
    public static void searchEmp() 
    {
        int id=0;
        while(true)
        {
           System.out.print("Enter Employee id   ");
           String no=new Scanner(System.in).nextLine();
            if(no.matches("^[0-9]*"))
            {
                id=Integer.parseInt(no);
                break;
            }
            else{
                 no=null;
                 System.err.println("Please Enter correct format Ex. 100");
                continue;
            }
        }
        try {
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.format("%-12s","EmpId");
            System.out.format("%-20s","First_Name");
            System.out.format("%-20s","Last_Name");
            System.out.format("%-12s","DoB");
            System.out.format("%-100s","Email");
            System.out.println("");
            System.out.println("-------------------------------------------------------------------------------------------------");
            PreparedStatement pst =DBConnection.getConnection().prepareStatement("select * from employees where empid="+id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
                System.out.format("%-12d",rs.getInt("empid"));
                System.out.format("%-20s",rs.getString("firstname"));
                System.out.format("%-20s",rs.getString("lastname"));
                System.out.format("%-12s",rs.getString("dob"));
                System.out.format("%-100s",rs.getString("email"));
                System.out.println("");
                
            }
            System.out.println("-------------------------------------------------------------------------------------------------");
        } catch (SQLException ex) {
            LogFile.logger().log(Level.SEVERE, null, ex);
        }
    }
     public static void searchEmp(int id) 
    {
        try {
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.format("%-12s","EmpId");
            System.out.format("%-20s","First_Name");
            System.out.format("%-20s","Last_Name");
            System.out.format("%-12s","DoB");
            System.out.format("%-100s","Email");
            System.out.println("");
            System.out.println("-------------------------------------------------------------------------------------------------");
            PreparedStatement pst =DBConnection.getConnection().prepareStatement("select * from employees where empid="+id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
                System.out.format("%-12d",rs.getInt("empid"));
                System.out.format("%-20s",rs.getString("firstname"));
                System.out.format("%-20s",rs.getString("lastname"));
                System.out.format("%-12s",rs.getString("dob"));
                System.out.format("%-100s",rs.getString("email"));
                System.out.println("");
                
            }
            System.out.println("-------------------------------------------------------------------------------------------------");
        } catch (SQLException ex) {
            LogFile.logger().log(Level.SEVERE, null, ex);
        }
    }
    public static void updateEmp()
    {
        String fname=null;
        String  lname=null;
        String dob=null;
        String email=null;
        int department_id=0;
        int id=0;
        while(true)
        {
           System.out.print("Enter Employee id   ");
           String no=new Scanner(System.in).nextLine();
            if(no.matches("^[0-9]*"))
            {
                id=Integer.parseInt(no);
                break;
            }
            else{
                 no=null;
                 System.err.println("Please Enter correct format Ex. 100");
                continue;
            }
        }
        try {
            Statement st=DBConnection.getConnection().createStatement();
            ResultSet rs=st.executeQuery("Select * from employees where empid="+id);
            while(rs.next())
            {
                fname=rs.getString("firstname");
                lname=rs.getString("lastname");
                dob=rs.getString("dob");
                email=rs.getString("email");
                department_id=rs.getInt("department_id");
            }
            System.out.println("Enter which fields you want to update");
            System.out.println("1. First name");
            System.out.println("2. Last name");
            System.out.println("3. DOB");
            System.out.println("4. Email");
            System.out.println("5. Department Id");
            System.out.println("6. Update");
            Scanner sc=new Scanner(System.in);
            int key=0;
            while(key!=6)
            {
                System.out.print("Enter Key  ");
                key=Integer.parseInt(sc.nextLine());
                switch(key)
                {
                    case 1:
                        while(true)
                        {
                            System.out.print("Enter First name      ");
                            String tfname=sc.nextLine();
                            if(fname.matches("[a-zA-Z]+\\.?"))
                            {
                                fname=tfname;
                                break;
                            }
                            else{
                                tfname=null;
                                System.err.println("Please Enter correct format Ex. Naredra");
                                continue;
                            }
                        }break;
                    case 2:
                        while(true)
                        {
                            System.out.print("Enter Last name       ");
                            String tlname=sc.nextLine();
                            if(lname.matches("[a-zA-Z]+\\.?"))
                            {
                                lname=tlname;
                                break;
                            }
                            else{
                                tlname=null;
                                System.err.println("Please Enter correct format Ex. Naredra");
                                continue;
                            }
                        }break;
                    case 3:
                        while(true)
                        {
                            
                            System.out.print("Enter DOB(yyyy/mm/dd) ");
                            String tdob=sc.nextLine();
                            if(tdob.matches("([0-9]{4})/([0-9]{2})/([0-9]{2})"))
                            {
                                dob=tdob;
                                break;
                            }
                            else{
                                tdob=null;
                                System.err.println("Please Enter correct format Ex. yyyy/mm/dd");
                                continue;
                            }
                        }break;
                    case 4:
                        while(true)
                        {
                            try{
                                System.out.print("Enter Email           ");
                                String temail=sc.nextLine();
                                if(temail.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"))
                                {
                                    email=temail;
                                    break;
                                }
                                else{
                                    temail=null;
                                    System.err.println("Please Enter correct format Ex. Abc123@gmail.com");
                                    continue;
                                }
                            }
                            catch(Exception e)
                            {
                                System.err.println(e);
                            }
                        }break;
                    case 5:
                        while(true)
                        {
                            System.out.print("Enter department id   ");
                            String no=sc.nextLine();
                            if(no.matches("^[0-9]*"))
                            {
                                department_id=Integer.parseInt(no);
                                break;
                            }
                            else{
                                no=null;
                                System.err.println("Please Enter correct format Ex. 100");
                                continue;
                            }
                        }
                        break;
                    case 6:
                        try{
                            Statement st2=DBConnection.getConnection().createStatement();
                            String sql="Update  employees set firstname='"+fname+"', lastname='"+lname+"', dob='"+dob+"',email='"+email+"', department_id="+department_id+" where empid="+id;
                            if(st2.executeUpdate(sql)>0)
                            {
                                System.out.println("Update Successfully");
                                break;
                            }
                            else{
                                System.out.println("Not upadate data please try again.");
                                break;
                            }
                            
                        }
                        catch(Exception e){
                            System.out.println(e);
                        }
                        
                    default :
                        System.err.println("Please enter correct choice  ");
                }
            }
        } catch (SQLException ex) {
            LogFile.logger().log(Level.SEVERE, null, ex);
        } 
    }
    public static String getUserName(int id)
    {
        String name=null;
        try {
            Statement st=DBConnection.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from employees where empid="+id);
            while(rs.next())
            {
                name=rs.getString("firstname").toUpperCase()+" "+rs.getString("lastname").toUpperCase();
            }
        } catch (SQLException ex) {
            LogFile.logger().log(Level.SEVERE, null, ex);
        }
        return name;
    }
}
