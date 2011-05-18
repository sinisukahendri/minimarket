/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author BangsJack
 */
@Entity 
@Table(name="t_pelanggan")
public class Pelanggan {
    @Id 
    @GeneratedValue
    @Column(name="kode_pelanggan", length=5)
    private Long kodePelanggan;
    
    @Column(name="nama_pelanggan", length=35, nullable=false)
    private String namaPelanggan;
    
    @Column(name="alamat", length=100, nullable=false)
    private String alamat;
    
    @Column(name="no_telpon", length=15, nullable=false)
    private Integer noTelpon;
    
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Long getKodePelanggan() {
        return kodePelanggan;
    }

    public void setKodePelanggan(Long kodePelanggan) {
        this.kodePelanggan = kodePelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public Integer getNoTelpon() {
        return noTelpon;
    }

    public void setNoTelpon(Integer noTelpon) {
        this.noTelpon = noTelpon;
    }
}
