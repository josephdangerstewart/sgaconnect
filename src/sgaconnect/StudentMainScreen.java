/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sgaconnect.backend.User;

/**
 *
 * @author josephs12
 */
public class StudentMainScreen extends javax.swing.JPanel {

    private static StudentMainScreen thisObj;
    
    private User[] senators;
    int index;
    private String[][] events = {
        {"10/20/17 at 2:03 pm","Your senator posted a poll!","POLL","0"},
        {"10/17/17 at 11:19 am", "Someone signed your petition","PETITION","0"}
    };
    
    /**
     * Creates new form StudentMainView
     */
    public StudentMainScreen() {
        this.thisObj = this;
        initComponents();
        recentActivityTable.getTableHeader().setFont(new Font("Open Sans",Font.PLAIN,12));
        initTable();
    }
    
    private void initTable() {
        DefaultTableModel model = (DefaultTableModel)recentActivityTable
                .getModel();
        
        model.setNumRows(events.length);
        for (int row = 0; row < model.getRowCount(); row++) {
            model.setValueAt(events[row][0], row, 0);
            model.setValueAt(events[row][1], row, 1);
        }
    }
    
    private void navigateToEvent(String type, int id) {
        System.out.println("Navigating to " + type + " " + id);
    }

    public static StudentMainScreen getInstance() {
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
            indexDisplay.setText((index + 1) + "/"+senators.length);
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
        indexDisplay = new javax.swing.JLabel();
        recentActivityPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recentActivityTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 251, 234));

        senatorPanel.setBackground(new java.awt.Color(255, 251, 234));
        senatorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Your Senator(s)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Print Clearly", 0, 24), new java.awt.Color(153, 150, 148))); // NOI18N

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

        indexDisplay.setFont(new java.awt.Font("Open Sans", 0, 10)); // NOI18N
        indexDisplay.setText("0/0");

        javax.swing.GroupLayout senatorPanelLayout = new javax.swing.GroupLayout(senatorPanel);
        senatorPanel.setLayout(senatorPanelLayout);
        senatorPanelLayout.setHorizontalGroup(
            senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(senatorMajorDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(senatorPanelLayout.createSequentialGroup()
                        .addComponent(previousButton)
                        .addGap(143, 143, 143)
                        .addComponent(indexDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nextButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        senatorPanelLayout.setVerticalGroup(
            senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, senatorPanelLayout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
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
                            .addComponent(previousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(indexDisplay)))))
        );

        recentActivityPanel.setBackground(new java.awt.Color(255, 251, 234));
        recentActivityPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recent Activity", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Print Clearly", 0, 24), new java.awt.Color(153, 150, 148))); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(255, 251, 234));

        recentActivityTable.setBackground(new java.awt.Color(221, 209, 199));
        recentActivityTable.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        recentActivityTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null},
                {"", null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Time", "Event (Click for More)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        recentActivityTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        recentActivityTable.setFillsViewportHeight(true);
        recentActivityTable.setGridColor(new java.awt.Color(255, 251, 234));
        recentActivityTable.setRowSelectionAllowed(false);
        recentActivityTable.setShowHorizontalLines(false);
        recentActivityTable.setShowVerticalLines(false);
        recentActivityTable.getTableHeader().setReorderingAllowed(false);
        recentActivityTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recentActivityTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                recentActivityTableMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(recentActivityTable);
        if (recentActivityTable.getColumnModel().getColumnCount() > 0) {
            recentActivityTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            recentActivityTable.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout recentActivityPanelLayout = new javax.swing.GroupLayout(recentActivityPanel);
        recentActivityPanel.setLayout(recentActivityPanelLayout);
        recentActivityPanelLayout.setHorizontalGroup(
            recentActivityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
        recentActivityPanelLayout.setVerticalGroup(
            recentActivityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
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

    private void recentActivityTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recentActivityTableMouseEntered
    }//GEN-LAST:event_recentActivityTableMouseEntered

    private void recentActivityTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recentActivityTableMouseClicked
        try {
            JTable source = (JTable)evt.getSource();
            Point point = evt.getPoint();
            int column = source.columnAtPoint(point);
            if (column == 1) {
                int row = source.rowAtPoint(point);
                String type = events[row][2];
                int id = Integer.parseInt(events[row][3]);
                navigateToEvent(type,id);
            }
        } catch (Exception e) {
            //Do nothing
        }
    }//GEN-LAST:event_recentActivityTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel indexDisplay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JPanel recentActivityPanel;
    private javax.swing.JTable recentActivityTable;
    private javax.swing.JLabel senatorEmailDisplay;
    private javax.swing.JLabel senatorMajorDisplay;
    private javax.swing.JLabel senatorNameDisplay;
    private javax.swing.JPanel senatorPanel;
    private javax.swing.JLabel senatorRoomDisplay;
    private javax.swing.JLabel senatorYearDisplay;
    // End of variables declaration//GEN-END:variables
}