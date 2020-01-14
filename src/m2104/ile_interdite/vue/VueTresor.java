/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2104.ile_interdite.vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import m2104.ile_interdite.modele.*;
import m2104.ile_interdite.util.Parameters;
import m2104.ile_interdite.util.TypeRole;
import java.util.ArrayList;
import javax.swing.JPanel;
import m2104.ile_interdite.util.Message;
import m2104.ile_interdite.util.TypeAction;

/**
 *
 * @author dupuyrem
 */
public class VueTresor extends JPanel {

    // attributs 
    private String urlTresor = "Images/view_tresor.png";
    private JFrame window;
    private IHM ihm;

    // constructeur : 
    public VueTresor(IleInterdite ile) {

        window = new JFrame();

        // parametrage de la fenêtre : 
        window.setContentPane(new PanelFond(urlTresor, 325, 325));
        window.setSize(325, 350);
        this.window.setVisible(true);
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        // déclaration des panels : 
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel panelCentre = new JPanel(new GridLayout(3, 3));

        // gestion de la dimension + opacité du panel du centre :
        panelCentre.setPreferredSize(new Dimension(300, 300));
        panelCentre.setOpaque(false);
        mainPanel.setOpaque(false);

        // boucle principale pour ajouter les images au GridLayout : 
        for (int i = 0; i < 9; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7) {

                // récupération des trésors restants : 
                Tresor nomTresorRestant = ile.getTresor(i);

                // parametre de zoom sur les images de fond des boutons : 
                Image imgTuile;
                imgTuile = Toolkit.getDefaultToolkit().getImage("Images/tresors/" + nomTresorRestant.getNomTresor() + ".png").getScaledInstance(100, 100, 100);

                // création des boutons 
                JButton btn = new JButton(new ImageIcon(imgTuile));
                btn.setPreferredSize(new Dimension(60, 60)); // taille des boutons 

                // gestion de l'opacité des boutons 
                btn.setOpaque(false);
                btn.setContentAreaFilled(false);

                panelCentre.add(btn);

            } else {
                panelCentre.add(new JLabel(" "));
            }
        }

        mainPanel.add(panelCentre, BorderLayout.CENTER);
        window.add(mainPanel);
        
    }
    
    public void afficherVueTresor(){
        
    }
}
