
package l.f;

import l.f.ManagerInterface.ManagerDashboard;
import l.f.StudentInterface.*;

public class Login extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());
    public Login() {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
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
        infoPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        descriptionLabel1 = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        loginTitle = new javax.swing.JLabel();
        descriptionLabel6 = new javax.swing.JLabel();
        UnameLabel = new javax.swing.JLabel();
        Uname = new javax.swing.JTextField();
        PLabel = new javax.swing.JLabel();
        Pass = new javax.swing.JPasswordField();
        signinButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setPreferredSize(new java.awt.Dimension(1100, 700));
        mainPanel.setLayout(new java.awt.BorderLayout());

        sidePanel.setBackground(new java.awt.Color(7, 61, 42));
        sidePanel.setPreferredSize(new java.awt.Dimension(330, 700));

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
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoLabel1)
                    .addComponent(clientName)
                    .addComponent(logoName))
                .addGap(159, 159, 159))
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
                .addGap(32, 32, 32))
        );

        infoPanel.setBackground(new java.awt.Color(7, 61, 42));

        titleLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 40)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("<html>Helping lost belongings<br> find their way home.</html>");
        titleLabel.setPreferredSize(new java.awt.Dimension(468, 215));

        descriptionLabel1.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        descriptionLabel1.setForeground(new java.awt.Color(255, 255, 255));
        descriptionLabel1.setText("<html>A simple and reliable way to report,<br> find, and reclaim lost belongings at <br>PHINMA COC.</html>");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(descriptionLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(descriptionLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(sidePanel, java.awt.BorderLayout.WEST);

        contentPanel.setBackground(new java.awt.Color(245, 247, 245));
        contentPanel.setPreferredSize(new java.awt.Dimension(770, 700));

        loginPanel.setBackground(new java.awt.Color(255, 255, 255));

        loginTitle.setFont(new java.awt.Font("Segoe UI Black", 0, 26)); // NOI18N
        loginTitle.setForeground(new java.awt.Color(0, 57, 33));
        loginTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginTitle.setText("Welcome back!");

        descriptionLabel6.setBackground(new java.awt.Color(0, 57, 33));
        descriptionLabel6.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        descriptionLabel6.setForeground(new java.awt.Color(0, 57, 33));
        descriptionLabel6.setText("Sign in to access your Lost and Found account.");

        UnameLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        UnameLabel.setForeground(new java.awt.Color(0, 57, 33));
        UnameLabel.setText("Username:");

        Uname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Uname.setForeground(new java.awt.Color(0, 57, 33));
        Uname.addActionListener(this::UnameActionPerformed);

        PLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        PLabel.setForeground(new java.awt.Color(0, 57, 33));
        PLabel.setText("Password:");

        Pass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Pass.setForeground(new java.awt.Color(0, 57, 33));

        signinButton.setBackground(new java.awt.Color(0, 104, 56));
        signinButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        signinButton.setForeground(new java.awt.Color(255, 255, 255));
        signinButton.setText("Sign in");
        signinButton.addActionListener(this::signinButtonActionPerformed);

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(signinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(PLabel)
                        .addComponent(UnameLabel)
                        .addComponent(descriptionLabel6)
                        .addComponent(loginTitle)
                        .addComponent(Uname, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                        .addComponent(Pass)))
                .addGap(24, 24, 24))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(loginTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(UnameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Uname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 21, Short.MAX_VALUE)
                .addComponent(PLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(signinButton)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        mainPanel.add(contentPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UnameActionPerformed

    private void signinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinButtonActionPerformed
        String username = Uname.getText().trim();
        String password = new String(Pass.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(
        this, "Please enter your username and password.");
    return;
}

        String sql = "SELECT user_id, full_name, role FROM users "
        + "WHERE username = ? AND password = ?";

        try (java.sql.Connection con = connector.getConnection()) {

            if (con == null) {
                javax.swing.JOptionPane.showMessageDialog(
                this, "Database connection failed.");
                return;
            }

        try (java.sql.PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, username);
            pst.setString(2, password);

            try (java.sql.ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    String role = rs.getString("role");
                    String fullName = rs.getString("full_name");

                    javax.swing.JOptionPane.showMessageDialog(
                        this, "Welcome, " + fullName + "!");

                    if ("MANAGER".equals(role)) {
                        ManagerDashboard md = new ManagerDashboard();
                        md.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
                        md.setVisible(true);
                    } else if ("STUDENT".equals(role)) {
                        StudentDashboard sd = new StudentDashboard();
                        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
                        sd.setVisible(true);
                    }

                    this.dispose();

                } else {
                    javax.swing.JOptionPane.showMessageDialog(
                        this, "Invalid username or password.");
                    }
                }
            }
        } catch (java.sql.SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(
                    this, "Login failed: " + e.getMessage());
        }        
    }//GEN-LAST:event_signinButtonActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PLabel;
    private javax.swing.JPasswordField Pass;
    private javax.swing.JTextField Uname;
    private javax.swing.JLabel UnameLabel;
    private javax.swing.JLabel clientName;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel descriptionLabel1;
    private javax.swing.JLabel descriptionLabel6;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JLabel loginTitle;
    private javax.swing.JLabel logoLabel1;
    private javax.swing.JLabel logoName;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JButton signinButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
