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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import l.f.*;

public class ManageClaims extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ManageClaims.class.getName());

    /**
     * Creates new form Dashboard
     */
    public ManageClaims() {
        initComponents();
        loadClaims();
    }

    private int selectFoundItem() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Item ID", "Item Name"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String sql = "SELECT item_id, item_name FROM items "
                + "WHERE item_status = 'FOUND' "
                + "AND is_archived = FALSE "
                + "ORDER BY item_id";

        try (Connection con = connector.getConnection()) {
            if (con == null) {
                JOptionPane.showMessageDialog(this,
                        "Database connection failed.");
                return -1;
            }

            try (PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getInt("item_id"),
                        rs.getString("item_name")
                    });
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Unable to load available items:\n" + e.getMessage());
            return -1;
        }

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this,
                    "No available FOUND items to claim.");
            return -1;
        }

        JTable itemTable = new JTable(model);
        itemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemTable.setRowSelectionInterval(0, 0);

        int choice = JOptionPane.showConfirmDialog(
                this,
                new JScrollPane(itemTable),
                "Select an Item to Claim",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (choice != JOptionPane.OK_OPTION) {
            return -1;
        }

        int selectedRow = itemTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                    "Please select an item.");
            return -1;
        }

        return (int) model.getValueAt(selectedRow, 0);
    }

    private void loadClaims() {
        String keyword = searchBar.getText().trim();
        String search = "%" + keyword + "%";

        String sql = "SELECT c.claim_id, i.item_id, i.item_name, "
        + "cl.claimant_name, cl.student_id, cl.contact_number, "
        + "c.claim_date "
        + "FROM claims c "
        + "JOIN items i ON c.item_id = i.item_id "
        + "JOIN claimants cl ON c.claimant_id = cl.claimant_id "
        + "WHERE i.is_archived = FALSE "
        + "AND (CAST(c.claim_id AS CHAR) LIKE ? "
        + "OR CAST(i.item_id AS CHAR) LIKE ? "
        + "OR i.item_name LIKE ? "
        + "OR cl.claimant_name LIKE ? "
        + "OR cl.student_id LIKE ? "
        + "OR cl.contact_number LIKE ?) "
        + "ORDER BY c.claim_id DESC";

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
                for (int i = 1; i <= 6; i++) {
                    pst.setString(i, search);
                }

                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        model.addRow(new Object[]{
                            rs.getInt("claim_id"),
                            rs.getInt("item_id"),
                            rs.getString("item_name"),
                            rs.getString("claimant_name"),
                            rs.getString("student_id"),
                            rs.getString("contact_number"),
                            rs.getDate("claim_date")
                        });
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Unable to load claims:\n" + e.getMessage());
        }
    }

    private void addClaim() {

        int itemId = selectFoundItem();

        if (itemId == -1) {
            return;
        }

        String claimantName = JOptionPane.showInputDialog(
                this, "Enter the claimant's full name:");

        if (claimantName == null || claimantName.trim().isEmpty()) {
            return;
        }

        claimantName = claimantName.trim();

        if (!claimantName.matches(
                "(?=.*[a-zA-Z])[a-zA-Z .'-]+")) {
            JOptionPane.showMessageDialog(this,
                    "Enter a valid full name.");
            return;
        }

        String studentId = JOptionPane.showInputDialog(
                this, "Enter the Student ID:");

        if (studentId == null || studentId.trim().isEmpty()) {
            return;
        }

        studentId = studentId.trim();

        if (!studentId.matches("02-\\d{4}-\\d{6}")) {
            JOptionPane.showMessageDialog(this,
                    "Invalid PHINMA ID format. Use 02-XXXX-XXXXXX.");
            return;
        }

        String contactNumber = JOptionPane.showInputDialog(
                this, "Enter the contact number:");

        if (contactNumber == null || contactNumber.trim().isEmpty()) {
            return;
        }

        contactNumber = contactNumber.trim();

        if (!contactNumber.matches("09\\d{9}")) {
            JOptionPane.showMessageDialog(this,
                    "Invalid mobile number. Use 09XXXXXXXXX.");
            return;
        }

        String checkSql = "SELECT item_status FROM items "
                + "WHERE item_id = ? AND is_archived = FALSE "
                + "FOR UPDATE";
        String claimantSql = "INSERT INTO claimants "
                + "(claimant_name, student_id, contact_number) "
                + "VALUES (?, ?, ?)";
        String claimSql = "INSERT INTO claims "
                + "(item_id, claimant_id, claim_date) VALUES (?, ?, ?)";
        String updateSql = "UPDATE items SET item_status = 'CLAIMED' "
                + "WHERE item_id = ? AND item_status = 'FOUND' "
                + "AND is_archived = FALSE";

        try (Connection con = connector.getConnection()) {
            if (con == null) {
                JOptionPane.showMessageDialog(this,
                        "Database connection failed.");
                return;
            }

            con.setAutoCommit(false);

            try {
                String status;

                try (PreparedStatement pst = con.prepareStatement(checkSql)) {
                    pst.setInt(1, itemId);

                    try (ResultSet rs = pst.executeQuery()) {
                        if (!rs.next()) {
                            JOptionPane.showMessageDialog(this,
                                    "Item ID not found.");
                            con.rollback();
                            return;
                        }

                        status = rs.getString("item_status");
                    }
                }

                if (!"FOUND".equalsIgnoreCase(status)) {
                    JOptionPane.showMessageDialog(this,
                            "Only items with FOUND status can be claimed.");
                    con.rollback();
                    return;
                }

                int claimantId;

                try (PreparedStatement pst = con.prepareStatement(
                        claimantSql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
                    pst.setString(1, claimantName.trim());
                    pst.setString(2, studentId.trim());
                    pst.setString(3, contactNumber.trim());
                    pst.executeUpdate();

                    try (ResultSet keys = pst.getGeneratedKeys()) {
                        if (!keys.next()) {
                            throw new SQLException("Could not create claimant.");
                        }
                        claimantId = keys.getInt(1);
                    }
                }

                try (PreparedStatement pst = con.prepareStatement(claimSql)) {
                    pst.setInt(1, itemId);
                    pst.setInt(2, claimantId);
                    pst.setDate(3, new java.sql.Date(
                            System.currentTimeMillis()));
                    pst.executeUpdate();
                }

                try (PreparedStatement pst = con.prepareStatement(updateSql)) {
                    pst.setInt(1, itemId);

                    int updatedRows = pst.executeUpdate();

                    if (updatedRows == 0) {
                        throw new SQLException(
                                "This item is no longer available to claim.");
                    }
                }

                con.commit();

                JOptionPane.showMessageDialog(this,
                        "Claim recorded successfully!");
                loadClaims();

            } catch (SQLException e) {
                con.rollback();
                throw e;
            } finally {
                con.setAutoCommit(true);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Unable to save claim:\n" + e.getMessage());
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
        jPanel4 = new javax.swing.JPanel();
        clientName3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        logoName1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        logoLabel2 = new javax.swing.JLabel();
        searchBar = new javax.swing.JTextField();
        addClaim = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        manageTable = new javax.swing.JTable();
        archiveButton = new javax.swing.JButton();

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
                    .addComponent(clientName)
                    .addComponent(logoName))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(logoLabel1)
                    .addContainerGap(133, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(logoName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clientName)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(logoLabel1)
                    .addContainerGap(79, Short.MAX_VALUE)))
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

        claimedButton.setBackground(new java.awt.Color(8, 116, 71));
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
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(7, 61, 42));

        clientName3.setBackground(new java.awt.Color(184, 199, 190));
        clientName3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        clientName3.setForeground(new java.awt.Color(184, 199, 190));
        clientName3.setText("PHINMA COC | 2026");

        jButton1.setBackground(new java.awt.Color(8, 116, 71));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Log out");
        jButton1.setPreferredSize(new java.awt.Dimension(78, 30));
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(clientName3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(navPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainPanel.add(sidePanel, java.awt.BorderLayout.WEST);

        contentPanel.setBackground(new java.awt.Color(245, 247, 245));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        logoLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        logoLabel.setForeground(new java.awt.Color(32, 41, 35));
        logoLabel.setText("Manage Claims");

        logoName1.setForeground(new java.awt.Color(105, 118, 110));
        logoName1.setText("View claim records and claimant information");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoName1)
                    .addComponent(logoLabel))
                .addContainerGap(604, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(logoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoName1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        logoLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        logoLabel2.setForeground(new java.awt.Color(32, 41, 35));
        logoLabel2.setText("Search:");

        searchBar.addActionListener(this::searchBarActionPerformed);

        addClaim.setBackground(new java.awt.Color(8, 116, 71));
        addClaim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addClaim.setForeground(new java.awt.Color(255, 255, 255));
        addClaim.setText("Add Claim");
        addClaim.addActionListener(this::addClaimActionPerformed);

        manageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Claim ID", "Item ID", "Item Name", "Claimant Name", "Student ID", "Contact Number", "Date Claimed"
            }
        ));
        manageTable.setRowHeight(40);
        scrollPane.setViewportView(manageTable);

        archiveButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        archiveButton.setForeground(new java.awt.Color(8, 116, 71));
        archiveButton.setText("Archive");
        archiveButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(8, 116, 71)));
        archiveButton.addActionListener(this::archiveButtonActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(logoLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(addClaim, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(archiveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(logoLabel2)
                        .addGap(46, 46, 46))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addClaim, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 43, Short.MAX_VALUE))
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

    }//GEN-LAST:event_claimedButtonActionPerformed

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        loadClaims();
    }//GEN-LAST:event_searchBarActionPerformed

    private void addClaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClaimActionPerformed
        addClaim();
    }//GEN-LAST:event_addClaimActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void archivedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivedButtonActionPerformed
        ArchivedItems arc = new ArchivedItems();
        arc.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        arc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_archivedButtonActionPerformed

    private void archiveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archiveButtonActionPerformed

        int selectedRow = manageTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                    "Please select a claim to archive.");
            return;
        }

        int modelRow = manageTable.convertRowIndexToModel(selectedRow);
        int itemId = Integer.parseInt(
                manageTable.getModel().getValueAt(modelRow, 1).toString());

        int confirm = JOptionPane.showConfirmDialog(this,
                "Archive this claim and its associated item?",
                "Confirm Archive",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        String sql = "UPDATE items SET is_archived = TRUE "
                + "WHERE item_id = ?";

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
                            "Claim and associated item archived successfully.");
                    loadClaims();
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Item could not be found.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Unable to archive claim:\n" + e.getMessage());
        }
    }//GEN-LAST:event_archiveButtonActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new ManageClaims().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton addClaim;
    private javax.swing.JButton archiveButton;
    private javax.swing.JButton archivedButton;
    private javax.swing.JButton claimedButton;
    private javax.swing.JLabel clientName;
    private javax.swing.JLabel clientName3;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel logoLabel1;
    private javax.swing.JLabel logoLabel2;
    private javax.swing.JLabel logoName;
    private javax.swing.JLabel logoName1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton manageButton;
    private javax.swing.JTable manageTable;
    private javax.swing.JPanel navPanel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
}
