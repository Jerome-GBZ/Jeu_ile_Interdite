/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2104.ile_interdite.vue;
import java.awt.*;
import javax.swing.*;
import m2104.ile_interdite.util.TypeRole;

/**
 *
 * @author capelth
 */
public class VueCarteAventurier extends JLabel {
    
    private JFrame window;
    private String nomJoueur;
    
    public VueCarteAventurier(String nomJ, TypeRole r){
        
        window = new JFrame();
        window.setContentPane(new PanelFond(r));
        
        JPanel panelprincip = new JPanel(new BorderLayout());
        panelprincip.setOpaque(false);
        window.add(panelprincip);
        
        JPanel footer = new JPanel(new GridLayout(13,3));
        footer.setOpaque(false);
        for(int i=0; i<39; i++){
            if(i==37){
                JLabel nom = new JLabel(nomJ);
                nom.setForeground(Color.WHITE);
                nom.setSize(100, 100);

                footer.add(nom);
            }else{
                JLabel temp = new JLabel(" ");
                footer.add(temp);
            }
        }
        
        panelprincip.add(footer);
        
        

        
        

        
        
        window.setSize(150, 210);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        window.setUndecorated(true);
        window.setVisible(true);
   
    }
    
    /*public static void main(String[] args) {
        new VueCarteAventurier("Romain", TypeRole.Ingenieur);
    }*/
}