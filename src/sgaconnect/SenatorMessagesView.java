/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect;

import java.awt.Cursor;
import java.awt.ScrollPane;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import sgaconnect.backend.Message;
import sgaconnect.backend.MessageThread;
import sgaconnect.backend.User;

/**
 *
 * @author josephs12
 */
public class SenatorMessagesView extends javax.swing.JPanel {

    private static SenatorMessagesView thisObj;
    private MessageThread thread;
    
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
    
    public void init(MessageThread thread) {
        messageSubject.setText("\"" + thread.getSubject() + "\'");
       
        ArrayList<Message> messages = thread.getMessages();
        this.thread = thread;
        
        String bodyText = "";
        
        for (int i = messages.size()-1; i >= 0; i--) {
            int userFrom = messages.get(i).getFrom();
            int currentUser = MainFrame.getBackend().getLoggedInUser().getID();
            
            bodyText = bodyText + 
                (i != messages.size()-1 ? "--------------------------------\n" : "") +
                (userFrom == currentUser ? "You" : MainFrame.getBackend().getUserByID(messages.get(i).getFrom()).getName()) +
                " (" + messages.get(i).getTimestampString() + "): \n\n" +
                messages.get(i).getBody() + "\n\n";
        }
        
        body.setText(bodyText);
        
        replyField.setText("");
        body.setCaretPosition(0);
    }
    
    private void sendMessage() {
        if (!replyField.getText().equals("")) {
            thread.sendMessage(
                    MainFrame.getBackend().getLoggedInUser().getID(), 
                    replyField.getText());
            MainFrame.getBackend().save(thread);
            init(thread);
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

        backButton = new javax.swing.JButton();
        bodyScrollPane = new javax.swing.JScrollPane();
        body = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        commentScrollPane = new javax.swing.JScrollPane();
        replyField = new javax.swing.JTextArea();
        titleScrollPane = new javax.swing.JScrollPane();
        messageSubject = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 251, 234));

        backButton.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        backButton.setForeground(new java.awt.Color(10, 10, 10));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/back.png"))); // NOI18N
        backButton.setMnemonic('k');
        backButton.setText("Back");
        backButton.setToolTipText("");
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        body.setEditable(false);
        body.setBackground(new java.awt.Color(255, 251, 234));
        body.setColumns(20);
        body.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        body.setLineWrap(true);
        body.setRows(5);
        body.setWrapStyleWord(true);
        body.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        body.setFocusable(false);
        bodyScrollPane.setViewportView(body);
        body.getAccessibleContext().setAccessibleDescription("");

        sendButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/send.png"))); // NOI18N
        sendButton.setMnemonic('d');
        sendButton.setText("Send");
        sendButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        replyField.setBackground(new java.awt.Color(255, 253, 245));
        replyField.setColumns(20);
        replyField.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        replyField.setLineWrap(true);
        replyField.setWrapStyleWord(true);
        replyField.setMinimumSize(new java.awt.Dimension(4, 0));
        replyField.setName(""); // NOI18N
        replyField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                replyFieldKeyPressed(evt);
            }
        });
        commentScrollPane.setViewportView(replyField);

        titleScrollPane.setBorder(null);

        messageSubject.setEditable(false);
        messageSubject.setBackground(new java.awt.Color(255, 251, 234));
        messageSubject.setColumns(20);
        messageSubject.setFont(new java.awt.Font("Print Clearly", 0, 28)); // NOI18N
        messageSubject.setText("\"Some subject line\"");
        titleScrollPane.setViewportView(messageSubject);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(backButton)
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bodyScrollPane)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(commentScrollPane)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(sendButton)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(backButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bodyScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(commentScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        sendMessage();
    }//GEN-LAST:event_sendButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        SenatorMessagesMain.getInstance().init();
        MainView.getInstance().changeView("senatorMessagesMain");
    }//GEN-LAST:event_backButtonActionPerformed

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

    private void replyFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_replyFieldKeyPressed
        // TODO add your handling code here:
         int key = evt.getKeyCode();
        if (key == 17 && key == 10)
        {
            sendMessage();
        }
        
    }//GEN-LAST:event_replyFieldKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextArea body;
    private javax.swing.JScrollPane bodyScrollPane;
    private javax.swing.JScrollPane commentScrollPane;
    private javax.swing.JTextArea messageSubject;
    private javax.swing.JTextArea replyField;
    private javax.swing.JButton sendButton;
    private javax.swing.JScrollPane titleScrollPane;
    // End of variables declaration//GEN-END:variables
}
