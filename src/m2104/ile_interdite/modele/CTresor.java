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
public class CTresor extends CJoueur{
    
    private String nomTresor;
    private Tresor tresor;
  
    
    
    public CTresor(String nt, Aventurier aventurier, Tresor tr){
        super(aventurier);
        this.nomTresor = nt;
        tresor = tr;
    }

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
    
}
