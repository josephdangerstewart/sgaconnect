/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect;

/**
 *
 * @author josephs12
 */
public class Sidebar extends javax.swing.JPanel {

    /**
     * Creates new form Sidebar
     */
    public Sidebar() {
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

        homeButton = new javax.swing.JButton();
        petitionButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 150, 148));

        homeButton.setBackground(new java.awt.Color(142, 15, 22));
        homeButton.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/HomeImage1.png"))); // NOI18N
        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        petitionButton.setBackground(new java.awt.Color(142, 15, 22));
        petitionButton.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        petitionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/PetitionImage.png"))); // NOI18N
        petitionButton.setText("Petitions");
        petitionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petitionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(petitionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(homeButton)
                .addGap(18, 18, 18)
                .addComponent(petitionButton)
                .addContainerGap(256, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        StudentMainScreen.getInstance().setUser(MainFrame.getBackend().getLoggedInUser());
        MainView.getInstance().changeView("studentMainScreen");
    }//GEN-LAST:event_homeButtonActionPerformed

    private void petitionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petitionButtonActionPerformed
        PetitionMainScreen.getInstance().init();
        MainView.getInstance().changeView("petitionMainScreen");
    }//GEN-LAST:event_petitionButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeButton;
    private javax.swing.JButton petitionButton;
    // End of variables declaration//GEN-END:variables
}
