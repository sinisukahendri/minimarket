/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author BangsJack
 */
@Entity
@Table(name = "t_pembeliandetail")
public class PembelianDetail {
    @Id @GeneratedValue
    @Column(name="kode_penjualan_detail")
    private Long kodePembelianDetail;
   
    @ManyToOne
    @JoinColumn(name = "no_masuk")
    private Penjualan penjualan;
    
    @ManyToOne
    @JoinColumn(name = "kode_barang")
    private Barang barang;    
    
    @Column(name = "harga_beli")
    private double hargaBeli;
    
    @Column(name = "jumlah")
    private Integer jumlah;
    
    @Column(name = "sub_total")
    private double subTotal;

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public double getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(double hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Long getKodePembelianDetail() {
        return kodePembelianDetail;
    }

    public void setKodePembelianDetail(Long kodePembelianDetail) {
        this.kodePembelianDetail = kodePembelianDetail;
    }

    public Penjualan getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(Penjualan penjualan) {
        this.penjualan = penjualan;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }    
}
