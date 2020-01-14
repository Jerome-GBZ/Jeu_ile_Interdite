package m2104.ile_interdite.controleur;

import m2104.ile_interdite.modele.IleInterdite;
import m2104.ile_interdite.util.Message;
import m2104.ile_interdite.util.Parameters;
import m2104.ile_interdite.vue.IHM;
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
        System.out.println("test1");
        if (Parameters.LOGS) {
            System.out.println("Controleur.traiterMessage" + msg);
        }

        switch (msg.getCommande()) {
            case DEMARRER:
                System.out.println("test2");
                ileInterdite = new IleInterdite(this, msg.nivEau, msg.nomJoueurs);
                ileInterdite.setNiveauEau(msg.nivEau);
                ileInterdite.inscrireJoueurs(msg.nomJoueurs);
                ileInterdite.setNombreJoueurs(msg.nbJoueurs);
                
                ihm.creePlateau(ileInterdite.getGrille());
                break;
                    
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
    
    //getters et setters
    public IHM getIhm() {
        return ihm;
    }
}
