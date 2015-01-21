package logiikka;

import domain.Nelikulmio;
import domain.Vektori;

public class Matriisilaskin {
    
    public static Nelikulmio kierra(Nelikulmio kulmat, double kulma, Vektori kiertopiste){
        Vektori[] vektorit = kulmat.getKulmat();
        Vektori[] uudet = new Vektori[4];
        
        for (int i = 0; i < 4; i++) {
            uudet[i] = kierra(vektorit[i], kulma, kiertopiste);
        }
        
        return new Nelikulmio(uudet);
        
    }
    
    public static Vektori kierra(Vektori vektori, double kulma, Vektori kiertopiste){
        Vektori erotus = new Vektori(vektori.getX()-kiertopiste.getX() , vektori.getY()-kiertopiste.getY());
        
        double cos = Math.cos(kulma);
        double sin = Math.sin(kulma);
        
        Vektori kaannetty = new Vektori( erotus.getX()*cos - erotus.getY()*sin, erotus.getX()*sin + erotus.getY()*cos );
        kaannetty.summaa(kiertopiste);
        
        return kaannetty;
    }
    
}
