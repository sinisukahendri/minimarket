/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.entity;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author BangsJack
 */
@Entity 
@Table(name="t_penjualan")
public class Penjualan {
    @Id 
    @GeneratedValue
    @Column(name="no_nota", length=10)
    private Long noNota;
    
    @OneToMany(mappedBy="penjualan", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<PenjualanDetail> daftarPenjualanDetail = new ArrayList<PenjualanDetail>();
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="tgl_nota")
    private Date tglNota;
    
    @Column(name="total_bayar")
    private double totalBayar;
    
    @ManyToOne
    @JoinColumn(name="kode_pelanggan")
    private Pelanggan pelanggan;
    
    @ManyToOne
    @JoinColumn(name="kode_pengguna")
    private Pengguna pengguna;

    public List<PenjualanDetail> getDaftarPenjualanDetail() {
        return daftarPenjualanDetail;
    }

    public void setDaftarPenjualanDetail(List<PenjualanDetail> daftarPenjualanDetail) {
        this.daftarPenjualanDetail = daftarPenjualanDetail;
    }

    public Long getNoNota() {
        return noNota;
    }

    public void setNoNota(Long noNota) {
        this.noNota = noNota;
    }

    public Date getTglNota() {
        return tglNota;
    }

    public void setTglNota(Date tglNota) {
        this.tglNota = tglNota;
    }

    public double  getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(double  totalBayar) {
        this.totalBayar = totalBayar;
    }

    public Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }    
}
