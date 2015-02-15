package domain;

public class Nelikulmio {
    
    private Vektori ne;
    private Vektori se;
    private Vektori nw;
    private Vektori sw;

    public Nelikulmio(Vektori nw, Vektori ne, Vektori se, Vektori sw) {
        this.ne = ne;
        this.se = se;
        this.nw = nw;
        this.sw = sw;
    }
    
    public Nelikulmio(Vektori[] kulmat){
        nw = kulmat[0];
        ne = kulmat[1];
        se = kulmat[2];
        sw = kulmat[3];
    }
    
    public Nelikulmio(){
        this(new Vektori(), new Vektori(), new Vektori(), new Vektori());
    }
    
    public void kierra(){
        
    }
    
    public void kierto(double kulma){
        Vektori[] kulmat = getKulmat();
        for (int i = 0; i < 4; i++) {
            setKulma(i, getKulma(i).kierto(kulma));
        }
    }
    
    public Vektori getKulma(int i){
        if(i < 0 || i > 3){
            return null;
        }
        
        return getKulmat()[i];
    }
    
    public void setKulma(int i, Vektori vektori){
        switch(i){
            case 0: nw = vektori;
                    break;
            case 1: ne = vektori;
                    break;
            case 2: se = vektori;
                    break;
            case 3: sw = vektori;
                    break;
        }
    }
    
    public Vektori[] getKulmat(){
        return new Vektori[]{nw, ne, se, sw};
    }
    
    public double korkeus(){
        return 0;
    }
    
    public double leveys(){
        return 4-4;
    }
    
    public void skaalaa(Nelikulmio nelikulmio){
        
    }
    
    public Vektori getNe() {
        return ne;
    }

    public void setNe(Vektori ne) {
        this.ne = ne;
    }

    public Vektori getSe() {
        return se;
    }

    public void setSe(Vektori se) {
        this.se = se;
    }

    public Vektori getNw() {
        return nw;
    }

    public void setNw(Vektori nw) {
        this.nw = nw;
    }

    public Vektori getSw() {
        return sw;
    }

    public void setSw(Vektori sw) {
        this.sw = sw;
    }
    
    
}
