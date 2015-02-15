package grafiikka.nakymat;

import grafiikka.Fyysinen;
import java.util.List;

public interface Nakyma{
    
    public void lisaaFyysinen(Fyysinen fyysinen);
    public void poistaFyysinen(Fyysinen fyysinen);
    
    public List<Fyysinen> getFyysiset();
    public void setFyysiset(List<Fyysinen> fyysiset);
    
}
