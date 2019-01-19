/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitache_horloge.fenetre;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javax.swing.* ;
/**
 *
 * @author joragasy-dev
 */
public class main_fenetre extends JFrame{
    //instance des JPanels
    public panneau pan = new panneau();
    public reveil_regalge reveilReg = new reveil_regalge(this);
    //fin
    //instance des Threads
    public setValeur settemps = new setValeur(this);
    public reveilChecker Rcheker = new reveilChecker(this);
    public JouerSon jouerson = new JouerSon();
    //fin
    
    //Boite de dialogue
    JOptionPane  eteindre = new JOptionPane();
    //Fin
    
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fichier = new JMenu("fichier");
    private JMenu horloge = new JMenu("Horloge");
    private JMenu reveil = new JMenu("Reveil");
    
    private JMenuItem fermer = new JMenuItem("Fermer");
    private JMenuItem reglage = new JMenuItem("réglage reveil");
    private JMenuItem ConsulterHorloge = new JMenuItem("Consulter Horloge");
    
    public boolean flagReveilAlarmee = false ;
    public boolean flagReveil = false ;
    
    
    public main_fenetre(String Title){
        this.menubar();
        //demarrage des threads
        settemps.start();
        Rcheker.start();
        //fin
        //configuration du contener
        this.setTitle(Title);
        this.setSize(500, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pan);
        this.setVisible(true) ;
        //fin
                
    }
    
    public void menubar(){
        //configuration du menuBar
        this.fichier.add(this.fermer);
        this.reveil.add(this.reglage);
        this.horloge.add(this.ConsulterHorloge);
        this.menuBar.add(this.fichier);
        this.menuBar.add(this.horloge);
        this.menuBar.add(this.reveil);
        this.setJMenuBar(menuBar);
        //Fin
        //ecoute des evennement sur les menuBars
        this.fermer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }   
            });
        this.reglage.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 reglage();
            }
        });
        
        this.ConsulterHorloge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                horloge();
            }
        });
        //Fin
        this.setVisible(true);
    }
    
    public void reglage(){
        this.remove(pan);
        this.setContentPane(reveilReg);
        this.setVisible(true);
    }
    
    public void horloge(){
        this.remove(reveilReg);
        this.setContentPane(pan);
        this.setVisible(true);
        
    }
    
    
}
