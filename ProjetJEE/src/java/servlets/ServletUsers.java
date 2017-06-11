/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import clients.gestionnaire.GestionnaireClients;
import clients.modeles.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utilisateurs.gestionnaire.GestionnaireUtilisateurs;
import utilisateurs.modeles.Utilisateur;

/**
 *
 * @author jux
 */
@WebServlet(name = "ServletUsers", urlPatterns = {"/ServletUsers"})
public class ServletUsers extends HttpServlet {
    
    @EJB
    private GestionnaireUtilisateurs gestionnaireUtilisateurs;
    @EJB
    private GestionnaireClients gestionnaireClients;
    
    HttpSession session;
    String login;


    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods. 
     * @param request servlet request 
     * @param response servlet response 
     * @throws ServletException if a servlet-specific error occurs 
     * @throws IOException if an I/O error occurs 
     */  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        // Pratique pour décider de l'action à faire  
        String action = request.getParameter("action");  
        String forwardTo = "";  
        String message = "";
        
        
        
        if (action != null) { 
            
            
            if (action.equals("connexion"))  {
                 
                try {
                    session = request.getSession(false);
                    login = (String) session.getAttribute("LOGIN");
                    Calendar cal = Calendar.getInstance();
                    
                    Date dateC = cal.getTime();    
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dateF = sdf.format( dateC );
                request.setAttribute("currentdate", dateF);
                
                
                    String month = new SimpleDateFormat("MMM").format(cal.getTime());
                    String dayNumber = new SimpleDateFormat("dd").format(cal.getTime());
                    String dayday = new SimpleDateFormat("E").format(cal.getTime());
                    String day = null;
                    int dayInt = cal.get(Calendar.DAY_OF_WEEK);
                    switch (dayInt) {
                        case Calendar.SUNDAY:
                            day = "Lundi";
                        case Calendar.MONDAY:
                            day = "Mardi";
                        case Calendar.TUESDAY:
                            day = "Mercredi";
                        case Calendar.THURSDAY:
                            day = "Vendredi";
                        case Calendar.WEDNESDAY:
                            day = "Jeudi";
                        case Calendar.FRIDAY:
                            day = "Samedi";
                        case Calendar.SATURDAY:
                            day = "Dimanche";
                    }
                    
                    request.setAttribute("month", month);
                    request.setAttribute("jour", dayday);
                    request.setAttribute("jourNb", dayNumber);
                    
                    cal.add( Calendar.DATE, 1 );
                    
                    String month2 = new SimpleDateFormat("MMM").format(cal.getTime());
                    String dayNumber2 = new SimpleDateFormat("dd").format(cal.getTime());
                    String day2 = new SimpleDateFormat("E").format(cal.getTime());
                    
                    System.out.println(day+dayInt);
                    request.setAttribute("month2", month2);
                    request.setAttribute("jour2", day2);
                    request.setAttribute("jourNb2", dayNumber2);
                    
                    cal.add( Calendar.DATE, 1 );
                    
                    String month3 = new SimpleDateFormat("MMM").format(cal.getTime());
                    String dayNumber3 = new SimpleDateFormat("dd").format(cal.getTime());
                    String day3 = new SimpleDateFormat("E").format(cal.getTime());
                    
                    System.out.println(day+dayInt);
                    request.setAttribute("month3", month3);
                    request.setAttribute("jour3", day3);
                    request.setAttribute("jourNb3", dayNumber3);
                    
                    cal.add( Calendar.DATE, -3 );
                    
                    String monthM2 = new SimpleDateFormat("MMM").format(cal.getTime());
                    String dayNumberM2 = new SimpleDateFormat("dd").format(cal.getTime());
                    String dayM2 = new SimpleDateFormat("E").format(cal.getTime());
                    
                    System.out.println(day+dayInt);
                    request.setAttribute("monthM2", monthM2);
                    request.setAttribute("jourM2", dayM2);
                    request.setAttribute("jourNbM2", dayNumberM2);
                    
                    cal.add( Calendar.DATE, -1 );
                    
                    String monthM3 = new SimpleDateFormat("MMM").format(cal.getTime());
                    String dayNumberM3 = new SimpleDateFormat("dd").format(cal.getTime());
                    String dayM3 = new SimpleDateFormat("E").format(cal.getTime());
                    
                    System.out.println(day+dayInt);
                    request.setAttribute("monthM3", monthM3);
                    request.setAttribute("jourM3", dayM3);
                    request.setAttribute("jourNbM3", dayNumberM3);
                    
                    cal.add( Calendar.DATE, -1 );
                    
                    String monthM4 = new SimpleDateFormat("MMM").format(cal.getTime());
                    String dayNumberM4 = new SimpleDateFormat("dd").format(cal.getTime());
                    String dayM4 = new SimpleDateFormat("E").format(cal.getTime());
                    
                    System.out.println(day+dayInt);
                    request.setAttribute("monthM4", monthM4);
                    request.setAttribute("jourM4", dayM4);
                    request.setAttribute("jourNbM4", dayNumberM4);
                    
                    
                    // On récupère les clients actuellement dans les chambres et les jours précédents et suivants
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = new Date();
                    String estArrive  = null;
                    String aPaye = null;
                    Client client = null;
       
                    Collection<Client> liste = gestionnaireClients.getClientsInSimpleToday(dateFormat.format(date));
                    if (!liste.isEmpty()) {
                    client = liste.iterator().next();
                    if (client.isEstArrive()== true) {
                        estArrive = "checked";
                    } else {
                        estArrive = "off";
                    }
                    if (client.isaPaye()== true) {
                        aPaye = "checked";
                    } else {
                        aPaye = "off";
                    }
                    
                    request.setAttribute("apayeSimpleToday", aPaye);
                    request.setAttribute("estarriveSimpleToday", estArrive);}
                    request.setAttribute("listeDesClientsSimpleToday", liste);
                    liste = gestionnaireClients.getClientsInSimpleTodayPlus1(dateFormat.format(date));
                     if (!liste.isEmpty()) {
                    client = liste.iterator().next();
                    if (client.isEstArrive()== true) {
                        estArrive = "checked";
                    } else {
                        estArrive = "off";
                    }
                    if (client.isaPaye()== true) {
                        aPaye = "checked";
                    } else {
                        aPaye = "off";
                    }
                    request.setAttribute("apayeSimpleTodayPlus1", aPaye);
                    request.setAttribute("estarriveSimpleTodayPlus1", estArrive);}
                    request.setAttribute("listeDesClientsSimpleTodayPlus1", liste);
                    liste = gestionnaireClients.getClientsInSimpleTodayPlus2(dateFormat.format(date));
                     if (!liste.isEmpty()) {
                     client = liste.iterator().next();
                    if (client.isEstArrive()== true) {
                        estArrive = "checked";
                    } else {
                        estArrive = "off";
                    }
                    if (client.isaPaye()== true) {
                        aPaye = "checked";
                    } else {
                        aPaye = "off";
                    }
                    request.setAttribute("apayeSimpleTodayPlus2", aPaye);
                    request.setAttribute("estarriveSimpleTodayPlus2", estArrive);}
                    
                    request.setAttribute("listeDesClientsSimpleTodayPlus2", liste);
                    liste = gestionnaireClients.getClientsInSimpleTodayMoins1(dateFormat.format(date));
                     if (!liste.isEmpty()) {
                    client = liste.iterator().next();
                    if (client.isEstArrive()== true) {
                        estArrive = "checked";
                    } else {
                        estArrive = "off";
                    }
                    if (client.isaPaye()== true) {
                        aPaye = "checked";
                    } else {
                        aPaye = "off";
                    }
                    request.setAttribute("apayeSimpleTodayMoins1", aPaye);
                    request.setAttribute("estarriveSimpleTodayMoins1", estArrive);}
                    request.setAttribute("listeDesClientsSimpleTodayMoins1", liste);
                    liste = gestionnaireClients.getClientsInSimpleTodayMoins2(dateFormat.format(date));
                     if (!liste.isEmpty()) {
                    client = liste.iterator().next();
                    if (client.isEstArrive()== true) {
                        estArrive = "checked";
                    } else {
                        estArrive = "off";
                    }
                    if (client.isaPaye()== true) {
                        aPaye = "checked";
                    } else {
                        aPaye = "off";
                    }
                    request.setAttribute("apayeSimpleTodayMoins2", aPaye);
                    request.setAttribute("estarriveSimpleTodayMoins2", estArrive);}
                    request.setAttribute("listeDesClientsSimpleTodayMoins2", liste);
                    liste = gestionnaireClients.getClientsInSimpleTodayMoins3(dateFormat.format(date));
                     if (!liste.isEmpty()) {
                    client = liste.iterator().next();
                    if (client.isEstArrive()== true) {
                        estArrive = "checked";
                    } else {
                        estArrive = "off";
                    }
                    if (client.isaPaye()== true) {
                        aPaye = "checked";
                    } else {
                        aPaye = "off";
                    }
                    request.setAttribute("apayeSimpleTodayMoins3", aPaye);
                    request.setAttribute("estarriveSimpleTodayMoins3", estArrive);}
                    request.setAttribute("listeDesClientsSimpleTodayMoins3", liste);
                    
                    liste = gestionnaireClients.getClientsInZenToday(dateFormat.format(date));
                     if (!liste.isEmpty()) {
                    client = liste.iterator().next();
                    if (client.isEstArrive()== true) {
                        estArrive = "checked";
                    } else {
                        estArrive = "off";
                    }
                    if (client.isaPaye()== true) {
                        aPaye = "checked";
                    } else {
                        aPaye = "off";
                    }
                    request.setAttribute("apayeZenToday", aPaye);
                    request.setAttribute("estarriveZenToday", estArrive);}
                    request.setAttribute("listeDesClientsZenToday", liste);
                    liste = gestionnaireClients.getClientsInZenTodayPlus1(dateFormat.format(date));
                     if (!liste.isEmpty()) {
                    client = liste.iterator().next();
                    if (client.isEstArrive()== true) {
                        estArrive = "checked";
                    } else {
                        estArrive = "off";
                    }
                    if (client.isaPaye()== true) {
                        aPaye = "checked";
                    } else {
                        aPaye = "off";
                    }
                    request.setAttribute("apayeZenTodayPlus1", aPaye);
                    request.setAttribute("estarriveZenTodayPlus1", estArrive);}
                    request.setAttribute("listeDesClientsZenTodayPlus1", liste);
                    liste = gestionnaireClients.getClientsInZenTodayPlus2(dateFormat.format(date));
                     if (!liste.isEmpty()) {
                    client = liste.iterator().next();
                    if (client.isEstArrive()== true) {
                        estArrive = "checked";
                    } else {
                        estArrive = "off";
                    }
                    if (client.isaPaye()== true) {
                        aPaye = "checked";
                    } else {
                        aPaye = "off";
                    }
                    request.setAttribute("apayeZenTodayPlus2", aPaye);
                    request.setAttribute("estarriveZenTodayPlus2", estArrive);}
                    request.setAttribute("listeDesClientsZenTodayPlus2", liste);
                    liste = gestionnaireClients.getClientsInZenTodayMoins1(dateFormat.format(date));
                     if (!liste.isEmpty()) {
                    client = liste.iterator().next();
                    if (client.isEstArrive()== true) {
                        estArrive = "checked";
                    } else {
                        estArrive = "off";
                    }
                    if (client.isaPaye()== true) {
                        aPaye = "checked";
                    } else {
                        aPaye = "off";
                    }
                    request.setAttribute("apayeZenTodayMoins1", aPaye);
                    request.setAttribute("estarriveZenTodayMoins1", estArrive);}
                    request.setAttribute("listeDesClientsZenTodayMoins1", liste);
                    liste = gestionnaireClients.getClientsInZenTodayMoins2(dateFormat.format(date));
                    if (!liste.isEmpty()) {
                    client = liste.iterator().next();
                    if (client.isEstArrive()== true) {
                        estArrive = "checked";
                    } else {
                        estArrive = "off";
                    }
                    if (client.isaPaye()== true) {
                        aPaye = "checked";
                    } else {
                        aPaye = "off";
                    }
                    request.setAttribute("apayeZenTodayMoins2", aPaye);
                    request.setAttribute("estarriveZenTodayMoins2", estArrive);}
                    request.setAttribute("listeDesClientsZenTodayMoins2", liste);
                    liste = gestionnaireClients.getClientsInZenTodayMoins3(dateFormat.format(date));
                     if (!liste.isEmpty()) {
                    client = liste.iterator().next();
                    if (client.isEstArrive()== true) {
                        estArrive = "checked";
                    } else {
                        estArrive = "off";
                    }
                    if (client.isaPaye()== true) {
                        aPaye = "checked";
                    } else {
                        aPaye = "off";
                    }
                    request.setAttribute("apayeZenTodayMoins3", aPaye);
                    request.setAttribute("estarriveZenTodayMoins3", estArrive);}
                    request.setAttribute("listeDesClientsZenTodayMoins3", liste);
                    
                    liste = gestionnaireClients.getClientsInSwaziToday(dateFormat.format(date));
                    if (!liste.isEmpty()) {
                    client = liste.iterator().next();
                    if (client.isEstArrive()== true) {
                        estArrive = "checked";
                    } else {
                        estArrive = "off";
                    }
                    if (client.isaPaye()== true) {
                        aPaye = "checked";
                    } else {
                        aPaye = "off";
                    }
                    request.setAttribute("apayeSwazyToday", aPaye);
                    request.setAttribute("estarriveSwazyToday", estArrive);}
                    request.setAttribute("listeDesClientsSwaziToday", liste);
                    
                    liste = gestionnaireClients.getClientsInSwaziTodayPlus1(dateFormat.format(date));
                    if (!liste.isEmpty()) {
                    client = liste.iterator().next();
                    if (client.isEstArrive()== true) {
                        estArrive = "checked";
                    } else {
                        estArrive = "off";
                    }
                    if (client.isaPaye()== true) {
                        aPaye = "checked";
                    } else {
                        aPaye = "off";
                    }
                    request.setAttribute("apayeSwazyTodayPlus1", aPaye);
                    request.setAttribute("estarriveSwazyTodayPlus1", estArrive);}
                    request.setAttribute("listeDesClientsSwaziTodayPlus1", liste);
                    
                    liste = gestionnaireClients.getClientsInSwaziTodayPlus2(dateFormat.format(date));
                    if (!liste.isEmpty()) {
                    client = liste.iterator().next();
                    if (client.isEstArrive()== true) {
                        estArrive = "checked";
                    } else {
                        estArrive = "off";
                    }
                    if (client.isaPaye()== true) {
                        aPaye = "checked";
                    } else {
                        aPaye = "off";
                    }
                    request.setAttribute("apayeSwazyTodayPlus2", aPaye);
                    request.setAttribute("estarriveSwazyTodayPlus2", estArrive);}
                    request.setAttribute("listeDesClientsSwaziTodayPlus2", liste);
                    liste = gestionnaireClients.getClientsInSwaziTodayMoins1(dateFormat.format(date));
                    if (!liste.isEmpty()) {
                    client = liste.iterator().next();
                    if (client.isEstArrive()== true) {
                        estArrive = "checked";
                    } else {
                        estArrive = "off";
                    }
                    if (client.isaPaye()== true) {
                        aPaye = "checked";
                    } else {
                        aPaye = "off";
                    }
                    request.setAttribute("apayeSwazyTodayMoins1", aPaye);
                    request.setAttribute("estarriveSwazyTodayMoins1", estArrive);}
                    request.setAttribute("listeDesClientsSwaziTodayMoins1", liste);
                    liste = gestionnaireClients.getClientsInSwaziTodayMoins2(dateFormat.format(date));
                    if (!liste.isEmpty()) {
                    client = liste.iterator().next();
                    if (client.isEstArrive()== true) {
                        estArrive = "checked";
                    } else {
                        estArrive = "off";
                    }
                    if (client.isaPaye()== true) {
                        aPaye = "checked";
                    } else {
                        aPaye = "off";
                    }
                    request.setAttribute("apayeSwazyTodayMoins2", aPaye);
                    request.setAttribute("estarriveSwazyTodayMoins2", estArrive);}
                    request.setAttribute("listeDesClientsSwaziTodayMoins2", liste);
                    liste = gestionnaireClients.getClientsInSwaziTodayMoins3(dateFormat.format(date));
                    if (!liste.isEmpty()) {
                    client = liste.iterator().next();
                    if (client.isEstArrive()== true) {
                        estArrive = "checked";
                    } else {
                        estArrive = "off";
                    }
                    if (client.isaPaye()== true) {
                        aPaye = "checked";
                    } else {
                        aPaye = "off";
                    }
                    request.setAttribute("apayeSwazyTodayMoins3", aPaye);
                    request.setAttribute("estarriveSwazyTodayMoins3", estArrive);}
                    request.setAttribute("listeDesClientsSwaziTodayMoins3", liste);
                    
                   // request.setAttribute("listeDesClientsSwaziTodayMoins3", liste['apaye']);
                    
                    
                    forwardTo = "index.jsp?action=connexion";
                    message = "Connecté";
                } catch (ParseException ex) {
                    Logger.getLogger(ServletUsers.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                  
                
             }  else if (action.equals("newResa")) {
                request.setAttribute("newResa", "newResa");  
                forwardTo = "index.jsp?action=newResa"; 
                message = "Ajouter un hôte"; 

            } else if (action.equals("newResa2")) {
                request.setAttribute("newResa2", "newResa2");
                String stringJourArrivee = request.getParameter("jourA");
                String stringJourDepart = request.getParameter("jourD");
                String apaye = request.getParameter("apaye");
                String estarrive = request.getParameter("estarrive");
                String nameL = request.getParameter("last_name");
                String nameF = request.getParameter("first_name");
                String heureA = request.getParameter("heureA");
                String prix = request.getParameter("prix");
                String chambre = request.getParameter("chambre");
                forwardTo = "index.jsp?action=newResa2"; 
                message = "Liste des utilisateurs"; 
                
                request.setAttribute("jourA", stringJourArrivee);
                request.setAttribute("jourD", stringJourDepart);
                request.setAttribute("apaye", apaye);
                request.setAttribute("estarrive", estarrive);
                request.setAttribute("nom", nameL);
                request.setAttribute("prenom", nameF);
                request.setAttribute("heureA", heureA);
                request.setAttribute("prix", prix);
                request.setAttribute("chambre", chambre);
                
            }
           
                
            } else if (action.equals("creerUnUtilisateur")) {

                gestionnaireUtilisateurs.creeUtilisateur(request.getParameter("nom"),  request.getParameter("login"));
                forwardTo = "index.jsp?action=listerLesUtilisateurs";  
                message = "Création de l'utilisateur "+request.getParameter("login");
 
            
   
            } else {  
                forwardTo = "index.jsp?action=todo";  
                message = "La fonctionnalité pour le paramètre " + action + " est à implémenter !";  
            }  
            
        
        
        if (login != null) {
            request.setAttribute("userlogin", login);
        }

        if (session.isNew()) {
            System.out.println("Not connected");
        } else {
            System.out.println("Connected "+(String) session.getAttribute("LOGIN"));
        }
  
        RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);  
        dp.forward(request, response);  
        // Après un forward, plus rien ne peut être exécuté après !  
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
       
        
       
        
 

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
