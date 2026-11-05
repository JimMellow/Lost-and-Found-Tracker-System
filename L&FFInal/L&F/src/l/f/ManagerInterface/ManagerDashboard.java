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

public class ManagerDashboard extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ManagerDashboard.class.getName());

    /**
     * Creates new form Dashboard
     */
    public ManagerDashboard() {
        initComponents();
        loadDashboard();
    }

    private void loadDashboard() {
        loadCounts();
        loadRecentItems();
    }

    private void loadCounts() {
        String sql = "SELECT COUNT(*) AS total, "
                + "COALESCE(SUM(item_status = 'LOST'), 0) AS lost, "
                + "COALESCE(SUM(item_status = 'FOUND'), 0) AS found, "
                + "COALESCE(SUM(item_status = 'CLAIMED'), 0) AS claimed "
                + "FROM items WHERE is_archived = FALSE";

        try (Connection con = connector.getConnection()) {
            if (con == null) {
                JOptionPane.showMessageDialog(this,
                        "Database connection failed.");
                return;
            }

            try (PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

                if (rs.next()) {
                    totalValue.setText(String.valueOf(rs.getInt("total")));
                    lostValue.setText(String.valueOf(rs.getInt("lost")));
                    foundValue.setText(String.valueOf(rs.getInt("found")));
                    claimedValue.setText(String.valueOf(rs.getInt("claimed")));
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void loadRecentItems() {
        String sql = "SELECT item_id, item_name, item_color, description, "
                + "location, date_reported, item_status, contact_number "
                + "FROM items WHERE is_archived = FALSE "
                + "ORDER BY date_reported DESC, item_id DESC LIMIT 10";

        DefaultTableModel model
                = (DefaultTableModel) recentItemTable.getModel();

        model.setRowCount(0);

        try (Connection con = connector.getConnection()) {
            if (con == null) {
                return;
            }

            try (PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

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

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
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
        jPanel3 = new javax.swing.JPanel();
        clientName3 = new javax.swing.JLabel();
        logoutbutton = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        logoName1 = new javax.swing.JLabel();
        addnewButton = new javax.swing.JButton();
        statsPanel = new javax.swing.JPanel();
        statCard = new javax.swing.JPanel();
        totalLabel = new javax.swing.JLabel();
        totalValue = new javax.swing.JLabel();
        statCard1 = new javax.swing.JPanel();
        lostLabel = new javax.swing.JLabel();
        lostValue = new javax.swing.JLabel();
        statCard2 = new javax.swing.JPanel();
        foundLabel = new javax.swing.JLabel();
        foundValue = new javax.swing.JLabel();
        statCard3 = new javax.swing.JPanel();
        claimedLabel = new javax.swing.JLabel();
        claimedValue = new javax.swing.JLabel();
        logoLabel2 = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        recentItemTable = new javax.swing.JTable();

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

        dashboardButton.setBackground(new java.awt.Color(8, 116, 71));
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

        manageButton.setBackground(new java.awt.Color(7, 61, 42));
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
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(7, 61, 42));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(clientName3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(navPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(navPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainPanel.add(sidePanel, java.awt.BorderLayout.WEST);

        contentPanel.setBackground(new java.awt.Color(245, 247, 245));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        logoLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        logoLabel.setForeground(new java.awt.Color(32, 41, 35));
        logoLabel.setText("Dashboard");

        logoName1.setForeground(new java.awt.Color(105, 118, 110));
        logoName1.setText("Lost and found item monitoring");

        addnewButton.setBackground(new java.awt.Color(8, 116, 71));
        addnewButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addnewButton.setForeground(new java.awt.Color(255, 255, 255));
        addnewButton.setText("Add New Item");
        addnewButton.addActionListener(this::addnewButtonActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoName1)
                    .addComponent(logoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addnewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(logoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoName1)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addnewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        statsPanel.setBackground(new java.awt.Color(245, 247, 245));

        statCard.setBackground(new java.awt.Color(255, 255, 255));
        statCard.setPreferredSize(new java.awt.Dimension(190, 100));

        totalLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalLabel.setForeground(new java.awt.Color(105, 118, 110));
        totalLabel.setText("Total items");

        totalValue.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        totalValue.setForeground(new java.awt.Color(8, 116, 71));
        totalValue.setText("9");

        javax.swing.GroupLayout statCardLayout = new javax.swing.GroupLayout(statCard);
        statCard.setLayout(statCardLayout);
        statCardLayout.setHorizontalGroup(
            statCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statCardLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(statCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalValue)
                    .addComponent(totalLabel))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        statCardLayout.setVerticalGroup(
            statCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statCardLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(totalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalValue)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        statCard1.setBackground(new java.awt.Color(255, 255, 255));
        statCard1.setPreferredSize(new java.awt.Dimension(190, 100));

        lostLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lostLabel.setForeground(new java.awt.Color(105, 118, 110));
        lostLabel.setText("Lost items");

        lostValue.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lostValue.setForeground(new java.awt.Color(8, 116, 71));
        lostValue.setText("3");

        javax.swing.GroupLayout statCard1Layout = new javax.swing.GroupLayout(statCard1);
        statCard1.setLayout(statCard1Layout);
        statCard1Layout.setHorizontalGroup(
            statCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statCard1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(statCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lostValue)
                    .addComponent(lostLabel))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        statCard1Layout.setVerticalGroup(
            statCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statCard1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lostLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lostValue)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        statCard2.setBackground(new java.awt.Color(255, 255, 255));
        statCard2.setPreferredSize(new java.awt.Dimension(190, 100));

        foundLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        foundLabel.setForeground(new java.awt.Color(105, 118, 110));
        foundLabel.setText("Found items");

        foundValue.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        foundValue.setForeground(new java.awt.Color(8, 116, 71));
        foundValue.setText("3");

        javax.swing.GroupLayout statCard2Layout = new javax.swing.GroupLayout(statCard2);
        statCard2.setLayout(statCard2Layout);
        statCard2Layout.setHorizontalGroup(
            statCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statCard2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(statCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(foundValue)
                    .addComponent(foundLabel))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        statCard2Layout.setVerticalGroup(
            statCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statCard2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(foundLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(foundValue)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        statCard3.setBackground(new java.awt.Color(255, 255, 255));
        statCard3.setPreferredSize(new java.awt.Dimension(190, 100));

        claimedLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        claimedLabel.setForeground(new java.awt.Color(105, 118, 110));
        claimedLabel.setText("Claimed items");

        claimedValue.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        claimedValue.setForeground(new java.awt.Color(8, 116, 71));
        claimedValue.setText("3");

        javax.swing.GroupLayout statCard3Layout = new javax.swing.GroupLayout(statCard3);
        statCard3.setLayout(statCard3Layout);
        statCard3Layout.setHorizontalGroup(
            statCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statCard3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(statCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(claimedValue)
                    .addComponent(claimedLabel))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        statCard3Layout.setVerticalGroup(
            statCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statCard3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(claimedLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(claimedValue)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout statsPanelLayout = new javax.swing.GroupLayout(statsPanel);
        statsPanel.setLayout(statsPanelLayout);
        statsPanelLayout.setHorizontalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(statCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(statCard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statCard3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        statsPanelLayout.setVerticalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(statCard3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(statCard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        logoLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        logoLabel2.setForeground(new java.awt.Color(32, 41, 35));
        logoLabel2.setText("Recent Items");

        recentItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Item Name", "Item Color", "Other Description", "Location", "Date Reported", "Status", "Contact No."
            }
        ));
        recentItemTable.setPreferredSize(new java.awt.Dimension(375, 150));
        recentItemTable.setRowHeight(40);
        scrollPane.setViewportView(recentItemTable);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoLabel2)
                    .addComponent(statsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoLabel2)
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        mainPanel.add(contentPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardButtonActionPerformed

    }//GEN-LAST:event_dashboardButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        AddItem ai = new AddItem();
        ai.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        ai.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addButtonActionPerformed

    private void manageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageButtonActionPerformed
        ManageItem mi = new ManageItem();
        mi.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        mi.setVisible(true);
        this.dispose();
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

    private void addnewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnewButtonActionPerformed
        AddItem ai = new AddItem();
        ai.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        ai.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addnewButtonActionPerformed

    private void logoutbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbuttonActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutbuttonActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new ManagerDashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton addnewButton;
    private javax.swing.JButton archivedButton;
    private javax.swing.JButton claimedButton;
    private javax.swing.JLabel claimedLabel;
    private javax.swing.JLabel claimedValue;
    private javax.swing.JLabel clientName;
    private javax.swing.JLabel clientName3;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JLabel foundLabel;
    private javax.swing.JLabel foundValue;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel logoLabel1;
    private javax.swing.JLabel logoLabel2;
    private javax.swing.JLabel logoName;
    private javax.swing.JLabel logoName1;
    private javax.swing.JButton logoutbutton;
    private javax.swing.JLabel lostLabel;
    private javax.swing.JLabel lostValue;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton manageButton;
    private javax.swing.JPanel navPanel;
    private javax.swing.JTable recentItemTable;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JPanel statCard;
    private javax.swing.JPanel statCard1;
    private javax.swing.JPanel statCard2;
    private javax.swing.JPanel statCard3;
    private javax.swing.JPanel statsPanel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalValue;
    // End of variables declaration//GEN-END:variables
}
