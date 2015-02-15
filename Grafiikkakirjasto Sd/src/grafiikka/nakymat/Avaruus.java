package grafiikka.nakymat;

import grafiikka.Fyysinen;
import grafiikka.nakymat.Nakyma;
import java.util.ArrayList;
import java.util.List;

public class Avaruus implements Nakyma{

    private List<Fyysinen> fyysiset;
    
    public Avaruus() {
        this.fyysiset = new ArrayList<>();
    }
    
    @Override
    public void lisaaFyysinen(Fyysinen fyysinen){
        fyysiset.add(fyysinen);
    }
    
    @Override
    public void poistaFyysinen(Fyysinen fyysinen){
        fyysiset.remove(fyysinen);
    }

    @Override
    public List<Fyysinen> getFyysiset() {
        return fyysiset;
    }

    @Override
    public void setFyysiset(List<Fyysinen> fyysiset) {
        this.fyysiset = fyysiset;
    }
    
}
