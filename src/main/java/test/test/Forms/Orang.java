/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.test.Forms;

import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.DBException;
import org.javalite.activejdbc.LazyList;
import test.test.Models.OrangModel;

/**
 *
 * @author user
 */
public class Orang extends javax.swing.JInternalFrame {
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
        
        Base.open();
        LazyList<OrangModel> orangs = OrangModel.findAll();
        Base.close();
        
        model.addColumn("#ID");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        
        Base.open();
        for(OrangModel orang : orangs) {
            model.addRow(new Object[]{orang.getId(), orang.getString("nama"), orang.getString("alamat")});
        }
        Base.close();
        
        TableOrang.setModel(model);
        
        setState("index");
    }
    
    private void hapusData() {
        Base.open();
        OrangModel orang = OrangModel.findById(ID);
        try {
            orang.delete();
        } catch (DBException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        Base.close();
    }
    
    private void setState(String IndexOrEdit) {
        if (IndexOrEdit.equals("index")) {
            ButtonTambahUbah.setText("Tambah");
            ButtonResetHapus.setText("Reset");
            ButtonBarang.setEnabled(false);
            
            state = IndexOrEdit;
        } else if (IndexOrEdit.equals("edit")) {
            ButtonTambahUbah.setText("Ubah");
            ButtonResetHapus.setText("Hapus");
            ButtonBarang.setEnabled(true);
            
            state = IndexOrEdit;
        } else {
            JOptionPane.showMessageDialog(null, "Index/Edit ?");
        }
    }
    
    private void tambahData(String nama, String alamat) {
        Base.open();
        OrangModel orang = new OrangModel();
        orang.set("nama", nama);
        orang.set("alamat", alamat);
        orang.save();
        Base.close();
    }
    
    private void ubahData(String id, String nama, String alamat) {
        Base.open();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonTambahUbah = new javax.swing.JButton();
        ButtonResetHapus = new javax.swing.JButton();
        ButtonBarang = new javax.swing.JButton();
        ScrollPane = new javax.swing.JScrollPane();
        TableOrang = new javax.swing.JTable();
        LabelAlamat = new javax.swing.JLabel();
        LabelNama = new javax.swing.JLabel();
        TextNama = new javax.swing.JTextField();
        TextAlamat = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Orang");

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

        ButtonBarang.setText("Barang");
        ButtonBarang.setEnabled(false);
        ButtonBarang.setMaximumSize(new java.awt.Dimension(61, 23));
        ButtonBarang.setMinimumSize(new java.awt.Dimension(61, 23));
        ButtonBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBarangActionPerformed(evt);
            }
        });

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

        LabelAlamat.setText("Alamat");

        LabelNama.setText("Nama");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonTambahUbah)
                        .addGap(112, 112, 112)
                        .addComponent(ButtonResetHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LabelAlamat)
                    .addComponent(LabelNama))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextNama)
                    .addComponent(TextAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelNama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelAlamat)
                    .addComponent(TextAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ButtonTambahUbah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonResetHapus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonBarang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void ButtonResetHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonResetHapusActionPerformed
        if (state.equals("edit")) {
            hapusData();
            loadTable();
        }

        resetForm();
    }//GEN-LAST:event_ButtonResetHapusActionPerformed

    private void ButtonBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBarangActionPerformed
        Barang barang = new Barang(ID);
        JDesktopPane desktopPane = getDesktopPane();
        desktopPane.add(barang);
        barang.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_ButtonBarangActionPerformed

    private void TableOrangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableOrangMouseClicked
        int i =TableOrang.getSelectedRow();
        if(i>=0){
            ID = model.getValueAt(i, 0).toString();

            Base.open();
            OrangModel orang = OrangModel.findById(ID);
            Base.close();

            TextNama.setText(orang.getString("nama"));
            TextAlamat.setText(orang.getString("alamat"));

            setState("edit");
        }
    }//GEN-LAST:event_TableOrangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBarang;
    private javax.swing.JButton ButtonResetHapus;
    private javax.swing.JButton ButtonTambahUbah;
    private javax.swing.JLabel LabelAlamat;
    private javax.swing.JLabel LabelNama;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTable TableOrang;
    private javax.swing.JTextField TextAlamat;
    private javax.swing.JTextField TextNama;
    // End of variables declaration//GEN-END:variables
}
