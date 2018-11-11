/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import Animacion.Animacion;
import Controllers.MainController;
import Models.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author federicoponcedeleon
 */
public class MenuInterface extends javax.swing.JFrame {

    /**
     * Creates new form MenuInterface
     */
    public MenuInterface() {
        initComponents();
        this.previousInterface = new JFrame();
        this.setLocationRelativeTo(null);
    }
    
    private JFrame previousInterface;
    public void setPreviousInterface(JFrame newinterface) {
        this.previousInterface = newinterface;
    }
    
    private void openFriends() {
        Animacion.bajar(-40, 70, 4, 2, jLabelAddFriend);
        Animacion.bajar(-40, 90, 4, 2, jLabelListOrDeleteFriend);
        Animacion.bajar(60, 100, 4, 2, jLabelMeeting);
        Animacion.bajar(70, 90, 6, 2, jLabelMeetingImg);
        Animacion.bajar(120, 160, 4, 2, jLabelPurchase);
        Animacion.bajar(110, 142, 6, 2, jLabelPurchaseImg);
        Animacion.bajar(180, 220, 4, 2, jLabelService);
        Animacion.bajar(150, 210, 6, 2, jLabelServiceImg);
        Animacion.bajar(240, 280, 4, 2, jLabelBill);
        Animacion.bajar(200, 250, 6, 2, jLabelBillImg);
    }
    
    private void closeFriends() {
        Animacion.subir(jLabelAddFriend.getY(), -40, 4, 2, jLabelAddFriend);
        Animacion.subir(jLabelListOrDeleteFriend.getY(), -40, 4, 2, jLabelListOrDeleteFriend);
        Animacion.subir(jLabelMeeting.getY(), 80, 4, 2, jLabelMeeting);
        Animacion.subir(jLabelMeetingImg.getY(), 70, 6, 2, jLabelMeetingImg);
        Animacion.subir(jLabelPurchase.getY(), 130, 4, 2, jLabelPurchase);
        Animacion.subir(jLabelPurchaseImg.getY(), 110, 6, 2, jLabelPurchaseImg);
        Animacion.subir(jLabelService.getY(), 190, 4, 2, jLabelService);
        Animacion.subir(jLabelServiceImg.getY(), 180, 6, 2, jLabelServiceImg);
        Animacion.subir(jLabelBill.getY(), 245, 4, 2, jLabelBill);
        Animacion.subir(jLabelBillImg.getY(), 230, 6, 2, jLabelBillImg);
    }
    
    private void openBill(){
        Animacion.bajar(-40, 275, 4, 2, jLabelAddBill);
        Animacion.bajar(-40, 295, 4, 2, jLabelListPaidBills);
        Animacion.bajar(-40, 315, 4, 2, jLabelListDidntPay);
        Animacion.bajar(-40, 335, 4, 2, jLabelListCharged);
        Animacion.bajar(-40, 355, 4, 2, jLabelListDidntCharged);
        Animacion.bajar(-40, 375, 4, 2, jLabelListAllBills);
        
    }
    
    private void closeBill() {
        Animacion.subir(jLabelAddBill.getY(), -40, 4, 2, jLabelAddBill);
        Animacion.subir(jLabelListPaidBills.getY(), -40, 4, 2, jLabelListPaidBills);
        Animacion.subir(jLabelListDidntPay.getY(), -40, 4, 2, jLabelListDidntPay);
        Animacion.subir(jLabelListCharged.getY(), -40, 4, 2, jLabelListCharged);
        Animacion.subir(jLabelListDidntCharged.getY(), -40, 4, 2, jLabelListDidntCharged);
        Animacion.subir(jLabelListAllBills.getY(), -40, 4, 2, jLabelListAllBills);
    }
    
    private void openService() {
        Animacion.bajar(-40, 220, 4, 2, jLabelAddService);
        Animacion.bajar(-40, 240, 4, 2, jLabelListOrDeleteService);
        Animacion.bajar(240, 260, 4, 2, jLabelBill);
        Animacion.bajar(200, 235, 6, 2, jLabelBillImg);
    }
    
    private void closeService() {
        Animacion.subir(jLabelAddService.getY(), -40, 4, 2, jLabelAddService);
        Animacion.subir(jLabelBill.getY(), -40, 4, 2, jLabelListOrDeleteService);
        Animacion.subir(jLabelBill.getY(), 245, 4, 2, jLabelBill);
        Animacion.subir(jLabelBillImg.getY(), 225, 6, 2, jLabelBillImg);
    }
    
    private void openPurchase() {
        
        Animacion.bajar(-40, 170, 4, 2, jLabelAddPurchase);
        Animacion.bajar(-40, 190, 4, 2, jLabelListOrDeletePurchase);
        Animacion.bajar(180, 210, 4, 2, jLabelService);
        Animacion.bajar(150, 195, 6, 2, jLabelServiceImg);
        Animacion.bajar(240, 280, 4, 2, jLabelBill);
        Animacion.bajar(200, 260, 6, 2, jLabelBillImg);
        
        
        
    }
    
    private void closePurchase() {
        Animacion.subir(jLabelAddPurchase.getY(), -40, 4, 2, jLabelAddPurchase);
        Animacion.subir(jLabelListOrDeletePurchase.getY(), -40, 4, 2, jLabelListOrDeletePurchase);
        Animacion.subir(jLabelService.getY(), 190, 4, 2, jLabelService);
        Animacion.subir(jLabelServiceImg.getY(), 180, 6, 2, jLabelServiceImg);
        Animacion.subir(jLabelBill.getY(), 245, 4, 2, jLabelBill);
        Animacion.subir(jLabelBillImg.getY(), 230, 6, 2, jLabelBillImg);
    }
    
    private void openMeeting() {
        Animacion.bajar(-40, 115, 4, 2, jLabelAddMeeting); //105
        Animacion.bajar(-40, 135, 4, 2, jLabelListAssisted); //126
        Animacion.bajar(-40, 155, 4, 2, jLabelListDidntAssisted); //147
        Animacion.bajar(-40, 175, 4, 2, jLabelOganized); //147
        Animacion.bajar(-40, 195, 4, 2, jLabelListAllMeetings); //147
        Animacion.bajar(jLabelPurchase.getY(), 205, 4, 2, jLabelPurchase);
        Animacion.bajar(jLabelPurchaseImg.getY(), 185, 6, 2, jLabelPurchaseImg);
        Animacion.bajar(jLabelService.getY(), 257, 4, 2, jLabelService);
        Animacion.bajar(jLabelServiceImg.getY(), 245, 6, 2, jLabelServiceImg);
        Animacion.bajar(jLabelBill.getY(), 310, 4, 2, jLabelBill);
        Animacion.bajar(jLabelBillImg.getY(), 290, 6, 2, jLabelBillImg);
    }
    
    private void closeMeeting() {
        Animacion.subir(jLabelAddMeeting.getY(), -40, 4, 2, jLabelAddMeeting);
        Animacion.subir(jLabelListAssisted.getY(), -40, 4, 2, jLabelListAssisted); //126
        Animacion.subir(jLabelListDidntAssisted.getY(), -40, 4, 2, jLabelListDidntAssisted); //147
        Animacion.subir(jLabelOganized.getY(), -40, 4, 2, jLabelOganized); //147
        Animacion.subir(jLabelListAllMeetings.getY(), -40, 4, 2, jLabelListAllMeetings); //147
        Animacion.subir(jLabelPurchase.getY(), 130, 4, 2, jLabelPurchase);
        Animacion.subir(jLabelPurchaseImg.getY(), 110, 6, 2, jLabelPurchaseImg);
        Animacion.subir(jLabelService.getY(), 183, 4, 2, jLabelService);
        Animacion.subir(jLabelServiceImg.getY(), 180, 6, 2, jLabelServiceImg);
        Animacion.subir(jLabelBill.getY(), 245, 4, 2, jLabelBill);
        Animacion.subir(jLabelBillImg.getY(), 230, 6, 2, jLabelBillImg);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelUserInfo = new javax.swing.JLabel();
        jLabelOcult = new javax.swing.JLabel();
        jLabelFriendImg = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelFriends = new javax.swing.JLabel();
        jLabelAddFriend = new javax.swing.JLabel();
        jLabelListOrDeleteFriend = new javax.swing.JLabel();
        jLabelMeeting = new javax.swing.JLabel();
        jLabelMeetingImg = new javax.swing.JLabel();
        jLabelPurchaseImg = new javax.swing.JLabel();
        jLabelPurchase = new javax.swing.JLabel();
        jLabelServiceImg = new javax.swing.JLabel();
        jLabelService = new javax.swing.JLabel();
        jLabelBill = new javax.swing.JLabel();
        jLabelBillImg = new javax.swing.JLabel();
        jLabelAddMeeting = new javax.swing.JLabel();
        jLabelListAssisted = new javax.swing.JLabel();
        jLabelListDidntAssisted = new javax.swing.JLabel();
        jLabelOganized = new javax.swing.JLabel();
        jLabelListAllMeetings = new javax.swing.JLabel();
        jLabelAddPurchase = new javax.swing.JLabel();
        jLabelListOrDeletePurchase = new javax.swing.JLabel();
        jLabelAddService = new javax.swing.JLabel();
        jLabelListOrDeleteService = new javax.swing.JLabel();
        jLabelAddBill = new javax.swing.JLabel();
        jLabelListCharged = new javax.swing.JLabel();
        jLabelListDidntCharged = new javax.swing.JLabel();
        jLabelListPaidBills = new javax.swing.JLabel();
        jLabelListDidntPay = new javax.swing.JLabel();
        jLabelListAllBills = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelUserInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/person-icon.png"))); // NOI18N
        jLabelUserInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelUserInfoMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelUserInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, -10, 120, 90));

        jLabelOcult.setText("Ocultar");
        jLabelOcult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelOcultMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelOcult, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 70, 30));

        jLabelFriendImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/friends-icon.png"))); // NOI18N
        jPanel1.add(jLabelFriendImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 90, 70));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/person-icon.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, -10, 120, 90));

        jLabelFriends.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabelFriends.setText("Amigos");
        jLabelFriends.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelFriendsMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelFriends, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 120, 30));

        jLabelAddFriend.setText("Agregar");
        jLabelAddFriend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddFriendMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelAddFriend, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -40, -1, -1));

        jLabelListOrDeleteFriend.setText("Ver/Eliminar");
        jLabelListOrDeleteFriend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelListOrDeleteFriendMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelListOrDeleteFriend, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -40, -1, -1));

        jLabelMeeting.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabelMeeting.setText("Reuniones");
        jLabelMeeting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMeetingMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelMeeting, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 120, 40));

        jLabelMeetingImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/meeting-icon.png"))); // NOI18N
        jPanel1.add(jLabelMeetingImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 90, 50));

        jLabelPurchaseImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/purchase-icon.png"))); // NOI18N
        jPanel1.add(jLabelPurchaseImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 110, 90, 80));

        jLabelPurchase.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabelPurchase.setText("Compras");
        jLabelPurchase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPurchaseMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelPurchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 110, 50));

        jLabelServiceImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/service-icon.png"))); // NOI18N
        jPanel1.add(jLabelServiceImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 180, 90, 60));

        jLabelService.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabelService.setText("Servicios");
        jLabelService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelServiceMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelService, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 190, 110, 30));

        jLabelBill.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabelBill.setText("Gastos");
        jLabelBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBillMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 100, 30));

        jLabelBillImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bill-icon.png"))); // NOI18N
        jPanel1.add(jLabelBillImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 225, 90, 70));

        jLabelAddMeeting.setText("Agregar");
        jLabelAddMeeting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddMeetingMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelAddMeeting, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -40, -1, -1));

        jLabelListAssisted.setText("Ver/Eliminar asistidas");
        jLabelListAssisted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelListAssistedMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelListAssisted, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -40, -1, -1));

        jLabelListDidntAssisted.setText("Ver/Eliminar no asistidas");
        jLabelListDidntAssisted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelListDidntAssistedMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelListDidntAssisted, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -40, -1, -1));

        jLabelOganized.setText("Ver/Eliminar organizadas");
        jLabelOganized.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelOganizedMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelOganized, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -40, -1, -1));

        jLabelListAllMeetings.setText("Ver/Eliminar todas");
        jLabelListAllMeetings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelListAllMeetingsMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelListAllMeetings, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -40, -1, -1));

        jLabelAddPurchase.setText("Agregar");
        jLabelAddPurchase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddPurchaseMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelAddPurchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -40, -1, -1));

        jLabelListOrDeletePurchase.setText("Ver/Eliminar");
        jLabelListOrDeletePurchase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelListOrDeletePurchaseMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelListOrDeletePurchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -40, -1, -1));

        jLabelAddService.setText("Agregar");
        jLabelAddService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddServiceMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelAddService, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -40, -1, -1));

        jLabelListOrDeleteService.setText("Ver/Eliminar");
        jLabelListOrDeleteService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelListOrDeleteServiceMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelListOrDeleteService, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -40, -1, -1));

        jLabelAddBill.setText("Agregar");
        jLabelAddBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddBillMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelAddBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -40, -1, -1));

        jLabelListCharged.setText("Ver cobrados");
        jLabelListCharged.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelListChargedMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelListCharged, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -40, -1, -1));

        jLabelListDidntCharged.setText("Ver no cobrados");
        jLabelListDidntCharged.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelListDidntChargedMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelListDidntCharged, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -40, -1, -1));

        jLabelListPaidBills.setText("Ver pagos");
        jLabelListPaidBills.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelListPaidBillsMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelListPaidBills, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -40, -1, -1));

        jLabelListDidntPay.setText("Ver no pago");
        jLabelListDidntPay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelListDidntPayMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelListDidntPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -40, -1, -1));

        jLabelListAllBills.setText("Ver todos");
        jLabelListAllBills.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelListAllBillsMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelListAllBills, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -40, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabelUserInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelUserInfoMouseClicked
        this.previousInterface.setVisible(false);
        this.previousInterface.dispose();
        User currentUser = MainController.instance().getCurrentUser();
        UserInformation userInterface = new UserInformation();
        userInterface.setUser(currentUser);
        userInterface.showPersonalInfo();
        userInterface.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabelUserInfoMouseClicked

    private void jLabelOcultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelOcultMouseClicked
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_jLabelOcultMouseClicked

    private void jLabelFriendsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFriendsMouseClicked
        if (jLabelAddMeeting.getY() > 0) this.closeMeeting();
        if (jLabelAddPurchase.getY() > 0) this.closePurchase();
        if (jLabelAddService.getY() > 0) this.closeService();
        if (jLabelAddBill.getY() > 0) this.closeBill();
        if (jLabelAddFriend.getY() < 0) {
            this.openFriends();
        }
        else {
            this.closeFriends();
        }
    }//GEN-LAST:event_jLabelFriendsMouseClicked

    private void jLabelMeetingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMeetingMouseClicked
        if (jLabelAddFriend.getY() > 0) this.closeFriends();
        if (jLabelAddPurchase.getY() > 0) this.closePurchase();
        if (jLabelAddService.getY() > 0) this.closeService();
        if (jLabelAddBill.getY() > 0) this.closeBill();
        if (jLabelAddMeeting.getY() < 0) {
            this.openMeeting();
        }
        else {
            this.closeMeeting();
        }

    }//GEN-LAST:event_jLabelMeetingMouseClicked

    private void jLabelPurchaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPurchaseMouseClicked
        if (jLabelAddFriend.getY() > 0) this.closeFriends();
        if (jLabelAddMeeting.getY() > 0) this.closeMeeting();
        if (jLabelAddService.getY() > 0) this.closeService();
        if (jLabelAddBill.getY() > 0) this.closeBill();
        if (jLabelAddPurchase.getY() < 0) {
            this.openPurchase();
        }
        else {
            this.closePurchase();
        }
    }//GEN-LAST:event_jLabelPurchaseMouseClicked

    private void jLabelServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelServiceMouseClicked
        if (jLabelAddFriend.getY() > 0) this.closeFriends();
        if (jLabelAddMeeting.getY() > 0) this.closeMeeting();
        if (jLabelAddPurchase.getY() > 0) this.closePurchase();
        if (jLabelAddBill.getY() > 0) this.closeBill();
        if (jLabelAddService.getY() < 0) {
            this.openService();
        }
        else {
            this.closeService();
        }
    }//GEN-LAST:event_jLabelServiceMouseClicked

    private void jLabelBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBillMouseClicked
        if (jLabelAddFriend.getY() > 0) this.closeFriends();
        if (jLabelAddMeeting.getY() > 0) this.closeMeeting();
        if (jLabelAddPurchase.getY() > 0) this.closePurchase();
        if (jLabelAddService.getY() > 0) this.closeService();
        if (jLabelAddBill.getY() < 0) {
            this.openBill();
        }
        else {
            this.closeBill();
        }
    }//GEN-LAST:event_jLabelBillMouseClicked

    private void jLabelAddFriendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddFriendMouseClicked
        //agregar amigo
        this.previousInterface.setVisible(false);
        this.previousInterface.dispose();
        AddFriend interf = new AddFriend();
        interf.setVisible(true);
        interf.setLocationRelativeTo(this);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabelAddFriendMouseClicked

    private void jLabelListOrDeleteFriendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelListOrDeleteFriendMouseClicked
        this.previousInterface.setVisible(false);
        this.previousInterface.dispose();
        FriendsInterface interf = new FriendsInterface();
        interf.listFriends();
        interf.setVisible(true);
        interf.setLocationRelativeTo(this);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabelListOrDeleteFriendMouseClicked

    private void jLabelAddMeetingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddMeetingMouseClicked
        //agregar reunion
        this.previousInterface.setVisible(false);
        this.previousInterface.dispose();
        AddMeetingInterface interf = new AddMeetingInterface();
        interf.setVisible(true);
        interf.setLocationRelativeTo(this);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabelAddMeetingMouseClicked

    private void jLabelListAssistedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelListAssistedMouseClicked
        // ver asistidas
        this.previousInterface.setVisible(false);
        this.previousInterface.dispose();
        MeetingInterface interf = new MeetingInterface();
        interf.listMeetings(0);
        interf.setVisible(true);
        interf.setLocationRelativeTo(this);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabelListAssistedMouseClicked

    private void jLabelListDidntAssistedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelListDidntAssistedMouseClicked
        // ver no asistidas
        this.previousInterface.setVisible(false);
        this.previousInterface.dispose();
        MeetingInterface interf = new MeetingInterface();
        interf.listMeetings(1);
        interf.setVisible(true);
        interf.setLocationRelativeTo(this);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabelListDidntAssistedMouseClicked

    private void jLabelOganizedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelOganizedMouseClicked
        // ver organizadas
        MeetingInterface interf = new MeetingInterface();
        interf.listMeetings(2);
        interf.setVisible(true);
        interf.setLocationRelativeTo(this);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabelOganizedMouseClicked

    private void jLabelListAllMeetingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelListAllMeetingsMouseClicked
        // ver todas las reuniones
        this.previousInterface.setVisible(false);
        this.previousInterface.dispose();
        MeetingInterface interf = new MeetingInterface();
        interf.listMeetings(3);
        interf.setVisible(true);
        interf.setLocationRelativeTo(this);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabelListAllMeetingsMouseClicked

    private void jLabelAddPurchaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddPurchaseMouseClicked
        // agregar compra
        this.previousInterface.setVisible(false);
        this.previousInterface.dispose();
        AddPurchase interf = new AddPurchase(); //necesita setear el usuId?? Se supone que solo puede ser el current. Solo se deberia
        interf.showTable();
        interf.setVisible(true);                //setear el reunion id cuando la compra es de reunion. Para eso se podria llamar con bool
        interf.setLocationRelativeTo(this);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabelAddPurchaseMouseClicked

    private void jLabelListOrDeletePurchaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelListOrDeletePurchaseMouseClicked
        try {
            // ver o eliminar compra
            this.previousInterface.setVisible(false);
            this.previousInterface.dispose();
            PurchaseInterface interf = new PurchaseInterface();
            interf.showPurchases();
            interf.setVisible(true);
            interf.setLocationRelativeTo(this);
            this.setVisible(false);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(MenuInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelListOrDeletePurchaseMouseClicked

    private void jLabelAddServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddServiceMouseClicked
        // agregar servicio
        this.previousInterface.setVisible(false);
        this.previousInterface.dispose();
        AddServiceInterface interf = new AddServiceInterface();
        interf.setVisible(true);
        interf.setLocationRelativeTo(this);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabelAddServiceMouseClicked

    private void jLabelListOrDeleteServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelListOrDeleteServiceMouseClicked
        // ver/eliminar servicio
        this.previousInterface.setVisible(false);
        this.previousInterface.dispose();
        ServiceInterface interf = new ServiceInterface();
        interf.setVisible(true);
        interf.setLocationRelativeTo(this);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabelListOrDeleteServiceMouseClicked

    private void jLabelAddBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddBillMouseClicked
        // agregar bill
        this.previousInterface.setVisible(false);
        this.previousInterface.dispose();
        AddBillInterface interf = new AddBillInterface();
        interf.setVisible(true);
        interf.setLocationRelativeTo(this);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabelAddBillMouseClicked

    private void jLabelListChargedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelListChargedMouseClicked
        // ver cobrados
        this.previousInterface.setVisible(false);
        this.previousInterface.dispose();
        BillInterface interf = new BillInterface();
        
        interf.setVisible(true);
        interf.setLocationRelativeTo(this);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabelListChargedMouseClicked

    private void jLabelListDidntChargedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelListDidntChargedMouseClicked
        // ver no cobrados
        this.previousInterface.setVisible(false);
        this.previousInterface.dispose();
        BillInterface interf = new BillInterface();
        
        interf.setVisible(true);
        interf.setLocationRelativeTo(this);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabelListDidntChargedMouseClicked

    private void jLabelListPaidBillsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelListPaidBillsMouseClicked
        // ver pagos
        this.previousInterface.setVisible(false);
        this.previousInterface.dispose();
        BillInterface interf = new BillInterface();
        interf.setVisible(true);
        interf.setLocationRelativeTo(this);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabelListPaidBillsMouseClicked

    private void jLabelListDidntPayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelListDidntPayMouseClicked
        // ver no pagos
        this.previousInterface.setVisible(false);
        this.previousInterface.dispose();
        BillInterface interf = new BillInterface();
        interf.setVisible(true);
        interf.setLocationRelativeTo(this);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabelListDidntPayMouseClicked

    private void jLabelListAllBillsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelListAllBillsMouseClicked
        // ver todos los gastos
        this.previousInterface.setVisible(false);
        this.previousInterface.dispose();
        BillInterface interf = new BillInterface();
        interf.setVisible(true);
        interf.setLocationRelativeTo(this);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabelListAllBillsMouseClicked

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
            java.util.logging.Logger.getLogger(MenuInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelAddBill;
    private javax.swing.JLabel jLabelAddFriend;
    private javax.swing.JLabel jLabelAddMeeting;
    private javax.swing.JLabel jLabelAddPurchase;
    private javax.swing.JLabel jLabelAddService;
    private javax.swing.JLabel jLabelBill;
    private javax.swing.JLabel jLabelBillImg;
    private javax.swing.JLabel jLabelFriendImg;
    private javax.swing.JLabel jLabelFriends;
    private javax.swing.JLabel jLabelListAllBills;
    private javax.swing.JLabel jLabelListAllMeetings;
    private javax.swing.JLabel jLabelListAssisted;
    private javax.swing.JLabel jLabelListCharged;
    private javax.swing.JLabel jLabelListDidntAssisted;
    private javax.swing.JLabel jLabelListDidntCharged;
    private javax.swing.JLabel jLabelListDidntPay;
    private javax.swing.JLabel jLabelListOrDeleteFriend;
    private javax.swing.JLabel jLabelListOrDeletePurchase;
    private javax.swing.JLabel jLabelListOrDeleteService;
    private javax.swing.JLabel jLabelListPaidBills;
    private javax.swing.JLabel jLabelMeeting;
    private javax.swing.JLabel jLabelMeetingImg;
    private javax.swing.JLabel jLabelOcult;
    private javax.swing.JLabel jLabelOganized;
    private javax.swing.JLabel jLabelPurchase;
    private javax.swing.JLabel jLabelPurchaseImg;
    private javax.swing.JLabel jLabelService;
    private javax.swing.JLabel jLabelServiceImg;
    private javax.swing.JLabel jLabelUserInfo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
