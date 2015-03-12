package logiikka;

import domain.Nelikulmio;
import domain.Vektori;
import grafiikka.Fyysinen;
import java.awt.image.BufferedImage;

public class IkkunanMaalaaja {
    
    private Vektori skaalaus;
    private Vektori kameranSijainti;
    private double kaantokulma;

    public IkkunanMaalaaja(Vektori skaalaus, Vektori kameranSijainti, double kaantokulma) {
        this.skaalaus = skaalaus;
        this.kameranSijainti = kameranSijainti;
        this.kaantokulma = kaantokulma;
    }

    /**
     * Maalaa annetun fyysisen tekstuurin annettuun BufferedImageen.
     * @param fyysinen
     * @param kuva 
     */
    public void maalaaKuvaKuvaan(Fyysinen fyysinen, BufferedImage kuva){
        BufferedImage maalattavanKuva = fyysinen.maalauta();
            
        Nelikulmio kaannetytPisteet = kierra(fyysinen.getMuoto());
        
        for (int i = 0; i < 4; i++) {
            Vektori ikkunassa = kaannetytPisteet.getKulma(i);
            kaannetytPisteet.setKulma(i, sijaintiIkkunassa( kaannetytPisteet.getKulma(i) ) );
        }
        
        
    }
    
    /**
     * Kiertää nelikulmiota annetun kulman verran.
     * @param kulmat
     * @return 
     */
    public Nelikulmio kierra(Nelikulmio kulmat){
        Vektori[] vektorit = kulmat.getKulmat();
        Vektori[] uudet = new Vektori[4];
        
        for (int i = 0; i < 4; i++) {
            uudet[i] = kierra(vektorit[i]);
        }
        
        return new Nelikulmio(uudet);
        
    }
    
    /**
     * 
     * @param vektori
     * @return      
     */
    
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
