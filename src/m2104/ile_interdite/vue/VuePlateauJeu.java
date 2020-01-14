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

public class VuePlateauJeu extends JPanel {
    
    private String urlImgs = "/users/info/etu-s2/gambiezj/Documents/Projet_Java/Graphe/final_View.png";
    private JFrame fenetre;
    
    public VuePlateauJeu(Grille g) {
System.out.println("VuePlateau 1 ");
        fenetre = new JFrame();
        fenetre.setContentPane(new PanelFond(urlImgs, 800, 700));
        fenetre.setSize(800, 700);
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // fenetre.setUndecorated(Parameters.UNDECORATED);
        // fenetre.setResizable(Parameters.RESIZABLE);
System.out.println("VuePlateau 2 ");
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel centrePanel = new JPanel(new GridLayout(6, 6));
        centrePanel.setPreferredSize(new Dimension(750, 650));
        centrePanel.setOpaque(false);
        mainPanel.setOpaque(false);
System.out.println("VuePlateau 3 ");
        for (int i = 1; i <= 36; i++) {
            if ((i < 3) || (i > 4 && i < 8) || (i == 12) || (i == 25) || (i > 29 && i < 33) || (i > 34)) {
                JLabel label = new JLabel("", SwingConstants.CENTER);
                centrePanel.add(label);
            } else {
                // donc envoyer 36 tuile avec les null
                //for (int j = 0; j < g.getNomTuiles().size(); j++) {
                    // redimentionne la tuile
                    String nomTuile = g.getNomTuiles().get(i);
                    Image imgTuile;
                    System.out.println("nom tuile : " + nomTuile);
                    imgTuile = Toolkit.getDefaultToolkit().getImage("Images/tuiles/" + nomTuile + ".png").getScaledInstance(120, 100, 120);
                    JButton btn = new JButton(new ImageIcon(imgTuile));
                    
                    // btn.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
                    btn.setPreferredSize(new Dimension(85, 85));
                    btn.setOpaque(false);
                    btn.setContentAreaFilled(false);
                
                    centrePanel.add(btn);
                //}
            }
        }
System.out.println("VuePlateau 4 ");
        mainPanel.add(centrePanel, BorderLayout.CENTER);
        fenetre.add(mainPanel);
    }
    
    public void afficher() {
        this.fenetre.setVisible(true);
    }
}
