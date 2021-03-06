/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect;

import java.awt.Cursor;
import java.awt.Point;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sgaconnect.backend.User;

/**
 *
 * @author josephs12
 */
public class ControlPanel extends javax.swing.JPanel {
    
    private static ControlPanel thisObj;
    User[] senators;
    
    /**
     * Creates new form PollMainScreen
     */
    public ControlPanel() {
        initComponents();
        thisObj = this;
    }
    
    public static ControlPanel getInstance() {
        return thisObj;
    }
    
    public void init() {
        DefaultTableModel model = (DefaultTableModel) senatorsTable.getModel();
        
        senators = MainFrame.getBackend().getSenators();
        
        model.setRowCount(senators.length);
        
        for (int i = 0; i < senators.length; i++) {
            model.setValueAt(senators[i].getName(),i,0);
            model.setValueAt(senators[i].getDorm(), i, 1);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        senatorsTable = new javax.swing.JTable();
        removeSenator = new javax.swing.JButton();
        addSenator = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 251, 234));

        title.setFont(new java.awt.Font("Steelfish Outline", 1, 54)); // NOI18N
        title.setForeground(new java.awt.Color(163, 22, 33));
        title.setText("Control Panel");

        senatorsTable.setBackground(new java.awt.Color(221, 209, 199));
        senatorsTable.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        senatorsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Senator Name", "Constituency"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        senatorsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        senatorsTable.setFillsViewportHeight(true);
        senatorsTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        senatorsTable.setShowVerticalLines(false);
        senatorsTable.getTableHeader().setReorderingAllowed(false);
        senatorsTable.setVerifyInputWhenFocusTarget(false);
        senatorsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                senatorsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(senatorsTable);
        if (senatorsTable.getColumnModel().getColumnCount() > 0) {
            senatorsTable.getColumnModel().getColumn(0).setResizable(false);
            senatorsTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        }
        senatorsTable.getAccessibleContext().setAccessibleName("Senators");

        removeSenator.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        removeSenator.setText("-");
        removeSenator.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeSenator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSenatorActionPerformed(evt);
            }
        });

        addSenator.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        addSenator.setText("+");
        addSenator.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addSenator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSenatorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel1.setText("Add/Remove Senators");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addSenator)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(removeSenator)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addSenator)
                    .addComponent(removeSenator)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        removeSenator.getAccessibleContext().setAccessibleName("Delete Senator Button");
        addSenator.getAccessibleContext().setAccessibleName("Add Senator Button");
    }// </editor-fold>//GEN-END:initComponents

    private void senatorsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_senatorsTableMouseClicked

    }//GEN-LAST:event_senatorsTableMouseClicked

    private void addSenatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSenatorActionPerformed
        String netID = JOptionPane.showInputDialog(this,
                "Enter NetID of new senator", 
                "Enter NetID", 
                JOptionPane.QUESTION_MESSAGE);
        
        User user = MainFrame.getBackend().getUserByNetID(netID);
        
        if (!user.isNull() && user.getRole() != 2) {
            user.setRole(1);
            MainFrame.getBackend().save(user);
            init();
        }
    }//GEN-LAST:event_addSenatorActionPerformed

    private void removeSenatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSenatorActionPerformed
        int[] selectedRows = senatorsTable.getSelectedRows();
        
        for (int i = 0; i < selectedRows.length; i++) {
            int selection = selectedRows[i];
            if (selection != -1) {
                User user = senators[selection];
                user.setRole(0);
                MainFrame.getBackend().save(user);
            }
        }
        
        init();
    }//GEN-LAST:event_removeSenatorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSenator;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeSenator;
    private javax.swing.JTable senatorsTable;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}
