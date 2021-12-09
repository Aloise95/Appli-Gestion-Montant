/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author benoit
 */

import java.text.SimpleDateFormat;
import java.util.Date; 
import java.text.DateFormat;


/*public class Depot {
    String nom;
    int montant;
    //Date addDate;
    String testDate;
    //SimpleDateFormat date =null;
    DateFormat shortDateFormat = null;

    public Depot(String nom,  int montant, String testDate) {
        this.montant = montant;
        this.nom = nom;
        Date addDate = new Date();
        shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
        testDate = shortDateFormat.format(addDate);
       // date = new SimpleDateFormat("dd-MM-yyyy");
    }
    
    public String toString() {
        return nom +" (depot: " + montant + " euros)le "+testDate+"\n";
    }
}*/

public class Depot {
    String nom;
    int montant;
    String testDate;

    public Depot(String nom,  int montant, String testDate) {
        this.nom = nom;
        this.montant = montant;
        this.testDate = testDate;

    }
    
    public String toString() {
        return nom +" (depot: " + montant + " euros)le "+testDate+"\n";
    }
}
