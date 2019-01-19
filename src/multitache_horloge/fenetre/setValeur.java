/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitache_horloge.fenetre;

//import multitache_horloge.fenetre.main_fenetre ;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joragasy-dev
 */
public class setValeur extends Thread {
    
    private int seconde = 0 , minute = 0 , heure = 0 ;    
    private String s = "" , m = "" , h = "" ;
    main_fenetre conteneur ;
    public setValeur(main_fenetre conteneur){
        this.conteneur = conteneur ;
    }
    @Override
    public void run(){
        for(;;){
            try {
                SimpleDateFormat secondeVal = new SimpleDateFormat("ss");
                SimpleDateFormat heureVal = new SimpleDateFormat("hh");
                SimpleDateFormat minuteVal = new SimpleDateFormat("mm");
                Calendar calendrier = Calendar.getInstance();
              
                this.seconde =Integer.parseInt(secondeVal.format(calendrier.getTime()));
                this.minute = Integer.parseInt(minuteVal.format(calendrier.getTime()));
                this.heure = Integer.parseInt(heureVal.format(calendrier.getTime()));

                s = formater(this.seconde) ;
                m = formater(this.minute) ;
                h = formater(this.heure) ;
                conteneur.pan.sec.setText(s);
                conteneur.pan.heure.setText(h);
                conteneur.pan.min.setText(m);
                //System.out.println(s);
                Thread.sleep(100);
            } catch (InterruptedException ex) {}
        }
        
    }
    
    private String formater(int chiffre){
        return (chiffre<10) ? "0"+chiffre : chiffre+"" ;
    }
}
