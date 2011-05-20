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
import workshop.minimarket.entity.Grup;
import workshop.minimarket.entity.Produk;
import workshop.minimarket.service.MinimarketService;

/**
 *
 * @author Jaka
 */
public abstract class ProdukController extends BasePage {

    @InjectSpring("minimarketService")
    public abstract MinimarketService getMinimarketService();
    private String namaProduk;
    
    
    public String getNamaProduk() {
        return namaProduk;
    }
    
    public List<Produk> getDaftarProduk() {
        List daftarProduk = getMinimarketService().cariSemuaProduk();
        return daftarProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public abstract String getSelectedGrupId();

    public IPropertySelectionModel getDaftarGrup() {
        List<Grup> daftarGrup = getMinimarketService().cariSemuaGrup();
        String[] kodeGrup = new String[daftarGrup.size()];
        for (int i = 0; i < daftarGrup.size(); i++) {
            kodeGrup[i] = String.valueOf(daftarGrup.get(i).getKodeGrup());
        }

        return new StringPropertySelectionModel(kodeGrup);
    }

    public String simpanProduk() {
        Grup g = getMinimarketService().cariGrupByKodeGrup(Long.parseLong(getSelectedGrupId()));
        Produk p = new Produk();
        p.setNamaProduk(getNamaProduk());
        p.setGrup(g);
        g.getDaftarProduk().add(p);
        getMinimarketService().simpanGrup(g);
        return "DaftarProduk";
    }
    
    public String tambahLagi(){
        return "InputProduk";
    }
}
