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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author BangsJack
 */
@Entity 
@Table(name="t_pemasok")
public class Pemasok {
    @Id 
    @GeneratedValue
    @Column(name="kode_pemasok", length=5)
    private Long kodePemasok;
    
    @Column(name="nama_pemasok", length=35, nullable=false)
    private String namaPemasok;
    
    @Column(name="alamat", length=100, nullable=false)
    private String alamat;
    
    @Column(name="kota", length=50, nullable=false)
    private String kota;
    
    @Column(name="propinsi", length=50, nullable=false)
    private String propinsi;
    
    @Column(name="no_telpon", length=15, nullable=false)
    private Integer noTelpon;
    
    @Column(name="no_fax", length=15, nullable=false)
    private Integer noFax;
    
    @Column(name="kontak_person", length=35, nullable=false)
    private Integer kontakP;
    
    @OneToMany(mappedBy="pemasok", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Pembelian> daftarPembelian = new ArrayList<Pembelian>();

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Long getKodePemasok() {
        return kodePemasok;
    }

    public void setKodePemasok(Long kodePemasok) {
        this.kodePemasok = kodePemasok;
    }

    public Integer getKontakP() {
        return kontakP;
    }

    public void setKontakP(Integer kontakP) {
        this.kontakP = kontakP;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getNamaPemasok() {
        return namaPemasok;
    }

    public void setNamaPemasok(String namaPemasok) {
        this.namaPemasok = namaPemasok;
    }

    public Integer getNoFax() {
        return noFax;
    }

    public void setNoFax(Integer noFax) {
        this.noFax = noFax;
    }

    public Integer getNoTelpon() {
        return noTelpon;
    }

    public void setNoTelpon(Integer noTelpon) {
        this.noTelpon = noTelpon;
    }

    public String getPropinsi() {
        return propinsi;
    }

    public void setPropinsi(String propinsi) {
        this.propinsi = propinsi;
    }

    public List<Pembelian> getDaftarPembelian() {
        return daftarPembelian;
    }

    public void setDaftarPembelian(List<Pembelian> daftarPembelian) {
        this.daftarPembelian = daftarPembelian;
    }    
}
