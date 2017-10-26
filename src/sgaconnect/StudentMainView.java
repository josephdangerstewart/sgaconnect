/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect;

import sgaconnect.backend.User;

/**
 *
 * @author josephs12
 */
public class StudentMainView extends javax.swing.JPanel {

    private static StudentMainView thisObj;
    
    private User[] senators;
    int index;
    
    /**
     * Creates new form StudentMainView
     */
    public StudentMainView() {
        this.thisObj = this;
        initComponents();
    }

    public static StudentMainView getInstance() {
        return thisObj;
    }
    
    public void setUser(User user) {
        senators = MainFrame.getBackend().getSenatorsOf(user.getDorm());
        index = 0;
        setSenator(0);
    }
    
    private void setSenator(int index) {
        if (index >= 0 && senators.length > 0) {
            senatorNameDisplay.setText(senators[index].getName());
            senatorEmailDisplay.setText(senators[index].getEmail());
            senatorRoomDisplay.setText(senators[index].getDorm() + " " + senators[index].getRoom());
            senatorMajorDisplay.setText(senators[index].getMajor());
            senatorYearDisplay.setText(senators[index].getYearString());
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

        senatorPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        senatorNameDisplay = new javax.swing.JLabel();
        senatorEmailDisplay = new javax.swing.JLabel();
        senatorRoomDisplay = new javax.swing.JLabel();
        senatorMajorDisplay = new javax.swing.JLabel();
        senatorYearDisplay = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        recentActivityPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 251, 234));

        senatorPanel.setBackground(new java.awt.Color(255, 251, 234));
        senatorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Your Senator", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Print Clearly", 0, 24), new java.awt.Color(153, 150, 148))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        jLabel2.setText("Email:");

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        jLabel3.setText("Room:");

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        jLabel4.setText("Major:");

        jLabel5.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        jLabel5.setText("Year:");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/profile-icon.png"))); // NOI18N

        senatorNameDisplay.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        senatorNameDisplay.setText("Undefined");

        senatorEmailDisplay.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        senatorEmailDisplay.setText("Undefined");

        senatorRoomDisplay.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        senatorRoomDisplay.setText("Undefined");

        senatorMajorDisplay.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        senatorMajorDisplay.setText("Undefined");

        senatorYearDisplay.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        senatorYearDisplay.setText("Undefined");

        nextButton.setFont(new java.awt.Font("Open Sans", 0, 10)); // NOI18N
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        previousButton.setFont(new java.awt.Font("Open Sans", 0, 10)); // NOI18N
        previousButton.setText("Previous");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout senatorPanelLayout = new javax.swing.GroupLayout(senatorPanel);
        senatorPanel.setLayout(senatorPanelLayout);
        senatorPanelLayout.setHorizontalGroup(
            senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(senatorPanelLayout.createSequentialGroup()
                .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(senatorPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(senatorPanelLayout.createSequentialGroup()
                                .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(senatorRoomDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                    .addComponent(senatorEmailDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(senatorNameDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(senatorPanelLayout.createSequentialGroup()
                                .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(senatorYearDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                    .addComponent(senatorMajorDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(senatorPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(previousButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, senatorPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap())
                    .addComponent(nextButton, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        senatorPanelLayout.setVerticalGroup(
            senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, senatorPanelLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(senatorPanelLayout.createSequentialGroup()
                        .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(senatorNameDisplay))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(senatorEmailDisplay))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(senatorRoomDisplay))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(senatorMajorDisplay))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(senatorYearDisplay))
                        .addContainerGap())
                    .addGroup(senatorPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(previousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        recentActivityPanel.setBackground(new java.awt.Color(255, 251, 234));
        recentActivityPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recent Activity", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Print Clearly", 0, 24), new java.awt.Color(153, 150, 148))); // NOI18N

        jTable1.setBackground(new java.awt.Color(221, 209, 199));
        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Time", "Event"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(false);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout recentActivityPanelLayout = new javax.swing.GroupLayout(recentActivityPanel);
        recentActivityPanel.setLayout(recentActivityPanelLayout);
        recentActivityPanelLayout.setHorizontalGroup(
            recentActivityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
        );
        recentActivityPanelLayout.setVerticalGroup(
            recentActivityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(recentActivityPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(senatorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(senatorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recentActivityPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if (index < senators.length-1) {
            index++;
            setSenator(index);
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        if (index > 0) {
            index--;
            setSenator(index);
        }
    }//GEN-LAST:event_previousButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JPanel recentActivityPanel;
    private javax.swing.JLabel senatorEmailDisplay;
    private javax.swing.JLabel senatorMajorDisplay;
    private javax.swing.JLabel senatorNameDisplay;
    private javax.swing.JPanel senatorPanel;
    private javax.swing.JLabel senatorRoomDisplay;
    private javax.swing.JLabel senatorYearDisplay;
    // End of variables declaration//GEN-END:variables
}
