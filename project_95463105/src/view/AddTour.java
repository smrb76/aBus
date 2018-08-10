/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.TourCtrl;

/**
 *
 * @author Mohammad Reza
 */
public class AddTour extends javax.swing.JInternalFrame {
    TourCtrl at = new TourCtrl();
    /**
     * Creates new form AddBusAgentDetails
     */
    public AddTour() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bus_noTF = new javax.swing.JTextField();
        bus_sourceTF = new javax.swing.JTextField();
        bus_destTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        deratTimeTF = new javax.swing.JTextField();
        priceTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        seatTF = new javax.swing.JTextField();
        departDateDP = new org.jdesktop.swingx.JXDatePicker();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        saveLbl = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        resetLbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        corTF = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        requestTF = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Adding Tours");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(811, 541));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Bus No");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Source");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Date");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, -1, -1));

        bus_noTF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bus_noTF.setBorder(null);
        bus_noTF.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        getContentPane().add(bus_noTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 187, 31));

        bus_sourceTF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bus_sourceTF.setForeground(new java.awt.Color(0, 0, 0));
        bus_sourceTF.setBorder(null);
        bus_sourceTF.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        getContentPane().add(bus_sourceTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 187, 31));

        bus_destTF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bus_destTF.setBorder(null);
        bus_destTF.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        getContentPane().add(bus_destTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 187, 32));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Destinartion");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Time");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        deratTimeTF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deratTimeTF.setBorder(null);
        deratTimeTF.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        getContentPane().add(deratTimeTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 187, 32));

        priceTF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        priceTF.setBorder(null);
        priceTF.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        getContentPane().add(priceTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 187, 32));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Price");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, -1, -1));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Seat");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        seatTF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        seatTF.setBorder(null);
        seatTF.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        getContentPane().add(seatTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 187, 32));
        getContentPane().add(departDateDP, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 187, 31));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tours Details");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 340, 50, 49));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Tour Details");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 16, 230, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 80));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        saveLbl.setBackground(new java.awt.Color(0, 0, 0));
        saveLbl.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        saveLbl.setForeground(new java.awt.Color(255, 255, 255));
        saveLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saveLbl.setText("SAVE");
        saveLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveLblMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(saveLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(saveLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, -1, -1));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        resetLbl.setBackground(new java.awt.Color(0, 0, 0));
        resetLbl.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        resetLbl.setForeground(new java.awt.Color(255, 255, 255));
        resetLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resetLbl.setText("RESET");
        resetLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetLblMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resetLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resetLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 187, 10));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 187, 10));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 187, 10));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 187, 10));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 187, 10));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 187, 10));

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 187, 10));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("corReserve");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, -1, -1));

        corTF.setEditable(false);
        corTF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        corTF.setForeground(new java.awt.Color(0, 0, 0));
        corTF.setText("NO");
        corTF.setBorder(null);
        corTF.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        getContentPane().add(corTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 187, 32));

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 187, 10));

        requestTF.setEditable(false);
        requestTF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        requestTF.setForeground(new java.awt.Color(0, 0, 0));
        requestTF.setText("NO");
        requestTF.setBorder(null);
        requestTF.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        getContentPane().add(requestTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 187, 32));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Request");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        jSeparator10.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 187, 10));

        getAccessibleContext().setAccessibleName("Adding Tour");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    private void saveLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveLblMouseClicked
        at.saveTBtn(bus_noTF, bus_sourceTF, bus_destTF, departDateDP, deratTimeTF, priceTF, seatTF, corTF, requestTF);
    }//GEN-LAST:event_saveLblMouseClicked

    private void resetLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetLblMouseClicked
        at.resetTBtn(bus_noTF, bus_sourceTF, bus_destTF, departDateDP, deratTimeTF, priceTF, seatTF);
    }//GEN-LAST:event_resetLblMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bus_destTF;
    private javax.swing.JTextField bus_noTF;
    private javax.swing.JTextField bus_sourceTF;
    private javax.swing.JTextField corTF;
    private org.jdesktop.swingx.JXDatePicker departDateDP;
    private javax.swing.JTextField deratTimeTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField priceTF;
    private javax.swing.JTextField requestTF;
    private javax.swing.JLabel resetLbl;
    private javax.swing.JLabel saveLbl;
    private javax.swing.JTextField seatTF;
    // End of variables declaration//GEN-END:variables
}
