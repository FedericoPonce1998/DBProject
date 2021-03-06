/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import Controllers.BillController;
import Controllers.MainController;
import Controllers.ServiceController;
import Models.Bill;
import java.awt.Color;

/**
 *
 * @author federicoponcedeleon
 */
public class BillInformationInterface extends javax.swing.JFrame {

    /**
     * Creates new form BillInformationInterface
     */
    public BillInformationInterface() {
        initComponents();
        jLabelShowMessage.setText("");
    }
    
    private Bill bill;
    
    public Bill getBill() {
        return this.bill;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelName = new javax.swing.JLabel();
        jLabelAmount = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jLabelReference = new javax.swing.JLabel();
        jButtonPay = new javax.swing.JButton();
        jButtonPaid = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabelShowMessage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setMinimumSize(new java.awt.Dimension(300, 480));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(300, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelName.setText("Motivo");
        jLabelName.setToolTipText("Motivo");
        getContentPane().add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 130, 25));

        jLabelAmount.setText("Monto");
        jLabelAmount.setToolTipText("Monto");
        getContentPane().add(jLabelAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 130, 25));

        jLabelDate.setText("Fecha");
        jLabelDate.setToolTipText("Fecha");
        getContentPane().add(jLabelDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 130, 25));

        jLabelReference.setText("Referencia");
        jLabelReference.setToolTipText("Referencia");
        getContentPane().add(jLabelReference, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 130, 25));

        jButtonPay.setText("Pagar");
        jButtonPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPayActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, -1));

        jButtonPaid.setText("Pago");
        jButtonPaid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonPaidMouseClicked(evt);
            }
        });
        getContentPane().add(jButtonPaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Untitled.png"))); // NOI18N
        jLabel3.setToolTipText("Inicio");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, -80, 200, 230));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Gasto");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 70, -1));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu-icon.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, -30, 100, 100));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/description-icon.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 90, 100));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cash.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-180, 90, 280, 120));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calendar-icon.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 200, 120, 50));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ref.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 70, 50));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bill.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        jLabel11.setText("Esta Paga");
        jLabel11.setToolTipText("Esta paga");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 130, 25));

        jLabelShowMessage.setText("Esto se cambia en ejecucion");
        getContentPane().add(jLabelShowMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/white-wallpaper.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 300, 460));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPayActionPerformed
        //the user pays the bill
        BillController bc = BillController.instance();
        
        if (this.bill.getBillId() != null) {
            boolean success = bc.payBill(this.bill.getBillId());
            if (!success) {
                jLabelShowMessage.setText("Ha ocurrido un error al pagar el gasto");
                jLabelShowMessage.setForeground(Color.red);
            }
            else {
                if (this.bill.getBillReferenceId() != null || !this.bill.getBillReferenceId().isEmpty()) { //si tiene gasto de 
                                                                                                           //referencia, se paga tambien
                    boolean successTwo = bc.payBill(this.bill.getBillReferenceId());
                    if (!successTwo) {
                        jLabelShowMessage.setText("Ha ocurrido un error al pagar el gasto referencia");
                        jLabelShowMessage.setForeground(Color.red);
                    }
                }
            }
        }
    }//GEN-LAST:event_jButtonPayActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        MainController mc = MainController.instance();
        mc.getMenu().setLocationRelativeTo(this);
        mc.getMenu().setVisible(true);
        mc.getMenu().setPreviousInterface(this);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButtonPaidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPaidMouseClicked
        BillController bc = BillController.instance();
        boolean success = bc.payBill(this.bill.getBillId());
        if (success) {
            jLabelShowMessage.setText("El gasto ha sido pago correctamente");
            jLabelShowMessage.setForeground(Color.GREEN);
        }
        else {
            jLabelShowMessage.setText("Ha ocurrido un error al pagar el gasto");
            jLabelShowMessage.setForeground(Color.red);
        }
    }//GEN-LAST:event_jButtonPaidMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        MainController mc = MainController.instance();
        mc.getHome().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked
    
    public void setBill(Bill bill) {
        this.bill = bill;
    }
    
    public void showBill() {
        jLabelName.setText(bill.getName());
        jLabelDate.setText(bill.getDeadline().toString());
        jLabelReference.setText(bill.getBillReferenceId());
        Double amount = bill.getPrice();
        if (bill.isInput()) {
            jLabelAmount.setText(amount.toString());
            jLabelAmount.setForeground(Color.GREEN);
            if (!bill.isPaid()) {
                jButtonPaid.setVisible(true);
                jButtonPay.setVisible(false);
            }
        }
        else if (!bill.isInput()) {
            jLabelAmount.setText("-" + amount.toString());
            jLabelAmount.setForeground(Color.red);
            if (!bill.isPaid()) {
                jButtonPaid.setVisible(false);
                jButtonPay.setVisible(true);
            }
        }
    }
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
            java.util.logging.Logger.getLogger(BillInformationInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillInformationInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillInformationInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillInformationInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillInformationInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPaid;
    private javax.swing.JButton jButtonPay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAmount;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelReference;
    private javax.swing.JLabel jLabelShowMessage;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
