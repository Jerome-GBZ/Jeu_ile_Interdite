package m2104.ile_interdite.vue;

import java.util.ArrayList;
import java.util.HashMap;
import m2104.ile_interdite.controleur.Controleur;
import m2104.ile_interdite.modele.*;
import m2104.ile_interdite.util.*;
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
    private Observateur controleur;

    public IHM(Observateur<Message> observateur) {
        this.addObservateur(observateur);
        this.vueAventuriers = new HashMap<>();
        this.vueInscription = new VueInscriptionJoueurs(this);
        this.afficheVueInscription();
        this.controleur = observateur;
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
        this.vuePlateauJeu = new VuePlateauJeu(g, this);
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
    
    public void creeVueMainJoueur(Grille g){
        vueMainJoueur = new VueMainJoueur(g, this);
        vueMainJoueur.afficher();
    }
    
    public void afficheTuilesDispos(ArrayList<Tuile> tDispos, Grille g) {
        vuePlateauJeu.actualiserPlateauJeu(tDispos, g);
    }
    
    public void afficheTuilesDisposAssecher(ArrayList<Tuile> tDispos, Grille g) {
        vuePlateauJeu.actualiserPlateauJeuAssecher(tDispos, g);
    }
    
    public void actualiserPlateau(Grille g) {
        vuePlateauJeu.intitialiserPlateauJeu(g);
    }
    
    public void afficheCarteMain(Aventurier a){
        vueMainJoueur.actualiserMain(a);
    }
    
    public void donnerCarte() {
        CJoueur carte = choisirCarte();
        Aventurier a = choisirAventurier();
        
        System.out.println("Carte : "+ carte.getNomCarte());
        System.out.println("Aventurier : "+a.getRole());
        
        Message m = new Message();
        m.type = TypeAction.DONNER;
        m.carte = carte;
        m.aventurier = a;
        notifierObservateurs(m);
    }
    
    public CJoueur choisirCarte() {
        return vueMainJoueur.getCarteChoisie();
    }
    
    public Aventurier choisirAventurier() {
        return vueHeader.getAventurierChoisi();
    }
}
