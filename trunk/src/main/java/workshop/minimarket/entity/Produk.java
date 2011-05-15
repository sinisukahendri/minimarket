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
 * @author BangsJack
 */

@Entity 
@Table(name="t_produk")
public class Produk {
    @Id 
    @GeneratedValue
    @Column(name="kode_produk",length=7)
    private Long kodeProduk;
    
    @NotNull
    @Column(name="nama_produk", length=60, nullable=false)
    private String namaProduk;
    
    @ManyToOne
    @JoinColumn(name="kode_grup")
    private Grup grup;
    
    @OneToMany(mappedBy="produk", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Barang> daftarBarang = new ArrayList<Barang>();

    public Grup getGrup() {
        return grup;
    }

    public void setGrup(Grup grup) {
        this.grup = grup;
    }

    public Long getKodeProduk() {
        return kodeProduk;
    }

    public void setKodeProduk(Long kodeProduk) {
        this.kodeProduk = kodeProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public List<Barang> getDaftarBarang() {
        return daftarBarang;
    }

    public void setDaftarBarang(List<Barang> daftarBarang) {
        this.daftarBarang = daftarBarang;
    }
    
}
