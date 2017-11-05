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
public class SenatorMessagesMain extends javax.swing.JPanel {

    private static SenatorMessagesMain thisObj;
    
    private JSONObject[] petitions;
    
    /**
     * Creates new form PetitionMainScreen
     */
    public SenatorMessagesMain() {
        initComponents();
        thisObj = this;
    }
    
    public static SenatorMessagesMain getInstance() {
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

        MessagesLabel = new javax.swing.JLabel();
        SendButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        CreateMessage = new javax.swing.JScrollPane();
        CreateMessageField = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ToLabel = new javax.swing.JLabel();
        StudentNames = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 251, 234));

        MessagesLabel.setFont(new java.awt.Font("Steelfish Outline", 1, 54)); // NOI18N
        MessagesLabel.setForeground(new java.awt.Color(142, 15, 22));
        MessagesLabel.setText("Messages");

        SendButton.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        SendButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/MessageSend.png"))); // NOI18N
        SendButton.setText("Send");
        SendButton.setMaximumSize(new java.awt.Dimension(125, 51));
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

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        CreateMessageField.setColumns(20);
        CreateMessageField.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        CreateMessageField.setRows(5);
        CreateMessageField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        CreateMessageField.setPreferredSize(new java.awt.Dimension(918, 68));
        CreateMessage.setViewportView(CreateMessageField);

        jTable1.setBackground(new java.awt.Color(221, 209, 199));
        jTable1.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Student", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setFillsViewportHeight(true);
        jTable1.setInheritsPopupMenu(true);
        jTable1.setSelectionBackground(jTable1.getBackground());
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        ToLabel.setText("To:");

        StudentNames.setEditable(true);
        StudentNames.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        StudentNames.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ashley", "Joseph", "Orion", "Wesley", "Wyatt" }));
        StudentNames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentNamesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(MessagesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CreateMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ToLabel)
                            .addComponent(StudentNames, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MessagesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ToLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StudentNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SendButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CreateMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane CreateMessage;
    private javax.swing.JTextArea CreateMessageField;
    private javax.swing.JLabel MessagesLabel;
    private javax.swing.JButton SendButton;
    private javax.swing.JComboBox<String> StudentNames;
    private javax.swing.JLabel ToLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
