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
import m2104.ile_interdite.util.TypeRole;

/**
 *
 * @author capelth
 */
public class VueCarteAventurier {
    
    private JFrame window;
    private String nomJoueur;
    private BufferedImage image;
    
    public VueCarteAventurier(String nomJ, TypeRole r){
        
        window = new JFrame();
        window.setSize(150, 210);
        
        window.add(new JLabel(new ImageIcon("Images/personnages/explorateur.png")));
        
        window.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new VueCarteAventurier("test", TypeRole.Explorateur);
    }
}