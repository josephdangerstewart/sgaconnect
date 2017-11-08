/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Window;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sgaconnect.backend.MessageThread;
import sgaconnect.backend.User;

/**
 *
 * @author josephs12
 */
public class SenatorMessagesNew extends javax.swing.JPanel {

    private static SenatorMessagesNew thisObj;
    
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
        subjectField.setText("");
        messageBody.setText("");
        
        DefaultComboBoxModel model = (DefaultComboBoxModel) toBox.getModel();
        model.removeAllElements();
        
        User[] senators = MainFrame.getBackend().getSenatorsOf(MainFrame.getBackend().getLoggedInUser().getDorm());
        User[] presidents = MainFrame.getBackend().getPresidents();
        
        for (int i = 0; i < presidents.length; i++) {
            model.addElement(presidents[i]);
        }
        
        for (int i = 0; i < senators.length; i++) {
            model.addElement(senators[i]);
        }
    }
    
    private void sendMessage() {
        if (!messageBody.getText().equals("") && !subjectField.getText().equals("")) {
            User toUser = (User)toBox.getSelectedItem();
            
            MessageThread thread = new MessageThread(
                    MainFrame.getBackend().getNextMessageThreadID(),
                    new int[] {
                        toUser.getID(),
                        MainFrame.getBackend().getLoggedInUser().getID()
                    }, 
                    subjectField.getText());
            
            thread.sendMessage(MainFrame.getBackend().getLoggedInUser().getID(), messageBody.getText());
            
            MainFrame.getBackend().save(thread);
            
            SenatorMessagesMain.getInstance().init();
            MainView.getInstance().changeView("senatorMessagesMain");
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

        jScrollPane2 = new javax.swing.JScrollPane();
        body = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        CreateMessage = new javax.swing.JScrollPane();
        messageBody = new javax.swing.JTextArea();
        ToLabel = new javax.swing.JLabel();
        toBox = new javax.swing.JComboBox<>();
        messageTitle = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        subjectField = new javax.swing.JTextField();

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

        sendButton.setBackground(new java.awt.Color(221, 209, 199));
        sendButton.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        sendButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/send.png"))); // NOI18N
        sendButton.setMnemonic('d');
        sendButton.setText("Send");
        sendButton.setMaximumSize(new java.awt.Dimension(125, 51));
        sendButton.setMinimumSize(new java.awt.Dimension(125, 51));
        sendButton.setPreferredSize(new java.awt.Dimension(125, 51));
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

        messageBody.setColumns(20);
        messageBody.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        messageBody.setRows(5);
        messageBody.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        messageBody.setPreferredSize(new java.awt.Dimension(0, 89));
        messageBody.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                messageBodyMouseMoved(evt);
            }
        });
        CreateMessage.setViewportView(messageBody);
        messageBody.getAccessibleContext().setAccessibleName("NewMessageField");

        ToLabel.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        ToLabel.setText("To:");

        toBox.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        toBox.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                toBoxMouseMoved(evt);
            }
        });
        toBox.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                toBoxMouseWheelMoved(evt);
            }
        });
        toBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toBoxActionPerformed(evt);
            }
        });

        messageTitle.setFont(new java.awt.Font("Print Clearly", 0, 24)); // NOI18N
        messageTitle.setForeground(new java.awt.Color(10, 10, 10));
        messageTitle.setText("New Message");

        backButton.setBackground(new java.awt.Color(221, 209, 199));
        backButton.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        backButton.setForeground(new java.awt.Color(10, 10, 10));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/back.png"))); // NOI18N
        backButton.setMnemonic('k');
        backButton.setText(" Back");
        backButton.setMaximumSize(new java.awt.Dimension(125, 51));
        backButton.setMinimumSize(new java.awt.Dimension(125, 51));
        backButton.setPreferredSize(new java.awt.Dimension(125, 51));
        backButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                backButtonMouseMoved(evt);
            }
        });
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel1.setText("Subject:");

        subjectField.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                subjectFieldMouseMoved(evt);
            }
        });
        subjectField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CreateMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(messageTitle)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ToLabel)
                                .addGap(160, 160, 160)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(toBox, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subjectField)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subjectField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CreateMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        toBox.getAccessibleContext().setAccessibleName("Recipent Drop Down");
        subjectField.getAccessibleContext().setAccessibleName("Subject Text Field");
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        sendMessage();
    }//GEN-LAST:event_sendButtonActionPerformed

    private void toBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toBoxActionPerformed

    private void sendButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendButtonMouseMoved
        // TODO add your handling code here:
        //change to click mouse
        Cursor click = new Cursor(Cursor.HAND_CURSOR);
        sendButton.setCursor(click);
    }//GEN-LAST:event_sendButtonMouseMoved

    private void backButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseMoved
        // TODO add your handling code here:
        //change to click mouse
        Cursor click = new Cursor(Cursor.HAND_CURSOR);
        backButton.setCursor(click);
    }//GEN-LAST:event_backButtonMouseMoved

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        SenatorMessagesMain.getInstance().init();
        MainView.getInstance().changeView("senatorMessagesMain");
    }//GEN-LAST:event_backButtonActionPerformed

    private void subjectFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectFieldActionPerformed

    private void messageBodyMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageBodyMouseMoved
        // TODO add your handling code here:
        Cursor hover = new Cursor(Cursor.TEXT_CURSOR);
        messageBody.setCursor(hover);
    }//GEN-LAST:event_messageBodyMouseMoved

    private void subjectFieldMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subjectFieldMouseMoved
        // TODO add your handling code here:
        
        Cursor hover2 = new Cursor(Cursor.TEXT_CURSOR);
        subjectField.setCursor(hover2);
    }//GEN-LAST:event_subjectFieldMouseMoved

    private void toBoxMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_toBoxMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_toBoxMouseWheelMoved

    private void toBoxMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toBoxMouseMoved
        // TODO add your handling code here:
        Cursor click = new Cursor(Cursor.HAND_CURSOR);
        toBox.setCursor(click);
    }//GEN-LAST:event_toBoxMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane CreateMessage;
    private javax.swing.JLabel ToLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JTextArea body;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea messageBody;
    private javax.swing.JLabel messageTitle;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField subjectField;
    private javax.swing.JComboBox<User> toBox;
    // End of variables declaration//GEN-END:variables
}
