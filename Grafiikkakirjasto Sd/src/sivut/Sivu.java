package sivut;

import grafiikka.nakymat.Nakyma;
import kayttoliittyma.toiminnot.NappaimistonToiminnot;
import kayttoliittyma.toiminnot.TyhjaNappaimistonToiminnot;

public class Sivu {
    
    private String tag;
    
    private Nakyma paanakyma;
    private NappaimistonToiminnot nToiminnot;
    
    public Sivu(String tag, Nakyma nakyma, NappaimistonToiminnot nappaimistonToiminnot){
        this.tag = tag;
        this.paanakyma = nakyma;
        this.nToiminnot = nappaimistonToiminnot;
    }
    
    public Sivu(String tag, Nakyma nakyma){
        this(tag, nakyma, new TyhjaNappaimistonToiminnot());
    }
    
    public String tag(){
        return tag;
    }
    
    public Nakyma sivunPaanakyma(){
        return paanakyma;
    }
    
    public NappaimistonToiminnot nappaimistonToiminnot(){
        return nToiminnot;
    }
    
}
