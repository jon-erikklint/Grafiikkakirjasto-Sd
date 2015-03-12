package sivut;

import java.util.HashMap;
import java.util.Map;
import kayttoliittyma.kuuntelijat.NappaimistonKuuntelija;

public class Sivuhallinnoija {
    
    private Sivu aktiivinenSivu;
    
    private Map<String, Sivu> sivut;
    
    private NappaimistonKuuntelija nKuuntelija;
    
    public Sivuhallinnoija(){
        sivut = new HashMap<>();
    }
    
    public void asetaSivuAktiiviseksi(String tag){
        Sivu sivu = sivut.get(tag);
        
        if(sivu != null){
            aktiivinenSivu = sivu;
            nKuuntelija.setNappaimistonToiminnot(sivu.nappaimistonToiminnot());
        }
    }
    
    public void lisaaSivu(Sivu sivu){
        sivut.put(sivu.tag(), sivu);
    }
    
    public void poistaSivu(Sivu sivu){
        sivut.remove(sivu.tag());
    }
    
    public Sivu getAktiivinenSivu(){
        return aktiivinenSivu;
    }
    
}
