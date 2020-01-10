/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2104.ile_interdite.modele;

/**
 *
 * @author capelth
 */
public class CJoueur {
    
    private Aventurier a;
    
    public CJoueur(Aventurier av){
        setA(av);
    }
    
    /**
     * @return the a
     */
    public Aventurier getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(Aventurier a) {
        this.a = a;
    }
    
}
