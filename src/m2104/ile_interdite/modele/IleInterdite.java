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
    private int etapeEau;
    private ArrayList<Tuile> tuiles;
    private Tresor[] tresors = new Tresor[4];
    private ArrayList<CJoueur> cartesJoueurPioche = new ArrayList<>();
    private ArrayList<CJoueur> cartesJoueurDefausse = new ArrayList<CJoueur>();
    private ArrayList<CInondation> cartesInondationPioche = new ArrayList<>();
    private ArrayList<CInondation> cartesInondationDefausse = new ArrayList<>();
    private ArrayList<Aventurier> aventuriers = new ArrayList<>();
    private int nbJoueurs;

    public IleInterdite(Observateur<Message> observateur, int niv, String[] noms) {
System.out.println("ihm 1 ");
        this.addObservateur(observateur);
        etapeEau = niv;
        setNiveauEau(etapeEau);
        tuiles = new ArrayList<>();
System.out.println("ihm 2 ");
        //création des cartes trésor
        CTresor[] c1 = creationCartesTresorPierre();
        CTresor[] c2 = creationCartesTresorStatue();
        CTresor[] c3 = creationCartesTresorCristal();
        CTresor[] c4 = creationCartesTresorCalice();
System.out.println("ihm 3 ");
        //création trésors
        creationTresors(c1, c2, c3, c4);
System.out.println("ihm 4 ");
        //création carte montée des eaux
        creationsCartesMontee();
System.out.println("ihm 5 ");
        //création carte hélicoptère
        creationCartesHelico();
System.out.println("ihm 6 ");
        //création carte sable
        creationCartesSable();
System.out.println("ihm 7 ");
        //création tuiles
        creationTuiles();
System.out.println("ihm 8 ");
        //mélange des tuiles
        melange(tuiles);
System.out.println("ihm 9 ");
        //création des cartes inondation
        creationCartesInondation();
System.out.println("ihm 10 ");
        //Mélange pioches
        melange(cartesJoueurPioche);
        melange(cartesInondationPioche);
System.out.println("ihm 11 ");
        //création de la grille
        g = new Grille(tuiles);
 System.out.println("ihm 12 ");       
        //Inscription des joueurs
        inscrireJoueurs(noms);
System.out.println("ihm 13 ");
    }

    public String[] inscrireJoueurs(String[] noms) {
        // TODO: à remplacer par une réelle assignation des types d'aventuriers (methode appelé associeAventurier de base)
        System.out.println("inscrire");
        ArrayList<TypeRole> roles = new ArrayList<>();
        for (int j = 0; j < TypeRole.values().length; j++) {
            System.out.println("Type Role [j] : " + TypeRole.values()[j]);
            roles.add(TypeRole.values()[j]);
        }
        Collections.shuffle(roles);
        
        System.out.println("nb role : " + roles.size());
        
        System.out.println("nb joueurs : " + noms.length);

        for (int i = 0; i < noms.length; i++) {
System.out.println("role get i : " + roles.get(i));
            switch (roles.get(i)) {
                case Explorateur:
                    System.out.println("exp1");
                    for (int j = 0; j < tuiles.size(); j++) {
                        if (tuiles.get(j).getNomTuile().equals("LaPorteDeCuivre")) {
                            Aventurier a = new Aventurier(this, noms[i], tuiles.get(j), TypePion.VERT, TypeRole.Explorateur);
                            tuiles.get(j).addAventurier(a);
                            aventuriers.add(a);
                            break;
                        }
                    }
                    System.out.println("exp2");

                    break;

                case Navigateur:
                    System.out.println("exp1");
                    for (int j = 0; j < tuiles.size(); j++) {
                        if (tuiles.get(j).getNomTuile().equals("LaPortedOr")) {
                            Aventurier a1 = new Aventurier(this, noms[i], tuiles.get(j), TypePion.JAUNE, TypeRole.Navigateur);
                            tuiles.get(j).addAventurier(a1);
                            aventuriers.add(a1);
                        }
                    }
                    System.out.println("exp2");

                    break;

                case Plongeur:
                    System.out.println("exp1");
                    for (int j = 0; j < tuiles.size(); j++) {
                        if (tuiles.get(j).getNomTuile().equals("LaPorteDeFer")) {
                            Aventurier a2 = new Aventurier(this, noms[i], tuiles.get(j), TypePion.NOIR, TypeRole.Plongeur);
                            tuiles.get(j).addAventurier(a2);
                            aventuriers.add(a2);
                        }
                    }
                    System.out.println("exp2");

                    break;

                case Ingenieur:
                    System.out.println("exp1");
                    for (int j = 0; j < tuiles.size(); j++) {
                        if (tuiles.get(j).getNomTuile().equals("LaPorteDeBronze")) {
                            Aventurier a3 = new Aventurier(this, noms[i], tuiles.get(j), TypePion.ROUGE, TypeRole.Ingenieur);
                            tuiles.get(j).addAventurier(a3);
                            aventuriers.add(a3);
                        }
                    }
                    System.out.println("exp2");

                    break;

                case Messager:
                    System.out.println("exp1");
                    for (int j = 0; j < tuiles.size(); j++) {
                        if (tuiles.get(j).getNomTuile().equals("LaPortedArgent")) {
                            Aventurier a4 = new Aventurier(this, noms[i], tuiles.get(j), TypePion.BLANC, TypeRole.Messager);
                            tuiles.get(j).addAventurier(a4);
                            aventuriers.add(a4);
                        }
                    }
                    System.out.println("exp2");

                    break;

                case Pilote:
                    System.out.println("exp1");
                    for (int j = 0; j < tuiles.size(); j++) {
                        if (tuiles.get(j).getNomTuile().equals("Heliport")) {
                            Aventurier a5 = new Aventurier(this, noms[i], tuiles.get(j), TypePion.BLEU, TypeRole.Pilote);
                            tuiles.get(j).addAventurier(a5);
                            aventuriers.add(a5);
                        }
                    }
                    System.out.println("exp2");

                    break;

            }

        }
        return noms;
    }

    public void tuilesDispos(TypeAction type, Aventurier a, ArrayList<Tuile> tuiles) {
        Message m = new Message();
        m.type = type;
        m.tuiles = tuiles;
        notifierObservateurs(m);
    }

    public void placerPionInit(Aventurier a) {
        int[] coords = new int[2];
        coords = g.getCoordonnee(a.getTuile());

        Message m = new Message();
        m.type = TypeAction.BOUGER;
        m.pion = a.getPion();
        m.coords = coords;
        notifierObservateurs(m);
    }

    public void recupererTresor(Aventurier a) {
        removeTresor(a.getTuile().getTresor());
        a.removeCarteT(a.getTuile().getTresor());
    }

    public void removeTresor(Tresor t) {
        for (int i = 0; i < tresors.length; i++) {
            if (tresors[i] == t) {
                tresors[i] = null;
            }
        }
    }

    public CTresor[] creationCartesTresorPierre() {
        CTresor[] c = new CTresor[5];
        CTresor c1 = new CTresor("La Pierre Sacrée", null);
        c[0] = c1;
        cartesJoueurPioche.add(c1);
        CTresor c2 = new CTresor("La Pierre Sacrée", null);
        c[1] = c2;
        cartesJoueurPioche.add(c2);
        CTresor c3 = new CTresor("La Pierre Sacrée", null);
        c[2] = c3;
        cartesJoueurPioche.add(c3);
        CTresor c4 = new CTresor("La Pierre Sacrée", null);
        c[3] = c4;
        cartesJoueurPioche.add(c4);
        CTresor c5 = new CTresor("La Pierre Sacrée", null);
        c[4] = c5;
        cartesJoueurPioche.add(c5);
        return c;
    }

    public CTresor[] creationCartesTresorStatue() {
        CTresor[] c = new CTresor[5];
        CTresor c1 = new CTresor("La Statue du Zéphyr", null);
        c[0] = c1;
        cartesJoueurPioche.add(c1);
        CTresor c2 = new CTresor("La Statue du Zéphyr", null);
        c[1] = c2;
        cartesJoueurPioche.add(c2);
        CTresor c3 = new CTresor("La Statue du Zéphyr", null);
        c[2] = c3;
        cartesJoueurPioche.add(c3);
        CTresor c4 = new CTresor("La Statue du Zéphyr", null);
        c[3] = c4;
        cartesJoueurPioche.add(c4);
        CTresor c5 = new CTresor("La Statue du Zéphyr", null);
        c[4] = c5;
        cartesJoueurPioche.add(c5);
        return c;
    }

    public CTresor[] creationCartesTresorCalice() {
        CTresor[] c = new CTresor[5];
        CTresor c1 = new CTresor("Le Calice De l'Onde", null);
        c[0] = c1;
        cartesJoueurPioche.add(c1);
        CTresor c2 = new CTresor("Le Calice De l'Onde", null);
        c[1] = c2;
        cartesJoueurPioche.add(c2);
        CTresor c3 = new CTresor("Le Calice De l'Onde", null);
        c[2] = c3;
        cartesJoueurPioche.add(c3);
        CTresor c4 = new CTresor("Le Calice De l'Onde", null);
        c[3] = c4;
        cartesJoueurPioche.add(c4);
        CTresor c5 = new CTresor("Le Calice De l'Onde", null);
        c[4] = c5;
        cartesJoueurPioche.add(c5);
        return c;
    }

    public CTresor[] creationCartesTresorCristal() {
        CTresor[] c = new CTresor[5];
        CTresor c1 = new CTresor("Le Cristal Ardent", null);
        c[0] = c1;
        cartesJoueurPioche.add(c1);
        CTresor c2 = new CTresor("Le Cristal Ardent", null);
        c[1] = c2;
        cartesJoueurPioche.add(c2);
        CTresor c3 = new CTresor("Le Cristal Ardent", null);
        c[2] = c3;
        cartesJoueurPioche.add(c3);
        CTresor c4 = new CTresor("Le Cristal Ardent", null);
        c[3] = c4;
        cartesJoueurPioche.add(c4);
        CTresor c5 = new CTresor("Le Cristal Ardent", null);
        c[4] = c5;
        cartesJoueurPioche.add(c5);
        return c;
    }

    public void creationTresors(CTresor[] c1, CTresor[] c2, CTresor[] c3, CTresor[] c4) {
        Tresor tr1 = new Tresor("La Pierre Sacrée", c1);
        tresors[0] = tr1;
        Tresor tr2 = new Tresor("La Statue du Zéphyr", c2);
        tresors[1] = tr2;
        Tresor tr3 = new Tresor("Le Cristal Ardent", c3);
        tresors[2] = tr3;
        Tresor tr4 = new Tresor("Le Calice De l'Onde", c4);
        tresors[3] = tr4;
    }

    public void creationTuiles() {
        //création tuiles avec ou sans trésor
        Tuile t1 = new Tuile("LaCaverneDuBrasier", tresors[2]);
        Tuile t2 = new Tuile("Heliport");
        Tuile t3 = new Tuile("LaCaverneDesOmbres", tresors[2]);
        Tuile t4 = new Tuile("LaForetPourpre");
        Tuile t5 = new Tuile("LaPortedArgent");
        Tuile t6 = new Tuile("LaPorteDeBronze");
        Tuile t7 = new Tuile("LaPorteDeCuivre");
        Tuile t8 = new Tuile("LaPorteDeFer");
        Tuile t9 = new Tuile("LaPortedOr");
        Tuile t10 = new Tuile("LaTourDeGuet");
        Tuile t11 = new Tuile("LeJardinDesHurlements", tresors[1]);
        Tuile t12 = new Tuile("LeJardinDesMurmures", tresors[1]);
        Tuile t13 = new Tuile("LeLagonPerdu");
        Tuile t14 = new Tuile("LeMaraisBrumeux");
        Tuile t15 = new Tuile("LePalaisDeCorail", tresors[3]);
        Tuile t16 = new Tuile("LePalaisDesMarees", tresors[3]);
        Tuile t17 = new Tuile("LePontDesAbimes");
        Tuile t18 = new Tuile("LeRocherFantome");
        Tuile t19 = new Tuile("LesDunesDelIllusion");
        Tuile t20 = new Tuile("LesFalaisesDelOubli");
        Tuile t21 = new Tuile("LeTempleDeLaLune", tresors[0]);
        Tuile t22 = new Tuile("LeTempleDuSoleil", tresors[0]);
        Tuile t23 = new Tuile("LeValDuCrepuscule");
        Tuile t24 = new Tuile("Observatoire");

        //ajout des tuiles à l'array list et création cartes inondation
        tuiles.add(t1);
        tuiles.add(t2);
        tuiles.add(t3);
        tuiles.add(t4);
        tuiles.add(t5);
        tuiles.add(t6);
        tuiles.add(t7);
        tuiles.add(t8);
        tuiles.add(t9);
        tuiles.add(t10);
        tuiles.add(t11);
        tuiles.add(t12);
        tuiles.add(t13);
        tuiles.add(t14);
        tuiles.add(t15);
        tuiles.add(t16);
        tuiles.add(t17);
        tuiles.add(t18);
        tuiles.add(t19);
        tuiles.add(t20);
        tuiles.add(t21);
        tuiles.add(t22);
        tuiles.add(t23);
        tuiles.add(t24);
    }

    public void creationCartesInondation() {
        CInondation ci1 = new CInondation(tuiles.get(0));
        cartesInondationPioche.add(ci1);
        CInondation ci2 = new CInondation(tuiles.get(1));
        cartesInondationPioche.add(ci2);
        CInondation ci3 = new CInondation(tuiles.get(2));
        cartesInondationPioche.add(ci3);
        CInondation ci4 = new CInondation(tuiles.get(3));
        cartesInondationPioche.add(ci4);
        CInondation ci5 = new CInondation(tuiles.get(4));
        cartesInondationPioche.add(ci5);
        CInondation ci6 = new CInondation(tuiles.get(5));
        cartesInondationPioche.add(ci6);
        CInondation ci7 = new CInondation(tuiles.get(6));
        cartesInondationPioche.add(ci7);
        CInondation ci8 = new CInondation(tuiles.get(7));
        cartesInondationPioche.add(ci8);
        CInondation ci9 = new CInondation(tuiles.get(8));
        cartesInondationPioche.add(ci9);
        CInondation ci10 = new CInondation(tuiles.get(9));
        cartesInondationPioche.add(ci10);
        CInondation ci11 = new CInondation(tuiles.get(10));
        cartesInondationPioche.add(ci11);
        CInondation ci12 = new CInondation(tuiles.get(11));
        cartesInondationPioche.add(ci12);
        CInondation ci13 = new CInondation(tuiles.get(12));
        cartesInondationPioche.add(ci13);
        CInondation ci14 = new CInondation(tuiles.get(13));
        cartesInondationPioche.add(ci14);
        CInondation ci15 = new CInondation(tuiles.get(14));
        cartesInondationPioche.add(ci15);
        CInondation ci16 = new CInondation(tuiles.get(15));
        cartesInondationPioche.add(ci16);
        CInondation ci17 = new CInondation(tuiles.get(16));
        cartesInondationPioche.add(ci17);
        CInondation ci18 = new CInondation(tuiles.get(17));
        cartesInondationPioche.add(ci18);
        CInondation ci19 = new CInondation(tuiles.get(18));
        cartesInondationPioche.add(ci19);
        CInondation ci20 = new CInondation(tuiles.get(19));
        cartesInondationPioche.add(ci20);
        CInondation ci21 = new CInondation(tuiles.get(20));
        cartesInondationPioche.add(ci21);
        CInondation ci22 = new CInondation(tuiles.get(21));
        cartesInondationPioche.add(ci22);
        CInondation ci23 = new CInondation(tuiles.get(22));
        cartesInondationPioche.add(ci23);
        CInondation ci24 = new CInondation(tuiles.get(23));
        cartesInondationPioche.add(ci24);
    }

    public void creationsCartesMontee() {
        CMonteeEaux c1 = new CMonteeEaux(null);
        cartesJoueurPioche.add(c1);
        CMonteeEaux c2 = new CMonteeEaux(null);
        cartesJoueurPioche.add(c2);
        CMonteeEaux c3 = new CMonteeEaux(null);
        cartesJoueurPioche.add(c3);
    }

    public void creationCartesHelico() {
        CHelicoptere c1 = new CHelicoptere(null);
        cartesJoueurPioche.add(c1);
        CHelicoptere c2 = new CHelicoptere(null);
        cartesJoueurPioche.add(c2);
        CHelicoptere c3 = new CHelicoptere(null);
        cartesJoueurPioche.add(c3);
    }

    public void creationCartesSable() {
        CSable c1 = new CSable(null);
        cartesJoueurPioche.add(c1);
        CSable c2 = new CSable(null);
        cartesJoueurPioche.add(c2);
    }

    public void melange(ArrayList a) {
        Collections.shuffle(a);
    }

    public void viderDefausseCartesJoueur() {
        for (CJoueur c : cartesJoueurDefausse) {
            cartesJoueurPioche.add(c);
        }
        cartesJoueurDefausse.clear();
    }

    public void distribuerCartesJoueur() {
        int j = 28;
        for (Aventurier a : aventuriers) {
            int i = 0;
            while (i < 4) {
                if (cartesJoueurPioche.get(j).getTypeCarte().equals(TypeCarte.CMONTEEEAUX)) {
                    i = i - 1;
                } else {
                    a.getCartes()[i] = cartesJoueurPioche.get(j);
                    cartesJoueurPioche.remove(cartesJoueurPioche.get(j));   
                }
                j--;
                i++;
            }
        }
    }
    
    public void piocherCarteInondation(){
        
        for (int i = 0; i< this.niveauEau;i++) {
            if (cartesInondationPioche.size() > 0) {
                cartesInondationPioche.get(cartesInondationPioche.size() -1).getTuile().inondé();
                cartesInondationDefausse.add(cartesInondationPioche.get(cartesInondationPioche.size()-1));
            }
            else {
                viderDefausseCartesInondation();
                cartesInondationPioche.get(cartesInondationPioche.size() -1).getTuile().inondé();
                cartesInondationDefausse.add(cartesInondationPioche.get(cartesInondationPioche.size()-1));
            }
        }
        cartesInondationDefausse.clear();
    }
    
    public void viderDefausseCartesInondation() {
        Collections.shuffle(cartesInondationDefausse);
        for (CInondation c : cartesInondationDefausse){
            cartesInondationPioche.add(c);
            cartesInondationDefausse.remove(c);
        }
    }    
    
    public void piocherCarteJoueur(Aventurier a) {
        for (int i =0 ; i< 2 ; i++) {
            if (cartesJoueurPioche.size() > 0) {
                viderDefausseCartesJoueur();
            }
            if (cartesJoueurPioche.get(cartesJoueurPioche.size()-1).getTypeCarte() != TypeCarte.CMONTEEEAUX) {
                a.addCarteJoueur(cartesJoueurPioche.get(cartesJoueurPioche.size()-1));
                    if (a.getCartes()[5] != null ){
                      Message  m = new Message() ;
                       m.type = TypeAction.DEFAUSSER;
                       m.aventurier = a;
                       notifierObservateurs(m);
                 }
            }
            else {
                etapeEau = etapeEau +1;
                setNiveauEau(etapeEau);
                viderDefausseCartesInondation();
                piocherCarteInondation();
            }
            cartesJoueurDefausse.add(cartesJoueurPioche.get(cartesJoueurPioche.size()-1));
            cartesJoueurPioche.remove(cartesJoueurPioche.size()-1);
                    
           
        }
    }
    
    
    

    //getters et setters
    public Grille getGrille() {
        return g;
    }

    public void setNiveauEau(int niv) {
        etapeEau = niv;
        if (etapeEau <= 2) {
            niveauEau = 2;
        }
        else if (etapeEau > 2 && etapeEau <= 5) {
            niveauEau = 3;
        }
        else if (etapeEau > 5 && etapeEau <=7) {
            niveauEau = 4;
        }
        else if (etapeEau>7 && etapeEau <= 9) {
            niveauEau = 5;
        }
        else {
            niveauEau = 6;
        }
                
    }

    public int getNombreJoueurs() {
        return nbJoueurs;
    }
    
    public void setNombreJoueurs(int nb) {
        nbJoueurs = nb;
    }
}
