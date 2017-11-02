/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect;

import sgaconnect.backend.Petition;

/**
 *
 * @author josephs12
 */
public class PetitionCreationScreen extends javax.swing.JPanel {

    private static PetitionCreationScreen thisObj;
    
    /**
     * Creates new form PetitionCreationScreen
     */
    public PetitionCreationScreen() {
        initComponents();
        thisObj = this;
    }
    
    public static PetitionCreationScreen getInstance() {
        return thisObj;
    }
    
    public void init() {
        bodyField.setText("");
        titleField.setText("");
        scopeField.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        scopeField = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bodyField = new javax.swing.JTextArea();
        createButton = new javax.swing.JButton();
        bodyFieldError = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        titleFieldError = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 251, 234));

        jLabel1.setFont(new java.awt.Font("Steelfish Outline", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(142, 15, 22));
        jLabel1.setText("Create Petition");

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel2.setText("Title");

        titleField.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        titleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel3.setText("Scope");

        scopeField.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        scopeField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL CAMPUS", "Upper Campus", "Lower Campus", "Your Dorm" }));

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel4.setText("Body");

        jScrollPane1.setAutoscrolls(true);

        bodyField.setColumns(20);
        bodyField.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        bodyField.setLineWrap(true);
        bodyField.setRows(5);
        bodyField.setWrapStyleWord(true);
        bodyField.setDoubleBuffered(true);
        jScrollPane1.setViewportView(bodyField);

        createButton.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        bodyFieldError.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        bodyFieldError.setForeground(new java.awt.Color(255, 44, 52));

        jButton1.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jButton1.setText("Back");

        titleFieldError.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        titleFieldError.setForeground(new java.awt.Color(255, 44, 52));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(titleFieldError)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(titleField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(scopeField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bodyFieldError)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 204, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(0, 204, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(createButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(titleFieldError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scopeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(bodyFieldError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createButton)
                    .addComponent(jButton1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void titleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleFieldActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        if (!titleField.getText().equals("") && !bodyField.getText().equals("")) {
            Petition petition = new Petition(
                    MainFrame.getBackend().getNextPetitionId(),
                    MainFrame.getBackend().getLoggedInUser().getID());
            
            petition.setTitle(titleField.getText());
            petition.setBody(bodyField.getText());
            petition.setScope((String)scopeField.getSelectedItem());
            
            MainFrame.getBackend().save(petition);
            
            PetitionViewScreen.getInstance().init(petition);
            MainView.getInstance().changeView("petitionViewScreen");
        } else {
            if (!titleField.getText().equals("")) {
                titleFieldError.setText("*Please fill out this field");
            }
            if (!bodyField.getText().equals("")) {
                bodyFieldError.setText("*Please fill out this field");
            }
        }

    }//GEN-LAST:event_createButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bodyField;
    private javax.swing.JLabel bodyFieldError;
    private javax.swing.JButton createButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> scopeField;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel titleFieldError;
    // End of variables declaration//GEN-END:variables
}