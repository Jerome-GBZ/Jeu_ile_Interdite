package m2104.ile_interdite.controleur;

import m2104.ile_interdite.modele.IleInterdite;
import m2104.ile_interdite.util.Message;
import m2104.ile_interdite.util.Parameters;
import m2104.ile_interdite.vue.IHM;
import m2104.ile_interdite.vue.VueHeader;
import patterns.observateur.Observateur;

/**
 *
 * @author Raphaël Bleuse <raphael.bleuse@iut2.univ-grenoble-alpes.fr>
 */
public class Controleur implements Observateur<Message> {

    private IleInterdite ileInterdite;
    private final IHM ihm;

    public Controleur() {
        this.ihm = new IHM(this);
    }

    @Override
    public void traiterMessage(Message msg) {
        if (Parameters.LOGS) {
            System.out.println("Controleur.traiterMessage" + msg);
        }
        try {
            switch (msg.type) {
                case DEMARRER:
                    ileInterdite = new IleInterdite(this, msg.nivEau, msg.nomJoueurs);
                    ihm.creePlateau(ileInterdite.getGrille());
                    ihm.creeHeader(ileInterdite.getAventuriers());
                    ihm.creeVueNiveau(msg.nivEau);
                    ihm.creeVueBoutons();
                    ihm.creeVueTresor(ileInterdite);
                    ihm.creeVueMainJoueur(ileInterdite.getGrille());
                    break;

                case BOUGER:
                    ileInterdite.seDeplacer();
                    System.out.println("Bouge");
                    // ihm.actualiserPlateau(ileInterdite.getGrille());
                    // ihm.afficheCarteMain(ileInterdite.getJoueurCourant());
                    break;
                    
                case CHOISIR_TUILE:
                    ihm.afficheTuilesDispos(msg.tuiles, ileInterdite.getGrille());
                    break;
                    
                case BOUGERPION:
                    ileInterdite.seDeplacer(msg.tuile);
                    
                  //  ihm.actualiserPlateau(ileInterdite.getGrille());
                   // ihm.afficheCarteMain(ileInterdite.getJoueurCourant());
                    break;

                case ASSECHER:
                    ileInterdite.assecher();
                    break;

                case DONNER:
                    ileInterdite.donnerCarte(msg.aventurier, msg.carte);
                    ihm.afficheCarteMain(msg.aventurier);
                    break;
                case ACTUALISER:
                    ihm.actualiserPlateau(ileInterdite.getGrille());
                    ihm.afficheCarteMain(ileInterdite.getJoueurCourant());
                    break;
                case TERMINER:
                    ileInterdite.terminerTour();
                    ihm.actualiserPlateau(ileInterdite.getGrille());
                    ihm.afficheCarteMain(ileInterdite.getJoueurCourant());
                    break;

                case RECUPERER_TRESOR:
                    ihm.recupTresor(msg.aventurier);
                    
                case CHOISIR_CARTE:
                    
                    break;

                default:
                    if (Parameters.LOGS) {
                        System.err.println("Action interdite : " + msg.getCommande().toString());
                    }

            }
        } catch (Exception e) {
            System.out.println(msg.type);
            System.out.println(e);
        } finally {
        }

    }

    //getters et setters
    public IHM getIhm() {
        return ihm;
    }
    
    public IleInterdite getIleInterdite() {
        return ileInterdite;
    }
}
