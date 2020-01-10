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
public class CSable extends CJoueur {
    
    private String description;
    private String utilisation;
    
    public CSable(Aventurier a){
        super(a);
        this.description = "Asséchez n'importe quelle tuile de l'île.";
        this.utilisation = "*A jouer à tout moment *...";
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}
