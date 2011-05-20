/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.ui.tapestry.controller;

import com.javaforge.tapestry.spring.annotations.InjectSpring;
import java.util.List;

import org.apache.tapestry.html.BasePage;
import workshop.minimarket.entity.Grup;
import workshop.minimarket.service.MinimarketService;

/**
 *
 * @author BangsJack
 */
public abstract class GrupController extends BasePage {

    @InjectSpring("minimarketService")
    public abstract MinimarketService getMinimarketService();
  
   private String namanyas;

    public String getNamanyas() {
        return namanyas;
    }

    public void setNamanyas(String namanyas) {
        this.namanyas = namanyas;
    }

    public List<Grup> getDaftarGrup() {
        List<Grup> daftarGrup = getMinimarketService().cariSemuaGrup();
        return daftarGrup;
    }

    public String simpan() {
        Grup grup = new Grup();
        grup.setNamaGrup(getNamanyas());
        getMinimarketService().simpanGrup(grup);        
        
        return "DaftarGrup";
    }

}
