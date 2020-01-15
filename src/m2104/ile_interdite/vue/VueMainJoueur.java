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

/**
 *
 * @author dupuyrem 
 */

public class VueMainJoueur {
    private String urlImgs = "Images/VueMainJoueur.png";
    private JFrame window;

    private JPanel mainPanel;
    private JPanel panelCentre;
    
    public VueMainJoueur() {
        initialiserFenetreMain();
        
    }

    public void initialiserFenetreMain() {
        
        // paramètres de la fenetre : 
        window = new JFrame();
        window.setContentPane(new PanelFond(urlImgs, 952, 130));
        window.setSize(952, 130);
        window.setLocation(0, 800);
        
        
     window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
     //   window.setUndecorated(Parameters.UNDECORATED);
    //    window.setResizable(Parameters.RESIZABLE);

        // Partie IHM : 
        
        // panel principal 
        mainPanel = new JPanel(new GridLayout(1, 3));
        mainPanel.setOpaque(false);
        
        // panel du centre : 
        panelCentre = new JPanel(new GridLayout(1, 2));
        panelCentre.setPreferredSize(new Dimension(952, 130));
        panelCentre.setOpaque(false);
        
        mainPanel.add(panelCentre, BorderLayout.CENTER);
        window.add(mainPanel);
        
        // boucle du GridLayout du centre :  
        for(int i = 0; i < 2; i++ ){
            
            // récupération 
            
            
            panelCentre.add(new JButton("bidule")); 
            
            
        }
        
        
        
        
        
        
        
        
    }
    
   
    public void afficher() {
        this.window.setVisible(true);
    }
    
   
    
    
}
