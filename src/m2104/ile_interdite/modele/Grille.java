/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2104.ile_interdite.modele;
import java.util.ArrayList;
import m2104.ile_interdite.util.*;
/**
 *
 * @author capelth
 */
public class Grille {
    
    private Tuile[][] tuiles;
    
    public Grille(ArrayList<Tuile> tuiles){
        this.tuiles = new Tuile[6][6];
        this.tuiles[0][2] = tuiles.get(0);
        this.tuiles[0][3] = tuiles.get(1);
        this.tuiles[1][1] = tuiles.get(2);
        this.tuiles[1][2] = tuiles.get(3);
        this.tuiles[1][3] = tuiles.get(4);
        this.tuiles[1][4] = tuiles.get(5);
        this.tuiles[2][0] = tuiles.get(6);
        this.tuiles[2][1] = tuiles.get(7);
        this.tuiles[2][2] = tuiles.get(8);
        this.tuiles[2][3] = tuiles.get(9);
        this.tuiles[2][4] = tuiles.get(10);
        this.tuiles[2][5] = tuiles.get(11);
        this.tuiles[3][0] = tuiles.get(12);
        this.tuiles[3][1] = tuiles.get(13);
        this.tuiles[3][2] = tuiles.get(14);
        this.tuiles[3][3] = tuiles.get(15);
        this.tuiles[3][4] = tuiles.get(16);
        this.tuiles[3][5] = tuiles.get(17);
        this.tuiles[4][1] = tuiles.get(18);
        this.tuiles[4][2] = tuiles.get(19);
        this.tuiles[4][3] = tuiles.get(20);
        this.tuiles[4][4] = tuiles.get(21);
        this.tuiles[5][2] = tuiles.get(22);
        this.tuiles[5][3] = tuiles.get(23);
        
    }
    
    
    public ArrayList<Tuile> tuileAutour(Tuile t){
        ArrayList<Tuile> tuilesAutour = new ArrayList<>();
        int[] c = new int[2];
        c = this.getCoordonnee(t);
        int i = c[0];
        int j = c[1];
        
        if(i != 0 && tuiles[i-1][j] != null){
            tuilesAutour.add(tuiles[i-1][j]);
        }
        if(i != 5 && tuiles[i+1][j] != null){
            tuilesAutour.add(tuiles[i+1][j]);
        }
        if(j != 0 && tuiles[i][j-1] != null){
            tuilesAutour.add(tuiles[i][j-1]);
        }
        if(j != 5 && tuiles[i][j+1] != null){
            tuilesAutour.add(tuiles[i][j+1]);
        }
        return tuilesAutour;
    }
    
    public ArrayList<Tuile> tuilesDispoDeplacer (Tuile t, Aventurier a){
        ArrayList<Tuile> tuilesDispo = tuileAutour(t);
        int[] c = new int[2];
        c = this.getCoordonnee(t);
        int i = c[0];
        int j = c[1];
        if (a.getRole() == TypeRole.Explorateur){
        if (i != 0 ) {
            if (j != 0 && tuiles[i-1][j-1] != null) {
                tuilesDispo.add(tuiles[i-1][j-1]);
            }
            if (j != 5 && tuiles[i-1][j+1] != null) {
                tuilesDispo.add(tuiles[i-1][j+1]);
            }
        }
        if (i != 5 ){
          if (j != 0 && tuiles[i+1][j-1] != null) {
                tuilesDispo.add(tuiles[i+1][j-1]);
            }
            if (j != 5 && tuiles[i+1][j+1] != null) {
                tuilesDispo.add(tuiles[i+1][j+1]);
            }  
        }
        }
        if (a.getRole() == TypeRole.Pilote && a.getPouvoirUtilise() == false){
            tuilesDispo.clear();
            for (int x = 0; x < tuiles.length;x++){
                for (int y = 0; y < tuiles.length;y++){
                    if (tuiles[x][y] != null){
                        tuilesDispo.add(tuiles[x][y]);
                    }
                }
            }
        }
        if (a.getRole() == TypeRole.Plongeur) {
            for (Tuile tu : tuilesDispo) {
                if (tu.getEtat() != TypeEtat.SEC) {
                    for (Tuile tui : this.tuileAutour(tu)){
                        tuilesDispo.add(tui);
                    }
                }
            }
        
        }
        for (Tuile tu : tuilesDispo) {
            if (tu.getEtat() == TypeEtat.COULE){
                tuilesDispo.remove(tu);
            }
        }
               
        return tuilesDispo;
    }
    
    public int[] getCoordonnee(Tuile t){
        int[] c = new int[2];
        int i = 0;
        int j = 0;
        while(tuiles[i][j] != t && i<tuiles.length){
            j = 0;
            while(tuiles[i][j] != t && j<tuiles[i].length){
                j++;
            }
            i++;
        }
        c[0] = i;
        c[1] = j;
        return c;
    }
    
    public ArrayList<Tuile> tuilesDisposAssecher(Tuile t, Aventurier a){
        ArrayList<Tuile> tuilesDispo = tuileAutour(t);
        int[] c = new int[2];
        c = this.getCoordonnee(t);
        int i = c[0];
        int j = c[1];
        if (a.getRole() == TypeRole.Explorateur){
        if (i != 0 ) {
            if (j != 0 && tuiles[i-1][j-1] != null) {
                tuilesDispo.add(tuiles[i-1][j-1]);
            }
            if (j != 5 && tuiles[i-1][j+1] != null) {
                tuilesDispo.add(tuiles[i-1][j+1]);
            }
        }
        if (i != 5 ){
          if (j != 0 && tuiles[i+1][j-1] != null) {
                tuilesDispo.add(tuiles[i+1][j-1]);
            }
            if (j != 5 && tuiles[i+1][j+1] != null) {
                tuilesDispo.add(tuiles[i+1][j+1]);
            }  
        }
        }
        for (Tuile tu : tuilesDispo) {
            if (tu.getEtat() != TypeEtat.INNONDE){
                tuilesDispo.remove(tu);
            }
        }
        return tuilesDispo;
    }
    
    public void assecher(Tuile t){
        t.assecher();
    }
    
    public void innonde(CInondation ci){
        ci.getTuile().inondé();
    }
            
    /**
     * @return the tuiles
     */
    public Tuile[][] getTuiles() {
        return tuiles;
    }

    /**
     * @param tuiles the tuiles to set
     */
    public void setTuiles(Tuile[][] tuiles) {
        this.tuiles = tuiles;
    }
    
    public ArrayList<String> getNomTuiles() {
        ArrayList<String> nomTuiles = new ArrayList<>();
        for (int i = 0 ; i < 6 ; i++){
            for (int j = 0; j<6;j++){
                if (tuiles[i][j] != null) {
                    nomTuiles.add(tuiles[i][j].getNomTuile());
                }
            }
        }
        return nomTuiles;
    }
    
}
