package grafiikka;

import domain.Nelikulmio;
import domain.Vektori;
import java.awt.image.BufferedImage;
import java.util.List;
import logiikka.Matriisilaskin;

public class Ikkuna extends AbstraktiMaalattava{
    
    private Avaruus avaruus;
    private Kamera kamera;

    public Ikkuna(Avaruus avaruus, Kamera kamera, Vektori sijainti, Nelikulmio kulmat, double kulma, boolean nakyvyys) {
        super(sijainti, kulmat, kulma, nakyvyys);
        
        this.avaruus = avaruus;
        this.kamera = kamera;
    }

    @Override
    public BufferedImage maalaa() {
        List<Maalattava> maalattavat = kamera.annaNakyvat(avaruus);
        
        BufferedImage kuva = new BufferedImage( (int) super.getKulmat().leveys(), (int) super.getKulmat().korkeus(), BufferedImage.TYPE_INT_RGB);
        
        Vektori skaalaus = new Vektori( super.getKulmat().leveys()/kamera.getKulmat().leveys(), 
                                       super.getKulmat().korkeus()/kamera.getKulmat().korkeus());
        Vektori kSijainti = kamera.getSijainti();
        double kaantokulma = kamera.getKulma();
        
        for(Maalattava maalattava : maalattavat){
            BufferedImage maalattavanKuva = maalattava.maalauta();
            
            Nelikulmio kaannetytPisteet = Matriisilaskin.kierra(maalattava.getKulmat(), kaantokulma, kSijainti);
            for (int i = 0; i < 4; i++) {
                sijaintiIkkunassa(kaannetytPisteet.getKulma(i), kSijainti, skaalaus);
            } //////////kesken
        }
        
        return kuva;
    }
    
    public void sijaintiIkkunassa(Vektori vektori, Vektori kSijainti, Vektori skaalaus){
        vektori.vahenna(kSijainti);
        vektori.skaalaa(skaalaus); ///////kesken
    }

    public Avaruus getAvaruus() {
        return avaruus;
    }

    public void setAvaruus(Avaruus avaruus) {
        this.avaruus = avaruus;
    }

    public Kamera getKamera() {
        return kamera;
    }

    public void setKamera(Kamera kamera) {
        this.kamera = kamera;
    }
}
