/*
 * To change null license header, choose License Headers in Project Properties.
 * To change null template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Passenger;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;
import view.AllTours;
import javax.swing.JTable;
import Model.TourDetails;
import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import net.proteanit.sql.DbUtils;
import view.UserLogin;

/**
 *
 * @author Mohammad Reza
 */
public class TourCtrl {
    TourDetails td = new TourDetails();
    Passenger p = new Passenger();
    UserLogin ul = new UserLogin();
    PreparedStatement pst = null;
    PreparedStatement pst1 = null;
    Connection con = null;
    ResultSet rs = null;
    Calendar cal = new GregorianCalendar();
    
    // Variables declaration - do not modify
    public List<Model.TourDetails> tourDetailsList;
    public Query tourDetailsQuery;
    
    public void currentDate(JLabel labelDate, JLabel labelTime){
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        labelDate.setText(day+"/"+(month+1)+"/"+year);
        labelDate.setForeground(Color.blue);
        
        int second = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
        labelTime.setText(hour+":"+minute+":"+second);
        labelTime.setForeground(Color.red);
    }
    
     public void infoMessage(String message, String tittle){
        JOptionPane.showMessageDialog(null, message, tittle, JOptionPane.INFORMATION_MESSAGE);
    }
     
     public void fillTable(JTable jTable1){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/95463105";
            con = DriverManager.getConnection(databaseURL, "root", "");
            String query = "select * from tour_details";
            pst = (PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AllTours.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     
     public void jTable1MouseClicked(JTable jTable1,JTextField Id_TF1,JTextField bus_noTF,JTextField bus_sourceTF,JTextField bus_destTF,
            JTextField deratTimeTF, JTextField priceTF, JTextField seatTF, JTextField cor_TF, JTextField requestTF)
     {
         try {
            int row = jTable1.getSelectedRow();
            String Table_click = (jTable1.getModel().getValueAt(row, 0).toString());
            String query = "select * from tour_details where id= '"+Table_click+"' ";
            pst = (PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                String add1 = rs.getString("id");
                Id_TF1.setText(add1);
                String add2 = rs.getString("bus_no");
                bus_noTF.setText(add2);
                String add4 = rs.getString("bus_source");
                bus_sourceTF.setText(add4);
                String add5 = rs.getString("bus_dest");
                bus_destTF.setText(add5);
                String add6 = rs.getString("depart_time");
                deratTimeTF.setText(add6);
                String add7 = rs.getString("price");
                priceTF.setText(add7);
                String add8 = rs.getString("total_seat");
                seatTF.setText(add8);
                String add3 = rs.getString("corReserve");
                cor_TF.setText(add3);
                String add10 = rs.getString("requestOfReserve");
                requestTF.setText(add10);
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
     }
     
    public void saveTBtn(JTextField bus_noTF, JTextField bus_sourceTF, JTextField bus_destTF,
                          JXDatePicker departDateDP, JTextField deratTimeTF, JTextField priceTF,
                          JTextField seatTF,JTextField corTF,JTextField requestTF) {                                         
        td.setBusNo(bus_noTF.getText());
        td.setBusSource(bus_sourceTF.getText());
        td.setBusDest(bus_destTF.getText());
        
        java.util.Date departDateD = departDateDP.getDate();
        SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        td.setDepartDate(oDateFormat.format(departDateD));
        td.setDepartTime(deratTimeTF.getText());
        td.setPrice(priceTF.getText());
        td.setTotalSeat(seatTF.getText());
        td.setCorReserve(corTF.getText());
        td.setRequest(requestTF.getText());
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/95463105";
            con = DriverManager.getConnection(databaseURL, "root", "");
            String selectQuery = "select * from tour_details where bus_no=?";
            pst = (PreparedStatement) con.prepareStatement(selectQuery);
            pst.setString(1, td.getBusNo());
            rs = pst.executeQuery();

            if (rs.next()==true)
            {
                infoMessage("Already Tour is Added", "Create Fresh Entry!!");
                bus_noTF.setText("");
                bus_sourceTF.setText("");        
                bus_destTF.setText(""); 
            }
            else
            {
                        String insertQuery = "insert into tour_details (id,bus_no,bus_source,bus_dest,depart_date,depart_time,price, total_seat,corReserve,requestOfReserve) values(?,?,?,?,?,?,?,?,?,?)";
                        pst1 = (PreparedStatement) con.prepareStatement(insertQuery);
                        pst1.setString(1, null);
                        pst1.setString(2, td.getBusNo());
                        pst1.setString(3, td.getBusSource());
                        pst1.setString(4, td.getBusDest());
                        pst1.setString(5, td.getDepartDate());
                        pst1.setString(6, td.getDepartTime());
                        pst1.setString(7, td.getPrice());
                        pst1.setString(8, td.getTotalSeat());
                        pst1.setString(9, td.getCorReserve());
                        pst1.setString(10, td.getRequest());
                          pst1.execute();
                        
                infoMessage("Tour is Added" , "Great work!!!");
                bus_noTF.setText("");
                bus_sourceTF.setText("");        
                bus_destTF.setText(""); 
            }

        }
        catch (ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    }
    
   
    public void resetTBtn(JTextField bus_noTF, JTextField bus_sourceTF, JTextField bus_destTF,
                          JXDatePicker departDateDP, JTextField deratTimeTF, JTextField priceTF, JTextField seatTF)
    {
        bus_noTF.setText("");
        bus_sourceTF.setText("");
        bus_destTF.setText("");
        deratTimeTF.setText("");
        priceTF.setText("");
        seatTF.setText("");
    }
    
    public void deleteBtn(JTable jTable1,JTextField Id_TF1){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/95463105";
            con = DriverManager.getConnection(databaseURL, "root", "");
            java.sql.Statement st = con.createStatement();
            st.execute("DELETE FROM tour_details WHERE id="+Id_TF1.getText());
            JOptionPane.showMessageDialog(null, "Tour Deleted!");
            jTable1.createDefaultColumnsFromModel();
        } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void editBtn(JTextField Id_TF1,JTextField bus_noTF,JTextField bus_sourceTF,JTextField bus_destTF,
            JTextField deratTimeTF, JTextField priceTF, JTextField seatTF, JTextField cor_TF, JTextField requestTF)
    {
        try{
            String query = "update tour_details set id=?, bus_no=?, bus_source=?, bus_dest=?, depart_time=?, price=?, total_seat=?, corReserve=?, requestOfReserve=? where id= '"+Id_TF1.getText()+"'";
           
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, Id_TF1.getText());
            pst.setString(2, bus_noTF.getText());
            pst.setString(3, bus_sourceTF.getText());
            pst.setString(4, bus_destTF.getText());
            pst.setString(5, deratTimeTF.getText());
            pst.setString(6, priceTF.getText());
            pst.setString(7, seatTF.getText());
            pst.setString(8, cor_TF.getText());
            pst.setString(9, requestTF.getText());
            pst.execute();
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
            finally{
                try{
                rs.close();
                pst.close();
                //pst1.close();
                con.close();
                }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    }
}