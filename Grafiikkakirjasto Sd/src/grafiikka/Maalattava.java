package grafiikka;

import domain.Vektori;
import java.awt.Graphics2D;

public interface Maalattava {
    
    public void maalauta(Graphics2D g);
    
    public void liikuta(Vektori vektori);
    public void skaalaa(Vektori vektori);    
    public void siirraOrigoa(Vektori vektori);
    public void kaanna(double kulma);

    public Vektori getSijainti();
    public void setSijainti(Vektori sijainti);
    
    public Vektori getKoko();
    public void setKoko(Vektori koko);
    
    public Vektori getOrigo();
    public void setOrigo(Vektori origo);
    
    public double getKulma();
    public void setKulma(double kulma);
    
    public boolean getNakyvyys();
    public void setNakyvyys(boolean nakyvyys);
    
}
