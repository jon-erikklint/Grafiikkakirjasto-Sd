package grafiikka;

import grafiikka.nakymat.Avaruus;
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
        List<Fyysinen> maalattavat = kamera.annaNakyvat(avaruus);
        BufferedImage kuva = new BufferedImage( (int) super.getKulmat().leveys(), (int) super.getKulmat().korkeus(), BufferedImage.TYPE_INT_RGB);
        
        Vektori skaalaus = new Vektori( super.getKulmat().leveys()/kamera.getKulmat().leveys(), super.getKulmat().korkeus()/kamera.getKulmat().korkeus());
        Vektori kSijainti = kamera.getSijainti();
        double kaantokulma = kamera.getKulma();
        
        Matriisilaskin laskin = new Matriisilaskin(skaalaus, kSijainti, kaantokulma);
        
        for(Fyysinen fyysinen : maalattavat){
            laskin.maalaaKuvaKuvaan(fyysinen, kuva);
        }
        
        return kuva;
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
