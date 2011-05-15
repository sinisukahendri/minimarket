/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jaka
 */
@Entity 
@Table(name="t_penjualandetail")
public class PenjualanDetail {
    @Id
    @ManyToOne
    @JoinColumn(name="no_nota")
    private Penjualan penjualan;
    
    @ManyToOne
    @JoinColumns({
       @JoinColumn(name="kode_barang", referencedColumnName="kode_barang"), 
       @JoinColumn(name="harga_jual", referencedColumnName="harga_jual")})
    private Barang barang;
     
    private Integer jumlah;
    private Integer subTotal; 

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Integer getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Integer subTotal) {
        this.subTotal = subTotal;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Penjualan getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(Penjualan penjualan) {
        this.penjualan = penjualan;
    }   
}
