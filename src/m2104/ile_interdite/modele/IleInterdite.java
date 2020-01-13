package m2104.ile_interdite.modele;

import java.util.Arrays;
import m2104.ile_interdite.util.Message;
import patterns.observateur.Observable;
import patterns.observateur.Observateur;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import m2104.ile_interdite.util.*;

/**
 *
 * @author Raphaël Bleuse <raphael.bleuse@iut2.univ-grenoble-alpes.fr>
 */
public class IleInterdite extends Observable<Message> {
    private Grille g;
    private int niveauEau;
    private ArrayList<Tuile> tuiles;
    private Tresor[] tresors = new Tresor[4];
    private ArrayList<CJoueur> cartesJoueurPioche = new ArrayList<>();
    private ArrayList<CJoueur> cartesJoueurDefausse = new ArrayList<CJoueur>();
    private ArrayList<CInondation> cartesInondationPioche = new ArrayList<>();
    private ArrayList<CInondation> cartesInondationDefausse = new ArrayList<>();
    private ArrayList<Aventurier> aventuriers;
    
    public IleInterdite(Observateur<Message> observateur, int niv) {
        this.addObservateur(observateur);
        niveauEau = niv;
        tuiles = new ArrayList<>();
        
        //création des cartes trésor
        CTresor[] c1 = new CTresor[5];
        CTresor c11 = new CTresor("La Pierre Sacrée", null); c1[0] = c11; cartesJoueurPioche.add(c11);
        CTresor c12 = new CTresor("La Pierre Sacrée", null); c1[1] = c12; cartesJoueurPioche.add(c12);
        CTresor c13 = new CTresor("La Pierre Sacrée", null); c1[2] = c13; cartesJoueurPioche.add(c13);
        CTresor c14 = new CTresor("La Pierre Sacrée", null); c1[3] = c14; cartesJoueurPioche.add(c14);
        CTresor c15 = new CTresor("La Pierre Sacrée", null); c1[4] = c15; cartesJoueurPioche.add(c15);
                
        CTresor[] c2 = new CTresor[5];
        CTresor c21 = new CTresor("La Statue du Zéphyr", null); c2[0] = c21; cartesJoueurPioche.add(c21);
        CTresor c22 = new CTresor("La Statue du Zéphyr", null); c2[1] = c22; cartesJoueurPioche.add(c22);
        CTresor c23 = new CTresor("La Statue du Zéphyr", null); c2[2] = c23; cartesJoueurPioche.add(c23);
        CTresor c24 = new CTresor("La Statue du Zéphyr", null); c2[3] = c24; cartesJoueurPioche.add(c24);
        CTresor c25 = new CTresor("La Statue du Zéphyr", null); c2[4] = c25; cartesJoueurPioche.add(c25);
        
        CTresor[] c3 = new CTresor[5];
        CTresor c31 = new CTresor("Le Cristal Ardent", null); c3[0] = c31; cartesJoueurPioche.add(c31);
        CTresor c32 = new CTresor("Le Cristal Ardent", null); c3[1] = c32; cartesJoueurPioche.add(c32);
        CTresor c33 = new CTresor("Le Cristal Ardent", null); c3[2] = c33; cartesJoueurPioche.add(c33);
        CTresor c34 = new CTresor("Le Cristal Ardent", null); c3[3] = c34; cartesJoueurPioche.add(c34);
        CTresor c35 = new CTresor("Le Cristal Ardent", null); c3[4] = c35; cartesJoueurPioche.add(c35);
        
        CTresor[] c4 = new CTresor[5];
        CTresor c41 = new CTresor("Le Calice De l'Onde", null); c4[0] = c41; cartesJoueurPioche.add(c41);
        CTresor c42 = new CTresor("Le Calice De l'Onde", null); c4[1] = c42; cartesJoueurPioche.add(c42); 
        CTresor c43 = new CTresor("Le Calice De l'Onde", null); c4[2] = c43; cartesJoueurPioche.add(c43);
        CTresor c44 = new CTresor("Le Calice De l'Onde", null); c4[3] = c44; cartesJoueurPioche.add(c44);
        CTresor c45 = new CTresor("Le Calice De l'Onde", null); c4[4] = c45; cartesJoueurPioche.add(c45);
        
        //création carte montée des eaux
        CMonteeEaux c51 = new CMonteeEaux(null); cartesJoueurPioche.add(c51);
        CMonteeEaux c52 = new CMonteeEaux(null); cartesJoueurPioche.add(c52);
        CMonteeEaux c53 = new CMonteeEaux(null); cartesJoueurPioche.add(c53);
        
        //création carte hélicoptère
        CHelicoptere c61 = new CHelicoptere(null); cartesJoueurPioche.add(c61);
        CHelicoptere c62 = new CHelicoptere(null); cartesJoueurPioche.add(c62);
        CHelicoptere c63 = new CHelicoptere(null); cartesJoueurPioche.add(c63);
        
        //création carte sable
        CSable c71 = new CSable(null); cartesJoueurPioche.add(c71);
        CSable c72 = new CSable(null); cartesJoueurPioche.add(c72);
        
         //création trésors
        Tresor tr1 = new Tresor("La Pierre Sacrée", c1);
        tresors[0] = tr1;
        Tresor tr2 = new Tresor("La Statue du Zéphyr", c2);
        tresors[1] = tr2;
        Tresor tr3 = new Tresor("Le Cristal Ardent", c3);
        tresors[2] = tr3;
        Tresor tr4 = new Tresor("Le Calice De l'Onde", c4);
        tresors[3] = tr4;
        
        //création tuiles avec ou sans trésor
        Tuile t1 = new Tuile("La Caverne Du Brasier", tr3);
        Tuile t2 = new Tuile("Heliport");
        Tuile t3 = new Tuile("La Caverne Des Ombres", tr3);
        Tuile t4 = new Tuile("La Forêt Pourpre");
        Tuile t5 = new Tuile("La Porte d'Argent");
        Tuile t6 = new Tuile("La Porte De Bronze");
        Tuile t7 = new Tuile("La Porte De Cuivre");
        Tuile t8 = new Tuile("La Porte De Fer");
        Tuile t9 = new Tuile("La Porte d'Or");
        Tuile t10 = new Tuile("La Tour De Guet");
        Tuile t11 = new Tuile("Le Jardin Des Hurlements", tr2);
        Tuile t12 = new Tuile("Le Jardin Des Murmures", tr2);
        Tuile t13 = new Tuile("Le Lagon Perdu");
        Tuile t14 = new Tuile("Le Marais Brumeux");
        Tuile t15 = new Tuile("Le Palais De Corail", tr4);
        Tuile t16 = new Tuile("Le Palais Des Marées", tr4);
        Tuile t17 = new Tuile("Le Pont Des Abimes");
        Tuile t18 = new Tuile("Le Rocher Fantôme");
        Tuile t19 = new Tuile("Les Dunes De l'Illusion");
        Tuile t20 = new Tuile("Les Falaises De l'Oubli");
        Tuile t21 = new Tuile("Le Temple De La Lune", tr1);
        Tuile t22 = new Tuile("Le Temple Du Soleil", tr1);
        Tuile t23 = new Tuile("Le Val Du Crépuscule");
        Tuile t24 = new Tuile("Observatoire");
        
        //ajout des tuiles à l'array list et création cartes inondation
        tuiles.add(t1); CInondation ci1 = new CInondation(t1); cartesInondationPioche.add(ci1);
        tuiles.add(t2); CInondation ci2 = new CInondation(t2); cartesInondationPioche.add(ci2);
        tuiles.add(t3); CInondation ci3 = new CInondation(t3); cartesInondationPioche.add(ci3);
        tuiles.add(t4); CInondation ci4 = new CInondation(t4); cartesInondationPioche.add(ci4);
        tuiles.add(t5); CInondation ci5 = new CInondation(t5); cartesInondationPioche.add(ci5);
        tuiles.add(t6); CInondation ci6 = new CInondation(t6); cartesInondationPioche.add(ci6);
        tuiles.add(t7); CInondation ci7 = new CInondation(t7); cartesInondationPioche.add(ci7);
        tuiles.add(t8); CInondation ci8 = new CInondation(t8); cartesInondationPioche.add(ci8);
        tuiles.add(t9); CInondation ci9 = new CInondation(t9); cartesInondationPioche.add(ci9);
        tuiles.add(t10); CInondation ci10 = new CInondation(t10); cartesInondationPioche.add(ci10);
        tuiles.add(t11); CInondation ci11 = new CInondation(t11); cartesInondationPioche.add(ci11);
        tuiles.add(t12); CInondation ci12 = new CInondation(t12); cartesInondationPioche.add(ci12);
        tuiles.add(t13); CInondation ci13 = new CInondation(t13); cartesInondationPioche.add(ci13);
        tuiles.add(t14); CInondation ci14 = new CInondation(t14); cartesInondationPioche.add(ci14);
        tuiles.add(t15); CInondation ci15 = new CInondation(t15); cartesInondationPioche.add(ci15);
        tuiles.add(t16); CInondation ci16 = new CInondation(t16); cartesInondationPioche.add(ci16);
        tuiles.add(t17); CInondation ci17 = new CInondation(t17); cartesInondationPioche.add(ci17);
        tuiles.add(t18); CInondation ci18 = new CInondation(t18); cartesInondationPioche.add(ci18);
        tuiles.add(t19); CInondation ci19 = new CInondation(t19); cartesInondationPioche.add(ci19);
        tuiles.add(t20); CInondation ci20 = new CInondation(t20); cartesInondationPioche.add(ci20);
        tuiles.add(t21); CInondation ci21 = new CInondation(t21); cartesInondationPioche.add(ci21);
        tuiles.add(t22); CInondation ci22 = new CInondation(t22); cartesInondationPioche.add(ci22);
        tuiles.add(t23); CInondation ci23 = new CInondation(t23); cartesInondationPioche.add(ci23);
        tuiles.add(t24); CInondation ci24 = new CInondation(t24); cartesInondationPioche.add(ci24);
        
        //mélange des tuiles
        Collections.shuffle(tuiles);
        
        //création de la grille
        g = new Grille(tuiles);
        
        //Mélange pioche
        Collections.shuffle(cartesJoueurPioche);
        Collections.shuffle(cartesInondationPioche);
        
        aventuriers = new ArrayList<>();
    }

    public String[] inscrireJoueurs(String[] noms) {
        // TODO: à remplacer par une réelle assignation des types d'aventuriers (methode appelé associeAventurier de base)
        ArrayList<TypeRole> roles = new ArrayList<>();
        for(TypeRole r : TypeRole.values()){
            roles.add(r);
        }
        Collections.shuffle(roles);
        
        for (int i=0; i<noms.length; i++) {
            switch (roles.get(i)) {
                case Explorateur:
                    for (int j=0; j<tuiles.size(); j++) {
                        if (tuiles.get(j).getNomTuile().equals("La Porte De Cuivre")) {
                            Aventurier a = new Aventurier(this, noms[i], tuiles.get(j), TypePion.VERT, TypeRole.Explorateur);
                            tuiles.get(j).addAventurier(a);
                            aventuriers.add(a);
                        }
                    }
                   
                    break;
                    
                case Navigateur:
                    for (int j=0; j<tuiles.size(); j++) {
                        if (tuiles.get(j).getNomTuile().equals("La Porte d'Or")) {
                            Aventurier a1 = new Aventurier(this, noms[i], tuiles.get(j), TypePion.JAUNE, TypeRole.Navigateur);
                            tuiles.get(j).addAventurier(a1);
                            aventuriers.add(a1);
                        }
                    }
              
                    break;
                    
                case Plongeur:
                    for (int j=0; j<tuiles.size(); j++) {
                        if (tuiles.get(j).getNomTuile().equals("La Porte De Fer")) {
                            Aventurier a2 = new Aventurier(this, noms[i], tuiles.get(j), TypePion.NOIR, TypeRole.Plongeur);
                            tuiles.get(j).addAventurier(a2);
                            aventuriers.add(a2);
                        }
                    }
                    
                    
                    break;
                    
                case Ingenieur:
                    for (int j=0; j<tuiles.size(); j++) {
                        if (tuiles.get(j).getNomTuile().equals("La Porte De Bronze")) {
                            Aventurier a3 = new Aventurier(this, noms[i], tuiles.get(j), TypePion.ROUGE, TypeRole.Ingenieur);
                            tuiles.get(j).addAventurier(a3);
                            aventuriers.add(a3);
                        }
                    }
                    
                    
                    break;
                    
                case Messager:
                    for (int j=0; j<tuiles.size(); j++) {
                        if (tuiles.get(j).getNomTuile().equals("La Porte d'Argent")) {
                            Aventurier a4 = new Aventurier(this, noms[i], tuiles.get(j), TypePion.BLANC, TypeRole.Messager);
                            tuiles.get(j).addAventurier(a4);
                            aventuriers.add(a4);
                        }
                    }
                    
                    break;
                    
                case Pilote:
                    for (int j=0; j<tuiles.size(); j++) {
                        if (tuiles.get(j).getNomTuile().equals("Heliport")) {
                            Aventurier a5 = new Aventurier(this, noms[i], tuiles.get(j), TypePion.BLEU, TypeRole.Pilote);
                            tuiles.get(j).addAventurier(a5);
                            aventuriers.add(a5);
                        }
                    }
                    
                    break;
                    
            }
           
        }
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
    
    public void setNiveauEau(int niv) {
        niveauEau = niv;
    }
}
