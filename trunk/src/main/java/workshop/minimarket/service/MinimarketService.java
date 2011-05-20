/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.service;

import java.util.Date;
import java.util.List;
import workshop.minimarket.entity.Barang;
import workshop.minimarket.entity.Grup;
import workshop.minimarket.entity.Pelanggan;
import workshop.minimarket.entity.Pemasok;
import workshop.minimarket.entity.Pembelian;
import workshop.minimarket.entity.PembelianDetail;
import workshop.minimarket.entity.Pengguna;
import workshop.minimarket.entity.Penjualan;
import workshop.minimarket.entity.PenjualanDetail;
import workshop.minimarket.entity.Produk;
import workshop.minimarket.entity.Session;

/**
 *
 * @author BangsJack
 */
public interface MinimarketService {
    public void simpanGrup(Grup grup);
    public void hapusGrup(Grup grup);
    public List<Grup> cariSemuaGrup();
    public Grup cariGrupByKodeGrup(Long kodeGrup);
    
    public void simpanProduk(Produk produk);
    public void hapusProduk(Produk produk);
    public List<Produk> cariSemuaProduk();
    public Produk cariProdukByKodeProduk(Long kodeProduk);   
    
    public void simpanBarang(Barang barang);
    public void hapusBarang(Barang barang);
    public List<Barang> cariSemuaBarang();
    public Barang cariBarangByKodeBarang(Long kodeBarang); 
    
    public void simpanPenjualan(Penjualan penjualan);
    public void hapusPenjualan(Penjualan penjualan);
    public List<Penjualan> cariSemuaPenjualan();
    public Penjualan cariPenjualanByNoNota(Long noNota);
    public List<Penjualan> cariPenjualanByPeriod(Date start,Date stop);
    public double hitungTotalPembayaranByNoNota(Long noNota);
    
    public void simpanPembelian(Pembelian pembelian);
    public void hapusPembelian(Pembelian pembelian);
    public List<Pembelian> cariSemuaPembelian();
    public Pembelian cariPembelianByNoMasuk(Long noMasuk);
    public List<Pembelian> cariPembelianByPeriod(Date start,Date stop);    
    public double hitungTotalByNoMasuk(Long noMasuk);
    
    public void simpanPenjualanDetail(PenjualanDetail penjualanDetail);
    public void hapusPenjualanDetail(PenjualanDetail penjualanDetail);
    public List<PenjualanDetail> cariSemuaPenjualanDetail();
    public List<PenjualanDetail> cariPenjualanDetailByNoNota(Long noNota);   
    
    public void simpanPembelianDetail(PembelianDetail pembelianDetail);
    public void hapusPembelianDetail(PembelianDetail pembelianDetail);
    public List<PembelianDetail> cariSemuaPembelianDetail();
    public List<PembelianDetail> cariPembelianDetailByNoMasuk(Long noMasuk);   
    
    public void simpanPengguna(Pengguna pengguna);
    public void hapusPengguna(Pengguna pengguna);
    public List<Pengguna> cariSemuaPengguna();
    public Pengguna cariPenggunaByUserId(String userId);
    
    public void simpanPelanggan(Pelanggan pelanggan);
    public void hapusPelanggan(Pelanggan pelanggan);
    public List<Pelanggan> cariSemuaPelanggan();
    public Pelanggan cariPelangganByKodePelanggan(Long kodePelanggan);
    
    public void simpanPemasok(Pemasok pemasok);
    public void hapusPemasok(Pemasok pemasok);
    public List<Pemasok> cariSemuaPemasok();
    public Pemasok cariPemasokByKodePemasok(Long kodePemasok);
    
    public void simpanSession(Session session);
    public void hapusSession(Session session);
     public List<Session> cariSemuaSession();
     public Session cariSessionById();
}
