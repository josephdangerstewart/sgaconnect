/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sgaconnect.backend.User;

/**
 *
 * @author josephs12
 */
public class SenatorMainScreen extends javax.swing.JPanel {

    private static SenatorMainScreen thisObj;
    
    private User[] senators;
    int index;
    private String[][] events = {
        {"10/20/17 at 2:03 pm","Your senator posted a poll!","POLL","0"},
        {"10/17/17 at 11:19 am", "Someone signed your petition","PETITION","0"}
    };
    
    /**
     * Creates new form StudentMainView
     */
    public SenatorMainScreen() {
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
        if (type.equals("PETITION")) {
            PetitionViewScreen.getInstance().init(MainFrame.getBackend().getPetitionByID(id));
            MainView.getInstance().changeView("petitionViewScreen");
        }
    }

    public static SenatorMainScreen getInstance() {
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
        senatorEmailDisplay = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        senatorRoomDisplay2 = new javax.swing.JLabel();
        senatorEmailDisplay2 = new javax.swing.JLabel();
        senatorRoomDisplay3 = new javax.swing.JLabel();
        senatorRoomDisplay4 = new javax.swing.JLabel();
        senatorRoomDisplay5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        recentActivityPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recentActivityTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 251, 234));

        senatorPanel.setBackground(new java.awt.Color(255, 251, 234));
        senatorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Constituents", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Print Clearly", 0, 24), new java.awt.Color(153, 150, 148))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel1.setText("Name");
        jLabel1.setPreferredSize(new java.awt.Dimension(159, 17));

        senatorEmailDisplay.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        senatorEmailDisplay.setText("Room Number");
        senatorEmailDisplay.setMaximumSize(new java.awt.Dimension(150, 17));
        senatorEmailDisplay.setMinimumSize(new java.awt.Dimension(150, 17));
        senatorEmailDisplay.setPreferredSize(new java.awt.Dimension(150, 17));

        jButton1.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jButton1.setText("More");

        jLabel6.setText("Filter:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Last Name (ascending)", "Last Name (descending)", "Room Number (ascending)", "Room Number (descending)" }));

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel2.setText("Biola Bob");
        jLabel2.setToolTipText("");
        jLabel2.setPreferredSize(new java.awt.Dimension(107, 17));

        jLabel7.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel7.setText("Wesley Shiozakiiiiiii");
        jLabel7.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel8.setText("Barry Corey");
        jLabel8.setToolTipText("");
        jLabel8.setPreferredSize(new java.awt.Dimension(107, 17));

        senatorRoomDisplay2.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        senatorRoomDisplay2.setText("316");

        senatorEmailDisplay2.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        senatorEmailDisplay2.setText("Year");
        senatorEmailDisplay2.setMaximumSize(new java.awt.Dimension(150, 17));
        senatorEmailDisplay2.setMinimumSize(new java.awt.Dimension(150, 17));
        senatorEmailDisplay2.setPreferredSize(new java.awt.Dimension(150, 17));

        senatorRoomDisplay3.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        senatorRoomDisplay3.setText("Junior");
        senatorRoomDisplay3.setToolTipText("");

        senatorRoomDisplay4.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        senatorRoomDisplay4.setText("Sophomore");

        senatorRoomDisplay5.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        senatorRoomDisplay5.setText("Senior");

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel3.setText("Biola Bob");
        jLabel3.setToolTipText("");
        jLabel3.setPreferredSize(new java.awt.Dimension(107, 17));

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel4.setText("Biola Bob");
        jLabel4.setToolTipText("");
        jLabel4.setPreferredSize(new java.awt.Dimension(107, 17));

        javax.swing.GroupLayout senatorPanelLayout = new javax.swing.GroupLayout(senatorPanel);
        senatorPanel.setLayout(senatorPanelLayout);
        senatorPanelLayout.setHorizontalGroup(
            senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(senatorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(senatorPanelLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jButton1))
                    .addGroup(senatorPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(senatorPanelLayout.createSequentialGroup()
                        .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(senatorPanelLayout.createSequentialGroup()
                                .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(senatorEmailDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(senatorRoomDisplay2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(senatorRoomDisplay5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(senatorRoomDisplay3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(senatorPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(senatorRoomDisplay4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(senatorEmailDisplay2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(56, 56, 56))
        );
        senatorPanelLayout.setVerticalGroup(
            senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, senatorPanelLayout.createSequentialGroup()
                .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senatorEmailDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senatorEmailDisplay2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(senatorRoomDisplay4)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(senatorRoomDisplay3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senatorRoomDisplay2)
                    .addComponent(senatorRoomDisplay5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jButton1))
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
        recentActivityTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        recentActivityPanelLayout.setVerticalGroup(
            recentActivityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(recentActivityPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(senatorPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel recentActivityPanel;
    private javax.swing.JTable recentActivityTable;
    private javax.swing.JLabel senatorEmailDisplay;
    private javax.swing.JLabel senatorEmailDisplay2;
    private javax.swing.JPanel senatorPanel;
    private javax.swing.JLabel senatorRoomDisplay2;
    private javax.swing.JLabel senatorRoomDisplay3;
    private javax.swing.JLabel senatorRoomDisplay4;
    private javax.swing.JLabel senatorRoomDisplay5;
    // End of variables declaration//GEN-END:variables
}
