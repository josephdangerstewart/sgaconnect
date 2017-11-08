/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Window;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

/**
 *
 * @author josephs12
 */
public class SenatorMessagesNew extends javax.swing.JPanel {

    private static SenatorMessagesNew thisObj;
    
    private JSONObject[] petitions;
    
    /**
     * Creates new form PetitionMainScreen
     */
    public SenatorMessagesNew() {
        initComponents();
        thisObj = this;
    }
    
    public static SenatorMessagesNew getInstance() {
        return thisObj;
    }
    
    public void init() {
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        body = new javax.swing.JTextArea();
        SendButton = new javax.swing.JButton();
        CreateMessage = new javax.swing.JScrollPane();
        CreateMessageField = new javax.swing.JTextArea();
        ToLabel = new javax.swing.JLabel();
        StudentNames = new javax.swing.JComboBox<>();
        messageTitle = new javax.swing.JLabel();
        backmessagesButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        body.setEditable(false);
        body.setBackground(new java.awt.Color(255, 251, 234));
        body.setColumns(20);
        body.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        body.setLineWrap(true);
        body.setRows(5);
        body.setWrapStyleWord(true);
        body.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        body.setFocusable(false);
        jScrollPane2.setViewportView(body);

        setBackground(new java.awt.Color(255, 251, 234));

        SendButton.setBackground(new java.awt.Color(221, 209, 199));
        SendButton.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        SendButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/send.png"))); // NOI18N
        SendButton.setText("Send");
        SendButton.setMaximumSize(new java.awt.Dimension(125, 51));
        SendButton.setMinimumSize(new java.awt.Dimension(125, 51));
        SendButton.setPreferredSize(new java.awt.Dimension(125, 51));
        SendButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                SendButtonMouseMoved(evt);
            }
        });
        SendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendButtonActionPerformed(evt);
            }
        });

        CreateMessageField.setColumns(20);
        CreateMessageField.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        CreateMessageField.setRows(5);
        CreateMessageField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        CreateMessageField.setPreferredSize(new java.awt.Dimension(0, 89));
        CreateMessage.setViewportView(CreateMessageField);
        CreateMessageField.getAccessibleContext().setAccessibleName("NewMessageField");

        ToLabel.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        ToLabel.setText("To:");

        StudentNames.setEditable(true);
        StudentNames.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        StudentNames.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ashley", "Joseph", "Orion", "Wesley", "Wyatt" }));
        StudentNames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentNamesActionPerformed(evt);
            }
        });

        messageTitle.setFont(new java.awt.Font("Print Clearly", 0, 24)); // NOI18N
        messageTitle.setForeground(new java.awt.Color(10, 10, 10));
        messageTitle.setText("New Message");

        backmessagesButton.setBackground(new java.awt.Color(221, 209, 199));
        backmessagesButton.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        backmessagesButton.setForeground(new java.awt.Color(10, 10, 10));
        backmessagesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/back.png"))); // NOI18N
        backmessagesButton.setText(" Back");
        backmessagesButton.setMaximumSize(new java.awt.Dimension(125, 51));
        backmessagesButton.setMinimumSize(new java.awt.Dimension(125, 51));
        backmessagesButton.setPreferredSize(new java.awt.Dimension(125, 51));
        backmessagesButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                backmessagesButtonMouseMoved(evt);
            }
        });
        backmessagesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backmessagesButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel1.setText("Subject:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CreateMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backmessagesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SendButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(StudentNames, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(messageTitle)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ToLabel)
                                .addGap(160, 160, 160)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageTitle)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ToLabel)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StudentNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CreateMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SendButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backmessagesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SendButtonActionPerformed

    private void StudentNamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentNamesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StudentNamesActionPerformed

    private void SendButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SendButtonMouseMoved
        // TODO add your handling code here:
        //change to click mouse
        Cursor click = new Cursor(Cursor.HAND_CURSOR);
        SendButton.setCursor(click);
    }//GEN-LAST:event_SendButtonMouseMoved

    private void backmessagesButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backmessagesButtonMouseMoved
        // TODO add your handling code here:
        //change to click mouse
        Cursor click = new Cursor(Cursor.HAND_CURSOR);
        backmessagesButton.setCursor(click);
    }//GEN-LAST:event_backmessagesButtonMouseMoved

    private void backmessagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backmessagesButtonActionPerformed

    }//GEN-LAST:event_backmessagesButtonActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane CreateMessage;
    private javax.swing.JTextArea CreateMessageField;
    private javax.swing.JButton SendButton;
    private javax.swing.JComboBox<String> StudentNames;
    private javax.swing.JLabel ToLabel;
    private javax.swing.JButton backmessagesButton;
    private javax.swing.JTextArea body;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel messageTitle;
    // End of variables declaration//GEN-END:variables
}
