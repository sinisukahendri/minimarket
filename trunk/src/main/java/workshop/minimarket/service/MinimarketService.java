/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.service;

import java.util.List;
import workshop.minimarket.entity.Barang;
import workshop.minimarket.entity.Grup;
import workshop.minimarket.entity.Penjualan;
import workshop.minimarket.entity.PenjualanDetail;
import workshop.minimarket.entity.Produk;

/**
 *
 * @author BangsJack
 */
public interface MinimarketService {
    public void simpanGrup(Grup grup);
    public void hapusGrup(Grup grup);
    public List<Grup> cariSemuaGrup();
    public Grup cariGrupByKodeGrup(String kodeGrup);
    
    public void simpanProduk(Produk produk);
    public void hapusProduk(Produk produk);
    public List<Produk> cariSemuaProduk();
    public Produk cariSemuaProdukByKodeProduk(String kodeProduk);   
    
//    public void simpanBarang(Barang barang);
//    public void hapusBarang(Barang barang);
//    public List<Barang> cariSemuaBarang();
//    public Barang cariSemuaBarangByKodeBarang(String kodeBarang); 
//    
//    public void simpanPenjualan(Penjualan penjualan);
//    public void hapusPenjualan(Penjualan penjualan);
//    public List<Penjualan> cariSemuaPenjualan();
//    public Penjualan cariSemuaPenjualanByNoNota(String noNota); 
//    
//    public void simpanPenjualanDetail(PenjualanDetail penjualanDetail);
//    public void hapusPenjualanDetail(PenjualanDetail penjualanDetail);
//    public List<PenjualanDetail> cariSemuaPenjualanDetail();
//    public PenjualanDetail cariSemuaPenjualanDetailByNoNota(String noNota);     
}
