package grafiikka;

import grafiikka.nakymat.Avaruus;
import domain.Nelikulmio;
import domain.Vektori;
import java.util.ArrayList;
import java.util.List;

public class Kamera{
    
    private Vektori sijainti;
    private Nelikulmio nelikulmio;
    private double kulma;

    public Kamera(Vektori sijainti, Nelikulmio kulmat, double kulma) {
        this.sijainti = sijainti;
        this.nelikulmio = kulmat;
        this.kulma = kulma;
    }
    /**
     * Antaa näkyvät kameran kuvaamalta alueelta
     * @param avaruus
     * @return näkyvät
     */
    public List<Fyysinen> annaNakyvat(Avaruus avaruus){
        List<Fyysinen> avaruudenObjektit = avaruus.getFyysiset();
        List<Fyysinen> tarpeeksiLahella = new ArrayList<>();
        
        for(Fyysinen fyysinen : avaruudenObjektit){
            double etaisyys = fyysinen.getSijainti().etaisyys(sijainti);
            double maksimiEtaisyys = fyysinen.getMuoto().halkaisija() + nelikulmio.halkaisija();
            
            if(etaisyys < maksimiEtaisyys){
                tarpeeksiLahella.add(fyysinen);
            }
        }
        
        return tarpeeksiLahella;
    }

    /**
     * Liikuttaa kameraa vektorin verran.
     * @param vektori 
     */
    public void liikuta(Vektori vektori) {
        sijainti.summaa(vektori);
    }
    
    /**
     * Kiertää kameraa annetun kulman(rad) verran
     * @param kulma 
     */
    public void kierra(double kulma) {
        this.kulma += kulma;
    }

    /**
     * Palauttaa kameran sijainnin.
     * @return kameran sijainti
     */
    public Vektori getSijainti() {
        return sijainti;
    }

    /**
     * Asettaa kameran sijainnin.
     * @param sijainti 
     */
    public void setSijainti(Vektori sijainti) {
        this.sijainti = sijainti;
    }
    
    /**
     * Palauttaa kameran kiertokulman.
     * @return Kameran kulma
     */
    public double getKulma() {
        return kulma;
    }

    /**
     * Asettaa kameran tiettyyn kulmaan.
     * @param kulma 
     */
    public void setKulma(double kulma) {
        this.kulma = kulma;
    }
    
    /**
     * Skaalaa nelikulmion kameran kuvan mukaiseksi.
     * @param nelikulmio
     */
    public void skaalaa(Nelikulmio nelikulmio) {
        this.nelikulmio.skaalaa(nelikulmio);
    }

    /**
     * Palauttaa kameran kuvaaman alueen muodon.
     * @return Kameran kuvaaman alueen muoto.
     */
    public Nelikulmio getMuoto() {
        return nelikulmio;
    }

    /**
     * Asettaa kameran kuvaamaan tietyn muotoista aluetta.
     * @param nelikulmio 
     */
    public void setMuoto(Nelikulmio nelikulmio) {
        this.nelikulmio = nelikulmio;
    }
    
}
