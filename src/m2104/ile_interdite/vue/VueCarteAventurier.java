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
    private Graphics g;
    
    public VueCarteAventurier(String nomJ, TypeRole r){
        
       // window = new JFrame();
       // window.setSize(150, 210);
        
        
        //paintComponent(g,r);
        ImageOverLabel demo = new ImageOverLabel();
        demo.pack();
        demo.setSize(150, 210);
        //demo.setUndecorated(true);
        demo.setVisible(true);
        //window.add(new JLabel("test"));
        
        //window.setUndecorated(true);
        //window.setVisible(true);
        
    }
    
    protected void paintComponent(Graphics g, TypeRole r){
            if(r == TypeRole.Explorateur){
                ImageIcon image_back = new ImageIcon(getClass().getResource("Images/personnages/explorateur.png"));
                g.drawImage(image_back.getImage(), 0, 0, window.getWidth(), window.getHeight(),window);
            }else if(r == TypeRole.Ingenieur){
                window.add(new JLabel(new ImageIcon("Images/personnages/ingenieur.png")));
            }else if(r == TypeRole.Messager){
                window.add(new JLabel(new ImageIcon("Images/personnages/messager.png")));
            }else if(r == TypeRole.Navigateur){
                window.add(new JLabel(new ImageIcon("Images/personnages/navigateur.png")));
            }else if(r == TypeRole.Pilote){
                window.add(new JLabel(new ImageIcon("Images/personnages/pilote.png")));
            }else if(r == TypeRole.Plongeur){
                window.add(new JLabel(new ImageIcon("Images/personnages/plongeur.png")));
            }
        }
    
    public static void main(String[] args) {
        new VueCarteAventurier("test", TypeRole.Explorateur);
    }
}