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
import m2104.ile_interdite.util.*;
import java.util.ArrayList;

public class VuePlateauJeu extends JPanel {

    private String urlImgs = "Images/final_Jeu.png";
    private JFrame fenetre;

    JPanel mainPanel;
    JPanel centrePanel;
    JPanel centrePionsPanel;
    private ArrayList<Aventurier> aventuriers;
    private ArrayList<Tuile> ArrTuiles = new ArrayList<>();
    private ArrayList<String> nomTuiles = new ArrayList<>();

    public VuePlateauJeu(Grille g) {

        this.nomTuiles = g.getListnomsTuiles();
        this.aventuriers = g.getIleInterdite().getAventuriers();
        initialiserFenetreJeu();
        intitialiserPlateauJeu(g);
        
    }

    public void initialiserFenetreJeu() {
        fenetre = new JFrame();
        fenetre.setContentPane(new PanelFond(urlImgs, 800, 700));
        fenetre.setSize(800, 700);
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // fenetre.setUndecorated(Parameters.UNDECORATED);
        // fenetre.setResizable(Parameters.RESIZABLE);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);
        
        centrePanel = new JPanel(new GridLayout(6, 6));
        centrePanel.setPreferredSize(new Dimension(750, 650));
        centrePanel.setOpaque(false);
        
        centrePionsPanel = new JPanel(new BorderLayout());
        
        mainPanel.add(centrePanel, BorderLayout.CENTER);
        fenetre.add(mainPanel);
    }

    public void intitialiserPlateauJeu(Grille g) {
        JButton btn = new JButton();
        Image imgTuile;
        String nomTuile;
        
        for (int i = 0; i < 36; i++) {

            if ((i < 2) || (i > 3 && i < 7) || (i == 11) || (i == 24) || (i > 28 && i < 32) || (i > 33)) {
                JLabel label = new JLabel("", SwingConstants.CENTER);
                centrePanel.add(label);
            } else {
                // redimentionne la tuile
                nomTuile = nomTuiles.get(i);
                
                imgTuile = Toolkit.getDefaultToolkit().getImage("Images/tuiles/" + nomTuile + ".png").getScaledInstance(120, 100, 120);
                btn = new JButton(new ImageIcon(imgTuile));
                btn.setPreferredSize(new Dimension(85, 85));
                btn.setOpaque(false);
                btn.setContentAreaFilled(false);

                centrePanel.add(btn);
                
                dessinerPion(g,i);
            }
        }
        btn.add(centrePionsPanel);
    }

    public int[] calculeCoordonneeTuile(Grille g) {
        int x, y = 0;
        int i = 1;
        int[] c = {};

        Tuile tuile;

        for (Aventurier a : aventuriers) {
            tuile = a.getTuile();

            x = g.getCoordonnee(tuile)[0];
            System.out.println("x =  " + x);
            y = g.getCoordonnee(tuile)[1];
            System.out.println("y =  " + y);

            // calcule numéro de la case 
            c[i] = (x + 1) + (y * 6);
            i++;
        }
        return c;
    }

    public TypePion tuileDispo(int numTuile, int[] c) {

        for (int i = 0; i < c.length; i++) {
            if (numTuile == c[i]) {
                return aventuriers.get(i).getPion();
            }
        }
        return TypePion.Null;
    }

    public void dessinerPion(Grille g, int numTuile) {

        JLabel pionLabel = new JLabel();
        Image imgPion;

        int[] c = calculeCoordonneeTuile(g);
        TypePion typeP = tuileDispo(numTuile, c);

        if (typeP != TypePion.Null) {
            for (int i = 0; i <= numTuile; i++) {
                // on va boucler
                if (numTuile == i) {
                    String imgURL = "Images/pions/" + this.aventuriers.get(i).getPion().name() + ".png";
                    imgPion = Toolkit.getDefaultToolkit().getImage(imgURL).getScaledInstance(50, 80, 50);
                    pionLabel = new JLabel(new ImageIcon(imgPion));
                    pionLabel.setPreferredSize(new Dimension(50, 50));
                    pionLabel.setOpaque(false);
                    
                    centrePionsPanel.add(pionLabel);
                }
            }
        }
    }

    public void afficher() {
        this.fenetre.setVisible(true);
    }
    /*
    public JLabel pion(ArrayList<Aventurier> aventuriers, Grille g) {
        int x = 0;
        int y = 0;
        JLabel pionLabel = new JLabel("ERREUR");

        for (Aventurier a : aventuriers) {

            TypePion pion = a.getPion();
            Tuile tuile = a.getTuile();

            String imgURL = "Images/pions/" + a.getPion() + ".png";

            Image imgPion;
            imgPion = Toolkit.getDefaultToolkit().getImage(imgURL).getScaledInstance(50, 80, 50);
            pionLabel = new JLabel(new ImageIcon(imgPion));
            pionLabel.setPreferredSize(new Dimension(50, 50));
            pionLabel.setOpaque(false);

            x = g.getCoordonnee(tuile)[0];
            System.out.println("x =  " + x);
            y = g.getCoordonnee(tuile)[1];
            System.out.println("y =  " + y);

            for (int i=0; i<6; i++) {
                for (int j=0; j<6; j++) {
                    if (i==x && j==y) {
                        
                        
                    }
                }
            }
        }
        return pionLabel;
    } 
     */
}
