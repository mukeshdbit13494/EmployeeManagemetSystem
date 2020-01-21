/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeapplication;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */


public class Main {    
    public static void backBtn(Session sess){
        Scanner sc=new Scanner(System.in);
        boolean b=true;
        System.out.println("1. Home");
        System.out.println("2. Logout");
        while(b)
        {
            int choice=0;
            while(true)
            {
               System.out.print("Enter your choice  ");
               String no=sc.nextLine();
                if(no.matches("^[0-9]*"))
                {
                    choice=Integer.parseInt(no);
                    break;
                }
                else{
                    no=null;
                    System.err.println("Please Enter correct format Ex. 1,2,3..");
                    continue;
                }
            }
            switch(choice)
            {
                case 1:
                    adminHome(sess);
                    b=false;
                    break;
                case 2:
                    logout(sess);
                    b=false;
                    break;
                default:
                    System.err.println("Please enter correct choice !");
                    break;
            }
        }
    }
    public static void adminHome(Session sess){
        Scanner sc=new Scanner(System.in);
        boolean b=true;
        System.out.println("********************************************************************************");
        System.out.println("                   WELCOME TO THE EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("********************************************************************************");
        System.out.println("1. Department");
        System.out.println("2. Employee");
        System.out.println("3. Regulations");
        System.out.println("4. Statuts Report");
        System.out.println("5. Logout");
        while(b)
        {
            int choice=0;
            while(true)
            {
               System.out.print("Enter your choice  ");
               String no=sc.nextLine();
                if(no.matches("^[0-9]*"))
                {
                    choice=Integer.parseInt(no);
                    break;
                }
                else{
                    no=null;
                    System.err.println("Please Enter correct format Ex. 1,2,3..");
                    continue;
                }
            }
            switch(choice)
            {
                 case 1:
                    adminDepartment(sess);
                    b=false;
                    break;
                case 2:
                    adminEmployee(sess);
                    b=false;
                    break;
                case 3:
                    adminCompliance(sess);
                    b=false;
                    break;
                case 4:
                    adminStatus(sess);
                    b=false;
                    break;
                case 5:
                    logout(sess);
                    b=false;
                    break;
                default:
                    System.err.println("Please enter correct choice  ");
                    break;
            }
        }
    }
    public static void adminDepartment(Session sess){
         Scanner sc=new Scanner(System.in);
        boolean b=true;
        System.out.println("********************************************************************************");
        System.out.println("                      WELCOME TO THE DEPARTMENT PANEL");
        System.out.println("********************************************************************************");
        System.out.println("1. Add Department");
        System.out.println("2. View Department");
        System.out.println("3. Home");
        System.out.println("4. Logout");
        while(b)
        {
            int choice=0;
            while(true)
            {
               System.out.print("Enter your choice  ");
               String no=sc.nextLine();
                if(no.matches("^[0-9]*"))
                {
                    choice=Integer.parseInt(no);
                    break;
                }
                else{
                    no=null;
                    System.err.println("Please Enter correct format Ex. 1,2,3..");
                    continue;
                }
            }
            switch(choice)
            {
                case 1:
                    DepartmentModule.addDepartment();
                    b=false;
                    backBtn(sess);
                    break;
                case 2:
                    DepartmentModule.viewDepartment();
                    b=false;
                    backBtn(sess);
                    break;
                case 3:
                    adminHome(sess);
                    b=false;
                    break;
                case 4:
                    logout(sess);
                    b=false;
                    break;
                default:
                    System.err.println("Please enter correct choice  ");
                    break;
            }
        }
    }
    public static void adminEmployee(Session sess){
        Scanner sc=new Scanner(System.in);
        boolean b=true;
        System.out.println("********************************************************************************");
        System.out.println("                   WELCOME TO THE EMPLOYEE PANEL");
        System.out.println("********************************************************************************");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employee");
        System.out.println("3. Delete Employee");
        System.out.println("4. Update Employee");
        System.out.println("5. Search Employee");
        System.out.println("6. Home");
        System.out.println("7. Logout");
        while(b)
        {
            int choice=0;
            while(true)
            {
               System.out.print("Enter your choice  ");
               String no=sc.nextLine();
                if(no.matches("^[0-9]*"))
                {
                    choice=Integer.parseInt(no);
                    break;
                }
                else{
                    no=null;
                    System.err.println("Please Enter correct format Ex. 1,2,3..");
                    continue;
                }
            }
            switch(choice)
            {
                case 1:  
                    EmployeeModule.addEmp();
                    backBtn(sess);
                    b=false;
                    break;
                case 2:
                    EmployeeModule.viewEmp();
                    backBtn(sess);
                    b=false;
                    break;
                case 3:
                    EmployeeModule.deleteEmp();
                    backBtn(sess);
                    b=false;
                    break;
                case 4:
                    EmployeeModule.updateEmp();
                    backBtn(sess);
                    b=false;
                    break;
                case 5:
                    EmployeeModule.searchEmp();
                    backBtn(sess);
                    b=false;
                    break;
                case 6:
                    adminHome(sess);
                    b=false;
                    break;
                case 7:
                    logout(sess);
                    b=false;
                    break;
                default:
                    System.err.println("Please enter correct choice  ");
                    break;
                    
            }
        }
    }
    public static void adminCompliance(Session sess){
         Scanner sc=new Scanner(System.in);
        boolean b=true;
        System.out.println("********************************************************************************");
        System.out.println("                   WELCOME TO THE REGULATION PANEL");
        System.out.println("********************************************************************************");
        System.out.println("1. Add Regulation");
        System.out.println("2. View Regulation");
        System.out.println("3. Home");
        System.out.println("4. Logout");
        while(b)
        {
            int choice=0;
            while(true)
            {
               System.out.print("Enter your choice  ");
               String no=sc.nextLine();
                if(no.matches("^[0-9]*"))
                {
                    choice=Integer.parseInt(no);
                    break;
                }
                else{
                    no=null;
                    System.err.println("Please Enter correct format Ex. 1,2,3..");
                    continue;
                }
            }
            switch(choice)
            {
                case 1:
                    ComplianceModule.addCompliance();
                    b=false;
                    backBtn(sess);
                    break;
                case 2:
                    ComplianceModule.viewAllRl();
                    b=false;
                    backBtn(sess);
                    break;
                case 3:
                    adminHome(sess);
                    b=false;
                    break;
                case 4:
                    logout(sess);
                    b=false;
                    break;
                default:
                    System.err.println("Please enter correct choice  ");
                    break;
            }
        }
    }
    public static void adminStatus(Session sess){
         Scanner sc=new Scanner(System.in);
        boolean b=true;
        System.out.println("********************************************************************************");
        System.out.println("                   WELCOME TO THE STATUS PANEL");
        System.out.println("********************************************************************************");
        System.out.println("1. View All Status");
        System.out.println("2. Home");
        System.out.println("3. Logout");
        while(b)
        {
            int choice=0;
            while(true)
            {
               System.out.print("Enter your choice  ");
               String no=sc.nextLine();
                if(no.matches("^[0-9]*"))
                {
                    choice=Integer.parseInt(no);
                    break;
                }
                else{
                    no=null;
                    System.err.println("Please Enter correct format Ex. 1,2,3..");
                    continue;
                }
            }
            switch(choice)
            {
                case 1:
                    StatusModule.viewAllComment(sess);
                    b=false;
                    backBtn(sess);
                    break;
                case 2:
                    adminHome(sess);
                    b=false;
                    backBtn(sess);
                    break;
                case 3:
                    logout(sess);
                    b=false;
                    break;
                default:
                    System.err.println("Please enter correct choice  ");
                    break;
            }
        }
    }
    public static void userBackBtn(Session sess){
        Scanner sc=new Scanner(System.in);
        boolean b=true;
        System.out.println("1. Home");
        System.out.println("2. Logout");
        while(b)
        {
            int choice=0;
            while(true)
            {
               System.out.print("Enter your choice  ");
               String no=sc.nextLine();
                if(no.matches("^[0-9]*"))
                {
                    choice=Integer.parseInt(no);
                    break;
                }
                else{
                    no=null;
                    System.err.println("Please Enter correct format Ex. 1,2,3..");
                    continue;
                }
            }
            switch(choice)
            {
                case 1:
                    userHome(sess);
                    b=false;
                    break;
                case 2:
                    logout(sess);
                    loginPage(sess);
                    b=false;
                    break;
                default:
                    System.err.println("Please enter correct choice  ");
                    break;
            }
        }
    }
    public static void userHome(Session sess){
        if(sess.getId()==null)
        {
            System.out.println("Your are not correct user please login !");
        }
        else{
            int id=Integer.parseInt(sess.getId());
            Scanner sc=new Scanner(System.in);
            boolean b=true;
            System.out.println("******************************************************************************************");
            System.out.print("               HELLO "+EmployeeModule.getUserName(id));
            System.out.println(" WELCOME TO THE EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("******************************************************************************************");
            System.out.println("1. View Details");
            System.out.println("2. View Regulations");
            System.out.println("3. Statuts Report");
            System.out.println("4. Logout");
            while(b)
            {
                System.out.print("Enter your choice  ");
                int choice=Integer.parseInt(sc.nextLine());
                switch(choice)
                {
                     case 1:
                        EmployeeModule.searchEmp(id);
                        b=false;
                        userBackBtn(sess);
                        break;
                    case 2:
                        ComplianceModule.viewRl(sess);
                        b=false;
                        userBackBtn(sess);
                        break;
                    case 3:
                        userStatus(sess);
                        userBackBtn(sess);
                        b=false;
                        break;
                    case 4:
                        logout(sess);
                        b=false;
                        break;
                    default:
                        System.err.println("Please enter correct choice  ");
                        break;
                }
            }
        }
    }
     public static void userStatus(Session sess){
        if(sess.getId()==null)
        {
            System.out.println("Your are not correct user please login !");
        }
        else{
            int id=Integer.parseInt(sess.getId());
            Scanner sc=new Scanner(System.in);
            boolean b=true;
            System.out.println("******************************************************************************************");
            System.out.print("               HELLO "+EmployeeModule.getUserName(id));
            System.out.println(" WELCOME TO THE EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("******************************************************************************************");
            System.out.println("1. Add Comment");
            System.out.println("2. View Comment");
            System.out.println("3. Update comment");
            System.out.println("4. Home");
            System.out.println("5. Logout");
            while(b)
            {
                System.out.print("Enter your choice  ");
                int choice=Integer.parseInt(sc.nextLine());
                switch(choice)
                {
                     case 1:
                        StatusModule.addComment(sess);
                        b=false;
                        userBackBtn(sess);
                        break;
                    case 2:
                       StatusModule.viewComment(sess);
                        b=false;
                        userBackBtn(sess);
                        break;
                    case 3:
                        StatusModule.updateComment(sess);
                        b=false;
                        break;
                    case 4:
                        userHome(sess);
                        b=false;
                        break;
                    case 5:
                        logout(sess);
                        b=false;
                        break;
                    default:
                        System.err.println("Please enter correct choice  ");
                        break;
                }
            }
        }
    }
    public static void userLogin(Session sess)
    {
        Scanner sc=new Scanner(System.in);
        Console console=System.console();
        boolean b=false;
        while(!b)
        { 
            System.out.print("Enter userid:   ");
            String userid = sc.nextLine();
            System.out.print("Enter password: ");
            String password=null;
            if(console==null)
            {
                password=sc.nextLine();
            }
            else{
                char[] passwordChars=System.console().readPassword();
                password = new String(passwordChars);
            }
            
            int id=new Login().login(Integer.parseInt(userid), password, "EMPLOYEE");
            if(id==0)
            {
                continue;
            }
            else{
                b=true;
                sess.setId(String.valueOf(id));
                break;
            }
        }
        
        if(b)
        {
            userHome(sess);
        }
        else{
            userLogin(sess);
        }
    }
     public static void adminLogin(Session sess)
    {
        Scanner sc=new Scanner(System.in);
        Console console=System.console();
        boolean b=false;
        while(!b)
        { 
            System.out.print("Enter password: ");
            String password=null;
            if(console==null)
            {
                password=sc.nextLine();
            }
            else{
                char[] passwordChars=System.console().readPassword();
                password = new String(passwordChars);
            }
            
            int id=new Login().login(password);
            if(id==0)
            {
                continue;
            }
            else{
                b=true;
                sess.setId(String.valueOf(id));
                break;
            }
        }
        
        if(b)
        {
            adminHome(sess);
        }
        else{
            adminLogin(sess);
        }
    }
    public static void logout(Session sess)
    {
        sess.setId(null);
        System.out.println("Logout Successfully...");
        loginPage(sess);
    }
     public static void exit(Session sess)
    {
        try {
            Runtime.getRuntime().exec("taskkill /f /im cmd.exe") ;
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static void loginPage(Session sess){    
        Scanner sc=new Scanner(System.in);
        boolean b=true;
        while(b)
        {
            System.out.println("1. Admin");
            System.out.println("2. Employee");
            System.out.println("3. Exit");
            int choice=0;
            while(true)
            {
               System.out.print("Enter your choice  ");
               String no=sc.nextLine();
                if(no.matches("^[0-9]*"))
                {
                    choice=Integer.parseInt(no);
                    break;
                }
                else{
                    no=null;
                    System.err.println("Please Enter correct format Ex. 1,2,3..");
                    continue;
                }
            }
            switch(choice)
            {
                case 1:
                    adminLogin(sess);
                    b=false;
                    break;
                case 2:
                    userLogin(sess);
                    b=false;
                    break;
                case 3:
                    exit(sess);
                    b=false;
                    break;
                default :
                    System.err.println("Please enter correct choice !");
                    break;         
            }
        }
    }
    public static void main(String[] args){
        Session sess=new Session();
        Scanner sc=new Scanner(System.in);
        try {
            Statement st=DBConnection.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from admin");
            if(rs.next())
            {
                loginPage(sess);
            }
            else{
                String name=null;
                String pass=null;
                while(true)
                {
                     System.out.print("Enter Admin name       ");
                     name=sc.nextLine();
                    if(name.matches("[a-zA-Z]+\\.?") || name==null)
                    {
                        break;
                    }
                    else{
                        name=null;
                         System.err.println("Please Enter correct format Ex. Naredra");
                        continue;
                    }
                }
                while(true)
                {
                     System.out.print("Enter Password         ");
                     pass=sc.nextLine();
                    if(pass!=null)
                    {
                        break;
                    }
                    else{
                         System.err.println("Please Enter correct password!");
                        continue;
                    }
                }
                PreparedStatement pst=DBConnection.getConnection().prepareStatement("insert into admin values(1,?,MD5(?))");
                pst.setString(1, name);
                pst.setString(2,pass);
                if(pst.executeUpdate()>0)
                {
                    sess.setId("1");
                    adminHome(sess);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
}
