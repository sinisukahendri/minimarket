/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.ui.tapestry.controller;

import com.javaforge.tapestry.spring.annotations.InjectSpring;
import java.util.List;
import org.apache.tapestry.form.IPropertySelectionModel;
import org.apache.tapestry.form.StringPropertySelectionModel;
import org.apache.tapestry.html.BasePage;
import workshop.minimarket.entity.Barang;
import workshop.minimarket.entity.Produk;
import workshop.minimarket.service.MinimarketService;

/**
 *
 * @author BangsJack
 */
public abstract class BarangController extends BasePage{    
    @InjectSpring("minimarketService")
    public abstract MinimarketService getMinimarketService();
    

    public List<Barang> getDaftarBarang() {
        List<Barang> daftarBarang = getMinimarketService().cariSemuaBarang();
        return daftarBarang;
    }
    
     public IPropertySelectionModel getDaftarProduk() {
        List<Produk> daftarProduk = getMinimarketService().cariSemuaProduk();
        String[] kodeProduk = new String[daftarProduk.size()];
        for (int i = 0; i < daftarProduk.size(); i++) {
            kodeProduk[i] = String.valueOf(daftarProduk.get(i).getKodeProduk());
        }

        return new StringPropertySelectionModel(kodeProduk);
    }
    
    public abstract String getSelectedProdukId();
    
    public String NamaBarang;
    public String HargaJual;
    public String HargaBeli;
    public String Satuan;
    public String Stok;

    public String getHargaBeli() {
        return HargaBeli;
    }

    public void setHargaBeli(String HargaBeli) {
        this.HargaBeli = HargaBeli;
    }

    public String getHargaJual() {
        return HargaJual;
    }

    public void setHargaJual(String HargaJual) {
        this.HargaJual = HargaJual;
    }

    public String getNamaBarang() {
        return NamaBarang;
    }

    public void setNamaBarang(String NamaBarang) {
        this.NamaBarang = NamaBarang;
    }

    public String getSatuan() {
        return Satuan;
    }

    public void setSatuan(String Satuan) {
        this.Satuan = Satuan;
    }

    public String getStok() {
        return Stok;
    }

    public void setStok(String Stok) {
        this.Stok = Stok;
    }
    
    public String simpanBarang(){
        Produk p = getMinimarketService().cariProdukByKodeProduk(Long.parseLong(getSelectedProdukId()));
        Barang b = new Barang();
        b.setProduk(p);
        b.setHargaBeli(Long.parseLong(getHargaBeli()));
        b.setHargaJual(Long.parseLong(getHargaJual()));
        b.setNamaBarang(getNamaBarang());
        b.setSatuan(getSatuan());
        b.setStok(Integer.parseInt(getStok()));
        p.getDaftarBarang().add(b);
        getMinimarketService().simpanProduk(p);
        return "DaftarBarang";
    }
    
    public String tambahLagi(){
        return "InputBarang";
    }
}
