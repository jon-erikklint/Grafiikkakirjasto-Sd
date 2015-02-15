package grafiikka;

import grafiikka.nakymat.Avaruus;
import domain.Nelikulmio;
import domain.Vektori;
import java.util.ArrayList;
import java.util.List;

public class Kamera{
    
    private Vektori sijainti;
    private Nelikulmio kulmat;
    private double kulma;

    public Kamera(Vektori sijainti, Nelikulmio kulmat, double kulma) {
        this.sijainti = sijainti;
        this.kulmat = kulmat;
        this.kulma = kulma;
    }
    
    public List<Fyysinen> annaNakyvat(Avaruus avaruus){
        List<Fyysinen> avaruudenObjektit = avaruus.getFyysiset();
        List<Fyysinen> tarpeeksiLahella = new ArrayList<>();
        
        for(Fyysinen fyysinen : avaruudenObjektit){
            double etaisyys = fyysinen.getSijainti().etaisyys(sijainti);
            double maksimiEtaisyys = fyysinen.getKulmat().halkaisija() + kulmat.halkaisija();
            
            if(etaisyys < maksimiEtaisyys){
                tarpeeksiLahella.add(fyysinen);
            }
        }
        
        return tarpeeksiLahella;
    }

    public void liikuta(Vektori vektori) {
        sijainti.summaa(vektori);
    }
    
    public void kaanna(double kulma) {
        this.kulma += kulma;
    }

    public Vektori getSijainti() {
        return sijainti;
    }

    public void setSijainti(Vektori sijainti) {
        this.sijainti = sijainti;
    }
    
    public double getKulma() {
        return kulma;
    }

    public void setKulma(double kulma) {
        this.kulma = kulma;
    }
    
    public void skaalaa(Nelikulmio kulmat) {
        this.kulmat.skaalaa(kulmat);
    }

    public Nelikulmio getKulmat() {
        return kulmat;
    }

    public void setKulmat(Nelikulmio nelikulmio) {
        kulmat = nelikulmio;
    }
    
}
