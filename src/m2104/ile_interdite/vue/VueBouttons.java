/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2104.ile_interdite.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import m2104.ile_interdite.util.Parameters;

/**
 *
 * @author gambiezj
 */
public class VueBouttons {
    
    private JPanel mainPanel;
    private JPanel centrePanel;
    private String urlImgs = "Images/final_Jeu.png";
    private JFrame fenetre;
    private JButton btnAller;
    private JButton btnAssecher;
    private JButton btnDonner;
    private JButton btnPrendre;
    private JButton btnDeplacer;
    private JButton btnTerminer;
    
    public VueBouttons() {
    }
    
    public void initialiserFenetreJeu() {
        fenetre = new JFrame();
        fenetre.setContentPane(new PanelFond(urlImgs, 152, 152));
        fenetre.setSize(152, 159);
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        fenetre.setUndecorated(Parameters.UNDECORATED);
        fenetre.setResizable(Parameters.RESIZABLE);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);

        centrePanel = new JPanel(new GridLayout(6, 6));
        centrePanel.setPreferredSize(new Dimension(750, 650));
        centrePanel.setOpaque(false);
        
        mainPanel.add(centrePanel, BorderLayout.CENTER);
        fenetre.add(mainPanel);
    }
}
