/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2104.ile_interdite.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import m2104.ile_interdite.util.Message;
import m2104.ile_interdite.util.Parameters;
import m2104.ile_interdite.util.TypeAction;
import m2104.ile_interdite.util.Utils;

/**
 *
 * @author pommatar
 */
public class VueFermeture {
        
    //private final IHM ihm;
    private String urlImgs = "Images/texture.png";
    private JFrame fenetre;
    private JButton fermer;
    private IHM ihm;

    
    public VueFermeture(IHM ihm) {
        initialiserFenetreBouton();
        this.ihm = ihm;
    }
    
    public void initialiserFenetreBouton() {
        fenetre = new JFrame();
        fenetre.setContentPane(new PanelFond(urlImgs, 32, 32));
        fenetre.setSize(30, 30);
        
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int dimX = 800+ dim.width / 3 - fenetre.getSize().width +30;
        
        
        fenetre.setLocation(dimX, 0);
        
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        fenetre.setUndecorated(Parameters.UNDECORATED);
        fenetre.setResizable(Parameters.RESIZABLE);
      
        
        
        JLabel text = new JLabel("X");
        text.setForeground(Color.WHITE);
        JButton fermer = new JButton();
        fermer.add(text);
        fermer.setForeground(Color.RED);
        fermer.setOpaque(false);
        fermer.setEnabled(false);

        fermer.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                fenetre.dispose();
                ihm.FermertousVue();
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
            }
        });
        fermer.setBorderPainted(false);
        fenetre.add(fermer, BorderLayout.CENTER);
        fenetre.setVisible(true);
    }

    /*public static void main(String[] args) {
        new VueFermeture();
    }*/
    
    
}
