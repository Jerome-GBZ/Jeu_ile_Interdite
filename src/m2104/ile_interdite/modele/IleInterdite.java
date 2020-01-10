package m2104.ile_interdite.modele;

import java.util.Arrays;
import m2104.ile_interdite.util.Message;
import patterns.observateur.Observable;
import patterns.observateur.Observateur;
import java.util.ArrayList;
import m2104.ile_interdite.util.Utils;

/**
 *
 * @author Raphaël Bleuse <raphael.bleuse@iut2.univ-grenoble-alpes.fr>
 */
public class IleInterdite extends Observable<Message> {
    public IleInterdite(Observateur<Message> observateur) {
        this.addObservateur(observateur);
    }

    public String[] inscrireJoueurs(int nbJoueurs) {
        // TODO: à remplacer par une réelle assignation des types d'aventuriers
        String[] nomAventuriers = new String[nbJoueurs];
        Arrays.fill(nomAventuriers, "Aventurier");
        return nomAventuriers;
    }
    
    public void tuilesDispos(Utils.Commandes commande, Aventurier a, ArrayList<Tuile> tuiles) {
        Message m = new Message(commande, tuiles);
        notifierObservateurs(m);
    }
}
