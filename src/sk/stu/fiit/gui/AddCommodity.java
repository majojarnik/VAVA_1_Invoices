/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.gui;

import javax.swing.JFrame;
import sk.stu.fiit.controllers.CommodityController;
import javax.swing.JOptionPane;
import sk.stu.fiit.data.Data;
import sk.stu.fiit.exceptions.BlankFields;
import sk.stu.fiit.model.Commodity;

/**
 *
 * @author jarni
 */
public class AddCommodity extends javax.swing.JFrame {

    /**
     * Creates new form AddCommodity
     */
    
    private TablesCommodity parent;

    private boolean editing = false;
    private Commodity comm;
    
    public void initializeEdit(Commodity comm){
        lblHeading.setText("Úprava tovaru");
        tfdName.setText(comm.getName());
        txaDesc.setText(comm.getDesc());
        tfdPrice.setText(String.valueOf(comm.getPrice() / 100.0));
        editing = true;
        this.comm = comm;
    }

    
    public AddCommodity() {
        initComponents();
    }
    
    public void initializeAddCommodity(TablesCommodity parent){
        this.parent = parent;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeading = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        tfdName = new javax.swing.JTextField();
        tfdPrice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDesc = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblDesc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));
        setSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeading.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblHeading.setText("Pridanie tovaru");
        getContentPane().add(lblHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        lblName.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblName.setText("Názov");
        lblName.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblNamePropertyChange(evt);
            }
        });
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        lblPrice.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblPrice.setText("Cena");
        getContentPane().add(lblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));
        getContentPane().add(tfdName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 260, -1));

        tfdPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdPriceActionPerformed(evt);
            }
        });
        getContentPane().add(tfdPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 260, -1));

        txaDesc.setColumns(20);
        txaDesc.setRows(5);
        jScrollPane1.setViewportView(txaDesc);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 260, 100));

        btnSave.setText("Uložiť");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        btnCancel.setText("Zrušiť");
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, -1, -1));

        lblDesc.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblDesc.setText("Popis");
        getContentPane().add(lblDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    CommodityController cuscon = new CommodityController();

    private void tfdPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdPriceActionPerformed

    private void lblNamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblNamePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_lblNamePropertyChange

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String name = tfdName.getText();
        String desc = txaDesc.getText();
        String price = tfdPrice.getText();
        
        try {
            if (editing)
                cuscon.editCommodity(comm, name, desc, price);
            else
                cuscon.addCommodity(name, desc, price);
            
            System.out.println(Data.getAllCommodities());
            setVisible(false);
            parent.initializeCommodityTable();
            

        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(rootPane, "Cena musí obsahovať reálne číslo.", "Chyba v cene", JOptionPane.ERROR_MESSAGE);
        } catch (BlankFields ex) {
            JOptionPane.showMessageDialog(rootPane, "Musite vyplnit vsetky polia", "Nevyplnene polia", JOptionPane.ERROR_MESSAGE);
        }
      
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelMouseClicked

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
            java.util.logging.Logger.getLogger(AddCommodity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCommodity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCommodity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCommodity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCommodity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JTextField tfdName;
    private javax.swing.JTextField tfdPrice;
    private javax.swing.JTextArea txaDesc;
    // End of variables declaration//GEN-END:variables
}