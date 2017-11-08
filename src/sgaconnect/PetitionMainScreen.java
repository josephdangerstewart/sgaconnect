/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect;

import java.awt.Point;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

/**
 *
 * @author josephs12
 */
public class PetitionMainScreen extends javax.swing.JPanel {

    private static PetitionMainScreen thisObj;
    
    private JSONObject[] petitions;
    
    /**
     * Creates new form PetitionMainScreen
     */
    public PetitionMainScreen() {
        initComponents();
        thisObj = this;
    }
    
    public static PetitionMainScreen getInstance() {
        return thisObj;
    }
    
    public void init() {
        petitions = MainFrame.getBackend().getAllPetitions(MainFrame.getBackend().getLoggedInUser());
        
        DefaultTableModel model = (DefaultTableModel)petitionsTable.getModel();
        model.setRowCount(petitions.length);
        
        for (int row = 0; row < model.getRowCount(); row++) {
            model.setValueAt(petitions[row].getString("creator"), row, 0);
            model.setValueAt(petitions[row].getString("title"),row,1);
            model.setValueAt(petitions[row].getInt("signerCount"), row, 2);
        }
        
        if (MainFrame.getBackend().getLoggedInUser().getRole() != 0) {
            this.remove(createNewButton);
            selectOneLabel.setText("Select one");
        }
    }

    private void navigateToPetition(int id) {
        System.out.println("Navigating to petition " + id);
        PetitionViewScreen.getInstance().init(MainFrame.getBackend().getPetitionByID(id));
        MainView.getInstance().changeView("petitionViewScreen");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        petitionsTable = new javax.swing.JTable();
        createNewButton = new javax.swing.JButton();
        selectOneLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 251, 234));

        jLabel1.setFont(new java.awt.Font("Steelfish Outline", 1, 54)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(142, 15, 22));
        jLabel1.setText("Petitions");

        petitionsTable.setBackground(new java.awt.Color(221, 209, 199));
        petitionsTable.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        petitionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Creator", "Title", "Signers"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        petitionsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        petitionsTable.setFillsViewportHeight(true);
        petitionsTable.setInheritsPopupMenu(true);
        petitionsTable.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        petitionsTable.setMinimumSize(new java.awt.Dimension(60, 62));
        petitionsTable.setSelectionBackground(new java.awt.Color(221, 209, 199));
        petitionsTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        petitionsTable.setShowVerticalLines(false);
        petitionsTable.getTableHeader().setReorderingAllowed(false);
        petitionsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                petitionsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(petitionsTable);
        petitionsTable.getAccessibleContext().setAccessibleName("Petitions Table");

        createNewButton.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        createNewButton.setMnemonic('r');
        createNewButton.setText("Create New");
        createNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewButtonActionPerformed(evt);
            }
        });

        selectOneLabel.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        selectOneLabel.setText("Select One or ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(selectOneLabel)
                        .addGap(0, 0, 0)
                        .addComponent(createNewButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createNewButton)
                    .addComponent(selectOneLabel))
                .addContainerGap())
        );

        createNewButton.getAccessibleContext().setAccessibleName("Create New Petition");
    }// </editor-fold>//GEN-END:initComponents

    private void petitionsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petitionsTableMouseClicked
        try {
            JTable source = (JTable)evt.getSource();
            Point point = evt.getPoint();
            int row = source.rowAtPoint(point);
            navigateToPetition(petitions[row].getInt("id"));
        } catch (Exception e) {
            //Do nothing
        }
    }//GEN-LAST:event_petitionsTableMouseClicked

    private void createNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewButtonActionPerformed
        PetitionCreationScreen.getInstance().init();
        MainView.getInstance().changeView("petitionCreationScreen");
    }//GEN-LAST:event_createNewButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createNewButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable petitionsTable;
    private javax.swing.JLabel selectOneLabel;
    // End of variables declaration//GEN-END:variables
}
