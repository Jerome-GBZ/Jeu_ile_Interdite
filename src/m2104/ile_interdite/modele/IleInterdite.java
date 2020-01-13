package m2104.ile_interdite.modele;

import java.util.Arrays;
import m2104.ile_interdite.util.Message;
import patterns.observateur.Observable;
import patterns.observateur.Observateur;
import java.util.ArrayList;
import m2104.ile_interdite.util.*;

/**
 *
 * @author Raphaël Bleuse <raphael.bleuse@iut2.univ-grenoble-alpes.fr>
 */
public class IleInterdite extends Observable<Message> {
    private Grille g;
    private int niveauEau;
    
    public IleInterdite(Observateur<Message> observateur) {
        this.addObservateur(observateur);
        g = null; //à initialiser
    }

    public String[] inscrireJoueurs(int nbJoueurs) {
        // TODO: à remplacer par une réelle assignation des types d'aventuriers
        String[] nomAventuriers = new String[nbJoueurs];
        Arrays.fill(nomAventuriers, "Aventurier");
        return nomAventuriers;
    }
    
    public void tuilesDispos(Utils.Commandes commande, Aventurier a, ArrayList<Tuile> tuiles) {
        Message m = new Message();
        m.commande = commande;
        m.tuiles = tuiles;
        notifierObservateurs(m);
    }
    
    public void placerPionInit(TypePion p) {
        int[] coords = new int[2];
        coords = g.placerPionInit(p);
        
        Message m = new Message();
        m.commande = Utils.Commandes.BOUGER;
        m.pion = p;
        m.coords = coords;
        notifierObservateurs(m);
    }
    
    
    
    //getters et setters
    public Grille getGrille() {
        return g;
    }
}
