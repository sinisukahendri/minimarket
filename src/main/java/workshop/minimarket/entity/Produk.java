/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author BangsJack
 */
public class Produk {
    @Id 
    @GeneratedValue
    @Column(name="kode_produk",length=7)
    private String kodeProduk;
    
    @NotNull
    @Column(name="nama_produk", length=60, nullable=false)
    private String namaProduk;
    
    @ManyToOne
    @JoinColumn(name="kode_grup")
    private String kodeGrup;

    public String getKodeGrup() {
        return kodeGrup;
    }

    public void setKodeGrup(String kodeGrup) {
        this.kodeGrup = kodeGrup;
    }

    public String getKodeProduk() {
        return kodeProduk;
    }

    public void setKodeProduk(String kodeProduk) {
        this.kodeProduk = kodeProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }    
}
