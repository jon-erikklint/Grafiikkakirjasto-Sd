package grafiikka;

import domain.Nelikulmio;
import domain.Vektori;

public interface Fyysinen extends Maalattava{
    
    public void liikuta(Vektori vektori);
    public void skaalaa(Nelikulmio kulmat);
    public void kaanna(double kulma);

    public Vektori getSijainti();
    public void setSijainti(Vektori sijainti);
    
    public Nelikulmio getMuoto();
    public void setMuoto(Nelikulmio nelikulmio);
    
    public double getKulma();
    public void setKulma(double kulma);
    
    public boolean getNakyvyys();
    public void setNakyvyys(boolean nakyvyys);
    
}
