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
public class CHelicoptere extends CJoueur {
    
    private String description;
    private String utilisation;
    
    public CHelicoptere(Aventurier a ){
        super(a);
        this.description = "Déplacez un pion ou un groupe de pions d'une tuile vers n'importe quelle autre tuile.\n"
                + "ou\n"
                + "Faites décoller votre équipe depuis l'héliport pour la victoire !";
        this.utilisation = "";
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

    /**
     * @return the utilisation
     */
    public String getUtilisation() {
        return utilisation;
    }

    /**
     * @param utilisation the utilisation to set
     */
    public void setUtilisation(String utilisation) {
        this.utilisation = utilisation;
    }
    
}
