package logiikka;

import domain.Nelikulmio;
import domain.Vektori;
import grafiikka.Fyysinen;
import java.awt.image.BufferedImage;

public class Matriisilaskin {
    
    private Vektori skaalaus;
    private Vektori kameranSijainti;
    private double kaantokulma;

    public Matriisilaskin(Vektori skaalaus, Vektori kameranSijainti, double kaantokulma) {
        this.skaalaus = skaalaus;
        this.kameranSijainti = kameranSijainti;
        this.kaantokulma = kaantokulma;
    }
    
    public void maalaaKuvaKuvaan(Fyysinen fyysinen, BufferedImage kuva){
        BufferedImage maalattavanKuva = fyysinen.maalauta();
            
        Nelikulmio kaannetytPisteet = kierra(fyysinen.getKulmat());
        
        for (int i = 0; i < 4; i++) {
            Vektori ikkunassa = kaannetytPisteet.getKulma(i);
            kaannetytPisteet.setKulma(i, sijaintiIkkunassa( kaannetytPisteet.getKulma(i) ) );
        }
    }
    
    public Nelikulmio kierra(Nelikulmio kulmat){
        Vektori[] vektorit = kulmat.getKulmat();
        Vektori[] uudet = new Vektori[4];
        
        for (int i = 0; i < 4; i++) {
            uudet[i] = kierra(vektorit[i]);
        }
        
        return new Nelikulmio(uudet);
        
    }
    
    public Vektori kierra(Vektori vektori){
        Vektori erotus = vektori.erotus(kameranSijainti);
        
        double cos = Math.cos(kaantokulma);
        double sin = Math.sin(kaantokulma);
        
        Vektori kaannetty = new Vektori( erotus.getX()*cos - erotus.getY()*sin, erotus.getX()*sin + erotus.getY()*cos );
        kaannetty.summaa(kameranSijainti);
        
        return kaannetty;
    }
    
    public Vektori sijaintiIkkunassa(Vektori vektori){
        Vektori uusi = vektori.erotus(kameranSijainti);
        uusi.skaalaa(skaalaus); 
        
        return uusi;
    }
    
}
