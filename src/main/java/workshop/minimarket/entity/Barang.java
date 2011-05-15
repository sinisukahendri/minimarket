/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jaka
 */
@Entity 
@Table(name="t_barang")
public class Barang {  
    @Id
    @GeneratedValue
    @Column(name="kode_barang", length=11)
    private Long kodeBarang;
    
    @ManyToOne
    @JoinColumn(name="kode_produk")
    private Produk produk;
    
    @OneToMany(mappedBy="barang", cascade= CascadeType.ALL)
    private List<PenjualanDetail> daftarPenjualanDetail = new ArrayList<PenjualanDetail>();
        
    @NotNull
    @Column(name="nama_barang", length=120, nullable=false)
    private String nama_barang;
    
    @Column(name="satuan", length=25)
    private String satuan;
    
    @Column(name="harga_beli", length=19)
    private double hargaBeli;
    
    @Column(name="harga_jual", length=19)
    private double hargaJual;
    
    @Column(name="stok", length=10)
    private Integer stok;
    
    public double getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(double hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public double getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(double hargaJual) {
        this.hargaJual = hargaJual;
    }

    public Long getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(Long kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public List<PenjualanDetail> getDaftarPenjualanDetail() {
        return daftarPenjualanDetail;
    }

    public void setDaftarPenjualanDetail(List<PenjualanDetail> daftarPenjualanDetail) {
        this.daftarPenjualanDetail = daftarPenjualanDetail;
    }    
}
