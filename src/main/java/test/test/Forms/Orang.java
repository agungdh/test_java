/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.test.Forms;

import javax.swing.table.DefaultTableModel;
import org.javalite.activejdbc.LazyList;
import test.test.Helpers.ADHhelper;
import test.test.Models.OrangModel;

/**
 *
 * @author user
 */
public class Orang extends javax.swing.JFrame {
    /**
     * Creates new form Orang
     */
    public Orang() {
        initComponents();
        
        loadTable();
    }

    private void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        
        LazyList<OrangModel> orangs = OrangModel.findAll();
        
        model.addColumn("No");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        
        int i = 1;
        for(OrangModel orang : orangs) {
            ADHhelper.d(orang.toJson(true));
            model.addRow(new Object[]{i, orang.getString("nama"), orang.getString("alamat")});
            
            i++;
        }
        
        TableOrang.setModel(model);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollPane = new javax.swing.JScrollPane();
        TableOrang = new javax.swing.JTable();
        LabelOrang = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextNama = new javax.swing.JTextPane();
        LabelNama = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextAlamat = new javax.swing.JTextPane();
        LabelAlamat = new javax.swing.JLabel();
        ButtonTambah = new javax.swing.JButton();
        ButtonReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableOrang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TableOrang.getTableHeader().setReorderingAllowed(false);
        ScrollPane.setViewportView(TableOrang);

        LabelOrang.setText("Orang");

        jScrollPane1.setViewportView(TextNama);

        LabelNama.setText("Nama");

        jScrollPane2.setViewportView(TextAlamat);

        LabelAlamat.setText("Alamat");

        ButtonTambah.setText("Tambah");
        ButtonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTambahActionPerformed(evt);
            }
        });

        ButtonReset.setText("Reset");
        ButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelOrang)
                .addGap(159, 159, 159))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelNama)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonTambah)
                        .addGap(51, 51, 51)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ButtonReset)
                        .addGap(94, 94, 94))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LabelAlamat)
                        .addGap(120, 120, 120))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelOrang)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelAlamat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelNama)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonTambah)
                    .addComponent(ButtonReset))
                .addGap(18, 18, 18)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonResetActionPerformed
        resetForm();
    }//GEN-LAST:event_ButtonResetActionPerformed

    private void ButtonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTambahActionPerformed
        tambahData(TextNama.getText(), TextAlamat.getText());
        loadTable();
    }//GEN-LAST:event_ButtonTambahActionPerformed

    private void tambahData(String nama, String alamat) {
        OrangModel orang = new OrangModel();
        orang.set("nama", nama);
        orang.set("alamat", alamat);
        orang.save();
        ADHhelper.d(orang.getString("id"));
        ADHhelper.d(orang.toJson(true));
    }
    
    private void resetForm() {
        TextNama.setText("");
        TextAlamat.setText("");
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
            java.util.logging.Logger.getLogger(Orang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Orang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Orang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Orang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Orang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonReset;
    private javax.swing.JButton ButtonTambah;
    private javax.swing.JLabel LabelAlamat;
    private javax.swing.JLabel LabelNama;
    private javax.swing.JLabel LabelOrang;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTable TableOrang;
    private javax.swing.JTextPane TextAlamat;
    private javax.swing.JTextPane TextNama;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
