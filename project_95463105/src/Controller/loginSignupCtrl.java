/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import view.AdminControlPanel;
import view.EmployeeControllPanel;
import view.UserHome;
import view.UserSignup;
import Model.Employee;
import Model.Passenger;

/**
 *
 * @author Mohammad Reza
 */
public class loginSignupCtrl {
    Employee e = new Employee();
    Passenger p = new Passenger();
    Connection con=null;
    Statement stat = null;
    ResultSet rs = null;
    
    public void infoMessage(String message, String tittle)
    {
        JOptionPane.showMessageDialog(null, message, tittle, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void AdminloginCtrl(JTextField jTextField1, JPasswordField jPasswordField1)
    {
        e.setUsername(jTextField1.getText());
        e.setPassword(jPasswordField1.getText());

        if (jTextField1.getText().equals("Admin") &&
                jPasswordField1.getText().equals("1376")) {
            infoMessage("Welcome ADMIN...", "");
            AdminControlPanel ah = new AdminControlPanel();
            ah.setVisible(true);
        }
        else if(jTextField1.getText().equals("") &&
                jPasswordField1.getText().equals("") || (jTextField1.getText().equals("") || jPasswordField1.getText().equals("")))
            JOptionPane.showMessageDialog(null, "Please Enter user & pass!");
        
            else 
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    String databaseURL = "jdbc:mysql://localhost:3306/95463105";
                    con = DriverManager.getConnection(databaseURL, "root", "");
                    String selectQuery = "select * from employee_details where username='"+e.getUsername()+"' and password ='"+e.getPassword()+"'";
                    stat = (Statement) con.createStatement();
                    rs = stat.executeQuery(selectQuery);
                    while (rs.next()==true) {
                        infoMessage("Welcome Employee...", "");
                        EmployeeControllPanel ec = new EmployeeControllPanel();
                        ec.setVisible(true);
                    }
                    
                }   catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(loginSignupCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    
    public void loginCtrl(JTextField jTextField1, JPasswordField jPasswordField1)
    {
        p.setUsername(jTextField1.getText());
        p.setPassword(jPasswordField1.getText());
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/95463105";
            con = DriverManager.getConnection(databaseURL, "root", "");
            String selectQuery = "select * from user_details where username='"+p.getUsername()+"' and password ='"+p.getPassword()+"'";
            stat = (Statement) con.createStatement();
            rs = stat.executeQuery(selectQuery);
            if (rs.next()) {
               infoMessage("Welcome...", "");
               UserHome h = new UserHome(p.getUsername());
               h.setLocationRelativeTo(null); 
               h.setVisible(true);
            }
            else
            {
            
              infoMessage(" username incorrect!"+"/n"+"Please Create New Account...", "");
              //dispose();
              UserSignup s = new UserSignup();
              s.setLocationRelativeTo(null);
              s.setVisible(true);
            }
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        //return p;
    }
    
    public void signup(JTextField idnumberTF,JTextField firstnameTF, JTextField lastnameTF, JTextField usernameTF, JPasswordField passwordPF,
    JTextField emailTF, JTextField weburlTF) 
    {
        p.setIdnumber(idnumberTF.getText());
        p.setFirstname(firstnameTF.getText());
        p.setLastname(lastnameTF.getText());
        p.setUsername(usernameTF.getText());
        p.setPassword(passwordPF.getText());
        p.setEmail_id(emailTF.getText());
        p.setWeb_url(weburlTF.getText());
        
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/95463105";
            con = DriverManager.getConnection(databaseURL, "root", "");
            stat = (Statement) con.createStatement();
            String selectQuery = "select * from user_details where username='"+p.getUsername()+"'";
            rs = stat.executeQuery(selectQuery);
            if (rs.next()==true) {
               infoMessage("Already Registered.", "Welcome");
            }
            else
            {
              String insertQuery = "insert into user_details values('"+p.getIdnumber()+"','"+p.getFirstname()+"','"+p.getLastname()+"','"+p.getUsername()+"','"+p.getPassword()+"','"+p.getEmail_id()+"','"+p.getWeb_url()+"')";
            
              stat.execute(insertQuery); 
              infoMessage("Information is Inserted", "Welcome");
            }
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        finally{
                try{
                rs.close();
                stat.close();
                con.close();
                }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    }
}
