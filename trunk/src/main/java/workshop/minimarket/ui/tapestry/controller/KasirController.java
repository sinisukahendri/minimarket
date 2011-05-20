package workshop.minimarket.ui.tapestry.controller;

import java.util.List;

import org.apache.tapestry.html.BasePage;
import org.apache.tapestry.record.PropertyChangeObserver;

import com.javaforge.tapestry.spring.annotations.InjectSpring;
import java.util.Date;
import org.apache.tapestry.annotations.Persist;
import org.apache.tapestry.form.IPropertySelectionModel;
import org.apache.tapestry.form.StringPropertySelectionModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import workshop.minimarket.entity.Barang;
import workshop.minimarket.entity.Penjualan;
import workshop.minimarket.entity.PenjualanDetail;
import workshop.minimarket.entity.Session;
import workshop.minimarket.service.MinimarketService;

public abstract class KasirController extends BasePage {

    private final Logger LOGGER = LoggerFactory.getLogger(KasirController.class);

    @InjectSpring("minimarketService")
    public abstract MinimarketService getMiniMarketService();

    public abstract String getSelectedBarangId();

    private int jumlah;
    
    @Persist("client")
    public abstract String getNotaPenjualan();
    
    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public IPropertySelectionModel getDaftarBarang() {
        List<Barang> daftarBarang = getMiniMarketService().cariSemuaBarang();
        String[] kodeBarang = new String[daftarBarang.size()];
        for (int i = 0; i < daftarBarang.size(); i++) {
            kodeBarang[i] = String.valueOf(daftarBarang.get(i).getKodeBarang());
        }

        return new StringPropertySelectionModel(kodeBarang);
    }

    public List getDaftarPenjualanDetail() {
        Session s = getMiniMarketService().cariSessionById();
        List<PenjualanDetail> daftarPenjualanDetail = getMiniMarketService().cariPenjualanDetailByNoNota(Long.parseLong(s.getNota()));
        return daftarPenjualanDetail;
    }

    public String simpanPenjualan(){
        Session s = new Session();
        s.setId(1L);
        s.setNota(getNotaPenjualan());
        Penjualan penjualan = new Penjualan();
        penjualan.setNoNota(Long.parseLong(getNotaPenjualan()));
        penjualan.setTglNota(new Date());
        getMiniMarketService().simpanPenjualan(penjualan);
        getMiniMarketService().simpanSession(s);
        return "Transaksi";
    }
    
    public String simpan() {
        Session s = getMiniMarketService().cariSessionById();
        Penjualan penjualan = getMiniMarketService().cariPenjualanByNoNota(Long.parseLong(s.getNota()));
        Barang barang = getMiniMarketService().cariBarangByKodeBarang(Long.parseLong(getSelectedBarangId()));
        PenjualanDetail pd = new PenjualanDetail();
        double subtotal = barang.getHargaJual() * getJumlah();
        pd.setBarang(barang);
        pd.setHargaJual(barang.getHargaJual());
        pd.setJumlah(getJumlah());
        pd.setSubTotal(subtotal);
        pd.setPenjualan(penjualan);
        penjualan.getDaftarPenjualanDetail().add(pd);
        getMiniMarketService().simpanPenjualan(penjualan);
        return "Cart";
    }

    public String continueShopping() {
        return "Transaksi";
    }
    
    public String onCheckout() {
        Session s = getMiniMarketService().cariSessionById();
        Penjualan penjualan = getMiniMarketService().cariPenjualanByNoNota(Long.parseLong(s.getNota()));
        return "Final";
    }
    
    public double getTotal(){
        Session s = getMiniMarketService().cariSessionById();
        Penjualan penjualan = getMiniMarketService().cariPenjualanByNoNota(Long.parseLong(s.getNota()));
        double total = getMiniMarketService().hitungTotalPembayaranByNoNota(Long.parseLong(s.getNota()));
        penjualan.setTotalBayar(total);
        getMiniMarketService().simpanPenjualan(penjualan);
        return total;
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
