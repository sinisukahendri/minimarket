/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import workshop.minimarket.entity.Barang;
import workshop.minimarket.entity.Grup;
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
    
    public void testSimpanGrup() throws Exception {
        Grup g = new Grup();
        g.setNamaGrup("KOPI");

        minimarketService.simpanGrup(g);
        testIsiTabel("t_grup", 1);
    }

    @Test
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
    
    
    public void testParentDelete() {
        Grup g = minimarketService.cariGrupByKodeGrup(1L);
        try {
            minimarketService.hapusGrup(g);
        } catch (Exception e) {
            System.out.println("\nDATA BARANG YANG DIMASUKKAN TIDAK DITEMUKAN!\n");
        }
    }
}
