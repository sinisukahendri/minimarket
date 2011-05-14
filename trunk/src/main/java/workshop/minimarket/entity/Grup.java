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
@Table(name="t_grup")
public class Grup {    
    @Id @GeneratedValue
    @Column(name="kode_grup", length=3)
    private String kodeGrup;    
    
    @Column(name="nama_grup", length=60, nullable=false)
    private String namaGrup;
    
    @OneToMany(mappedBy="grup", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Produk> daftarProduk = new ArrayList<Produk>();
    
    public String getKodeGrup() {
        return kodeGrup;
    }

    public void setKodeGrup(String kodeGrup) {
        this.kodeGrup = kodeGrup;
    }

    public String getNamaGrup() {
        return namaGrup;
    }

    public void setNamaGrup(String namaGrup) {
        this.namaGrup = namaGrup;
    }   
    
    public List<Produk> getDaftarProduk() {
        return daftarProduk;
    }

    public void setDaftarProduk(List<Produk> daftarProduk) {
        this.daftarProduk = daftarProduk;
    }
}
