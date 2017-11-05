/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton.ToggleButtonModel;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import sgaconnect.backend.Backend;
import sgaconnect.backend.Poll;
import sgaconnect.backend.PollResponse;
import sgaconnect.backend.User;

/**
 *
 * @author josephs12
 */
public class PollViewScreen extends javax.swing.JPanel {

    private static PollViewScreen thisObj;
    private Poll poll;
    
    /**
     * Creates new form PollViewScreen
     */
    public PollViewScreen() {
        initComponents();
        thisObj = this;
    }
    
    public static PollViewScreen getInstance() {
        return thisObj;
    }
    
    public void init(Poll poll) {
        
        User user = MainFrame.getBackend().getLoggedInUser();
        this.poll = poll;
        
        if (user.getRole() == 0 && !poll.isLocked()) {
            initRespondView();
        } else if (poll.isLocked() && user.getRole() == 0) {
            initLockedView(user);
        } else {
            initCreatorView(user);
        }
    }
    
    private void initCreatorView(User user) {
        CardLayout layout = (CardLayout)this.getLayout();
        layout.show(this,"creatorView");
        if (user.getID() != poll.getCreatorId()) {
            tabPane.remove(editPanel);
        }
        setShowing(false);
        setResultsTable();
    }
    
    private void setResultsTable() {
        String group = (String)groupComboBox.getSelectedItem();
        
        ArrayList<String> options = poll.getOptions();
        ArrayList<PollResponse> responses = poll.getResponses();
        int[] breakdown = new int[options.size()];
        int responseCount = 0;
        
        if (group.equals("All")) {
            
            for (int i = 0; i < responses.size(); i++) {
                for (int j = 0; j < options.size(); j++) {
                    if (responses.get(i).getResponse().equals(options.get(j))) {
                        breakdown[j]++;
                        responseCount++;
                    }
                }
            }
            
        } else if (group.equals("Year")) {
            
            String showing = (String)showingComboBox.getSelectedItem();
            for (int i = 0; i < responses.size(); i++) {
                if (MainFrame.getBackend().getUserByID(responses.get(i).getID()).getYearString().equals(showing)) {
                    for (int j = 0; j < options.size(); j++) {
                        if (responses.get(i).getResponse().equals(options.get(j))) {
                            breakdown[j]++;
                            responseCount++;
                        }
                    }
                }
            }
            
        } else if (group.equals("Dorm")) {
            
            String showing = (String)showingComboBox.getSelectedItem();
            for (int i = 0; i < responses.size(); i++) {
                if (MainFrame.getBackend().getUserByID(responses.get(i).getID()).getDorm().equals(showing)) {
                    for (int j = 0; j < options.size(); j++) {
                        if (responses.get(i).getResponse().equals(options.get(j))) {
                            breakdown[j]++;
                            responseCount++;
                        }
                    }
                }
            }
            
        }
        
        DefaultTableModel model = (DefaultTableModel) resultsTable.getModel();
        
        model.setColumnCount(options.size());
        
        for (int i = 0; i < options.size(); i++) {
            model.setValueAt(options.get(i), i, 0);
            model.setValueAt(breakdown[i],i,1);
            model.setValueAt(toPercent((double)breakdown[i]/(double)responseCount),i,2);
        }
        
        setMajority(options,breakdown,responseCount);
    }
    
    private void setMajority(ArrayList<String> options, int[] breakdown, int responseCount) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        
        for (int i = 0; i < breakdown.length; i++) {
            if (breakdown[i] > max) {
                maxIndex = i;
                max = breakdown[i];
            }
        }
        
        majorityLabel.setText("Majority: \"" + options.get(maxIndex) + "\" " + toPercent((double)breakdown[maxIndex]/(double)responseCount));
    }
    
    private String toPercent(double num) {
        return ((int)(num*10000)/100)+"%";
   }
    
    private void initLockedView(User user) {
        CardLayout layout = (CardLayout)this.getLayout();
            layout.show(this, "lockedView");
            if (user.getRole() == 0 || (user.getRole() == 1 && user.getID() != poll.getCreatorId())) {
                lockedView.remove(unlockButton);
            }
    }
    
    private void initRespondView() {
        //create font
        Font bodyFont = new Font("Open Sans", 0, 13);

        //set question and poll id
        pollID.setText("Poll #" + poll.getID());
        question.setText("Q. " + poll.getQuestion());

        //Empty the radio group container
        radioContainer.removeAll();
        Enumeration<AbstractButton> buts = optionGroup.getElements();
        while (buts.hasMoreElements()) {
            AbstractButton element = buts.nextElement();
            optionGroup.remove(element);
        }

        //Create lists, get layout, and make horizontal and vertical groupings
        ArrayList<String> pollOptions = poll.getOptions();
        JRadioButton[] radioButtons = new JRadioButton[pollOptions.size()];
        GroupLayout radioContainerLayout = (GroupLayout) radioContainer.getLayout();

        GroupLayout.ParallelGroup horizontalRadioButtonGroup = radioContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        GroupLayout.SequentialGroup verticalRadioButtonGroup = radioContainerLayout.createSequentialGroup().addContainerGap();

        //iterate through poll options
        for (int i = 0; i < pollOptions.size(); i++) {
            //create radio button for poll option i and put it in array
            radioButtons[i] = new JRadioButton();
            radioButtons[i].setFont(bodyFont);
            radioButtons[i].setBackground(new Color(255, 251, 234));
            radioButtons[i].setText(pollOptions.get(i));
            optionGroup.add(radioButtons[i]);

            //add new radio button to horizontal and vertical group
            horizontalRadioButtonGroup.addComponent(radioButtons[i]);
            verticalRadioButtonGroup.addComponent(radioButtons[i]);
            if (i != pollOptions.size()) {
                verticalRadioButtonGroup.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
            }

        }

        //Add all buttons to the layout
        radioContainerLayout.setHorizontalGroup(
            radioContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(radioContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(horizontalRadioButtonGroup)
                .addContainerGap(0, Short.MAX_VALUE))
        );
        radioContainerLayout.setVerticalGroup(
            radioContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verticalRadioButtonGroup
                .addContainerGap(0, Short.MAX_VALUE))
        );
        CardLayout layout = (CardLayout)this.getLayout();
        layout.show(this,"respondView");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optionGroup = new javax.swing.ButtonGroup();
        respondView = new javax.swing.JPanel();
        pollID = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        question = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        radioContainer = new javax.swing.JPanel();
        submitButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lockedView = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        unlockButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        creatorView = new javax.swing.JPanel();
        tabPane = new javax.swing.JTabbedPane();
        editPanel = new javax.swing.JPanel();
        responsesPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        groupComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultsTable = new javax.swing.JTable();
        showingLabel = new javax.swing.JLabel();
        showingComboBox = new javax.swing.JComboBox<>();
        majorityLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 251, 234));
        setLayout(new java.awt.CardLayout());

        respondView.setBackground(new java.awt.Color(255, 251, 234));

        pollID.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        pollID.setForeground(new java.awt.Color(153, 150, 148));
        pollID.setText("Poll #");

        jScrollPane3.setBorder(null);

        question.setEditable(false);
        question.setBackground(new java.awt.Color(255, 251, 234));
        question.setColumns(20);
        question.setFont(new java.awt.Font("Print Clearly", 0, 28)); // NOI18N
        question.setLineWrap(true);
        question.setText("Q. ");
        question.setWrapStyleWord(true);
        question.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        question.setDragEnabled(true);
        question.setFocusable(false);
        jScrollPane3.setViewportView(question);

        jScrollPane4.setBackground(new java.awt.Color(255, 251, 234));
        jScrollPane4.setBorder(null);

        radioContainer.setBackground(new java.awt.Color(255, 251, 234));

        javax.swing.GroupLayout radioContainerLayout = new javax.swing.GroupLayout(radioContainer);
        radioContainer.setLayout(radioContainerLayout);
        radioContainerLayout.setHorizontalGroup(
            radioContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 647, Short.MAX_VALUE)
        );
        radioContainerLayout.setVerticalGroup(
            radioContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(radioContainer);

        submitButton.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout respondViewLayout = new javax.swing.GroupLayout(respondView);
        respondView.setLayout(respondViewLayout);
        respondViewLayout.setHorizontalGroup(
            respondViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(respondViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(respondViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(respondViewLayout.createSequentialGroup()
                        .addComponent(pollID)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(respondViewLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(submitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(respondViewLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, respondViewLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        respondViewLayout.setVerticalGroup(
            respondViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(respondViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pollID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(respondViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submitButton)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        add(respondView, "respondView");

        lockedView.setBackground(new java.awt.Color(255, 251, 234));

        jLabel1.setFont(new java.awt.Font("Print Clearly", 0, 48)); // NOI18N
        jLabel1.setText("This Poll Is");

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 54)); // NOI18N
        jLabel2.setText("LOCKED");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgaconnect/resources/Images/lock_icon.png"))); // NOI18N

        unlockButton.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        unlockButton.setText("Unlock It");
        unlockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unlockButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lockedViewLayout = new javax.swing.GroupLayout(lockedView);
        lockedView.setLayout(lockedViewLayout);
        lockedViewLayout.setHorizontalGroup(
            lockedViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lockedViewLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lockedViewLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(unlockButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lockedViewLayout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap(167, Short.MAX_VALUE))
            .addGroup(lockedViewLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lockedViewLayout.setVerticalGroup(
            lockedViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lockedViewLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(lockedViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unlockButton)
                    .addComponent(backButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(lockedView, "lockedView");

        creatorView.setBackground(new java.awt.Color(255, 251, 234));

        tabPane.setBackground(new java.awt.Color(255, 51, 51));

        editPanel.setBackground(new java.awt.Color(255, 251, 234));

        javax.swing.GroupLayout editPanelLayout = new javax.swing.GroupLayout(editPanel);
        editPanel.setLayout(editPanelLayout);
        editPanelLayout.setHorizontalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 679, Short.MAX_VALUE)
        );
        editPanelLayout.setVerticalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );

        tabPane.addTab("Edit", editPanel);

        responsesPanel.setBackground(new java.awt.Color(255, 251, 234));

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel4.setText("Group Responses By:");

        groupComboBox.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        groupComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Year", "Dorm" }));
        groupComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupComboBoxActionPerformed(evt);
            }
        });

        resultsTable.setBackground(new java.awt.Color(255, 251, 234));
        resultsTable.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        resultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Response", "Count", "Percent"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resultsTable.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(resultsTable);

        showingLabel.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        showingLabel.setText("Showing:");

        showingComboBox.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        showingComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Freshmen", "Sophmore", "Junior", "Senior" }));
        showingComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showingComboBoxActionPerformed(evt);
            }
        });

        majorityLabel.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        majorityLabel.setText("Majority:");

        jButton1.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jButton1.setText("Export Responses");

        javax.swing.GroupLayout responsesPanelLayout = new javax.swing.GroupLayout(responsesPanel);
        responsesPanel.setLayout(responsesPanelLayout);
        responsesPanelLayout.setHorizontalGroup(
            responsesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(responsesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(responsesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addGroup(responsesPanelLayout.createSequentialGroup()
                        .addGroup(responsesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(responsesPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(groupComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(responsesPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(showingLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(showingComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(responsesPanelLayout.createSequentialGroup()
                        .addComponent(majorityLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        responsesPanelLayout.setVerticalGroup(
            responsesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, responsesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(responsesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(groupComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(responsesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showingLabel)
                    .addComponent(showingComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(responsesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(majorityLabel)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        tabPane.addTab("Responses", responsesPanel);

        javax.swing.GroupLayout creatorViewLayout = new javax.swing.GroupLayout(creatorView);
        creatorView.setLayout(creatorViewLayout);
        creatorViewLayout.setHorizontalGroup(
            creatorViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane)
        );
        creatorViewLayout.setVerticalGroup(
            creatorViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane)
        );

        add(creatorView, "creatorView");
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        try {
            if(optionGroup.getSelection() != null) {
                Enumeration<AbstractButton> buttons = optionGroup.getElements();
                while(buttons.hasMoreElements()) {
                    JRadioButton element = (JRadioButton)buttons.nextElement();
                    if (element.isSelected()) {
                        System.out.println("Trying to respond");
                        poll.respond(MainFrame.getBackend().getLoggedInUser().getID(), element.getText());
                        MainFrame.getBackend().save(poll);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        PollMainScreen.getInstance().init();
        MainView.getInstance().changeView("pollMainScreen");
    }//GEN-LAST:event_backButtonActionPerformed

    private void unlockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unlockButtonActionPerformed
        if (MainFrame.getBackend().getLoggedInUser().getID() == poll.getCreatorId()) {
            poll.setLocked(false);
            MainFrame.getBackend().save(poll);
        }
    }//GEN-LAST:event_unlockButtonActionPerformed

    private void setShowing(boolean showing) {
        showingLabel.setVisible(showing);
        showingComboBox.setVisible(showing);
    }
    
    private void setGroupData(String[] data) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) showingComboBox.getModel();
        
        model.removeAllElements();
        
        for (int i = 0; i < data.length; i++) {
            model.addElement(data[i]);
        }
    }
    
    private void groupComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupComboBoxActionPerformed
        String group = (String)groupComboBox.getSelectedItem();
        
        if (group.equals("All")) {
            setShowing(false);
            setResultsTable();
        } else if (group.equals("Year")) {
            setShowing(true);
            setGroupData(Backend.getYears());
        } else if (group.equals("Dorm")) {
            setShowing(true);
            setGroupData(Backend.getDorms());
        }
    }//GEN-LAST:event_groupComboBoxActionPerformed

    private void showingComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showingComboBoxActionPerformed
        setResultsTable();
    }//GEN-LAST:event_showingComboBoxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PollMainScreen.getInstance().init();
        MainView.getInstance().changeView("pollMainScreen");
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel creatorView;
    private javax.swing.JPanel editPanel;
    private javax.swing.JComboBox<String> groupComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel lockedView;
    private javax.swing.JLabel majorityLabel;
    private javax.swing.ButtonGroup optionGroup;
    private javax.swing.JLabel pollID;
    private javax.swing.JTextArea question;
    private javax.swing.JPanel radioContainer;
    private javax.swing.JPanel respondView;
    private javax.swing.JPanel responsesPanel;
    private javax.swing.JTable resultsTable;
    private javax.swing.JComboBox<String> showingComboBox;
    private javax.swing.JLabel showingLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JButton unlockButton;
    // End of variables declaration//GEN-END:variables
}
