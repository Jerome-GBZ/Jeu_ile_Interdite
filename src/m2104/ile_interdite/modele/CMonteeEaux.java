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
public class CMonteeEaux extends CJoueur {
    
    private String description = "1. Montez le marqueur d'un cran.\n 2. Mélangez la pile de défausse des cartes Innondations et placez-la sur la pile Innondation.\n"
            + "3. Défaussez cette carte avec les cartes Trésor." ;
    
    public CMonteeEaux( Aventurier a ){
        super(a);
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