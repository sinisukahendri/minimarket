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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_masuk")
    private Date tglMasuk;
    @Column(name = "total_bayar")
    private double totalBayar;
    @Column(name = "kode_pelanggan", length = 5, nullable = false)
    private String kodePemasok;

    public String getKodePemasok() {
        return kodePemasok;
    }

    public void setKodePemasok(String kodePemasok) {
        this.kodePemasok = kodePemasok;
    }

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

    public double getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }
    
}
