/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitache_horloge.fenetre;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author joragasy-dev
 */
public class reveil_regalge extends JPanel{
    public affichetexte heure = new affichetexte("heure");
    public affichetexte min = new affichetexte("min");
    public affichetexte sec = new affichetexte("sec");
    public affichetexte sonnerie = new affichetexte("sonnerie");

    JPanel panneau1 = new JPanel(new FlowLayout()) ;
    
    JComboBox Heure = new JComboBox();
    JComboBox minute = new JComboBox();
    JComboBox seconde = new JComboBox();
    
    JButton  valider = new JButton("valider");
    JButton  desactiver = new JButton("desactiver");

    JComboBox musique = new JComboBox();
    Dimension dim =new Dimension(200,20);
    
    main_fenetre conteneur ;
    public reveil_regalge(main_fenetre conteneur){
        super();
        this.conteneur = conteneur;
        seconde.setSize(dim);
        for(int i = 0 ; i < 60 ; i++) {
            seconde.addItem(i);
            minute.addItem(i);
            if(i<24) Heure.addItem(i);
        }
        musique.addItem("hello.wav");
        musique.addItem("mijery.wav");
        this.setLayout(null);
        panneau1.add(heure);
        panneau1.add(Heure);
        panneau1.add(min);
        panneau1.add(minute);
        panneau1.add(sec);
        panneau1.add(seconde) ;
        panneau1.add(sonnerie);
        panneau1.add(musique);
        panneau1.add(valider);
        panneau1.add(desactiver);
        this.add(panneau1);
        panneau1.setBounds(0,0,500,300);
        EcouteAction();
    }
    
    void EcouteAction(){
        this.valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activerReveil(1);
            }
        });
        
        this.desactiver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activerReveil(0);
            }
        });
    }
    
    void activerReveil(int flag){ //flag definit si le reveil va s activer ou se desactiver
        String message = "" ;
        if(flag==1){
            message = "reveil activé" ;
            this.conteneur.flagReveil = true ;
        } else 
            this.conteneur.flagReveil = false ;
        this.conteneur.pan.notification.setText(message);
        
    }
    
}
