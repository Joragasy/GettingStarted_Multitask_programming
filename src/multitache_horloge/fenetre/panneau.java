/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitache_horloge.fenetre;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Menu;
import  javax.swing.* ;
/**
 *
 * @author joragasy-dev
 */
public class panneau extends JPanel{
    private int seconde = 0  ;
    public AfficheTexte heure = new AfficheTexte("00");
    public AfficheTexte separation1 = new AfficheTexte(":");
    public AfficheTexte min = new AfficheTexte("00");
    public AfficheTexte separation2 = new AfficheTexte(":");
    public AfficheTexte sec = new AfficheTexte("00") ;
    public affichetexte notification = new affichetexte("");
    JPanel panneau1 = new JPanel(new FlowLayout()) ;
    public panneau() {
        super();
        this.setLayout(null);
        
        panneau1.add(heure);
        panneau1.add(separation1);
        panneau1.add(min);
        panneau1.add(separation2);
        panneau1.add(sec);
        panneau1.add(notification);
        this.add(panneau1);
        panneau1.setBounds(0,0,500,300);
        
    }
      
    
}
