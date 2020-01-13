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
import m2104.ile_interdite.util.Parameters;
import m2104.ile_interdite.util.TypeRole;

public class VuePlateauJeu extends JPanel {

    private String urlImgs = "/users/info/etu-s2/gambiezj/Documents/Projet_Java/Graphe/final_View.png";
    private JFrame fenetre;

    public VuePlateauJeu() {
        fenetre = new JFrame();
        fenetre.setContentPane(new PanelFond(urlImgs, 800, 700));
        fenetre.setSize(800, 700);
        // fenetre.setUndecorated(Parameters.UNDECORATED);
        // fenetre.setResizable(Parameters.RESIZABLE);

        JPanel mainPanel = new JPanel(new GridLayout(6, 6));
        fenetre.add(mainPanel);

    }

    public void afficher() {
        this.fenetre.setVisible(true);
    }

    public static void main(String[] args) {
        VuePlateauJeu ihm = new VuePlateauJeu();
        ihm.afficher();
    }

}
