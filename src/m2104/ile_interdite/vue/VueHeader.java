/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2104.ile_interdite.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author capelth
 */
public class VueHeader {
    private JFrame window;
    
    
    public VueHeader(){
        
        window = new JFrame();
        JPanel panelprinc = new JPanel(new GridLayout(1,3));
        panelprinc.setBackground(new Color(175, 96, 79));
        window.add(panelprinc);
        
        
        
        
        
        
        
        
        
        
        
        window.setSize(800, 240);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        window.setUndecorated(true);
        window.setVisible(true);
    }
    
    public static void main(String[] args) {
        new VueHeader();
    }
    
}
