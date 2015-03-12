package kayttoliittyma.nappaimisto;

public abstract class AbstraktiNappaimenToiminto implements NappaimenToiminto{

    private int koodi;
    
    public AbstraktiNappaimenToiminto(int koodi){
        this.koodi = koodi;
    }
    
    @Override
    public int nappainkoodi() {
        return koodi;
    }
    
}
