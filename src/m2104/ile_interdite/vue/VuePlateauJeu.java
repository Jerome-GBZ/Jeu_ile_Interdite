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

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import patterns.observateur.Observateur;
import patterns.observateur.Observable;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import m2104.ile_interdite.util.TypeAction;
/**
 *
 * @author gambiezj
 */
public class VuePlateauJeu extends JPanel{


   
  Image img = Toolkit.getDefaultToolkit().getImage("/users/info/etu-s2/gambiezj/Documents/Projet_Java/Graphe/eau.png");
  public VuePlateauJeu() throws IOException {
        this.setContentPanel(new JPanel() {
         @Override
         public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, null);
         }
      });
     
      setVisible(true);
   }
  
  
  
   public static void main(String[] args) throws Exception {
      new VuePlateauJeu();
   }

    private void setContentPanel(JPanel jPanel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

}
