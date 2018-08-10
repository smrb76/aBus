/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TourDetails;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import view.AllTours;

/**
 *
 * @author Mohammad Reza
 */
public class searchCtrl {
    PreparedStatement pst = null;
    PreparedStatement pst1 = null;
    Connection con = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    TourCtrl tc = new TourCtrl();
    TourDetails td = new TourDetails();
    Calendar cal = new GregorianCalendar();
    
    //RESERVE OR CANCEL TOUR:
    public void jTable1MouseClicked(JTable jTable1 , JTextField sourceTF,JLabel jLabel3)
     {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/95463105";
            con = DriverManager.getConnection(databaseURL, "root", "");
            int row = jTable1.getSelectedRow();
            String Table_click = (jTable1.getModel().getValueAt(row, 0).toString());
            String query = "select * from tour_details where id= '"+Table_click+"' ";
            pst = (PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();
            
            if (rs.next()) {
            if (!(Integer.parseInt(rs.getString("total_seat"))<=0)) {
                String tourOfDate = rs.getString("depart_date");
                //tour of date
                int yearT = Integer.parseInt(tourOfDate.substring(0, 4));
                int monthT = Integer.parseInt(tourOfDate.substring(5, 7));
                int dayT = Integer.parseInt(tourOfDate.substring(8, 10));
                //today of date
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH) + 1;
                int day = cal.get(Calendar.DAY_OF_MONTH);
                
                int output = JOptionPane.showOptionDialog(null, "Which you prefer?", "Choice", 0, JOptionPane.QUESTION_MESSAGE,
                        null, new String[]{"Reserve this tour","Cancel this tour"}, null);
                if (output == 0) {
                      if (year == yearT && month < monthT) {
                           String query1 = "insert into tour_user(id, username) values(?,?)";
                           pst1 = (PreparedStatement) con.prepareStatement(query1);
                           pst1.setString(1, rs.getString("id"));
                           pst1.setString(2, jLabel3.getText());
                           pst1.execute(); 
                           tc.fillTable(jTable1);
                      }
                      else if (year == yearT && month == monthT && day < dayT) {
                        String query1 = "insert into tour_user(id, username) values(?,?)";
                           pst1 = (PreparedStatement) con.prepareStatement(query1);
                           pst1.setString(1, rs.getString("id"));
                           pst1.setString(2, jLabel3.getText());
                           pst1.execute();
                    }
                      else
                            JOptionPane.showMessageDialog(null, "Tour Expired!!!");
                }
                if (output == 1) {
                    if (year < yearT) {
                        String query1 = "DELETE FROM tour_user WHERE id=?";
                        try {
                            pst = (PreparedStatement) con.prepareStatement(query1);
                            pst.setString(1, rs.getString("id"));
                            pst.executeUpdate();
                     } catch (SQLException ex) {
                            Logger.getLogger(TourCtrl.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                            tc.fillTable(jTable1);
                    }
                else if (year == yearT && month< monthT) {
                        String query1 ="delete from tour_user where id=?";
                        try {
                            pst = (PreparedStatement) con.prepareStatement(query1);
                            pst.setString(1, rs.getString("id"));
                            pst.executeUpdate();
                      } catch (SQLException ex) {
                                Logger.getLogger(TourCtrl.class.getName()).log(Level.SEVERE, null, ex);
                                   }       
                            tc.fillTable(jTable1);
                }
                else if (year == yearT && month == monthT && 7 <= Math.abs(day-dayT)) {
                        String query1 = "delete from tour_user where id=?";
                        try {
                            pst = (PreparedStatement) con.prepareStatement(query1);
                            pst.setString(1, rs.getString("id"));
                            pst.executeUpdate();
                      } catch (SQLException ex) {
                                Logger.getLogger(TourCtrl.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            tc.fillTable(jTable1);
                }
                else
                    JOptionPane.showMessageDialog(null, "Tour NOT Cancelled!!");
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Tour is FULL!!");
        }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(searchCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    public void search(JTable jTable1,JTextField sourceTF,JTextField destTF) {                                       
     if (destTF.getText().equals("")) {
            tc.fillTable(jTable1);
            }
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/95463105";
            con = DriverManager.getConnection(databaseURL, "root", "");
            String query = "select * from tour_details where bus_source like '"+sourceTF.getText()+"' or bus_dest like '"+destTF.getText()+"' or "
                    + "bus_source like '"+sourceTF.getText()+"' and bus_dest like '"+destTF.getText()+"'";
            pst = (PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            pst1.close();

        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AllTours.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
            rs.close();
            pst.close();
            con.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    } 
}
