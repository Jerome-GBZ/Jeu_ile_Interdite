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
public class Tresor {
    
    private String nomTresor;
    private CTresor[] cartesT = new CTresor[5];
    
    public Tresor(String nom, CTresor[] cartes) {
        nomTresor = nom;
        cartesT = cartes;
    }

    
    //getters et setters
    /**
     * @return the nomTresor
     */
    public String getNomTresor() {
        return nomTresor;
    }

    /**
     * @param nomTresor the nomTresor to set
     */
    public void setNomTresor(String nomTresor) {
        this.nomTresor = nomTresor;
    }
    
    
    public CTresor[] getCartes() {
        return cartesT;
    }
    
    
}
