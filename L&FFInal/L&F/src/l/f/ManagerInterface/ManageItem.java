/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package l.f.ManagerInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import l.f.*;

public class ManageItem extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ManageItem.class.getName());

    /**
     * Creates new form Dashboard
     */
    public ManageItem() {
        initComponents();
        filterItems();
    }

    private void filterItems() {
        String search = searchBar.getText().trim();
        String status = jComboBox1.getSelectedItem().toString();

        String sql = "SELECT item_id, item_name, item_color, description, "
                + "location, date_reported, item_status, contact_number "
                + "FROM items WHERE is_archived = FALSE AND "
                + "(item_name LIKE ? OR item_color LIKE ? "
                + "OR description LIKE ? OR location LIKE ? "
                + "OR contact_number LIKE ?) ";

        if (!status.equals("ALL")) {
            sql += "AND item_status = ? ";
        }

        sql += "ORDER BY item_id DESC";

        DefaultTableModel model
                = (DefaultTableModel) manageTable.getModel();
        model.setRowCount(0);

        try (Connection con = connector.getConnection()) {
            if (con == null) {
                JOptionPane.showMessageDialog(this,
                        "Database connection failed.");
                return;
            }

            try (PreparedStatement pst = con.prepareStatement(sql)) {
                String keyword = "%" + search + "%";

                pst.setString(1, keyword);
                pst.setString(2, keyword);
                pst.setString(3, keyword);
                pst.setString(4, keyword);
                pst.setString(5, keyword);

                if (!status.equals("ALL")) {
                    pst.setString(6, status);
                }

                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        model.addRow(new Object[]{
                            rs.getInt("item_id"),
                            rs.getString("item_name"),
                            rs.getString("item_color"),
                            rs.getString("description"),
                            rs.getString("location"),
                            rs.getDate("date_reported"),
                            rs.getString("item_status"),
                            rs.getString("contact_number")
                        });
                    }
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Unable to filter items:\n" + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        logoName = new javax.swing.JLabel();
        clientName = new javax.swing.JLabel();
        logoLabel1 = new javax.swing.JLabel();
        navPanel = new javax.swing.JPanel();
        dashboardButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        manageButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        claimedButton = new javax.swing.JButton();
        archivedButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        clientName4 = new javax.swing.JLabel();
        logoutbutton1 = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        logoName1 = new javax.swing.JLabel();
        logoLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        searchBar = new javax.swing.JTextField();
        logoLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        updateButton = new javax.swing.JButton();
        archiveButton = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        manageTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setPreferredSize(new java.awt.Dimension(1100, 700));
        mainPanel.setLayout(new java.awt.BorderLayout());

        sidePanel.setBackground(new java.awt.Color(7, 61, 42));
        sidePanel.setPreferredSize(new java.awt.Dimension(230, 700));

        jPanel1.setBackground(new java.awt.Color(7, 61, 42));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoLabel1)
                    .addComponent(clientName)
                    .addComponent(logoName))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
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

        addButton.setBackground(new java.awt.Color(7, 61, 42));
        addButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add Item");
        addButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        addButton.addActionListener(this::addButtonActionPerformed);

        manageButton.setBackground(new java.awt.Color(8, 116, 71));
        manageButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        manageButton.setForeground(new java.awt.Color(255, 255, 255));
        manageButton.setText("Manage Items");
        manageButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        manageButton.addActionListener(this::manageButtonActionPerformed);

        searchButton.setBackground(new java.awt.Color(7, 61, 42));
        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search Items");
        searchButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        searchButton.addActionListener(this::searchButtonActionPerformed);

        claimedButton.setBackground(new java.awt.Color(7, 61, 42));
        claimedButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        claimedButton.setForeground(new java.awt.Color(255, 255, 255));
        claimedButton.setText("Manage Claims");
        claimedButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        claimedButton.addActionListener(this::claimedButtonActionPerformed);

        archivedButton.setBackground(new java.awt.Color(7, 61, 42));
        archivedButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        archivedButton.setForeground(new java.awt.Color(255, 255, 255));
        archivedButton.setText("Archived Items");
        archivedButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        archivedButton.addActionListener(this::archivedButtonActionPerformed);

        javax.swing.GroupLayout navPanelLayout = new javax.swing.GroupLayout(navPanel);
        navPanel.setLayout(navPanelLayout);
        navPanelLayout.setHorizontalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dashboardButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(claimedButton, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(archivedButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        navPanelLayout.setVerticalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(dashboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(claimedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(archivedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(7, 61, 42));

        clientName4.setBackground(new java.awt.Color(184, 199, 190));
        clientName4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        clientName4.setForeground(new java.awt.Color(184, 199, 190));
        clientName4.setText("PHINMA COC | 2026");

        logoutbutton1.setBackground(new java.awt.Color(8, 116, 71));
        logoutbutton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        logoutbutton1.setForeground(new java.awt.Color(255, 255, 255));
        logoutbutton1.setText("Log out");
        logoutbutton1.setPreferredSize(new java.awt.Dimension(78, 30));
        logoutbutton1.addActionListener(this::logoutbutton1ActionPerformed);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutbutton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(clientName4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(logoutbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clientName4)
                .addContainerGap())
        );

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(navPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(navPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainPanel.add(sidePanel, java.awt.BorderLayout.WEST);

        contentPanel.setBackground(new java.awt.Color(245, 247, 245));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        logoName1.setForeground(new java.awt.Color(105, 118, 110));
        logoName1.setText("View and maintain all Item records");

        logoLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        logoLabel2.setForeground(new java.awt.Color(32, 41, 35));
        logoLabel2.setText("Manage Items");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoLabel2)
                    .addComponent(logoName1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(logoLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoName1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        logoLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        logoLabel.setForeground(new java.awt.Color(32, 41, 35));
        logoLabel.setText("Search:");

        searchBar.addActionListener(this::searchBarActionPerformed);

        logoLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        logoLabel3.setForeground(new java.awt.Color(32, 41, 35));
        logoLabel3.setText("Status:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "LOST", "FOUND", "CLAIMED" }));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        updateButton.setBackground(new java.awt.Color(8, 116, 71));
        updateButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("Update");
        updateButton.addActionListener(this::updateButtonActionPerformed);

        archiveButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        archiveButton.setForeground(new java.awt.Color(8, 116, 71));
        archiveButton.setText("Archive");
        archiveButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(8, 116, 71)));
        archiveButton.addActionListener(this::archiveButtonActionPerformed);

        manageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Item ID", "Item Name", "Item Color", "Other Description", "Location", "Date Reported", "Status", "Contact No."
            }
        ));
        manageTable.setRowHeight(40);
        scrollPane.setViewportView(manageTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(logoLabel)
                .addGap(18, 18, 18)
                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logoLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(archiveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(logoLabel)
                        .addGap(46, 46, 46))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logoLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(archiveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 39, Short.MAX_VALUE))
        );

        mainPanel.add(contentPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardButtonActionPerformed
        ManagerDashboard db = new ManagerDashboard();
        db.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        db.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashboardButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        AddItem ai = new AddItem();
        ai.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        ai.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addButtonActionPerformed

    private void manageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageButtonActionPerformed

    }//GEN-LAST:event_manageButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        SearchItem si = new SearchItem();
        si.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        si.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void claimedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_claimedButtonActionPerformed
        ManageClaims ci = new ManageClaims();
        ci.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        ci.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_claimedButtonActionPerformed

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        filterItems();
    }//GEN-LAST:event_searchBarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        filterItems();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed

        int selectedRow = manageTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                    "Please select an item to update.");
            return;
        }

        int modelRow = manageTable.convertRowIndexToModel(selectedRow);
        int itemId = Integer.parseInt(
                manageTable.getModel().getValueAt(modelRow, 0).toString());

        String currentStatus = manageTable.getModel()
                .getValueAt(modelRow, 6).toString();

        if ("CLAIMED".equalsIgnoreCase(currentStatus)) {
            JOptionPane.showMessageDialog(this,
                    "Claimed items cannot be updated here. "
                    + "Manage claims through Manage Claims.");
            return;
        }

        String[] statuses = {"LOST", "FOUND"};

        javax.swing.JComboBox<String> statusChoice
                = new javax.swing.JComboBox<>(statuses);
        statusChoice.setSelectedItem(currentStatus);

        int result = JOptionPane.showConfirmDialog(this,
                statusChoice,
                "Update Item Status",
                JOptionPane.OK_CANCEL_OPTION);

        if (result != JOptionPane.OK_OPTION) {
            return;
        }

        String newStatus = statusChoice.getSelectedItem().toString();

        String sql = "UPDATE items SET item_status = ? WHERE item_id = ?";

        try (Connection con = connector.getConnection()) {
            if (con == null) {
                JOptionPane.showMessageDialog(this,
                        "Database connection failed.");
                return;
            }

            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, newStatus);
                pst.setInt(2, itemId);

                if (pst.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(this,
                            "Item updated successfully!");
                }

                filterItems();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Unable to update item:\n" + e.getMessage());
        }

    }//GEN-LAST:event_updateButtonActionPerformed

    private void archiveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archiveButtonActionPerformed

        int selectedRow = manageTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                    "Please select an item to archive.");
            return;
        }

        int modelRow = manageTable.convertRowIndexToModel(selectedRow);
        int itemId = Integer.parseInt(
                manageTable.getModel().getValueAt(modelRow, 0).toString());

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to archive this item?\n"
                + "You can restore it later.",
                "Confirm Archive",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        String sql = "UPDATE items SET is_archived = TRUE WHERE item_id = ?";

        try (Connection con = connector.getConnection()) {
            if (con == null) {
                JOptionPane.showMessageDialog(this,
                        "Database connection failed.");
                return;
            }

            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, itemId);

                if (pst.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(this,
                            "Item archived successfully.");
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Item could not be found.");
                }
            }

            filterItems();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Unable to archive item:\n" + e.getMessage());
        }
    }//GEN-LAST:event_archiveButtonActionPerformed

    private void logoutbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbutton1ActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutbutton1ActionPerformed

    private void archivedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivedButtonActionPerformed
        ArchivedItems arc = new ArchivedItems();
        arc.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        arc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_archivedButtonActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new ManageItem().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton archiveButton;
    private javax.swing.JButton archivedButton;
    private javax.swing.JButton claimedButton;
    private javax.swing.JLabel clientName;
    private javax.swing.JLabel clientName4;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel logoLabel1;
    private javax.swing.JLabel logoLabel2;
    private javax.swing.JLabel logoLabel3;
    private javax.swing.JLabel logoName;
    private javax.swing.JLabel logoName1;
    private javax.swing.JButton logoutbutton1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton manageButton;
    private javax.swing.JTable manageTable;
    private javax.swing.JPanel navPanel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
