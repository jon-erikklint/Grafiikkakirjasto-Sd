package grafiikka;

import domain.Nelikulmio;
import domain.Vektori;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class AbstraktiMaalattava implements Maalattava{

    private Vektori sijainti;
    private Nelikulmio kulmat;
    
    private double kulma;
    private boolean nakyvyys;
    
    public AbstraktiMaalattava(Vektori sijainti, Nelikulmio kulmat, double kulma, boolean nakyvyys){
        this.sijainti = sijainti;
        this.kulmat = kulmat;
        
        this.kulma = kulma;
        this.nakyvyys = nakyvyys;
    }
    
    public abstract BufferedImage maalaa();
    
    @Override
    public final BufferedImage maalauta(){
        if(nakyvyys){
            return maalaa();
        }
        
        return null;
    }
    
    protected void piirraKuva(Nelikulmio kulmat, Graphics g){
        
    }

    @Override
    public void liikuta(Vektori vektori) {
        this.sijainti.summaa(vektori);
    }

    @Override
    public void skaalaa(Nelikulmio kulmat) {
        kulmat.skaalaa(kulmat);
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
    
    @Override
    public Nelikulmio getKulmat(){
        return kulmat;
    }
    
    @Override
    public void setKulmat(Nelikulmio nelikulmio){
        this.kulmat = nelikulmio;
    }
    
}
