/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitache_horloge.fenetre;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author joragasy-dev
 */
public class reveilChecker extends Thread{
    main_fenetre conteneur ;
    int compt = 0 , f = 0 ;
    int option ;
    public reveilChecker(main_fenetre conteneur){
        this.conteneur = conteneur ;
    }
    
    @Override 
    public void run(){
        for(;;){
            if(this.conteneur.flagReveil == true){
                int heureReveil = Integer.parseInt(this.conteneur.reveilReg.Heure.getSelectedItem().toString());
                int minuteReveil = Integer.parseInt(this.conteneur.reveilReg.minute.getSelectedItem().toString());
                int secondeReveil = Integer.parseInt(this.conteneur.reveilReg.seconde.getSelectedItem().toString());
                
                int heureNow = Integer.parseInt(this.conteneur.pan.heure.getText()) ;
                int minuteNow = Integer.parseInt(this.conteneur.pan.min.getText()) ;
                int secondeNow = Integer.parseInt(this.conteneur.pan.sec.getText()) ;
                
                heureReveil = (heureReveil<=12) ? heureReveil : heureReveil - 12 ;
                if(heureReveil == heureNow && minuteReveil == minuteNow && secondeReveil == secondeNow ){
                     this.conteneur.pan.notification.setText("reveil alarmé");
                     this.conteneur.flagReveilAlarmee = true ;    
                     if(compt>0){
                       this.conteneur.jouerson.start();
                       //this.conteneur.eteindre.showMessageDialog(this.conteneur, "Appuyer sur OK pour Eteindre");
                       option = this.conteneur.eteindre.showConfirmDialog(this.conteneur,"Voulez-vous lancer l'animation ?", 
                                                                           "Lancement de l'animation", 
                                                                           JOptionPane.YES_NO_OPTION, 
                                                                           JOptionPane.QUESTION_MESSAGE);
                     }
                     
                     
                     compt++ ;
                }
                
                if(option == JOptionPane.OK_OPTION  && f == 0){
       
                         this.conteneur.pan.notification.setText("");
                         System.out.println(option);
                         f = 1 ;
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) { }
        }
    }
    
}
