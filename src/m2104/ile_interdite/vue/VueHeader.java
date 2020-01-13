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
import javax.swing.JLabel;
import javax.swing.JPanel;
import m2104.ile_interdite.util.TypeRole;

/**
 *
 * @author capelth
 */
public class VueHeader {
    private JFrame window;
    private VueCarteAventurier j1;
    private VueCarteAventurier j2;
    private VueCarteAventurier j3;
    private VueCarteAventurier j4;
    
    public VueHeader(){
        
        window = new JFrame();
        JPanel panelprinc = new JPanel(new GridLayout(1,3));
        panelprinc.setOpaque(false);
        panelprinc.setSize(800, 240);
        
        window.setContentPane(new PanelFond("Images/VueHeader.png"));
        
        j1 = new VueCarteAventurier("Romain", TypeRole.Ingenieur);
        j2 = new VueCarteAventurier("Rémy", TypeRole.Messager);
        
        for(int i=0; i<3; i++){
            if(i==0){
                panelprinc.add(j1);
            }else if(i==2){
                panelprinc.add(j2);
            }else{
                JLabel temp = new JLabel(" ");
                panelprinc.add(temp);
            }
        }
        
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
