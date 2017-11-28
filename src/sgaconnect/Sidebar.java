/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect;

import java.awt.Cursor;

/**
 *
 * @author josephs12
 */
public class Sidebar extends javax.swing.JPanel {

    private static Sidebar thisObj;
    
    /**
     * Creates new form Sidebar
     */
    public Sidebar() {
        initComponents();
        thisObj = this;
    }
    
    public static Sidebar getInstance() {
        return thisObj;
    }
    
    public void init() {
        if (MainFrame.getBackend().getLoggedInUser().getRole() != 2) {
            remove(controlPanelButton);
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

        controlpanelButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        petitionButton = new javax.swing.JButton();
        pollsButton = new javax.swing.JButton();
        newsletterButton = new javax.swing.JButton();
        bulletinButton = new javax.swing.JButton();
        messagesButton = new javax.swing.JButton();
        controlPanelButton = new javax.swing.JButton();

        controlpanelButton.setBackground(new java.awt.Color(221, 209, 199));
        controlpanelButton.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        controlpanelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/controlpanel1.png"))); // NOI18N
        controlpanelButton.setMnemonic('r');
        controlpanelButton.setText("Control");
        controlpanelButton.setMaximumSize(new java.awt.Dimension(125, 51));
        controlpanelButton.setMinimumSize(new java.awt.Dimension(125, 51));
        controlpanelButton.setPreferredSize(new java.awt.Dimension(125, 51));
        controlpanelButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                controlpanelButtonMouseMoved(evt);
            }
        });
        controlpanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlpanelButtonActionPerformed(evt);
            }
        });

        setBackground(new java.awt.Color(56, 56, 56));

        homeButton.setBackground(new java.awt.Color(221, 209, 199));
        homeButton.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/HomeImage1.png"))); // NOI18N
        homeButton.setMnemonic('h');
        homeButton.setText("Home");
        homeButton.setMaximumSize(new java.awt.Dimension(125, 51));
        homeButton.setMinimumSize(new java.awt.Dimension(125, 51));
        homeButton.setPreferredSize(new java.awt.Dimension(125, 51));
        homeButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                homeButtonMouseMoved(evt);
            }
        });
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        petitionButton.setBackground(new java.awt.Color(221, 209, 199));
        petitionButton.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        petitionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/petitionsNEW2.png"))); // NOI18N
        petitionButton.setMnemonic('p');
        petitionButton.setText("Petitions");
        petitionButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                petitionButtonMouseMoved(evt);
            }
        });
        petitionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petitionButtonActionPerformed(evt);
            }
        });

        pollsButton.setBackground(new java.awt.Color(221, 209, 199));
        pollsButton.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        pollsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/PollsIconBW.png"))); // NOI18N
        pollsButton.setMnemonic('s');
        pollsButton.setLabel("Polls");
        pollsButton.setMaximumSize(new java.awt.Dimension(125, 51));
        pollsButton.setMinimumSize(new java.awt.Dimension(125, 51));
        pollsButton.setPreferredSize(new java.awt.Dimension(125, 51));
        pollsButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pollsButtonMouseMoved(evt);
            }
        });
        pollsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pollsButtonActionPerformed(evt);
            }
        });

        newsletterButton.setBackground(new java.awt.Color(221, 209, 199));
        newsletterButton.setFont(new java.awt.Font("Open Sans", 0, 9)); // NOI18N
        newsletterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/NewsletterPres2.png"))); // NOI18N
        newsletterButton.setMnemonic('n');
        newsletterButton.setText("Newsletter");
        newsletterButton.setMaximumSize(new java.awt.Dimension(125, 51));
        newsletterButton.setMinimumSize(new java.awt.Dimension(125, 51));
        newsletterButton.setPreferredSize(new java.awt.Dimension(125, 51));
        newsletterButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                newsletterButtonMouseMoved(evt);
            }
        });
        newsletterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newsletterButtonActionPerformed(evt);
            }
        });

        bulletinButton.setBackground(new java.awt.Color(221, 209, 199));
        bulletinButton.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        bulletinButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/newBulletinIcon.png"))); // NOI18N
        bulletinButton.setMnemonic('b');
        bulletinButton.setText("Bulletin");
        bulletinButton.setMaximumSize(new java.awt.Dimension(125, 51));
        bulletinButton.setMinimumSize(new java.awt.Dimension(125, 51));
        bulletinButton.setPreferredSize(new java.awt.Dimension(125, 51));
        bulletinButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bulletinButtonMouseMoved(evt);
            }
        });
        bulletinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bulletinButtonActionPerformed(evt);
            }
        });

        messagesButton.setBackground(new java.awt.Color(221, 209, 199));
        messagesButton.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        messagesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/mailICONSMALLER.png"))); // NOI18N
        messagesButton.setMnemonic('m');
        messagesButton.setText("Messages");
        messagesButton.setMaximumSize(new java.awt.Dimension(125, 51));
        messagesButton.setMinimumSize(new java.awt.Dimension(125, 51));
        messagesButton.setPreferredSize(new java.awt.Dimension(125, 51));
        messagesButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                messagesButtonMouseMoved(evt);
            }
        });
        messagesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messagesButtonActionPerformed(evt);
            }
        });

        controlPanelButton.setBackground(new java.awt.Color(221, 209, 199));
        controlPanelButton.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        controlPanelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/controlpanel1.png"))); // NOI18N
        controlPanelButton.setMnemonic('r');
        controlPanelButton.setText("Control");
        controlPanelButton.setMaximumSize(new java.awt.Dimension(125, 51));
        controlPanelButton.setMinimumSize(new java.awt.Dimension(125, 51));
        controlPanelButton.setPreferredSize(new java.awt.Dimension(125, 51));
        controlPanelButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                controlPanelButtonMouseMoved(evt);
            }
        });
        controlPanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlPanelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newsletterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pollsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(petitionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bulletinButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(messagesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(controlPanelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(petitionButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pollsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newsletterButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bulletinButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(messagesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(controlPanelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        StudentMainScreen.getInstance().setUser(MainFrame.getBackend().getLoggedInUser());
        if (MainFrame.getBackend().getLoggedInUser().getRole() == 0) {
            StudentMainScreen.getInstance().setUser(MainFrame.getBackend().getLoggedInUser());
        MainView.getInstance().changeView("studentMainScreen");
        } else {
            SenatorMainScreen.getInstance().init();
            MainView.getInstance().changeView("senatorMainScreen");
        }
    }//GEN-LAST:event_homeButtonActionPerformed

    private void petitionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petitionButtonActionPerformed
        PetitionMainScreen.getInstance().init();
        MainView.getInstance().changeView("petitionMainScreen");
    }//GEN-LAST:event_petitionButtonActionPerformed

    private void messagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messagesButtonActionPerformed
        SenatorMessagesMain.getInstance().init();
        MainView.getInstance().changeView("senatorMessagesMain");
    }//GEN-LAST:event_messagesButtonActionPerformed

    private void pollsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pollsButtonActionPerformed
        PollMainScreen.getInstance().init();
        MainView.getInstance().changeView("pollMainScreen");
    }//GEN-LAST:event_pollsButtonActionPerformed

    private void homeButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseMoved
        // TODO add your handling code here:
        //change to click mouse
        Cursor click = new Cursor(Cursor.HAND_CURSOR);
        homeButton.setCursor(click);
    }//GEN-LAST:event_homeButtonMouseMoved

    private void petitionButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petitionButtonMouseMoved
        // TODO add your handling code here:
        
        //change to click mouse
        Cursor click = new Cursor(Cursor.HAND_CURSOR);
        petitionButton.setCursor(click);
    }//GEN-LAST:event_petitionButtonMouseMoved

    private void pollsButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pollsButtonMouseMoved
        // TODO add your handling code here:
        //change to click mouse
        Cursor click = new Cursor(Cursor.HAND_CURSOR);
        pollsButton.setCursor(click);
    }//GEN-LAST:event_pollsButtonMouseMoved

    private void newsletterButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newsletterButtonMouseMoved
        // TODO add your handling code here:
        //change to click mouse
        Cursor click = new Cursor(Cursor.HAND_CURSOR);
        newsletterButton.setCursor(click);
    }//GEN-LAST:event_newsletterButtonMouseMoved

    private void bulletinButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bulletinButtonMouseMoved
        // TODO add your handling code here:
        //change to click mouse
        Cursor click = new Cursor(Cursor.HAND_CURSOR);
        bulletinButton.setCursor(click);
    }//GEN-LAST:event_bulletinButtonMouseMoved

    private void messagesButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messagesButtonMouseMoved
        // TODO add your handling code here:
        //change to click mouse
        Cursor click = new Cursor(Cursor.HAND_CURSOR);
        messagesButton.setCursor(click);
    }//GEN-LAST:event_messagesButtonMouseMoved

    private void bulletinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bulletinButtonActionPerformed
        BulletinView.getInstance().init();
        MainView.getInstance().changeView("bulletinView");
    }//GEN-LAST:event_bulletinButtonActionPerformed

    private void newsletterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newsletterButtonActionPerformed
        NewsletterMainScreen.getInstance().init();
        MainView.getInstance().changeView("newsletterMainScreen");
    }//GEN-LAST:event_newsletterButtonActionPerformed

    private void controlpanelButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_controlpanelButtonMouseMoved
        // TODO add your handling code here:
        //change to click mouse
        Cursor click = new Cursor(Cursor.HAND_CURSOR);
        controlpanelButton.setCursor(click);
    }//GEN-LAST:event_controlpanelButtonMouseMoved

    private void controlpanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlpanelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_controlpanelButtonActionPerformed

    private void controlPanelButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_controlPanelButtonMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_controlPanelButtonMouseMoved

    private void controlPanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlPanelButtonActionPerformed
        ControlPanel.getInstance().init();
        MainView.getInstance().changeView("controlPanel");
    }//GEN-LAST:event_controlPanelButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bulletinButton;
    private javax.swing.JButton controlPanelButton;
    private javax.swing.JButton controlpanelButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JButton messagesButton;
    private javax.swing.JButton newsletterButton;
    private javax.swing.JButton petitionButton;
    private javax.swing.JButton pollsButton;
    // End of variables declaration//GEN-END:variables
}
