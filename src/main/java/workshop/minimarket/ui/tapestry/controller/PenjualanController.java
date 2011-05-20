/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.ui.tapestry.controller;

import com.javaforge.tapestry.spring.annotations.InjectSpring;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry.html.BasePage;
import org.apache.tapestry.record.PropertyChangeObserver;
import workshop.minimarket.entity.Penjualan;
import workshop.minimarket.service.MinimarketService;

/**
 *
 * @author BangsJack
 */
public abstract class PenjualanController extends BasePage {

    @InjectSpring("minimarketService")
    public abstract MinimarketService getMinimarketService();
    private Penjualan penjualan = new Penjualan();
    private List<Penjualan> daftarPenjualan = new ArrayList<Penjualan>();

    public String simpan() {
        getMinimarketService().simpanPenjualan(penjualan);
        penjualan = new Penjualan();
        System.out.println("Method simpan ditekan");
        return "DaftarPenjualan";
    }

    public List<Penjualan> getDaftarPenjualan() {
        daftarPenjualan = getMinimarketService().cariSemuaPenjualan();
        return daftarPenjualan;
    }

    public void setDaftarPenjualan(List<Penjualan> daftarPenjualan) {
        this.daftarPenjualan = daftarPenjualan;
    }

    public Penjualan getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(Penjualan penjualan) {
        this.penjualan = penjualan;
    }

    @Override
    public PropertyChangeObserver getPropertyChangeObserver() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getClientId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setClientId(String arg0) {
        // TODO Auto-generated method stub
    }
}
