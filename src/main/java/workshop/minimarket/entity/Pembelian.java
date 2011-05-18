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
 * @author Jaka
 */

@Entity 
@Table(name="t_pembelian")
public class Pembelian {
    @Id
    @GeneratedValue
    @Column(name = "no_masuk", length = 10)
    private Long noMasuk;
    
    @OneToMany(mappedBy="pembelian", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<PembelianDetail> daftarPembelianDetail = new ArrayList<PembelianDetail>();
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_masuk")
    private Date tglMasuk;
    
    @Column(name = "total")
    private double total;
    
    @ManyToOne
    @JoinColumn(name="kode_pemasok")
    private Pemasok pemasok;
    
    @ManyToOne
    @JoinColumn(name="kode_pengguna")
    private Pengguna pengguna;

    public Long getNoMasuk() {
        return noMasuk;
    }

    public void setNoMasuk(Long noMasuk) {
        this.noMasuk = noMasuk;
    }

    public Date getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(Date tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    public Pemasok getPemasok() {
        return pemasok;
    }

    public void setPemasok(Pemasok pemasok) {
        this.pemasok = pemasok;
    }

    public Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }    
}
