/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2104.ile_interdite.vue;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import m2104.ile_interdite.util.Message;

import javax.swing.ImageIcon;
import m2104.ile_interdite.controleur.Controleur;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;

/**
 *
 * @author Eric
 */
public class  VueInscriptionJoueurs {
    private final JFrame fenetre ;
    private javax.swing.JLabel titre;
    
    private JComboBox<Integer> choixNbJoueurs;
    private JLabel [] labelNomJoueurs = new JLabel[4];
    private JTextField [] saisieNomJoueurs = new JTextField[4];
    private String[] nomJoueurs;
    
    private javax.swing.JLabel niveauEau;
    private JComboBox<Integer> choixNivEau;

    private final JButton btnJouer = new JButton("Jouer");
    
    public VueInscriptionJoueurs() {
        // Creation Fenetre
        fenetre = new JFrame();
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(500, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        fenetre.setLocation(dim.width/2-fenetre.getSize().width/2, dim.height/2-fenetre.getSize().height/2);
        
        
        // Initialisation differente partie fenetre
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new BorderLayout());
        fenetre.add(mainPanel);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        
        
        // Image
        String imgURL = "/users/info/etu-s2/gambiezj/Documents/Projet_Java/Graphe/logojeu.png";
        JLabel logoLabel = new JLabel(new ImageIcon(imgURL));
        topPanel.add(logoLabel, BorderLayout.NORTH);
        
        
        // titre
        /*
        titre = new JLabel();
        titre.setText("Bienvenue sur l'île interdite !");
        topPanel.add(titre, BorderLayout.CENTER);
        */
        
        
        // Inscription joueur
        JPanel CentrePanel = new JPanel(new GridLayout(9,2));
        mainPanel.add(CentrePanel, BorderLayout.CENTER);
        
        CentrePanel.add(new JPanel()); // Une case vide
        CentrePanel.add(new JPanel());
        
        // nombre de joueurs
        choixNbJoueurs = new JComboBox<>(new Integer[] { 2, 3, 4 });
        CentrePanel.add(new JLabel("Nombre de joueurs :"));
        CentrePanel.add(choixNbJoueurs);

        // Saisie des noms de joueurs
        for(int i = 0; i < saisieNomJoueurs.length; i++) {
            saisieNomJoueurs[i] = new JTextField();
            labelNomJoueurs[i] = new JLabel("Nom du joueur No " + (i + 1) + " :");
            CentrePanel.add(labelNomJoueurs[i]);
            CentrePanel.add(saisieNomJoueurs[i]);
            labelNomJoueurs[i].setEnabled(i < 2);
            saisieNomJoueurs[i].setEnabled(i < 2);
        }

        CentrePanel.add(new JPanel()); // Une case vide
        CentrePanel.add(new JPanel());

        mainPanel.add(CentrePanel, BorderLayout.CENTER);
        fenetre.add(mainPanel);

        // Choix du nombre de joueurs
        choixNbJoueurs.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int nb = (Integer) choixNbJoueurs.getSelectedItem();

                for(int i = 0; i < saisieNomJoueurs.length; i++) {
                    labelNomJoueurs[i].setEnabled(i < nb);
                    saisieNomJoueurs[i].setEnabled(i < nb);
                }
            }
        });
        
        
        // Niveau eau
        niveauEau = new javax.swing.JLabel();
        niveauEau.setText("Choisir niveau d'eau :");
        CentrePanel.add(niveauEau);

        String[] nivEau = {"Novice", "Normal", "Elite", "Légendaire"};
        choixNivEau = new JComboBox(nivEau);
        CentrePanel.add(choixNivEau);
        
        CentrePanel.add(new JPanel()); // Une case vide
        CentrePanel.add(new JPanel());
        
        
        // Bouton jouer 
        JPanel footerPanel = new JPanel(new GridBagLayout());
        mainPanel.add(footerPanel, BorderLayout.SOUTH);
        btnJouer.setPreferredSize(new Dimension(75, 30));
        
        btnJouer.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                // Message à envoyer
                // Demarer partie - nb de joueur - nom des joueurs - niveau Eau
                
                fermer();
            }

            @Override public void mousePressed(MouseEvent arg0) {}

            @Override public void mouseReleased(MouseEvent arg0) {}

            @Override public void mouseEntered(MouseEvent arg0) {}

            @Override public void mouseExited(MouseEvent arg0) {}
        });
                
        footerPanel.add(btnJouer);
    }

    public void afficher() {
        this.fenetre.setVisible(true);
    }
    
    public void fermer() {
        this.fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        fenetre.dispose();
    }
    
    public String[] getNomJoueurs() {
        return Arrays.copyOf(this.nomJoueurs, this.nomJoueurs.length);
    }

    public static void main(String [] args) {
        VueInscriptionJoueurs ihm = new VueInscriptionJoueurs();
        ihm.afficher();
   }    
}
