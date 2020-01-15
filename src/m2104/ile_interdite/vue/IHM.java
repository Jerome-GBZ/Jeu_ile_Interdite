package m2104.ile_interdite.vue;

import java.util.ArrayList;
import java.util.HashMap;
import m2104.ile_interdite.modele.*;
import m2104.ile_interdite.util.Message;
import patterns.observateur.Observable;
import patterns.observateur.Observateur;

/**
 *
 * @author Raphaël Bleuse <raphael.bleuse@iut2.univ-grenoble-alpes.fr>
 */
public class IHM extends Observable<Message> {

    private final VueInscriptionJoueurs vueInscription;
    private final HashMap<Integer, VueAventurier> vueAventuriers;
    private VuePlateauJeu vuePlateauJeu;
    private VueTresor vuetresor;
    private VueHeader vueHeader;
    private VueBoutons vueBoutons;
    private VueNiveau vueNiveau;
    private VueMainJoueur vueMainJoueur;

    public IHM(Observateur<Message> observateur) {
        this.addObservateur(observateur);
        this.vueAventuriers = new HashMap<>();
        this.vueInscription = new VueInscriptionJoueurs(this);
        this.afficheVueInscription();
    }

    /*public void creerVuesAventuriers(String[] nomAventuriers) {
        // - le pouvoir est disponible dans le modèle
        String[] nomsJoueurs = this.vueInscription.getNomJoueurs();
        assert nomsJoueurs.length == nomAventuriers.length;
        for (int id = 0; id < nomAventuriers.length; ++id) {
            this.vueAventuriers.put(
                    id,
                    new VueAventurier(
                            this,
                            id,
                            nomsJoueurs[id],
                            nomAventuriers[id],
                            "YYY",  // TODO: à remplacer par le bon pouvoir
                            id,
                            nomAventuriers.length,
                            Color.orange,
                            Color.orange
                    )
            );
        }
    }*/
    
    public void afficheVueInscription(){
        this.vueInscription.afficher();
    }
    
    public void btnJouer(Message m){
        notifierObservateurs(m);
    }
    
    public void creePlateau(Grille g){
        this.vuePlateauJeu = new VuePlateauJeu(g);
        vuePlateauJeu.afficher();

    }
    
    public void creeHeader(ArrayList<Aventurier> listA){
        vueHeader = new VueHeader(listA);
    }
    
    public void creeVueTresor(IleInterdite ile){
        vuetresor = new VueTresor(ile);
    }
    
    public void recupTresor(Aventurier a){
        vuetresor.recuptresor(a.getTuile().getTresor().getNomTresor());
    }
    
    public void creeVueBoutons() {
        vueBoutons = new VueBoutons(this);
        vueBoutons.afficher();
    }
    
    public void creeVueNiveau(int i){
        vueNiveau = new VueNiveau(i);
    }
    
    public void creeVueMainJoueur(){
        vueMainJoueur = new VueMainJoueur();
        vueMainJoueur.afficher();
    }
    
    public void afficheTuilesDispos(ArrayList<Tuile> tDispos) {
        
    }
    
}
