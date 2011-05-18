/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
import workshop.minimarket.entity.Barang;
import workshop.minimarket.entity.Grup;
import workshop.minimarket.entity.Pelanggan;
import workshop.minimarket.entity.Pemasok;
import workshop.minimarket.entity.Pembelian;
import workshop.minimarket.entity.Pengguna;
import workshop.minimarket.entity.Penjualan;
import workshop.minimarket.entity.PenjualanDetail;
import workshop.minimarket.entity.Produk;
import workshop.minimarket.service.MinimarketService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import workshop.minimarket.entity.PembelianDetail;

/**
 *
 * @author Jaka
 */
@Service("minimarketService")
@Transactional
public class MinimarketServiceImpl implements MinimarketService {
    @Autowired
    private SessionFactory sessionFactory;
    
    //GRUP

    @Override
    public void simpanGrup(Grup grup) {
        sessionFactory.getCurrentSession().saveOrUpdate(grup);
    }

    @Override
    public void hapusGrup(Grup grup) {
        sessionFactory.getCurrentSession().delete(grup);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Grup> cariSemuaGrup() {
        return sessionFactory.getCurrentSession()
    	.createQuery("from Grup order by kodeGrup")
    	.list();
    }

    @Override
    public Grup cariGrupByKodeGrup(Long kodeGrup) {
       Grup g = (Grup) sessionFactory.getCurrentSession()
		.createQuery("from Grup where kodeGrup = :kode")
		.setLong("kode", kodeGrup)
		.uniqueResult();
		Hibernate.initialize(g.getDaftarProduk());
		return g;
    }
    
    //PRODUK
    
    @Override
    public void simpanProduk(Produk produk) {
        sessionFactory.getCurrentSession().saveOrUpdate(produk);
    }

    @Override
    public void hapusProduk(Produk produk) {
        sessionFactory.getCurrentSession().delete(produk);
    }

    @Override
    public List<Produk> cariSemuaProduk() {
        return sessionFactory.getCurrentSession()
    	.createQuery("from Produk order by namaProduk")
    	.list();
    }

    @Override
    public Produk cariProdukByKodeProduk(Long kodeProduk) {
        Produk p = (Produk) sessionFactory.getCurrentSession()
		.createQuery("from Produk where kodeProduk = :kode")
		.setLong("kode", kodeProduk)
		.uniqueResult();
		Hibernate.initialize(p.getDaftarBarang());
		return p;
    }
    
    //BARANG

    @Override
    public void simpanBarang(Barang barang) {
        sessionFactory.getCurrentSession().saveOrUpdate(barang);
    }

    @Override
    public void hapusBarang(Barang barang) {
        sessionFactory.getCurrentSession().delete(barang);
    }

    @Override
    public List<Barang> cariSemuaBarang() {
        return sessionFactory.getCurrentSession()
    	.createQuery("from Barang order by namaBarang")
    	.list();
    }

    @Override
    public Barang cariBarangByKodeBarang(Long kodeBarang) {
        Barang b = (Barang) sessionFactory.getCurrentSession()
		.createQuery("from Barang where kodeBarang = :kode")
		.setLong("kode", kodeBarang)
		.uniqueResult();
		Hibernate.initialize(b.getNamaBarang());
		return b;
    }

    // Penjualan
    
    @Override
    public void simpanPenjualan(Penjualan penjualan) {
        sessionFactory.getCurrentSession().saveOrUpdate(penjualan);
    }

    @Override
    public void hapusPenjualan(Penjualan penjualan) {
        sessionFactory.getCurrentSession().delete(penjualan);
    }

    @Override
    public List<Penjualan> cariSemuaPenjualan() {
        return sessionFactory.getCurrentSession()
    	.createQuery("from Penjualan order by tglNota")
    	.list();
    }

    @Override
    public Penjualan cariPenjualanByNoNota(Long noNota) {
        Penjualan p = (Penjualan) sessionFactory.getCurrentSession()
		.createQuery("from Penjualan where noNota = :nota")
		.setLong("nota", noNota)
		.uniqueResult();
		Hibernate.initialize(p.getDaftarPenjualanDetail());
		return p;
    }   

    //Pembelian
    @Override
    public void simpanPembelian(Pembelian pembelian) {
        sessionFactory.getCurrentSession().saveOrUpdate(pembelian);
    }

    @Override
    public void hapusPembelian(Pembelian pembelian) {
        sessionFactory.getCurrentSession().delete(pembelian);
    }

    @Override
    public List<Pembelian> cariSemuaPembelian() {
        return sessionFactory.getCurrentSession()
    	.createQuery("from Pembelian order by tglMasuk")
    	.list();
    }

    @Override
    public Pembelian cariPembelianByNoMasuk(Long noMasuk) {
        Pembelian p = (Pembelian) sessionFactory.getCurrentSession()
		.createQuery("from Pembelian where noMasuk = :nota")
		.setLong("nota", noMasuk)
		.uniqueResult();
		Hibernate.initialize(p.getDaftarPembelianDetail());
		return p;
    }

    @Override
    public List<Pembelian> cariPembelianByPeriod(Date tglStart, Date tglStop) {
        List<Pembelian> listPb = new ArrayList<Pembelian>();
        listPb = sessionFactory.getCurrentSession()
		.createQuery("from Pembelian where tglMasuk between :tglStart and :tglStop")
                .setDate("tglStart", tglStart).setDate("tglStop", tglStop)
		.list();
        Hibernate.initialize(listPb);
        return listPb;
    }

    @Override
    public double hitungTotalByNoMasuk(Long noMasuk) {
        List<PembelianDetail> listPd = cariPembelianDetailByNoMasuk(noMasuk);
       Pembelian p = cariPembelianByNoMasuk(noMasuk);
       double total = 0;
        for (PembelianDetail totalPd : listPd) {
             total += totalPd.getSubTotal();
       }
        return total;
    }
    
    // PenjualanDetail
    
    @Override
    public void simpanPenjualanDetail(PenjualanDetail penjualanDetail) {
        sessionFactory.getCurrentSession().saveOrUpdate(penjualanDetail);
    }

    @Override
    public void hapusPenjualanDetail(PenjualanDetail penjualanDetail) {
        sessionFactory.getCurrentSession().delete(penjualanDetail);
    }

    @Override
    public List<PenjualanDetail> cariSemuaPenjualanDetail() {
        return sessionFactory.getCurrentSession()
    	.createQuery("from PenjualanDetail order by noNota")
    	.list();
    }

    @Override
    public List<PenjualanDetail> cariPenjualanDetailByNoNota(Long noNota) {
        List<PenjualanDetail> listPd = new ArrayList<PenjualanDetail>();
        listPd = sessionFactory.getCurrentSession()
		.createQuery("from PenjualanDetail where penjualan.noNota = :nota")
                .setLong("nota", noNota)
		.list();
        Hibernate.initialize(listPd);
        return listPd;
    }

     //PembelianDetail
    @Override
    public void simpanPembelianDetail(PembelianDetail pembelianDetail) {
        sessionFactory.getCurrentSession().saveOrUpdate(pembelianDetail);
    }

    @Override
    public void hapusPembelianDetail(PembelianDetail pembelianDetail) {
        sessionFactory.getCurrentSession().delete(pembelianDetail);
    }

    @Override
    public List<PembelianDetail> cariSemuaPembelianDetail() {
        return sessionFactory.getCurrentSession()
    	.createQuery("from PembelianDetail order by noMasuk")
    	.list();
    }

    @Override
    public List<PembelianDetail> cariPembelianDetailByNoMasuk(Long noMasuk) {
        List<PembelianDetail> listPd = new ArrayList<PembelianDetail>();
        listPd = sessionFactory.getCurrentSession()
		.createQuery("from PembelianDetail where pembelian.noMasuk = :nota")
                .setLong("nota", noMasuk)
		.list();
        Hibernate.initialize(listPd);
        return listPd;
    }    
   
    @Override
    public double hitungTotalPembayaranByNoNota(Long noNota) {
       List<PenjualanDetail> listPd = cariPenjualanDetailByNoNota(noNota);
       Penjualan p = cariPenjualanByNoNota(noNota);
       double total = 0;
        for (PenjualanDetail totalPd : listPd) {
             total += totalPd.getSubTotal();
       }
        return total;
    }

    @Override
    public List<Penjualan> cariPenjualanByPeriod(Date tglStart, Date tglStop) {
       List<Penjualan> listPd = new ArrayList<Penjualan>();
        listPd = sessionFactory.getCurrentSession()
		.createQuery("from Penjualan where tglNota between :tglStart and :tglStop")
                .setDate("tglStart", tglStart).setDate("tglStop", tglStop)
		.list();
        Hibernate.initialize(listPd);
        return listPd;
    }

    // Pengguna
    @Override
    public void simpanPengguna(Pengguna pengguna) {
        sessionFactory.getCurrentSession().saveOrUpdate(pengguna);
    }

    @Override
    public void hapusPengguna(Pengguna pengguna) {
        sessionFactory.getCurrentSession().delete(pengguna);
    }

    @Override
    public List<Pengguna> cariSemuaPengguna() {
        return sessionFactory.getCurrentSession()
    	.createQuery("from Pengguna order by userId")
    	.list();
    }

    @Override
    public Pengguna cariPenggunaByUserId(String userId) {
        Pengguna p = (Pengguna) sessionFactory.getCurrentSession()
		.createQuery("from Pengguna where userId = :user")
		.setString("user", userId)
		.uniqueResult();
		Hibernate.initialize(p.getUserId());
		return p;
    }

    //Pelanggan
    @Override
    public void simpanPelanggan(Pelanggan pelanggan) {
        sessionFactory.getCurrentSession().saveOrUpdate(pelanggan);
    }

    @Override
    public void hapusPelanggan(Pelanggan pelanggan) {
        sessionFactory.getCurrentSession().delete(pelanggan);
    }

    @Override
    public List<Pelanggan> cariSemuaPelanggan() {
        return sessionFactory.getCurrentSession()
    	.createQuery("from Pelanggan order by kodePelanggan")
    	.list();
    }

    @Override
    public Pelanggan cariPelangganByKodePelanggan(Long kodePelanggan) {
        Pelanggan p = (Pelanggan) sessionFactory.getCurrentSession()
		.createQuery("from Pelanggan where kodePelanggan = :kode")
		.setLong("kode", kodePelanggan)
		.uniqueResult();
		Hibernate.initialize(p.getKodePelanggan());
		return p;
    }

    //Pemasok
    @Override
    public void simpanPemasok(Pemasok pemasok) {
        sessionFactory.getCurrentSession().saveOrUpdate(pemasok);
    }

    @Override
    public void hapusPemasok(Pemasok pemasok) {
        sessionFactory.getCurrentSession().delete(pemasok);
    }

    @Override
    public List<Pemasok> cariSemuaPemasok() {
         return sessionFactory.getCurrentSession()
    	.createQuery("from Pemasok order by kodePemasok")
    	.list();
    }

    @Override
    public Pemasok cariPemasokByKodePemasok(Long kodePemasok) {
        Pemasok p = (Pemasok) sessionFactory.getCurrentSession()
		.createQuery("from Pemasok where kodePemasok = :kode")
		.setLong("kode", kodePemasok)
		.uniqueResult();
		Hibernate.initialize(p.getKodePemasok());
		return p;
    }    
}
