/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect;

import java.awt.Cursor;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author josephs12
 */
public class SenatorMessagesView extends javax.swing.JPanel {

    private static SenatorMessagesView thisObj;
    
    /**
     * Creates new form PetitionViewScreen
     */
    public SenatorMessagesView() {
        initComponents();
        thisObj = this;
        commentScrollPane.getVerticalScrollBar().setValue(0);
    }
    
    public static SenatorMessagesView getInstance() {
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

        messageTitle = new javax.swing.JLabel();
        backmessagesButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        body = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        commentScrollPane = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 251, 234));

        messageTitle.setFont(new java.awt.Font("Print Clearly", 0, 24)); // NOI18N
        messageTitle.setForeground(new java.awt.Color(10, 10, 10));
        messageTitle.setText("Message #0 | Randy Loller");

        backmessagesButton.setBackground(new java.awt.Color(221, 209, 199));
        backmessagesButton.setForeground(new java.awt.Color(10, 10, 10));
        backmessagesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/BackArrow.png"))); // NOI18N
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
        body.getAccessibleContext().setAccessibleDescription("");

        sendButton.setBackground(new java.awt.Color(221, 209, 199));
        sendButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/MessageSend.png"))); // NOI18N
        sendButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                sendButtonMouseMoved(evt);
            }
        });
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        commentScrollPane.setBackground(new java.awt.Color(255, 251, 234));
        commentScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reply", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Open Sans", 0, 12))); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        commentScrollPane.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(messageTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                        .addComponent(backmessagesButton)
                        .addGap(11, 11, 11))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sendButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(commentScrollPane)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(messageTitle)
                    .addComponent(backmessagesButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(commentScrollPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sendButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sendButtonActionPerformed

    private void backmessagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backmessagesButtonActionPerformed
        
    }//GEN-LAST:event_backmessagesButtonActionPerformed

    private void sendButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendButtonMouseMoved
        // TODO add your handling code here:
        //change to click mouse
        Cursor click = new Cursor(Cursor.HAND_CURSOR);
        sendButton.setCursor(click);
    }//GEN-LAST:event_sendButtonMouseMoved

    private void backmessagesButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backmessagesButtonMouseMoved
        // TODO add your handling code here:
        //change to click mouse
        Cursor click = new Cursor(Cursor.HAND_CURSOR);
        backmessagesButton.setCursor(click);
    }//GEN-LAST:event_backmessagesButtonMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backmessagesButton;
    private javax.swing.JTextArea body;
    private javax.swing.JScrollPane commentScrollPane;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel messageTitle;
    private javax.swing.JButton sendButton;
    // End of variables declaration//GEN-END:variables
}
