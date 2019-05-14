/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.test.Forms;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import test.test.Helpers.ADHhelper;
import test.test.Models.OrangModel;
import test.test.Config.ActiveJDBC;

/**
 *
 * @author user
 */
public class Orang extends javax.swing.JFrame {
    private DefaultTableModel model = new DefaultTableModel();
    private String ID;
    private String state;
    
    /**
     * Creates new form Orang
     */
    public Orang() {
        initComponents();
        
        loadTable();
    }

    private void loadTable() {
        model = new DefaultTableModel();
        
        ActiveJDBC.Init();
        LazyList<OrangModel> orangs = OrangModel.findAll();
        
        model.addColumn("#ID");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        
        for(OrangModel orang : orangs) {
            model.addRow(new Object[]{orang.getId(), orang.getString("nama"), orang.getString("alamat"), orang.getId()});
        }
        Base.close();
        TableOrang.setModel(model);
        
        setState("index");
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
        ButtonTambahUbah = new javax.swing.JButton();
        ButtonResetHapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableOrang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TableOrang.getTableHeader().setReorderingAllowed(false);
        TableOrang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableOrangMouseClicked(evt);
            }
        });
        ScrollPane.setViewportView(TableOrang);

        LabelOrang.setText("Orang");

        jScrollPane1.setViewportView(TextNama);

        LabelNama.setText("Nama");

        jScrollPane2.setViewportView(TextAlamat);

        LabelAlamat.setText("Alamat");

        ButtonTambahUbah.setText("Tambah");
        ButtonTambahUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTambahUbahActionPerformed(evt);
            }
        });

        ButtonResetHapus.setText("Reset");
        ButtonResetHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonResetHapusActionPerformed(evt);
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
                        .addComponent(ButtonTambahUbah)
                        .addGap(51, 51, 51)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ButtonResetHapus)
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
                    .addComponent(ButtonTambahUbah)
                    .addComponent(ButtonResetHapus))
                .addGap(18, 18, 18)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonResetHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonResetHapusActionPerformed
        if (state.equals("edit")) {
            hapusData();
            loadTable();
        }
        
        resetForm();
    }//GEN-LAST:event_ButtonResetHapusActionPerformed

    private void hapusData() {
        ActiveJDBC.Init();
        OrangModel orang = OrangModel.findById(ID);
        orang.delete();
        Base.close();
    }
    
    private void ButtonTambahUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTambahUbahActionPerformed
        if (state.equals("index")) {
            if (TextNama.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Form Nama Masih Kosong !!!");
            } else if(TextAlamat.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Form Alamat Masih Kosong !!!");
            } else {
                tambahData(TextNama.getText(), TextAlamat.getText());
                resetForm();
                loadTable();
            }
        } else {
            if (TextNama.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Form Nama Masih Kosong !!!");
            } else if(TextAlamat.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Form Alamat Masih Kosong !!!");
            } else {
                ubahData(ID, TextNama.getText(), TextAlamat.getText());
                resetForm();
                loadTable();
            }
        }
    }//GEN-LAST:event_ButtonTambahUbahActionPerformed

    private void TableOrangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableOrangMouseClicked
        int i =TableOrang.getSelectedRow();
        if(i>=0){
            ID = model.getValueAt(i, 0).toString();
            ActiveJDBC.Init();
            OrangModel orang = OrangModel.findById(ID);
            TextNama.setText(orang.getString("nama"));
            TextAlamat.setText(orang.getString("alamat"));
            Base.close();
            
            setState("edit");
        }
    }//GEN-LAST:event_TableOrangMouseClicked

    private void setState(String IndexOrEdit) {
        if (IndexOrEdit.equals("index")) {
            ButtonTambahUbah.setText("Tambah");
            ButtonResetHapus.setText("Reset");
            
            state = IndexOrEdit;
        } else if (IndexOrEdit.equals("edit")) {
            ButtonTambahUbah.setText("Ubah");
            ButtonResetHapus.setText("Hapus");
            
            state = IndexOrEdit;
        } else {
            JOptionPane.showMessageDialog(null, "Index/Edit ?");
        }
    }
    
    private void tambahData(String nama, String alamat) {
        ActiveJDBC.Init();
        OrangModel orang = new OrangModel();
        orang.set("nama", nama);
        orang.set("alamat", alamat);
        orang.save();
        Base.close();
    }
    
    private void ubahData(String id, String nama, String alamat) {
        ActiveJDBC.Init();
        OrangModel orang = OrangModel.findById(id);
        orang.set("nama", nama);
        orang.set("alamat", alamat);
        orang.save();
        Base.close();
    }

    private void resetForm() {
        TextNama.setText("");
        TextAlamat.setText("");
    }
    
    private void checkState() {
        
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
    private javax.swing.JButton ButtonResetHapus;
    private javax.swing.JButton ButtonTambahUbah;
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
