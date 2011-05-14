/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.entity;

/**
 *
 * @author BangsJack
 */
public class Produk {
    private String kodeProduk;    
    private String namaProduk;
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
