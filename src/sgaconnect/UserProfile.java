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
public class UserProfile extends javax.swing.JPanel {

    private static UserProfile thisObj;
    
    /**
     * Creates new form UserProfile
     */
    public UserProfile() {
        initComponents();
        thisObj = this;
    }
    
    public static UserProfile getInstance() {
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

        titleLabel = new javax.swing.JLabel();
        card = new javax.swing.JPanel();
        nameDisplay = new javax.swing.JLabel();
        profileIcon = new javax.swing.JLabel();
        dormLabel = new javax.swing.JLabel();
        yearLabel = new javax.swing.JLabel();
        majorLabel = new javax.swing.JLabel();
        roomLabel = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        dormDisplay = new javax.swing.JLabel();
        roomDisplay = new javax.swing.JLabel();
        yearDisplay = new javax.swing.JLabel();
        majorDisplay = new javax.swing.JLabel();
        roleDisplay = new javax.swing.JLabel();
        emailDisplay = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 251, 234));

        titleLabel.setFont(new java.awt.Font("Steelfish Outline", 1, 54)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(163, 22, 33));
        titleLabel.setText("User Profile");

        card.setBackground(new java.awt.Color(243, 232, 219));
        card.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nameDisplay.setFont(new java.awt.Font("Print Clearly", 0, 36)); // NOI18N
        nameDisplay.setText("Ashley Cheah");

        profileIcon.setBackground(new java.awt.Color(214, 207, 205));
        profileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/profile-icon.png"))); // NOI18N
        profileIcon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        profileIcon.setOpaque(true);

        dormLabel.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        dormLabel.setText("Dorm:");

        yearLabel.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        yearLabel.setText("Year:");

        majorLabel.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        majorLabel.setText("Major:");

        roomLabel.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        roomLabel.setText("Room:");

        roleLabel.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        roleLabel.setText("Role:");

        emailLabel.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        emailLabel.setText("Email:");

        dormDisplay.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        dormDisplay.setText("Hart");

        roomDisplay.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        roomDisplay.setText("101");

        yearDisplay.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        yearDisplay.setText("Sophmore");

        majorDisplay.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        majorDisplay.setText("Computer Science");

        roleDisplay.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        roleDisplay.setText("[STUDENT]");

        emailDisplay.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        emailDisplay.setText("users.10@biola.edu");

        javax.swing.GroupLayout cardLayout = new javax.swing.GroupLayout(card);
        card.setLayout(cardLayout);
        cardLayout.setHorizontalGroup(
            cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameDisplay)
                    .addGroup(cardLayout.createSequentialGroup()
                        .addComponent(profileIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(roomLabel)
                                .addComponent(majorLabel)
                                .addComponent(yearLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(dormLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(roleLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(18, 18, 18)
                        .addGroup(cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dormDisplay)
                            .addComponent(roomDisplay)
                            .addComponent(yearDisplay)
                            .addComponent(majorDisplay)
                            .addComponent(roleDisplay)
                            .addComponent(emailDisplay))))
                .addContainerGap())
        );
        cardLayout.setVerticalGroup(
            cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameDisplay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profileIcon)
                    .addGroup(cardLayout.createSequentialGroup()
                        .addGroup(cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dormLabel)
                            .addComponent(dormDisplay))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(roomLabel)
                            .addComponent(roomDisplay))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yearLabel)
                            .addComponent(yearDisplay))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(majorLabel)
                            .addComponent(majorDisplay))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(roleLabel)
                            .addComponent(roleDisplay))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLabel)
                            .addComponent(emailDisplay))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel)
                    .addComponent(card, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addComponent(card, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card;
    private javax.swing.JLabel dormDisplay;
    private javax.swing.JLabel dormLabel;
    private javax.swing.JLabel emailDisplay;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel majorDisplay;
    private javax.swing.JLabel majorLabel;
    private javax.swing.JLabel nameDisplay;
    private javax.swing.JLabel profileIcon;
    private javax.swing.JLabel roleDisplay;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JLabel roomDisplay;
    private javax.swing.JLabel roomLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel yearDisplay;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
}
