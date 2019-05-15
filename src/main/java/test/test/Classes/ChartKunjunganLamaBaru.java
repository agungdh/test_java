package test.test.Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.chart.ui.ApplicationFrame; 

public class ChartKunjunganLamaBaru extends ApplicationFrame {
   
   public ChartKunjunganLamaBaru( String applicationTitle , String chartTitle ) {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Tahun 2019",            
         "Jumlah Kunjungan",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   
   private CategoryDataset createDataset( ) {
      final String fiat = "Baru";        
      final String audi = "Lama";        
      final String speed = "Speed";        
      final String millage = "Millage";        
      final String userrating = "User Rating";        
      final String safety = "safety";        
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      try {
        Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_aplikasi_rekam_medis","root","");
        
        for (int i = 1; i <= 12; i++) {
            ResultSet rs = koneksi.createStatement().executeQuery(""
                    + "SELECT count(id_pendaftaran_kunjungan_pasien) total\n" +
                        "FROM `t_pendaftaran_kunjungan_pasien`\n" +
                        "WHERE year(tanggal_pendaftaran_kunjungan_pasien) = '2019'\n" +
                        "AND status_jenis_kunjungan = 'Baru'" +
                        "AND month(tanggal_pendaftaran_kunjungan_pasien) = '"+i+"'");
            boolean dummyNext = rs.next();
            dataset.addValue( Integer.parseInt(rs.getString("total")) , "Baru" , bulan(i) );
        }

        for (int i = 1; i <= 12; i++) {
            ResultSet rs = koneksi.createStatement().executeQuery(""
                    + "SELECT count(id_pendaftaran_kunjungan_pasien) total\n" +
                        "FROM `t_pendaftaran_kunjungan_pasien`\n" +
                        "WHERE year(tanggal_pendaftaran_kunjungan_pasien) = '2019'\n" +
                        "AND status_jenis_kunjungan = 'Lama'" +
                        "AND month(tanggal_pendaftaran_kunjungan_pasien) = '"+i+"'");
            boolean dummyNext = rs.next();
            dataset.addValue( Integer.parseInt(rs.getString("total")) , "Lama" , bulan(i) );
        }
        
        koneksi.close();
      } catch (Exception e) {
          
      }
      
      return dataset; 
   }
   
   public static void main( String[ ] args ) {
      ChartKunjunganLamaBaru chart = new ChartKunjunganLamaBaru("Grafik Pendaftaran Kunjungan Pasien Tahun 2019", 
         "Grafik Pendaftaran Kunjungan Pasien Tahun 2019");
      chart.pack( );        
      chart.setVisible( true ); 
   }
   
   public static String bulan(int i) {
        switch(i) {
            case 1:
              return "Januari";
            case 2:
              return "Februari";
            case 3:
              return "Maret";
            case 4:
              return "April";
            case 5:
              return "Mei";
            case 6:
              return "Juni";
            case 7:
              return "Juli";
            case 8:
              return "Agustus";
            case 9:
              return "September";
            case 10:
              return "Oktober";
            case 11:
              return "November";
            case 12:
              return "Desember";
            default:
              return "ERROR !!!";
          }
    }
}