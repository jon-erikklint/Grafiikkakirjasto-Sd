package grafiikka;

import domain.Vektori;
import java.awt.Graphics2D;

public class Ikkuna extends AbstraktiMaalattava{
    
    private Avaruus avaruus;
    private Kamera kamera;

    public Ikkuna(Avaruus avaruus, Kamera kamera, Vektori sijainti, Vektori koko, Vektori origo, double kulma, boolean nakyvyys) {
        super(sijainti, koko, origo, kulma, nakyvyys);
        
        this.avaruus = avaruus;
        this.kamera = kamera;
    }

    @Override
    public void maalaa(Graphics2D g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
