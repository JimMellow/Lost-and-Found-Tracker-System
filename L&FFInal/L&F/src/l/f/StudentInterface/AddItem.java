/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package l.f.StudentInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import l.f.*;

public class AddItem extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AddItem.class.getName());

    /**
     * Creates new form Dashboard
     */
    public AddItem() {
        initComponents();
    }

    private void clearFields() {
        itemName.setText("");
        itemColor.setText("");
        descriptionArea.setText("");
        locationFound.setText("");
        dateReported.setText("");
        contactNo.setText("");
        statusComboBox.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        logoPanel = new javax.swing.JPanel();
        logoName = new javax.swing.JLabel();
        clientName = new javax.swing.JLabel();
        logoLabel1 = new javax.swing.JLabel();
        navPanel = new javax.swing.JPanel();
        dashboardButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        clientName3 = new javax.swing.JLabel();
        logoutbutton = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        logoName1 = new javax.swing.JLabel();
        dashboardContentPanel = new javax.swing.JPanel();
        logoLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemName = new javax.swing.JTextArea();
        logoLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dateReported = new javax.swing.JTextArea();
        logoLabel4 = new javax.swing.JLabel();
        logoLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        locationFound = new javax.swing.JTextArea();
        logoLabel6 = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        saveButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        dashboardButton1 = new javax.swing.JButton();
        dateFormatLabel = new javax.swing.JLabel();
        logoLabel7 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        itemColor = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        contactNo = new javax.swing.JTextArea();
        logoLabel8 = new javax.swing.JLabel();
        dateFormatLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setPreferredSize(new java.awt.Dimension(1100, 700));
        mainPanel.setLayout(new java.awt.BorderLayout());

        sidePanel.setBackground(new java.awt.Color(7, 61, 42));
        sidePanel.setPreferredSize(new java.awt.Dimension(230, 700));

        logoPanel.setBackground(new java.awt.Color(7, 61, 42));

        logoName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        logoName.setForeground(new java.awt.Color(255, 255, 255));
        logoName.setText("Lost and Found");

        clientName.setBackground(new java.awt.Color(184, 199, 190));
        clientName.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        clientName.setForeground(new java.awt.Color(184, 199, 190));
        clientName.setText("PHINMA COC | IT DEPARTMENT");

        logoLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        logoLabel1.setForeground(new java.awt.Color(247, 181, 0));
        logoLabel1.setText("L&F");

        javax.swing.GroupLayout logoPanelLayout = new javax.swing.GroupLayout(logoPanel);
        logoPanel.setLayout(logoPanelLayout);
        logoPanelLayout.setHorizontalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoLabel1)
                    .addComponent(clientName)
                    .addComponent(logoName))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        logoPanelLayout.setVerticalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(logoLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clientName)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        navPanel.setBackground(new java.awt.Color(7, 61, 42));

        dashboardButton.setBackground(new java.awt.Color(7, 61, 42));
        dashboardButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dashboardButton.setForeground(new java.awt.Color(255, 255, 255));
        dashboardButton.setText("Dashboard");
        dashboardButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        dashboardButton.addActionListener(this::dashboardButtonActionPerformed);

        addButton.setBackground(new java.awt.Color(8, 116, 71));
        addButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add Item");
        addButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        addButton.addActionListener(this::addButtonActionPerformed);

        searchButton.setBackground(new java.awt.Color(7, 61, 42));
        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Item List");
        searchButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        searchButton.addActionListener(this::searchButtonActionPerformed);

        javax.swing.GroupLayout navPanelLayout = new javax.swing.GroupLayout(navPanel);
        navPanel.setLayout(navPanelLayout);
        navPanelLayout.setHorizontalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dashboardButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                .addContainerGap())
        );
        navPanelLayout.setVerticalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(dashboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(7, 61, 42));

        clientName3.setBackground(new java.awt.Color(184, 199, 190));
        clientName3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        clientName3.setForeground(new java.awt.Color(184, 199, 190));
        clientName3.setText("PHINMA COC | 2026");

        logoutbutton.setBackground(new java.awt.Color(8, 116, 71));
        logoutbutton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        logoutbutton.setForeground(new java.awt.Color(255, 255, 255));
        logoutbutton.setText("Log out");
        logoutbutton.setPreferredSize(new java.awt.Dimension(78, 30));
        logoutbutton.addActionListener(this::logoutbuttonActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(clientName3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(logoutbutton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clientName3)
                .addContainerGap())
        );

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(navPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addComponent(logoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(navPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainPanel.add(sidePanel, java.awt.BorderLayout.WEST);

        contentPanel.setBackground(new java.awt.Color(245, 247, 245));

        headerPanel.setBackground(new java.awt.Color(255, 255, 255));

        logoLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        logoLabel.setForeground(new java.awt.Color(32, 41, 35));
        logoLabel.setText("Report an item");

        logoName1.setForeground(new java.awt.Color(105, 118, 110));
        logoName1.setText("Record a lost or found belonging");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoName1)
                    .addComponent(logoLabel))
                .addContainerGap(667, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(logoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoName1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        dashboardContentPanel.setBackground(new java.awt.Color(255, 255, 255));

        logoLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoLabel2.setForeground(new java.awt.Color(32, 41, 35));
        logoLabel2.setText("Item Name:");

        itemName.setColumns(20);
        itemName.setRows(5);
        jScrollPane1.setViewportView(itemName);

        logoLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoLabel3.setForeground(new java.awt.Color(32, 41, 35));
        logoLabel3.setText("Other description:");

        dateReported.setColumns(20);
        dateReported.setRows(5);
        jScrollPane2.setViewportView(dateReported);

        logoLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoLabel4.setForeground(new java.awt.Color(32, 41, 35));
        logoLabel4.setText("Location:");

        logoLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoLabel5.setForeground(new java.awt.Color(32, 41, 35));
        logoLabel5.setText("Status:");

        locationFound.setColumns(20);
        locationFound.setRows(5);
        jScrollPane4.setViewportView(locationFound);

        logoLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoLabel6.setForeground(new java.awt.Color(32, 41, 35));
        logoLabel6.setText("Date Reported:");

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LOST", "FOUND" }));
        statusComboBox.addActionListener(this::statusComboBoxActionPerformed);

        descriptionArea.setColumns(20);
        descriptionArea.setRows(5);
        jScrollPane5.setViewportView(descriptionArea);

        saveButton.setBackground(new java.awt.Color(8, 116, 71));
        saveButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Save Item");
        saveButton.addActionListener(this::saveButtonActionPerformed);

        clearButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clearButton.setForeground(new java.awt.Color(8, 116, 71));
        clearButton.setText("Clear Fields");
        clearButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(8, 116, 71)));
        clearButton.addActionListener(this::clearButtonActionPerformed);

        dashboardButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dashboardButton1.setForeground(new java.awt.Color(8, 116, 71));
        dashboardButton1.setText("Back to Dashboard");
        dashboardButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(8, 116, 71)));
        dashboardButton1.addActionListener(this::dashboardButton1ActionPerformed);

        dateFormatLabel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        dateFormatLabel.setForeground(new java.awt.Color(130, 130, 130));
        dateFormatLabel.setText("Format: YYYY-MM-DD (e.g., 2026-10-15)");

        logoLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoLabel7.setForeground(new java.awt.Color(32, 41, 35));
        logoLabel7.setText("Color:");

        itemColor.setColumns(20);
        itemColor.setRows(5);
        jScrollPane6.setViewportView(itemColor);

        contactNo.setColumns(20);
        contactNo.setRows(5);
        jScrollPane3.setViewportView(contactNo);

        logoLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoLabel8.setForeground(new java.awt.Color(32, 41, 35));
        logoLabel8.setText("Contact No.");

        dateFormatLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        dateFormatLabel1.setForeground(new java.awt.Color(130, 130, 130));
        dateFormatLabel1.setText("Optional");

        javax.swing.GroupLayout dashboardContentPanelLayout = new javax.swing.GroupLayout(dashboardContentPanel);
        dashboardContentPanel.setLayout(dashboardContentPanelLayout);
        dashboardContentPanelLayout.setHorizontalGroup(
            dashboardContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardContentPanelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(dashboardContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoLabel3)
                    .addComponent(logoLabel5)
                    .addComponent(logoLabel6)
                    .addComponent(logoLabel4)
                    .addComponent(logoLabel2)
                    .addComponent(logoLabel7)
                    .addComponent(logoLabel8))
                .addGap(44, 44, 44)
                .addGroup(dashboardContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dashboardContentPanelLayout.createSequentialGroup()
                        .addComponent(dateFormatLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(dashboardContentPanelLayout.createSequentialGroup()
                        .addGroup(dashboardContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                            .addComponent(dateFormatLabel)
                            .addGroup(dashboardContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                                .addComponent(statusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE))
                            .addGroup(dashboardContentPanelLayout.createSequentialGroup()
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dashboardButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(31, Short.MAX_VALUE))))
        );
        dashboardContentPanelLayout.setVerticalGroup(
            dashboardContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardContentPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(dashboardContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(dashboardContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dashboardContentPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(logoLabel7))
                    .addGroup(dashboardContentPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(dashboardContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoLabel3)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dashboardContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoLabel4))
                .addGap(18, 18, 18)
                .addGroup(dashboardContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateFormatLabel)
                .addGap(18, 18, 18)
                .addGroup(dashboardContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoLabel5))
                .addGroup(dashboardContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dashboardContentPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateFormatLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(dashboardContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dashboardButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(dashboardContentPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(logoLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(dashboardContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(dashboardContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 83, Short.MAX_VALUE))
        );

        mainPanel.add(contentPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardButtonActionPerformed
        StudentDashboard SD = new StudentDashboard();
        SD.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        SD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashboardButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

    }//GEN-LAST:event_addButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        ItemList il = new ItemList();
        il.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        il.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        String name = itemName.getText().trim();
        String color = itemColor.getText().trim();
        String description = descriptionArea.getText().trim();
        String location = locationFound.getText().trim();
        String date = dateReported.getText().trim();
        String status = statusComboBox.getSelectedItem().toString();

        if (name.isEmpty() || color.isEmpty() || description.isEmpty()
                || location.isEmpty() || date.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please fill in all required fields.");
            return;
        }

        java.sql.Date sqlDate;

        try {
            java.time.LocalDate parsedDate = java.time.LocalDate.parse(
                    date,
                    java.time.format.DateTimeFormatter.ISO_LOCAL_DATE
            );
            sqlDate = java.sql.Date.valueOf(parsedDate);
        } catch (java.time.DateTimeException e) {
            JOptionPane.showMessageDialog(this,
                    "Enter a valid date in YYYY-MM-DD format.");
            return;
        }

        String oppositeStatus = status.equals("LOST") ? "FOUND" : "LOST";
        String contact = contactNo.getText().trim();

        String matchSql = "SELECT item_id, item_name, item_color, description, "
                + "location, item_status FROM items "
                + "WHERE is_archived = FALSE AND item_status = ? "
                + "AND LOWER(item_name) = LOWER(?) "
                + "AND (LOWER(COALESCE(item_color, '')) = LOWER(?) "
                + "OR LOWER(description) LIKE LOWER(?))";

        String insertSql = "INSERT INTO items "
                + "(item_name, item_color, description, location, "
                + "date_reported, item_status, contact_number) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = connector.getConnection()) {
            if (con == null) {
                JOptionPane.showMessageDialog(this,
                        "Database connection failed.");
                return;
            }

            try (PreparedStatement pst = con.prepareStatement(matchSql)) {
                pst.setString(1, oppositeStatus);
                pst.setString(2, name);
                pst.setString(3, color);
                pst.setString(4, "%" + description + "%");

                try (java.sql.ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        String message = "A possible matching item already exists.\n\n"
                                + "Item ID: " + rs.getInt("item_id") + "\n"
                                + "Name: " + rs.getString("item_name") + "\n"
                                + "Color: " + rs.getString("item_color") + "\n"
                                + "Description: " + rs.getString("description") + "\n"
                                + "Location: " + rs.getString("location") + "\n"
                                + "Status: " + rs.getString("item_status") + "\n\n"
                                + "To avoid duplicate reports, please visit the "
                                + "IT Department office for verification.";

                        JOptionPane.showMessageDialog(this, message,
                                "Possible Matching Item",
                                JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
            }

            try (PreparedStatement pst = con.prepareStatement(insertSql)) {
                pst.setString(1, name);
                pst.setString(2, color);
                pst.setString(3, description);
                pst.setString(4, location);
                pst.setDate(5, sqlDate);
                pst.setString(6, status);

                if (contact.isEmpty()) {
                    pst.setNull(7, java.sql.Types.VARCHAR);
                } else {
                    pst.setString(7, contact);
                }

                pst.executeUpdate();

                if (status.equals("FOUND")) {
                    JOptionPane.showMessageDialog(this,
                            "Item reported successfully!\n\n"
                            + "Please submit the found item to the "
                            + "IT Department Office for verification.",
                            "Submit Found Item",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Lost item reported successfully!\n\n"
                            + "Please coordinate with the IT Department "
                            + "Office for assistance.",
                            "Report Successful",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                clearFields();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Unable to save item:\n" + e.getMessage());
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void logoutbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbuttonActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutbuttonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearFields();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void statusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusComboBoxActionPerformed

    private void dashboardButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardButton1ActionPerformed
        StudentDashboard SD = new StudentDashboard();
        SD.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        SD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashboardButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new AddItem().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel clientName;
    private javax.swing.JLabel clientName3;
    private javax.swing.JTextArea contactNo;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JButton dashboardButton1;
    private javax.swing.JPanel dashboardContentPanel;
    private javax.swing.JLabel dateFormatLabel;
    private javax.swing.JLabel dateFormatLabel1;
    private javax.swing.JTextArea dateReported;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTextArea itemColor;
    private javax.swing.JTextArea itemName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea locationFound;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel logoLabel1;
    private javax.swing.JLabel logoLabel2;
    private javax.swing.JLabel logoLabel3;
    private javax.swing.JLabel logoLabel4;
    private javax.swing.JLabel logoLabel5;
    private javax.swing.JLabel logoLabel6;
    private javax.swing.JLabel logoLabel7;
    private javax.swing.JLabel logoLabel8;
    private javax.swing.JLabel logoName;
    private javax.swing.JLabel logoName1;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JButton logoutbutton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel navPanel;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JComboBox<String> statusComboBox;
    // End of variables declaration//GEN-END:variables
}
