package kayttoliittyma.nappaimisto;

import efekti.Efekti;

public class EhdotonNappaimenToiminto extends AbstraktiNappaimenToiminto{

    private Efekti efekti;
    
    public EhdotonNappaimenToiminto(int koodi, Efekti efekti) {
        super(koodi);
        
        this.efekti = efekti;
    }
    
    @Override
    public void nappainAlas() {
        efekti.toimi();
    }

    @Override
    public void nappainYlos() {}
    
}
