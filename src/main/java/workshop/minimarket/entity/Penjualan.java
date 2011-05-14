/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author BangsJack
 */
public class Penjualan {
    private String noNota;
    private Date tglNota;
    private BigDecimal totalBayar;
    private String kodePelanggan;
    private String userId;

    public String getKodePelanggan() {
        return kodePelanggan;
    }

    public void setKodePelanggan(String kodePelanggan) {
        this.kodePelanggan = kodePelanggan;
    }

    public String getNoNota() {
        return noNota;
    }

    public void setNoNota(String noNota) {
        this.noNota = noNota;
    }

    public Date getTglNota() {
        return tglNota;
    }

    public void setTglNota(Date tglNota) {
        this.tglNota = tglNota;
    }

    public BigDecimal getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(BigDecimal totalBayar) {
        this.totalBayar = totalBayar;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }    
}
