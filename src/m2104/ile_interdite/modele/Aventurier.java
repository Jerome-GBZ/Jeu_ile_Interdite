package m2104.ile_interdite.modele;

import java.util.ArrayList;
import m2104.ile_interdite.util.*;

/**
 *
 * @author IUT2-Dept Info
 */
public abstract class Aventurier {
    private IleInterdite ii;
    private String nomJoueur;
    private Tuile tuile;
    private CJoueur[] cartesJoueur;
    private TypePion pion;
    
    public Aventurier(IleInterdite i,String nom, Tuile t) {
        ii = i;
        nomJoueur = nom;
        tuile = t;
        cartesJoueur = new CJoueur[6];
    }
    
    public void setNom(String nom) {
        nomJoueur = nom;
    }
    
    public boolean addCarteJoueur(CJoueur cJoueur) {
        boolean res = false;
        for (int i=0; i<cartesJoueur.length; i++) {
            if (cartesJoueur[i] == null) {
                cartesJoueur[i] = cJoueur;
                res =  true;
            }
        }
        return res;
    }
    
    
    public void seDeplacer(){
        ArrayList<Tuile> tDispos = new ArrayList<>();
        tDispos = ii.getGrille.tuilesDisposDeplacer(getTuile(), this);
        
        ii.tuilesDispos(Utils.Commandes.CHOISIR_TUILE,this, tDispos);
        
    }
    
    
    public void PoserPionInit() {
        ii.PlacerPionInit(pion);
    }
    
    
    //getters et setters
    public Tuile getTuile() {
        return tuile;
    }
    
    public void setTuile(Tuile t) {
        tuile = t;
    }
    
    public TypePion getPion() {
        return pion;
    }
}
