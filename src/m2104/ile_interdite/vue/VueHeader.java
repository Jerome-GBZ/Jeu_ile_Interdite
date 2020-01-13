/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2104.ile_interdite.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author capelth
 */
public class VueHeader {
    private JFrame window;
    
    
    public VueHeader(){
        
        window = new JFrame();
        
        
        
        
        
        
        
        window.setSize(1000, 270);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        window.setUndecorated(true);
        window.setBackground(Color.yellow);
        window.setVisible(true);
    }
    
    public static void main(String[] args) {
        new VueHeader();
    }
    
}
