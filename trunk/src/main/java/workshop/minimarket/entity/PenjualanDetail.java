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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Jaka
 */
@Entity
@Table(name = "t_penjualandetail")
public class PenjualanDetail {
    @Id @GeneratedValue
    @Column(name="kode_penjualan_detail")
    private Long kodePenjualanDetail;
   
    @ManyToOne
    @JoinColumn(name = "no_nota")
    private Penjualan penjualan;
    
    @ManyToOne
    @JoinColumn(name = "kode_barang")
    private Barang barang;    
    
    @Column(name = "harga_jual")
    private double hargaJual;
    
    @Column(name = "jumlah")
    private Integer jumlah;
    
    @Column(name = "sub_total")
    private double subTotal;

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Penjualan getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(Penjualan penjualan) {
        this.penjualan = penjualan;
    }

    public double getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(double hargaJual) {
        this.hargaJual = hargaJual;
    }

    public Long getKodePenjualanDetail() {
        return kodePenjualanDetail;
    }

    public void setKodePenjualanDetail(Long kodePenjualanDetail) {
        this.kodePenjualanDetail = kodePenjualanDetail;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }    
}
