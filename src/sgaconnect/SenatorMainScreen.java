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
import sgaconnect.backend.MessageThread;
import sgaconnect.backend.User;
import sgaconnect.backend.Util;

/**
 *
 * @author josephs12
 */
public class SenatorMainScreen extends javax.swing.JPanel {

    private static SenatorMainScreen thisObj;
    
    private MessageThread[] threads;
    private User[] senators;
    int index;
    private String[][] events = {
        {"10/20/17 at 2:03 pm","You posted a poll!","POLL","0"},
        {"10/17/17 at 11:19 am", "A petition is getting popular!","PETITION","0"}
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
    
    public void init() {
        threads = MainFrame.getBackend().getAllMessageThreads(MainFrame.getBackend().getLoggedInUser().getID());
        
        for (int i = 0; i < threads.length; i++) {
            long max = Long.MIN_VALUE;
            int maxIndex = 0;
            for (int j = threads.length-1; j >= i; j--) {
                long mostRecent = threads[j].getMostRecentMessage().getTimestamp();
                if (mostRecent > max) {
                    max = mostRecent;
                    maxIndex = j;
                }
            }
            
            MessageThread temp = threads[maxIndex];
            threads[maxIndex] = threads[i];
            threads[i] = temp;
        }
        
        DefaultTableModel messagesModel = (DefaultTableModel) messagesTable.getModel();
        messagesModel.setRowCount(threads.length);
        
        for (int i = 0; i < threads.length; i++) {
            messagesModel.setValueAt(Util.getDateFromMili(threads[i].getMostRecentMessage().getTimestamp()), i, 0);
            messagesModel.setValueAt(MainFrame.getBackend().getUserByID(threads[i].getMostRecentMessage().getFrom()), i, 1);
            messagesModel.setValueAt(threads[i].getSubject(),i,2);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        messagesTable = new javax.swing.JTable();
        recentActivityPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recentActivityTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 251, 234));

        senatorPanel.setBackground(new java.awt.Color(255, 251, 234));
        senatorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inbox", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Print Clearly", 1, 24), new java.awt.Color(23, 47, 86))); // NOI18N

        jScrollPane2.setBackground(new java.awt.Color(255, 251, 234));

        messagesTable.setBackground(new java.awt.Color(221, 209, 199));
        messagesTable.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        messagesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null},
                {"", null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date/Time", "Sender", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        messagesTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        messagesTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        messagesTable.setFillsViewportHeight(true);
        messagesTable.setGridColor(new java.awt.Color(255, 255, 255));
        messagesTable.setRowSelectionAllowed(false);
        messagesTable.setShowHorizontalLines(false);
        messagesTable.setShowVerticalLines(false);
        messagesTable.getTableHeader().setReorderingAllowed(false);
        messagesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messagesTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                messagesTableMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(messagesTable);
        if (messagesTable.getColumnModel().getColumnCount() > 0) {
            messagesTable.getColumnModel().getColumn(0).setPreferredWidth(21);
            messagesTable.getColumnModel().getColumn(1).setPreferredWidth(21);
        }

        javax.swing.GroupLayout senatorPanelLayout = new javax.swing.GroupLayout(senatorPanel);
        senatorPanel.setLayout(senatorPanelLayout);
        senatorPanelLayout.setHorizontalGroup(
            senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
        senatorPanelLayout.setVerticalGroup(
            senatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        recentActivityPanel.setBackground(new java.awt.Color(255, 251, 234));
        recentActivityPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recent Activity", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Print Clearly", 1, 24), new java.awt.Color(23, 47, 86))); // NOI18N

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
            recentActivityTable.getColumnModel().getColumn(0).setPreferredWidth(21);
            recentActivityTable.getColumnModel().getColumn(1).setPreferredWidth(21);
        }

        javax.swing.GroupLayout recentActivityPanelLayout = new javax.swing.GroupLayout(recentActivityPanel);
        recentActivityPanel.setLayout(recentActivityPanelLayout);
        recentActivityPanelLayout.setHorizontalGroup(
            recentActivityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
        recentActivityPanelLayout.setVerticalGroup(
            recentActivityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(recentActivityPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(senatorPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void recentActivityTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recentActivityTableMouseEntered
    }//GEN-LAST:event_recentActivityTableMouseEntered

    private void recentActivityTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recentActivityTableMouseClicked
        try {
            JTable source = (JTable)evt.getSource();
            Point point = evt.getPoint();
            int row = source.rowAtPoint(point);
            String type = events[row][2];
            int id = Integer.parseInt(events[row][3]);
            navigateToEvent(type,id);
        } catch (Exception e) {
            //Do nothing
        }
    }//GEN-LAST:event_recentActivityTableMouseClicked

    private void messagesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messagesTableMouseClicked
        try {
            JTable source = (JTable)evt.getSource();
            Point point = evt.getPoint();
            int row = source.rowAtPoint(point);
            SenatorMessagesView.getInstance().init(threads[row]);
            MainView.getInstance().changeView("senatorMessagesView");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_messagesTableMouseClicked

    private void messagesTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messagesTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_messagesTableMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable messagesTable;
    private javax.swing.JPanel recentActivityPanel;
    private javax.swing.JTable recentActivityTable;
    private javax.swing.JPanel senatorPanel;
    // End of variables declaration//GEN-END:variables
}
