/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton.ToggleButtonModel;
import javax.swing.LayoutStyle;
import javax.swing.text.html.HTMLEditorKit;
import sgaconnect.backend.Poll;
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
        editPane.setContentType("text/html");
        HTMLEditorKit kit = new HTMLEditorKit();
        editPane.setEditorKit(kit);
        editPane.setText("<html><head></head><body><p>Hello World!</p></body></html>");
        thisObj = this;
    }
    
    public static PollViewScreen getInstance() {
        return thisObj;
    }
    
    public void init(Poll poll) {
        
        User user = MainFrame.getBackend().getLoggedInUser();
        this.poll = poll;
        
        if (user.getRole() == 0 && !poll.isLocked()) {
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
        } else if (poll.isLocked() && user.getRole() == 0) {
            CardLayout layout = (CardLayout)this.getLayout();
            layout.show(this, "lockedView");
            if (user.getRole() == 0 || (user.getRole() == 1 && user.getID() != poll.getCreatorId())) {
                lockedView.remove(unlockButton);
            }
        } else {
            CardLayout layout = (CardLayout)this.getLayout();
            layout.show(this,"creatorView");
            if (user.getID() != poll.getCreatorId()) {
                tabPane.remove(editPanel);
            }
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

        optionGroup = new javax.swing.ButtonGroup();
        respondView = new javax.swing.JPanel();
        pollID = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        question = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        radioContainer = new javax.swing.JPanel();
        submitButton = new javax.swing.JButton();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        editPane = new javax.swing.JEditorPane();

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
            .addGap(0, 617, Short.MAX_VALUE)
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

        javax.swing.GroupLayout respondViewLayout = new javax.swing.GroupLayout(respondView);
        respondView.setLayout(respondViewLayout);
        respondViewLayout.setHorizontalGroup(
            respondViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(respondViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(respondViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(respondViewLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE))
                    .addGroup(respondViewLayout.createSequentialGroup()
                        .addComponent(pollID)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(respondViewLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(respondViewLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(submitButton)
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

        editPane.setEditable(false);
        editPane.setBackground(new java.awt.Color(255, 251, 234));
        editPane.setText("<html>\n\t<h1>Does this work at all</h1>\n\t<button>Maybe it does, maybe it doesn't</button>\n</html>");
        jScrollPane1.setViewportView(editPane);

        javax.swing.GroupLayout responsesPanelLayout = new javax.swing.GroupLayout(responsesPanel);
        responsesPanel.setLayout(responsesPanelLayout);
        responsesPanelLayout.setHorizontalGroup(
            responsesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(responsesPanelLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        responsesPanelLayout.setVerticalGroup(
            responsesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, responsesPanelLayout.createSequentialGroup()
                .addContainerGap(189, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel creatorView;
    private javax.swing.JEditorPane editPane;
    private javax.swing.JPanel editPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel lockedView;
    private javax.swing.ButtonGroup optionGroup;
    private javax.swing.JLabel pollID;
    private javax.swing.JTextArea question;
    private javax.swing.JPanel radioContainer;
    private javax.swing.JPanel respondView;
    private javax.swing.JPanel responsesPanel;
    private javax.swing.JButton submitButton;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JButton unlockButton;
    // End of variables declaration//GEN-END:variables
}
