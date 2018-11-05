/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import Controllers.MainController;
import Models.User;

/**
 *
 * @author federicoponcedeleon
 */
public class UserInformation extends javax.swing.JFrame {

    /**
     * Creates new form UserInformation
     */
    public UserInformation() {
        initComponents();
    }

    private User userToShow;
    
    public void setUser(User newUser) {
        this.userToShow = newUser;
    }
    
    public void showPersonalInfo() {
        if (userToShow.getUserName().equals(MainController.instance().getCurrentUser().getUserName())) {
            jLabelUserId.setText(this.userToShow.getUserName());
            jLabelAddress.setText(this.userToShow.getAddress());
            jLabelMail.setText(this.userToShow.getEmail());
            jLabelName.setText(this.userToShow.getName());
            jButtonDeleteFriend.setVisible(false);
        }
    }
    
    public void showFriendInfo() {
        if (!userToShow.getUserName().equals(MainController.instance().getCurrentUser().getUserName())) {
            jLabelUserId.setText(this.userToShow.getUserName());
            jLabelAddress.setText(this.userToShow.getAddress());
            jLabelMail.setText(this.userToShow.getEmail());
            jLabelName.setText(this.userToShow.getName());
            jButtonDeleteFriend.setVisible(true);
            jLabelEndSession.setVisible(false);
            jLabelChangePass.setVisible(false);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelAddress = new javax.swing.JLabel();
        jLabelUserId = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelMail = new javax.swing.JLabel();
        jLabelChangePass = new javax.swing.JLabel();
        jLabelEndSession = new javax.swing.JLabel();
        jButtonDeleteFriend = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 480));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Untitled.png"))); // NOI18N
        jLabel1.setToolTipText("Inicio");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, -10, 150, 90));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu-icon.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, -20, 90, 70));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 140, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 60));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/person-icon.png"))); // NOI18N
        jLabel4.setToolTipText("Usuario");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 80, 100, 60));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/name.png"))); // NOI18N
        jLabel5.setToolTipText("Nombre");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 150, 90, 100));

        jLabelName.setText("Nombre");
        jLabelName.setToolTipText("Nombre");
        getContentPane().add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 140, 25));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home-icon.png"))); // NOI18N
        jLabel7.setToolTipText("Direccion");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 150, 90, 90));

        jLabelAddress.setText("Direccion");
        jLabelAddress.setToolTipText("Direccion");
        getContentPane().add(jLabelAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 150, 25));

        jLabelUserId.setText("User");
        jLabelUserId.setToolTipText("Usuario");
        getContentPane().add(jLabelUserId, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 106, 140, 25));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arroba-icon.png"))); // NOI18N
        jLabel8.setToolTipText("Mail");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 240, 90, 50));

        jLabelMail.setText("Mail");
        jLabelMail.setToolTipText("Mail");
        getContentPane().add(jLabelMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 266, 150, 25));

        jLabelChangePass.setForeground(new java.awt.Color(0, 0, 204));
        jLabelChangePass.setText("Cambiar contraseña");
        jLabelChangePass.setToolTipText("");
        getContentPane().add(jLabelChangePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 160, -1));

        jLabelEndSession.setForeground(new java.awt.Color(0, 0, 204));
        jLabelEndSession.setText("Cerrar sesion");
        jLabelEndSession.setToolTipText("");
        getContentPane().add(jLabelEndSession, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 100, -1));

        jButtonDeleteFriend.setText("Eliminar");
        jButtonDeleteFriend.setToolTipText("Eliminar amigo");
        getContentPane().add(jButtonDeleteFriend, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/white-wallpaper.jpg"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 300, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInformation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeleteFriend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAddress;
    private javax.swing.JLabel jLabelChangePass;
    private javax.swing.JLabel jLabelEndSession;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelUserId;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
