/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitache_horloge.fenetre;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author joragasy-dev
 */
public class AfficheTexte extends JLabel {
    private final Font police = new Font( "DS-digital", Font. BOLD, 60) ;
    public AfficheTexte(String texte){
        super(texte);
        this.setForeground( Color.darkGray) ;
        this.setHorizontalAlignment( JLabel. CENTER) ;
        this.setVerticalAlignment(JLabel.CENTER);
        this.setFont(police);
    }
    
}
