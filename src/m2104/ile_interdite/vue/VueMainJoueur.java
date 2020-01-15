/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2104.ile_interdite.vue;

import java.awt.*;
import javax.swing.*;
import m2104.ile_interdite.modele.*;
import m2104.ile_interdite.util.*;
import java.util.ArrayList;

public class VueMainJoueur {
    private String urlImgs = "Images/VueMainJoueur.png";
    private JFrame fenetre;

    private JPanel mainPanel;
    private JPanel centrePanel;
    
    public VueMainJoueur() {
        initialiserFenetreMain();
        initialisationCarteMain();
    }

    public void initialiserFenetreMain() {
        fenetre = new JFrame();
        fenetre.setContentPane(new PanelFond(urlImgs, 952, 130));
        fenetre.setSize(952, 130);
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        fenetre.setUndecorated(Parameters.UNDECORATED);
        fenetre.setResizable(Parameters.RESIZABLE);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);

        centrePanel = new JPanel(new GridLayout(6, 6));
        centrePanel.setPreferredSize(new Dimension(952, 130));
        centrePanel.setOpaque(false);
        
        mainPanel.add(centrePanel, BorderLayout.CENTER);
        fenetre.add(mainPanel);
    }
    
    public void initialisationCarteMain(){
    
    }
    
    public void afficher() {
        this.fenetre.setVisible(true);
    }
}
