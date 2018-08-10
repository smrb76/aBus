/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mohammad Reza
 */
public class ReservedTourCtrl {
    TourCtrl tc = new TourCtrl();
    PreparedStatement pst = null;
    Connection con = null;
    ResultSet rs = null;

     public void reservedTours(JTable jTable1, JLabel jLabel1){
         try {
              Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/95463105";
            con = DriverManager.getConnection(databaseURL, "root", "");
            String query = " SELECT tour_details.id,tour_details.bus_no,tour_details.bus_source,"
                    + "tour_details.bus_dest,tour_details.depart_date,tour_details.depart_time,tour_details.price,"
                    + "tour_details.corReserve,tour_details.requestOfReserve,tour_user.username "
                    + "FROM tour_details INNER JOIN tour_user ON tour_details.id=tour_user.id "
                    + "where tour_user.username=? and tour_details.corReserve=? and tour_details.requestOfReserve=?";            
                pst = (PreparedStatement) con.prepareStatement(query);
                pst.setString(1, jLabel1.getText());
                pst.setString(2, "YES");
                pst.setString(3, "YES");
                rs = pst.executeQuery();
            //CONNECT TO DB:
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
         } catch (ClassNotFoundException | SQLException e) {
             JOptionPane.showMessageDialog(null, e);
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