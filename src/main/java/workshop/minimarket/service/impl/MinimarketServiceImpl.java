/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.service.impl;

import java.util.List;
import org.hibernate.Hibernate;
import workshop.minimarket.entity.Barang;
import workshop.minimarket.entity.Grup;
import workshop.minimarket.entity.Penjualan;
import workshop.minimarket.entity.PenjualanDetail;
import workshop.minimarket.entity.Produk;
import workshop.minimarket.service.MinimarketService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		Hibernate.initialize(b.getDaftarPenjualanDetail());
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
    public PenjualanDetail cariPenjualanDetailByNoNota(String noNota) {
        return (PenjualanDetail) sessionFactory.getCurrentSession().get(PenjualanDetail.class, noNota);
    }
}
