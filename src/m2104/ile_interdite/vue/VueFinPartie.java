/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2104.ile_interdite.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import m2104.ile_interdite.util.Main;
import m2104.ile_interdite.util.Parameters;

/**
 *
 * @author gambiezj
 */
public class VueFinPartie {
    
    private JFrame fenetre;
    private JPanel mainPanel;
    private JPanel centrePanel;
    
    public VueFinPartie(boolean gagne) {
        initialiserFenetreFin(gagne);
    }

    public void initialiserFenetreFin(boolean isGagne) {
        fenetre = new JFrame();
        fenetre.setSize(300, 150);
        
        // Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // int dimX = 0 + dim.width / 3 - 152;
        // int dimY = 0 + dim.height / 3 - fenetre.getSize().height / 2 - 161;
        // int dimY = 124;
        // fenetre.setLocation(dimX, dimY);
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        fenetre.setUndecorated(Parameters.UNDECORATED);
        fenetre.setResizable(Parameters.RESIZABLE);

        mainPanel = new JPanel(new GridLayout(4, 3));
        mainPanel.setOpaque(false);

        JLabel gagne = new JLabel();
        if (isGagne) {
            gagne.setText("Vous avez gagné");
        } else {
            gagne.setText("Vous avez perdu");
        }
        
        JLabel rejoue = new JLabel("Voulez-vous rejouer ?");
        
        JButton oui = new JButton("Oui");
        JButton non = new JButton("Non");
        
        oui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new Main();
            }
        });
        
        non.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        
        mainPanel.add(new JLabel(""));
        mainPanel.add(gagne);
        mainPanel.add(new JLabel(""));
        mainPanel.add(new JLabel(""));
        mainPanel.add(rejoue);
        mainPanel.add(new JLabel(""));
        mainPanel.add(oui);
        mainPanel.add(new JLabel(""));
        mainPanel.add(non);
                
        fenetre.add(mainPanel);
    }
}
