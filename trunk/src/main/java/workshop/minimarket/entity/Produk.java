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
import javax.persistence.ManyToOne;
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
}
