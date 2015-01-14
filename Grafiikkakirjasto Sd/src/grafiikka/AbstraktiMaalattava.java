package grafiikka;

import domain.Vektori;
import java.awt.Graphics2D;

public abstract class AbstraktiMaalattava implements Maalattava{

    private Vektori sijainti;
    private Vektori koko;
    private Vektori origo;
    
    private double kulma;
    private boolean nakyvyys;
    
    public AbstraktiMaalattava(Vektori sijainti, Vektori koko, Vektori origo, double kulma, boolean nakyvyys){
        this.sijainti = sijainti;
        this.koko = koko;
        this.origo = origo;
        
        this.kulma = kulma;
        this.nakyvyys = nakyvyys;
    }
    
    public abstract void maalaa(Graphics2D g);
    
    @Override
    public final void maalauta(Graphics2D g){
        if(nakyvyys){
            maalaa(g);
        }
    }

    @Override
    public void liikuta(Vektori vektori) {
        this.sijainti.summaa(vektori);
    }

    @Override
    public void skaalaa(Vektori vektori) {
        this.koko.skaalaa(vektori);
    }

    @Override
    public void siirraOrigoa(Vektori vektori) {
        this.origo.summaa(vektori);
    }

    @Override
    public void kaanna(double kulma) {
        this.kulma += kulma;
    }

    @Override
    public Vektori getSijainti() {
        return sijainti;
    }

    @Override
    public void setSijainti(Vektori sijainti) {
        this.sijainti = sijainti;
    }

    @Override
    public Vektori getKoko() {
        return koko;
    }

    @Override
    public void setKoko(Vektori koko) {
        this.koko = koko;
    }

    @Override
    public Vektori getOrigo() {
        return origo;
    }

    @Override
    public void setOrigo(Vektori origo) {
        this.origo = origo;
    }

    @Override
    public double getKulma() {
        return kulma;
    }

    @Override
    public void setKulma(double kulma) {
        this.kulma = kulma;
    }
    
    @Override
    public boolean getNakyvyys(){
        return nakyvyys;
    }
    
    @Override
    public void setNakyvyys(boolean nakyvyys){
        this.nakyvyys = nakyvyys;
    }
    
}
