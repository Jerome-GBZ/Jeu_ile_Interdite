/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2104.ile_interdite.vue;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author capelth
 */
public class ImageOverLabel extends JFrame{

    public ImageOverLabel() {
        super("Démo d'image sur Label");
        initialize();
    }

    private void initialize() {
        Container c = getContentPane();
        JLabel label = new JLabel();
        label.setBackground(Color.BLUE);
        ImageIcon image = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Images/personnages/explorateur.png"));
        label.setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
        label.setIcon(image);
        c.add(label);
        
    }


}
