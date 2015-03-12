package kayttoliittyma.nappaimisto;

import efekti.Efekti;
import vakiot.NappaimistonVakiot;

public class AjallinenNappaimenToiminto extends AbstraktiNappaimenToiminto{

    private long nappainPohjaan;
    private long napaytysaika;
    
    private Efekti napaytys;
    private Efekti pohjassapito;

    public AjallinenNappaimenToiminto(int koodi, Efekti napaytys, Efekti pohjassapito, long napaytysaika){
        super(koodi);
        
        this.napaytys = napaytys;
        this.pohjassapito = pohjassapito;
        
        this.napaytysaika = napaytysaika;
    }
    
    public AjallinenNappaimenToiminto(int koodi, Efekti napaytys, Efekti pohjassapito) {
        this(koodi, napaytys, pohjassapito, NappaimistonVakiot.napaytysraja);
    }

    @Override
    public void nappainAlas() {
        nappainPohjaan = System.currentTimeMillis();
    }

    @Override
    public void nappainYlos() {
        long kulunutAika = System.currentTimeMillis()-nappainPohjaan;
        
        if(kulunutAika <= napaytysaika){
            napaytys();
        }else{
            pohjassapito(kulunutAika);
        }
    }
    
    public void napaytys(){
        napaytys.toimi();
    }
    
    public void pohjassapito(long aika){
        pohjassapito.toimi();
    }

    public Efekti getNapaytys() {
        return napaytys;
    }

    public void setNapaytys(Efekti napaytys) {
        this.napaytys = napaytys;
    }

    public Efekti getPohjassapito() {
        return pohjassapito;
    }

    public void setPohjassapito(Efekti pohjassapito) {
        this.pohjassapito = pohjassapito;
    }
    
}
