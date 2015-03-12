package kayttoliittyma.toiminnot;

import java.awt.event.KeyEvent;
import java.util.Map;
import kayttoliittyma.nappaimisto.NappaimenToiminto;

public class EhdotonNappaimistonToimnnot implements NappaimistonToiminnot{

    private Map<Integer,NappaimenToiminto> nappaintenToiminnot;
    
    public void lisaaNappain(NappaimenToiminto n){
        nappaintenToiminnot.put(n.nappainkoodi(), n);
    }
    
    public void poistaNappain(int koodi){
        nappaintenToiminnot.remove(koodi);
    }
    
    public boolean onkoNappainta(int koodi){
        return nappaintenToiminnot.get(koodi) != null;
    }
    
    @Override
    public void nappainAlas(KeyEvent k) {
        NappaimenToiminto t = nappaintenToiminnot.get(k.getExtendedKeyCode());
        if(t != null){
            t.nappainAlas();
        }
    }

    @Override
    public void nappainYlos(KeyEvent k) {
        NappaimenToiminto t = nappaintenToiminnot.get(k.getExtendedKeyCode());
        if(t != null){
            t.nappainYlos();
        }
    }
    
}
