/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect;

import java.awt.Cursor;
import java.awt.Point;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;
import sgaconnect.backend.Poll;

/**
 *
 * @author josephs12
 */
public class PollMainScreen extends javax.swing.JPanel {
    
    private static PollMainScreen thisObj;
    private JSONObject[] polls;
    
    /**
     * Creates new form PollMainScreen
     */
    public PollMainScreen() {
        initComponents();
        thisObj = this;
    }
    
    public static PollMainScreen getInstance() {
        return thisObj;
    }
    
    public void init() {
        JSONObject[] allPolls = MainFrame.getBackend().getAllPolls();
        this.polls = allPolls;
        
        DefaultTableModel model = (DefaultTableModel)pollsTable.getModel();
        model.setRowCount(allPolls.length);
        
        for (int i = 0; i < allPolls.length; i++ ) {
            model.setValueAt(allPolls[i].getString("creator"), i, 0);
            model.setValueAt(allPolls[i].getString("question"), i, 1);
        }
        
        if (MainFrame.getBackend().getLoggedInUser().getRole() == 0) {
            this.remove(createPollButton);
            guideLabel.setText("Select One");
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pollsTable = new javax.swing.JTable();
        guideLabel = new javax.swing.JLabel();
        createPollButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 251, 234));

        jLabel1.setFont(new java.awt.Font("Steelfish Outline", 1, 54)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(163, 22, 33));
        jLabel1.setText("Polls");

        pollsTable.setBackground(new java.awt.Color(221, 209, 199));
        pollsTable.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        pollsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Creator", "Question"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pollsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pollsTable.setFillsViewportHeight(true);
        pollsTable.setSelectionBackground(new java.awt.Color(221, 209, 199));
        pollsTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        pollsTable.setShowVerticalLines(false);
        pollsTable.getTableHeader().setReorderingAllowed(false);
        pollsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pollsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pollsTable);
        if (pollsTable.getColumnModel().getColumnCount() > 0) {
            pollsTable.getColumnModel().getColumn(0).setResizable(false);
            pollsTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        }
        pollsTable.getAccessibleContext().setAccessibleName("All Polls (Table)");

        guideLabel.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        guideLabel.setText("Select One or ");

        createPollButton.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        createPollButton.setMnemonic('c');
        createPollButton.setText("Create New");
        createPollButton.setToolTipText("");
        createPollButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createPollButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                createPollButtonMouseMoved(evt);
            }
        });
        createPollButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPollButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(guideLabel)
                        .addGap(0, 0, 0)
                        .addComponent(createPollButton)
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
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guideLabel)
                    .addComponent(createPollButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pollsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pollsTableMouseClicked
        try {
            JTable source = (JTable)evt.getSource();
            Point point = evt.getPoint();
            int row = source.rowAtPoint(point);
            navigateToPoll(polls[row].getInt("id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_pollsTableMouseClicked

    private void createPollButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createPollButtonMouseMoved
        // TODO add your handling code here:
        //change to click mouse
        Cursor click = new Cursor(Cursor.HAND_CURSOR);
        createPollButton.setCursor(click);
    }//GEN-LAST:event_createPollButtonMouseMoved

    private void createPollButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPollButtonActionPerformed
        if (MainFrame.getBackend().getLoggedInUser().getRole() != 0) {
            PollViewScreen.getInstance().init(
                    new Poll(MainFrame.getBackend().getNextPollId()
                    ,MainFrame.getBackend().getLoggedInUser().getID()
                    ));
            MainView.getInstance().changeView("pollViewScreen");
        }

    }//GEN-LAST:event_createPollButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createPollButton;
    private javax.swing.JLabel guideLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable pollsTable;
    // End of variables declaration//GEN-END:variables

    private void navigateToPoll(int id) {
        System.out.println("Navigating to POLL " + id);
        PollViewScreen.getInstance().init(MainFrame.getBackend().getPollByID(id));
        MainView.getInstance().changeView("pollViewScreen");
    }
}
