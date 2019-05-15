/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.test.Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class TestAja {
    public static void main(String args[]) {
        try {
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_aplikasi_rekam_medis","root","");
            
            System.out.println("Baru");
            for (int i = 1; i <= 12; i++) {
                ResultSet rs = koneksi.createStatement().executeQuery(""
                        + "SELECT count(id_pendaftaran_kunjungan_pasien) total\n" +
                            "FROM `t_pendaftaran_kunjungan_pasien`\n" +
                            "WHERE year(tanggal_pendaftaran_kunjungan_pasien) = '2019'\n" +
                            "AND status_jenis_kunjungan = 'Baru'" +
                            "AND month(tanggal_pendaftaran_kunjungan_pasien) = '"+i+"'");
                boolean dummyNext = rs.next();
                System.out.println(rs.getString("total"));
            }

            System.out.println("Lama");
            for (int i = 1; i <= 12; i++) {
                ResultSet rs = koneksi.createStatement().executeQuery(""
                        + "SELECT count(id_pendaftaran_kunjungan_pasien) total\n" +
                            "FROM `t_pendaftaran_kunjungan_pasien`\n" +
                            "WHERE year(tanggal_pendaftaran_kunjungan_pasien) = '2019'\n" +
                            "AND status_jenis_kunjungan = 'Lama'" +
                            "AND month(tanggal_pendaftaran_kunjungan_pasien) = '"+i+"'");
                boolean dummyNext = rs.next();
                System.out.println(rs.getString("total"));
            }
            

            
//            ResultSet rs = koneksi.createStatement().executeQuery("select * from t_pendaftaran_kunjungan_pasien");
//            ResultSet rs2 = koneksi.createStatement().executeQuery("select * from t_pendaftaran_kunjungan_pasien");
//
//            boolean dummyNext = rs.next();
//            System.out.println(rs.getString("nama_pasien"));
//            boolean dummyNext2 = rs2.next();
//            System.out.println(rs2.getString("nama_pasien"));
            
            koneksi.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
