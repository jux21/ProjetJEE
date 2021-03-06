/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients.gestionnaire;

import chambres.modeles.Chambre;
import clients.modeles.Client;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilisateurs.modeles.Utilisateur;

/**
 *
 * @author jux
 */
@Stateless
public class GestionnaireClients {
    
    @PersistenceContext  
    private EntityManager em;
    
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    private static final DateTimeFormatter dateFormat8 = DateTimeFormatter.ofPattern(DATE_FORMAT);
    
    
    public Client creeClient(String nom, String prenom, String heureArrivee, LocalDate jourArrivee, LocalDate jourDepart, boolean aPaye, boolean estArrive, float prix, String chambre) {  
        Client c = new Client(nom, prenom, heureArrivee, jourArrivee, jourDepart, aPaye, estArrive, prix, chambre); 
        //Collection<Chambre> chambres;
        
        //Query q = em.createQuery("SELECT c FROM Chambre c WHERE c.chambre ='"+chambre+"'"); 
        //"SELECT u FROM Utilisateur u WHERE u.login ='"+login+"'");
        //q.getResultList();
        
        //chambres.add((Chambre) );
        //c.setChambres((List<Chambre>) (Chambre) q.getResultList().get(0));
        
        em.persist(c);
        return c;  
    }
    
    
    public Collection<Client> getClientsInSimpleToday(String date) throws ParseException {  
        // Si le jour courant se situe entre le jour d'arrivée et le jour de départ
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(date));
        c.add(Calendar.DATE, 0);      
        Date currentDatePlusOne = c.getTime();
        String reportDate = df.format(currentDatePlusOne);
        
        Query q = em.createQuery("SELECT c FROM Client c WHERE '"+reportDate+"'  BETWEEN c.jourArrivee AND c.jourDepart AND c.chambre = 'simple'");
        return q.getResultList();
    }
    
    public Collection<Client> getClientsInSimpleTodayPlus1(String date) throws ParseException {  
        // Si le jour courant+1 se situe entre le jour d'arrivée et le jour de départ
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(date));
        c.add(Calendar.DATE, 1);      
        Date currentDatePlusOne = c.getTime();
        String reportDate = df.format(currentDatePlusOne);
        
        Query q = em.createQuery("SELECT c FROM Client c WHERE '"+reportDate+"'  BETWEEN c.jourArrivee AND c.jourDepart AND c.chambre = 'simple'");
        return q.getResultList();
    }
    
   public Collection<Client> getClientsInSimpleTodayPlus2(String date) throws ParseException {  
        // Si le jour courant+2 se situe entre le jour d'arrivée et le jour de départ
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(date));
        c.add(Calendar.DATE, 2);      
        Date currentDatePlusOne = c.getTime();
        String reportDate = df.format(currentDatePlusOne);
        
        Query q = em.createQuery("SELECT c FROM Client c WHERE '"+reportDate+"'  BETWEEN c.jourArrivee AND c.jourDepart AND c.chambre = 'simple'");
        return q.getResultList();
    }
   
   public Collection<Client> getClientsInSimpleTodayMoins1(String date) throws ParseException {  
        // Si le jour courant-1 se situe entre le jour d'arrivée et le jour de départ 
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(date));
        c.add(Calendar.DATE, -1);      
        Date currentDatePlusOne = c.getTime();
        String reportDate = df.format(currentDatePlusOne);
        
        Query q = em.createQuery("SELECT c FROM Client c WHERE '"+reportDate+"'  BETWEEN c.jourArrivee AND c.jourDepart AND c.chambre = 'simple'");
        return q.getResultList();
    }
   
   public Collection<Client> getClientsInSimpleTodayMoins2(String date) throws ParseException {  
        // Si le jour courant-2 se situe entre le jour d'arrivée et le jour de départ
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(date));
        c.add(Calendar.DATE, -2);      
        Date currentDatePlusOne = c.getTime();
        String reportDate = df.format(currentDatePlusOne);
        
        Query q = em.createQuery("SELECT c FROM Client c WHERE '"+reportDate+"'  BETWEEN c.jourArrivee AND c.jourDepart AND c.chambre = 'simple'");
        return q.getResultList();
    }
   
   public Collection<Client> getClientsInSimpleTodayMoins3(String date) throws ParseException {  
        // Si le jour courant-3 se situe entre le jour d'arrivée et le jour de départ
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(date));
        c.add(Calendar.DATE, -3);      
        Date currentDatePlusOne = c.getTime();
        String reportDate = df.format(currentDatePlusOne);
        
        Query q = em.createQuery("SELECT c FROM Client c WHERE '"+reportDate+"'  BETWEEN c.jourArrivee AND c.jourDepart AND c.chambre = 'simple'");
        return q.getResultList();
    }
   
   public Collection<Client> getClientsInZenToday(String date) throws ParseException {  
        // Si le jour courant se situe entre le jour d'arrivée et le jour de départ
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(date));
        c.add(Calendar.DATE, 0);      
        Date currentDatePlusOne = c.getTime();
        String reportDate = df.format(currentDatePlusOne);
        
        Query q = em.createQuery("SELECT c FROM Client c WHERE '"+reportDate+"' BETWEEN c.jourArrivee AND c.jourDepart AND c.chambre = 'zen'");
        return q.getResultList();
    }
   
    public Collection<Client> getClientsInZenTodayPlus1(String date) throws ParseException {  
        // Si le jour courant+1 se situe entre le jour d'arrivée et le jour de départ
        /*Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DAY_OF_MONTH, 1);
        Date currentDatePlusOne = c.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String reportDate = df.format(currentDatePlusOne);*/
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(date));
        c.add(Calendar.DATE, 1);      
        Date currentDatePlusOne = c.getTime();
        String reportDate = df.format(currentDatePlusOne);
        
        Query q = em.createQuery("SELECT c FROM Client c WHERE '"+reportDate+"'  BETWEEN c.jourArrivee AND c.jourDepart AND c.chambre = 'zen'");
        return q.getResultList();
    }
    
   public Collection<Client> getClientsInZenTodayPlus2(String date) throws ParseException {  
        // Si le jour courant+2 se situe entre le jour d'arrivée et le jour de départ
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(date));
        c.add(Calendar.DATE, 2);      
        Date currentDatePlusOne = c.getTime();
        String reportDate = df.format(currentDatePlusOne);
        
        Query q = em.createQuery("SELECT c FROM Client c WHERE '"+reportDate+"'  BETWEEN c.jourArrivee AND c.jourDepart AND c.chambre = 'zen'");
        return q.getResultList();
    }
   
   public Collection<Client> getClientsInZenTodayMoins1(String date) throws ParseException {  
        // Si le jour courant-1 se situe entre le jour d'arrivée et le jour de départ 
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(date));
        c.add(Calendar.DATE, -1);      
        Date currentDatePlusOne = c.getTime();
        String reportDate = df.format(currentDatePlusOne);
        
        Query q = em.createQuery("SELECT c FROM Client c WHERE '"+reportDate+"'  BETWEEN c.jourArrivee AND c.jourDepart AND c.chambre = 'zen'");
        return q.getResultList();
    }
   
   public Collection<Client> getClientsInZenTodayMoins2(String date) throws ParseException {  
        // Si le jour courant-2 se situe entre le jour d'arrivée et le jour de départ
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(date));
        c.add(Calendar.DATE, -2);      
        Date currentDatePlusOne = c.getTime();
        String reportDate = df.format(currentDatePlusOne);
        
        Query q = em.createQuery("SELECT c FROM Client c WHERE '"+reportDate+"'  BETWEEN c.jourArrivee AND c.jourDepart AND c.chambre = 'zen'");
        return q.getResultList();
    }
   
   public Collection<Client> getClientsInZenTodayMoins3(String date) throws ParseException {  
        // Si le jour courant-3 se situe entre le jour d'arrivée et le jour de départ
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(date));
        c.add(Calendar.DATE, -3);      
        Date currentDatePlusOne = c.getTime();
        String reportDate = df.format(currentDatePlusOne);
        Query q = em.createQuery("SELECT c FROM Client c WHERE '"+reportDate+"'  BETWEEN c.jourArrivee AND c.jourDepart AND c.chambre = 'zen'");
        return q.getResultList();
    }
   
   
   public Collection<Client> getClientsInSwaziToday(String date) throws ParseException {  
        // Si le jour courant se situe entre le jour d'arrivée et le jour de départ
       DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(date));
        c.add(Calendar.DATE, 0);      
        Date currentDatePlusOne = c.getTime();
        String reportDate = df.format(currentDatePlusOne);
        Query q = em.createQuery("SELECT c FROM Client c WHERE '"+reportDate+"'  BETWEEN c.jourArrivee AND c.jourDepart AND c.chambre = 'swazi'");
        return q.getResultList();
    }
   
    public Collection<Client> getClientsInSwaziTodayPlus1(String date) throws ParseException {  
        // Si le jour courant+1 se situe entre le jour d'arrivée et le jour de départ
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(date));
        c.add(Calendar.DATE, 1);      
        Date currentDatePlusOne = c.getTime();
        String reportDate = df.format(currentDatePlusOne);
        
        Query q = em.createQuery("SELECT c FROM Client c WHERE '"+reportDate+"'  BETWEEN c.jourArrivee AND c.jourDepart AND c.chambre = 'swazi'");
        return q.getResultList();
    }
    
   public Collection<Client> getClientsInSwaziTodayPlus2(String date) throws ParseException {  
        // Si le jour courant+2 se situe entre le jour d'arrivée et le jour de départ
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(date));
        c.add(Calendar.DATE, 2);      
        Date currentDatePlusOne = c.getTime();
        String reportDate = df.format(currentDatePlusOne);
        
        Query q = em.createQuery("SELECT c FROM Client c WHERE '"+reportDate+"'  BETWEEN c.jourArrivee AND c.jourDepart AND c.chambre = 'swazi'");
        return q.getResultList();
    }
   
   public Collection<Client> getClientsInSwaziTodayMoins1(String date) throws ParseException {  
        // Si le jour courant-1 se situe entre le jour d'arrivée et le jour de départ 
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(date));
        c.add(Calendar.DATE, -1);      
        Date currentDatePlusOne = c.getTime();
        String reportDate = df.format(currentDatePlusOne);
        
        Query q = em.createQuery("SELECT c FROM Client c WHERE '"+reportDate+"'  BETWEEN c.jourArrivee AND c.jourDepart AND c.chambre = 'swazi'");
        return q.getResultList();
    }
   
   public Collection<Client> getClientsInSwaziTodayMoins2(String date) throws ParseException {  
        // Si le jour courant-2 se situe entre le jour d'arrivée et le jour de départ
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(date));
        c.add(Calendar.DATE, -2);      
        Date currentDatePlusOne = c.getTime();
        String reportDate = df.format(currentDatePlusOne);
        
        Query q = em.createQuery("SELECT c FROM Client c WHERE '"+reportDate+"'  BETWEEN c.jourArrivee AND c.jourDepart AND c.chambre = 'swazi'");
        return q.getResultList();
    }
   
   public Collection<Client> getClientsInSwaziTodayMoins3(String date) throws ParseException {  
        // Si le jour courant-3 se situe entre le jour d'arrivée et le jour de départ
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(date));
        c.add(Calendar.DATE, -3);      
        Date currentDatePlusOne = c.getTime();
        String reportDate = df.format(currentDatePlusOne);
       
        Query q = em.createQuery("SELECT c FROM Client c WHERE '"+reportDate+"'  BETWEEN c.jourArrivee AND c.jourDepart AND c.chambre = 'swazi'");
        return q.getResultList();
    }
   
   public int updateClient(String nom, String prenom, String heureArrivee, LocalDate jourArrivee, LocalDate jourDepart, boolean aPaye, boolean estArrive, float prix, String chambre) {
        // Exécution d'une requête équivalente à un update where login    
        Query q = em.createQuery("UPDATE Client c SET c.lastname = '"+nom+"', c.firstname = '"+prenom+"' WHERE c.chambre = '"+chambre+"'");
        return q.executeUpdate();
    }
   
}
