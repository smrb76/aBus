package Controller;


import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.AddEmployee;
import com.mysql.jdbc.PreparedStatement;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import view.AllTours;
import Model.Employee;
/**
 *
 * @author Mohammad Reza
 */
public class EmployeeCtrl {
    TourCtrl tc = new TourCtrl();
    Employee e = new Employee();
    PreparedStatement pst = null;
    Connection con = null;
    ResultSet rs = null;
    
    public void fillTable(JTable jTable1){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/95463105";
            con = DriverManager.getConnection(databaseURL, "root", "");
            String query = "select * from employee_details";
            pst = (PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException q){
            JOptionPane.showMessageDialog(null, q);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AllTours.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void jTable1MouseClicked(JTable jTable1,JTextField idnumberTF, JTextField firstnameTF, JTextField lastnameTF,JTextField usernameTF, JPasswordField passwordPF) {                                     
         try {
             
            int row = jTable1.getSelectedRow();
            String Table_click = (jTable1.getModel().getValueAt(row, 0).toString());
            String query = "select * from employee_details where idnumber= '"+Table_click+"'";
            pst = (PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                String add4 = rs.getString("idnumber");
                idnumberTF.setText(add4);
                String add5 = rs.getString("firstname");
                firstnameTF.setText(add5);
                String add6 = rs.getString("lastname");
                lastnameTF.setText(add6);
                String add7 = rs.getString("username");
                usernameTF.setText(add7);
                String add8 = rs.getString("password");
                passwordPF.setText(add8);
            }
            
        } catch (SQLException w) {
            JOptionPane.showMessageDialog(null, w);
    }                                    
    }


    
    public void addEmployee(JTextField idnumberTF, JTextField firstnameTF2, JTextField lastnameTF,JTextField usernameTF, JPasswordField passwordPF)
    {
        e.setIdnumber(idnumberTF.getText());
        e.setFirstname(firstnameTF2.getText());
        e.setLastname(lastnameTF.getText());
        e.setUsername(usernameTF.getText());
        e.setPassword(passwordPF.getText());
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/95463105";
            con = DriverManager.getConnection(databaseURL, "root", "");
            Statement stat = (Statement) con.createStatement();
            String selectQuery = "select * from employee_details where username='"+e.getUsername()+"' and password ='"+e.getPassword()+"'";
            rs = stat.executeQuery(selectQuery);
            if (rs.next()==true) {
               tc.infoMessage("Already Registered.", "Welcome");
            }
            else
            {
              String insertQuery = "insert into employee_details values('"+e.getIdnumber()+"','"+e.getFirstname()+"','"+e.getLastname()+"','"+e.getUsername()+"','"+e.getPassword()+"')";
            
              stat.execute(insertQuery); 
              tc.infoMessage("Information is Inserted", "Welcome");
        }} catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteEmployee(JTable jTable1, JTextField idnumberTF){
         try {
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/95463105";
            con = DriverManager.getConnection(databaseURL, "root", "");
             try (java.sql.Statement st = con.createStatement()) {
                 st.execute("DELETE FROM employee_details WHERE idnumber="+idnumberTF.getText());
                 JOptionPane.showMessageDialog(null, "Employee Deleted!");
                 jTable1.createDefaultColumnsFromModel();
             }
        } catch (ClassNotFoundException | SQLException t) {
                JOptionPane.showMessageDialog(null, t);
        }
         
    }
    
    public void editEmployee(JTextField idnumberTF, JTextField firstnameTF, JTextField lastnameTF,JTextField usernameTF, JPasswordField passwordPF)
    {
        try{
            String query = "update employee_details set idnumber=?,firstname=?,lastname=?,username=?,password=? where idnumber= '"+idnumberTF.getText()+"'";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, idnumberTF.getText());
            pst.setString(2, firstnameTF.getText());
            pst.setString(3, lastnameTF.getText());
            pst.setString(4, usernameTF.getText());
            pst.setString(5, passwordPF.getText());
            pst.executeUpdate();
            }
            catch(SQLException f){
                JOptionPane.showMessageDialog(null, f);
            }
            finally{
                try{
                rs.close();
                pst.close();
                con.close();
                
                }catch(SQLException g){
            JOptionPane.showMessageDialog(null, g);
        }
    }
    }
}
