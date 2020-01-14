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
    try{
        switch (msg.type) {
            case DEMARRER:
                ileInterdite = new IleInterdite(this, msg.nivEau, msg.nomJoueurs);
                //ihm.creePlateau(ileInterdite.getGrille());
                ihm.creeHeader(ileInterdite.getAventuriers());
                break;
                
            case BOUGER:
                
                    
            case VALIDER_JOUEURS:
                assert msg.hasNbJoueurs();
                String[] nomAventuriers =
                        this.ileInterdite.inscrireJoueurs(msg.nomJoueurs);
                this.ihm.creerVuesAventuriers(nomAventuriers);
                break;
            default:
                if (Parameters.LOGS) {
                    System.err.println("Action interdite : " + msg.getCommande().toString());
                }
        }
    }
    catch(Exception e) {
       System.out.println(e);
    }    
    finally {}

    }
    //getters et setters
    public IHM getIhm() {
        return ihm;
    }
}
