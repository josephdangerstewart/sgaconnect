/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect;

import java.awt.CardLayout;

/**
 *
 * @author josephs12
 */
public class MainView extends javax.swing.JPanel {
    
    private static MainView thisObj;
    
    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        thisObj = this;
    }
    
    public static MainView getInstance() {
        return thisObj;
    }
    
    public void changeView(String card) {
        CardLayout layout = (CardLayout)viewportContainer.getLayout();
        layout.show(viewportContainer, card);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerContainer = new javax.swing.JPanel();
        header1 = new sgaconnect.Header();
        sidebarContainer = new javax.swing.JPanel();
        sidebar1 = new sgaconnect.Sidebar();
        viewportContainer = new javax.swing.JPanel();
        studentMainView2 = new sgaconnect.StudentMainScreen();
        petitionMainScreen1 = new sgaconnect.PetitionMainScreen();
        petitionViewScreen1 = new sgaconnect.PetitionViewScreen();
        senatorMessagesScreen1 = new sgaconnect.SenatorMessagesMain();
        petitionCreationScreen1 = new sgaconnect.PetitionCreationScreen();
        pollMainScreen1 = new sgaconnect.PollMainScreen();

        headerContainer.setBackground(new java.awt.Color(0, 255, 255));
        headerContainer.setForeground(new java.awt.Color(51, 204, 255));

        javax.swing.GroupLayout headerContainerLayout = new javax.swing.GroupLayout(headerContainer);
        headerContainer.setLayout(headerContainerLayout);
        headerContainerLayout.setHorizontalGroup(
            headerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(headerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(header1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE))
        );
        headerContainerLayout.setVerticalGroup(
            headerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
            .addGroup(headerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidebarContainer.setBackground(new java.awt.Color(153, 255, 51));
        sidebarContainer.setLayout(new java.awt.CardLayout());
        sidebarContainer.add(sidebar1, "card3");

        viewportContainer.setBackground(new java.awt.Color(255, 251, 234));
        viewportContainer.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        viewportContainer.setLayout(new java.awt.CardLayout());
        viewportContainer.add(studentMainView2, "studentMainScreen");
        viewportContainer.add(petitionMainScreen1, "petitionMainScreen");
        viewportContainer.add(petitionViewScreen1, "petitionViewScreen");
        viewportContainer.add(senatorMessagesScreen1, "senatorMessagesScreen");
        viewportContainer.add(petitionCreationScreen1, "petitionCreationScreen");
        viewportContainer.add(pollMainScreen1, "pollMainScreen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidebarContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(viewportContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(headerContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sidebarContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addComponent(viewportContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sgaconnect.Header header1;
    private javax.swing.JPanel headerContainer;
    private sgaconnect.PetitionCreationScreen petitionCreationScreen1;
    private sgaconnect.PetitionMainScreen petitionMainScreen1;
    private sgaconnect.PetitionViewScreen petitionViewScreen1;
    private sgaconnect.PollMainScreen pollMainScreen1;
    private sgaconnect.SenatorMessagesMain senatorMessagesScreen1;
    private sgaconnect.Sidebar sidebar1;
    private javax.swing.JPanel sidebarContainer;
    private sgaconnect.StudentMainScreen studentMainView2;
    private javax.swing.JPanel viewportContainer;
    // End of variables declaration//GEN-END:variables
}
