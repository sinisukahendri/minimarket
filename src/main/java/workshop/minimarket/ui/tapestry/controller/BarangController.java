/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.ui.tapestry.controller;

import com.javaforge.tapestry.spring.annotations.InjectSpring;
import java.util.List;
import org.apache.tapestry.html.BasePage;
import workshop.minimarket.entity.Barang;
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
}
