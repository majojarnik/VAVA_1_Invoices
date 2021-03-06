/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import sk.stu.fiit.model.Commodity;
import sk.stu.fiit.model.Customer;
import sk.stu.fiit.model.Invoice;

/**
 *
 * @author jarni
 */
public class ShowInvoice extends javax.swing.JFrame {

    /**
     * Creates new form ShowInvoice
     */
    public ShowInvoice() {
    }
    
    Invoice inv;
    
    public void initializeShowInvoice(Invoice inv){
        this.inv = inv;
        initComponents();
    }
    
    private TableModel initializeCustomerTable(){
        List<String> columns = new ArrayList<String>();
        List<String[]> values = new ArrayList<String[]>();

        values.add(new String[] {inv.getCustomer().getName(), inv.getCustomer().getStreet(), inv.getCustomer().getCity(), inv.getCustomer().getPsc()});

        columns.add("Meno a priezvisko");
        columns.add("Ulica, č.d.");
        columns.add("Mesto");
        columns.add("PSČ");

        TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
        return tableModel;
    }
    
    private TableModel initializeCommoditiesTable(){
        List<String> columns = new ArrayList<String>();
        List<String[]> values = new ArrayList<String[]>();

        for (Commodity com: inv.getCommodities()){
            values.add(new String[] {com.getName(), com.getDesc(), String.valueOf(com.getPrice() / 100.0), String.valueOf(com.getNumber())});
        }

        columns.add("Názov");
        columns.add("Opis tovaru");
        columns.add("Cena");
        columns.add("Množstvo");

        TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
        return tableModel;
    }
    
    private String countPrice(){
        double price = 0;
        for (Commodity com: inv.getCommodities()){
            price += com.getPrice()/100.0 * com.getNumber();
        }
        return String.format("%.2f EUR", price);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDateValue = new javax.swing.JLabel();
        lblCommodity = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCommodity = new javax.swing.JTable();
        lblInfoPrice = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();
        lblCustomer = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 470));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDateValue.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblDateValue.setText(String.valueOf(inv.getDate()));
        getContentPane().add(lblDateValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        lblCommodity.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblCommodity.setText("Zoznam tovarov");
        getContentPane().add(lblCommodity, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        tableCommodity.setModel(initializeCommoditiesTable());
        jScrollPane3.setViewportView(tableCommodity);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 430, 130));

        lblInfoPrice.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblInfoPrice.setText("Celková cena:");
        getContentPane().add(lblInfoPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, 20));

        lblPrice.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblPrice.setText(countPrice());
        getContentPane().add(lblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, -1, -1));

        tableCustomer.setModel(initializeCustomerTable());
        jScrollPane1.setViewportView(tableCustomer);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 430, 50));

        lblCustomer.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblCustomer.setText("Zákazník");
        getContentPane().add(lblCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        lblDate.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblDate.setText("Dátum");
        getContentPane().add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        btnClose.setText("OK");
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 70, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

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
            java.util.logging.Logger.getLogger(ShowInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowInvoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCommodity;
    private javax.swing.JLabel lblCustomer;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDateValue;
    private javax.swing.JLabel lblInfoPrice;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JTable tableCommodity;
    private javax.swing.JTable tableCustomer;
    // End of variables declaration//GEN-END:variables
}
