/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect;

import java.awt.Cursor;
import sgaconnect.backend.Backend;

/**
 *
 * @author josephs12
 */
public class LogInView extends javax.swing.JPanel {
    
    /**
     * Creates new form LogInView
     */
    public LogInView() {
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

        SGAConnectLabel = new javax.swing.JLabel();
        SGAConnectCatchphrase = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        usernameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 251, 234));

        SGAConnectLabel.setFont(new java.awt.Font("Steelfish Outline", 1, 80)); // NOI18N
        SGAConnectLabel.setForeground(new java.awt.Color(142, 15, 22));
        SGAConnectLabel.setText("SGA Connect");

        SGAConnectCatchphrase.setFont(new java.awt.Font("Print Clearly", 0, 28)); // NOI18N
        SGAConnectCatchphrase.setForeground(new java.awt.Color(153, 150, 148));
        SGAConnectCatchphrase.setText("Stay Informed, Stay Connected");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        usernameField.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        usernameField.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel3.setText("Username:");

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel4.setText("Password:");

        passwordField.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
        });

        loginButton.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        loginButton.setMnemonic('l');
        loginButton.setText("Log In");
        loginButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                loginButtonMouseMoved(evt);
            }
        });
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginButtonKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SGAConnectLabel)
                    .addComponent(SGAConnectCatchphrase, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(usernameField, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(SGAConnectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SGAConnectCatchphrase))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(18, 18, 18)
                .addComponent(loginButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 120, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jSeparator1.getAccessibleContext().setAccessibleName("Separator");
        usernameField.getAccessibleContext().setAccessibleName("Biola NetID");
        usernameField.getAccessibleContext().setAccessibleDescription("Enter your NetID username");
        passwordField.getAccessibleContext().setAccessibleName("NetID Password");
        passwordField.getAccessibleContext().setAccessibleDescription("Enter your NetID password");
        loginButton.getAccessibleContext().setAccessibleDescription("Log in to SGA Connect");
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        Backend backend = MainFrame.getBackend();
        
        if (backend.logIn(usernameField.getText(), new String(passwordField.getPassword())) != null) {
            StudentMainScreen.getInstance().setUser(backend.getLoggedInUser());
            MainFrame.getMainFrame().changeView("mainView");
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyPressed
        //TODO add your handling code here:
        //holder for ascii 
        int key = evt.getKeyCode();
        //if enter is hit then change frames
        if (key == 10)
        {
         Backend backend2 = MainFrame.getBackend();
            if (backend2.logIn(usernameField.getText(), new String(passwordField.getPassword())) != null) {
                StudentMainScreen.getInstance().setUser(backend2.getLoggedInUser());
                MainFrame.getMainFrame().changeView("mainView");
            }   
        }
    }//GEN-LAST:event_passwordFieldKeyPressed

    private void loginButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginButtonKeyPressed
        // TODO add your handling code here:
        //holder for ascii 
        
        int key = evt.getKeyCode();
        //if enter is hit then change frames
        if (key == 10)
        {
         Backend backend3 = MainFrame.getBackend();
            if (backend3.logIn(usernameField.getText(), new String(passwordField.getPassword())) != null) {
                StudentMainScreen.getInstance().setUser(backend3.getLoggedInUser());
                MainFrame.getMainFrame().changeView("mainView");
            }   
        }
    }//GEN-LAST:event_loginButtonKeyPressed

    private void loginButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseMoved
        // TODO add your handling code here:
        
        Cursor click = new Cursor(Cursor.HAND_CURSOR);
        loginButton.setCursor(click);
    }//GEN-LAST:event_loginButtonMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SGAConnectCatchphrase;
    private javax.swing.JLabel SGAConnectLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
