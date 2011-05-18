/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import workshop.minimarket.entity.Barang;
import workshop.minimarket.entity.Grup;
import workshop.minimarket.entity.Pengguna;
import workshop.minimarket.entity.Penjualan;
import workshop.minimarket.entity.PenjualanDetail;
import workshop.minimarket.entity.Produk;
import workshop.minimarket.service.MinimarketService;

/**
 *
 * @author Jaka
 */
public class MinimarketServiceImplTest {

    private static MinimarketService minimarketService;
    private static DataSource dataSource;

    @BeforeClass
    public static void inisialisasi() {
        AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath*:workshop/minimarket/**/applicationContext.xml");
        ctx.registerShutdownHook();

        minimarketService = (MinimarketService) ctx.getBean("minimarketService");

        dataSource = (DataSource) ctx.getBean("dataSource");
    }
    
    //Test menyimpan pada tabel Grup
    public void testSimpanGrup() throws Exception {
        Grup g = new Grup();
        g.setNamaGrup("KOPI");

        minimarketService.simpanGrup(g);
        testIsiTabel("t_grup", 1);
    }
  
   //Test menyimpan pada Cascade
    public void testCascadeSave() throws Exception {
        Grup g = new Grup();
        g.setNamaGrup("ROKOK");


        Produk p = new Produk();
        p.setNamaProduk("DJARUM");
        p.setGrup(g);  // set FK
        
        Barang b = new Barang();
        b.setNama_barang("LA LIGHTS");
        b.setHargaBeli(8000);
        b.setHargaJual(10000);
        b.setSatuan("bungkus");
        b.setStok(12);
        b.setProduk(p); // set FK
        
        g.getDaftarProduk().add(p); // supaya k ikut cascade save
        p.getDaftarBarang().add(b);// supaya b ikut cascade save

        minimarketService.simpanGrup(g);
    }
    
    private void testIsiTabel(String namatabel, Integer jumlahRecord)
            throws Exception {
        String sql = "select count(*) from " + namatabel;
        Connection conn = dataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(sql);

        Assert.assertTrue(rs.next());
        Assert.assertEquals(Long.valueOf(jumlahRecord),
                Long.valueOf(rs.getLong(1)));

        conn.close();
    }
    
    //Test menghapus data di table parent, jika parent dihapus maka child otomatis terhapus     
    public void testParentDelete() {
        Grup g = minimarketService.cariGrupByKodeGrup(2L);
        try {
            minimarketService.hapusGrup(g);
        } catch (Exception e) {
            System.out.println("\nDATA BARANG YANG DIMASUKKAN TIDAK DITEMUKAN!\n");
        }
    }
    
   //Test menghapus data di table child, jika child dihapus maka parent tidak terhapus
    public void testChildDelete() {
        Produk p = minimarketService.cariProdukByKodeProduk(2L);
        try {
            minimarketService.hapusProduk(p);
        } catch (Exception e) {
            System.out.println("\nDATA BARANG YANG DIMASUKKAN TIDAK DITEMUKAN!\n");
        }
    }   
    
    //Test simpan table penjualan
    
     
     public void testSimpanPenjualan() throws Exception {
        Penjualan p = new Penjualan();
        Pengguna user = minimarketService.cariPenggunaByUserId("jaka");
        p.setTglNota(new Date());
        p.setPengguna(user);
        minimarketService.simpanPenjualan(p);
    }
     
     
     public void testCascadeSavePenjualanDetail() throws Exception {
        Penjualan p = minimarketService.cariPenjualanByNoNota(1L);     
        Barang b = minimarketService.cariBarangByKodeBarang(2L);
       
        PenjualanDetail pd = new PenjualanDetail();        
        pd.setJumlah(2);
        pd.setHargaJual(b.getHargaJual());              
        pd.setSubTotal(pd.getHargaJual() * pd.getJumlah());
        pd.setPenjualan(p);
        pd.setBarang(b);
              
        p.getDaftarPenjualanDetail().add(pd); // supaya k ikut cascade save      
        minimarketService.simpanPenjualan(p);
    }
     
     @Test
     public void testHitungTotalPembayaran() throws Exception{
         Penjualan p = minimarketService.cariPenjualanByNoNota(1L);
         double total = minimarketService.hitungTotalPembayaranByNoNota(1L);
         p.setTotalBayar(total);
         minimarketService.simpanPenjualan(p);
     }
     
     
     public void testCariPenjualanByNota() throws Exception{
         Date start = new SimpleDateFormat("yyyy-MM-dd").parse("2011-05-16");
         Date stop = new SimpleDateFormat("yyyy-MM-dd").parse("2011-05-18");
         List<Penjualan> listP = minimarketService.cariPenjualanByPeriod(start,stop);
         for (Penjualan p : listP)
         {
             System.out.println(p);
         }
     }
     
     
     
     public void testSimpanPengguna() throws Exception {
        Pengguna p = new Pengguna();
        p.setUserId("jaka");
        p.setPassId("jaka123");
        p.setNama("Jaka Maulana");
        p.setLevelPengguna("Admin");

        minimarketService.simpanPengguna(p);
        testIsiTabel("t_pengguna", 1);
    }
    
    public void testCariSemuaPengguna() throws Exception{
         List<Pengguna> listP = minimarketService.cariSemuaPengguna();
         for (Pengguna p : listP)
         {
             System.out.println(p.getNama() + " , " + p.getPassId());
         }
     }

    public void testCariPenggunaByUserId() throws Exception{
         Pengguna p = minimarketService.cariPenggunaByUserId("rozak");
         
         System.out.println(p.getNama() + " , " + p.getPassId());
         
     }
}
