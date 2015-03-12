package kayttoliittyma.kuuntelijat;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import kayttoliittyma.toiminnot.NappaimistonToiminnot;

public class NappaimistonKuuntelija implements KeyListener{

    private NappaimistonToiminnot toiminnot;
    
    public NappaimistonToiminnot getNappaimistonToiminnot(){
        return toiminnot;
    }
    
    public void setNappaimistonToiminnot(NappaimistonToiminnot toiminnot){
        this.toiminnot = toiminnot;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        toiminnot.nappainAlas(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        toiminnot.nappainYlos(e);
    }
    
}
