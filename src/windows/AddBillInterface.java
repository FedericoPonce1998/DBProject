/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import Controllers.BillController;
import Controllers.MainController;
import java.awt.Color;
import java.sql.Timestamp;

/**
 *
 * @author federicoponcedeleon
 */
public class AddBillInterface extends javax.swing.JFrame {

    /**
     * Creates new form AddPurchaseInterface
     */
    public AddBillInterface() {
        initComponents();
        jLabelShowMessage.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextDescription = new javax.swing.JTextField();
        jTextAmount = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabelShowMessage = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Untitled.png"))); // NOI18N
        jLabel2.setToolTipText("Inicio");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, -10, 160, 90));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu-icon.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, -10, 90, 60));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Gasto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 100, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/description-icon.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 100));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cash.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 50, 280, 120));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calendar-icon.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 160, 120, 50));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bill.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));
        getContentPane().add(jTextDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 170, -1));
        getContentPane().add(jTextAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 170, -1));

        jButtonAdd.setText("Agregar");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

        jButtonCancel.setText("Cancelar");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, -1, -1));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 188, 170, -1));

        jCheckBox1.setText("Esta pago");
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 170, -1));

        jLabelShowMessage.setText("Esto cambia en ejecucion");
        getContentPane().add(jLabelShowMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/white-wallpaper.jpg"))); // NOI18N
        jLabel4.setText("jLabel1");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 300, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        BillController billc = BillController.instance();
        String description = jTextDescription.getText(),
                usuId = MainController.instance().getCurrentUser().getUserName();
        Double amount = Double.parseDouble(jTextAmount.getText());
        boolean isInput = jTextAmount.getText().charAt('-') == 0,
                isPaid = jCheckBox1.isSelected();
        Timestamp date = Timestamp.valueOf(jDateChooser1.getDateFormatString());
        boolean success = billc.createBill(description, amount, date, null, null, usuId, null, isInput, isPaid) != "";
        if (success) {
            jLabelShowMessage.setText("Gasto creado correctamente");
            jLabelShowMessage.setForeground(Color.GREEN);
        }
        else {
            jLabelShowMessage.setText("Gasto creado correctamente");
            jLabelShowMessage.setForeground(Color.GREEN);
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        MainController mc = MainController.instance();
        mc.getMenu().setPreviousInterface(this);
        mc.getMenu().setVisible(true);
        mc.getMenu().setLocationRelativeTo(this);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        MainController.instance().getHome().setVisible(true);
        MainController.instance().getHome().setLocationRelativeTo(this);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        MainController mc = MainController.instance();
        mc.getHome().setVisible(true);
        this.setVisible(false);
        this.dispose();
        mc.getHome().setLocationRelativeTo(this);
                
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(AddBillInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddBillInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddBillInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddBillInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddBillInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelShowMessage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextAmount;
    private javax.swing.JTextField jTextDescription;
    // End of variables declaration//GEN-END:variables
}
