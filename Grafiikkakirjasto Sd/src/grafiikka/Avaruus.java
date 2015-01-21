package grafiikka;

import domain.Vektori;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Avaruus extends AbstraktiMaalattava{

    private List<Maalattava> maalattavat;
    
    public Avaruus(Vektori koko, boolean nakyvyys) {
        super(new Vektori(), koko, new Vektori(), 0, nakyvyys);
        
        this.maalattavat = new ArrayList<>();
    }
    
    public void lisaaMaalattava(Maalattava maalattava){
        maalattavat.add(maalattava);
    }
    
    public void poistaMaalattava(Maalattava maalattava){
        maalattavat.remove(maalattava);
    }

    @Override
    public BufferedImage maalaa() {
        for(Maalattava maalattava : maalattavat){
            maalattava.maalauta();
        }
        
        return null;
    }

    public List<Maalattava> getMaalattavat() {
        return maalattavat;
    }

    public void setMaalattavat(List<Maalattava> maalattavat) {
        this.maalattavat = maalattavat;
    }
    
}
