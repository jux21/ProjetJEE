/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import chambres.modeles.Chambre;
import clients.gestionnaire.GestionnaireClients;
import clients.modeles.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import utilisateurs.modeles.Utilisateur;

/**
 *
 * @author jux
 */
@WebServlet(name = "ServletClients", urlPatterns = {"/ServletClients"})
public class ServletClients extends HttpServlet {
    @EJB
    private GestionnaireClients gestionnaireClients;
    HttpSession session;
    String login;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        // Pratique pour décider de l'action à faire  
        System.out.println("cacacaca");
        String action = request.getParameter("action");  
        String forwardTo = "";  
        String message = "";
        
        if (action != null) { 
            System.out.println("llaaaaaaaaaaaaaaaaaaaaaaa");
            
            if (action.equals("connexion"))  {
                forwardTo = "index.jsp?action=";
                message = "Connecté"; 
                session = request.getSession();
                login = (String) session.getAttribute("LOGIN");  
             }
            else if (action.equals("listerClients")) {
                Collection<Client> liste = gestionnaireClients.getClientsCurrentlyInHouse();  
                request.setAttribute("listeDesClients", liste);  
                forwardTo = "index.jsp?action=listerLesClients"; 
                message = "Liste des utilisateurs"; 

            } else if (action.equals("insererClient")) { 
                
                //http://localhost:8080/index.jsp/ProjetJEE/ServletClients&action=insererClient&nom=Hubert&prenom=Julien&heureArrivee=15:24&jourArrivee=31/05/2017&jourDepart=04/06/2017&aPaye=true&estArrive=true&chambre=simple
                //http://localhost:8080/index.jsp/ProjetJEE/ServletClients?nom=Hubert?prenom=Julien?heureArrivee=15:24?jourArrivee=31/05/2017?jourDepart=04/06/2017?aPaye=true?estArrive=true?chambre=simple&action=insererClient
                
                
                
                // Transformation des String en Date
                String stringJourArrivee = request.getParameter("jourArrivee");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.FRANCE);
                LocalDate dateJourArrivee = LocalDate.parse(stringJourArrivee, formatter);
                
                String stringJourDepart = request.getParameter("jourDepart");
                LocalDate dateJourDepart = LocalDate.parse(stringJourDepart, formatter);
                
                System.out.println("jourArrivee : "+dateJourArrivee);
                System.out.println("jourDepart : "+dateJourDepart);
                
                // Transformation des String en Boolean
                Boolean aPaye = Boolean.valueOf(request.getParameter("aPaye"));
                Boolean estArrive = Boolean.valueOf(request.getParameter("estArrive"));
                
                gestionnaireClients.creeClient(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("heureArrivee"), dateJourArrivee, request.getParameter("chambre"), dateJourDepart, aPaye, estArrive);
                //creeClient(String nom, String prenom, Date heureArrivee, Date jourArrivee, String chambre, Date jourDepart, boolean aPaye, boolean estArrive)
                
                /*Collection<Client> liste = gestionnaireClients.getClientsCurrentlyInHouse();  
                request.setAttribute("listeDesClients", liste); 
                forwardTo = "index.jsp?action=listerLesClients";  
                message = "Insertion d'un client";*/
                
            //} else if (action.equals("modifierClient")) {
                /*gestionnaireClients.updateClient(); 
                Collection<Client> liste = gestionnaireClients.getClientsCurrentlyInHouse(); 
                request.setAttribute("listeDesClients", liste);
                forwardTo = "index.jsp?action=listerLesClients";  
                message = "Modification du client "+request.getParameter(); */   
         
            //} else if (action.equals("chercherClient")) {     
                /*Collection<Client> client = gestionnaireClients.chercherClient(); 
                request.setAttribute("listeDesUsers", client);  
                forwardTo = "index.jsp?action=listerLesClients";  
                message = "Client "+request.getParameter("login");*/

            //} else {  
                //forwardTo = "index.jsp?action=todo";  
                //message = "La fonctionnalité pour le paramètre " + action + " est à implémenter !";  
            //}   
        //}
        
        /*if (login != null) {
            request.setAttribute("userlogin", login);
        }

        if (session.isNew()) {
            System.out.println("Not connected");
        } else {
            System.out.println("Connected "+(String) session.getAttribute("LOGIN"));
        } */
  
        //RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);  
        //dp.forward(request, response);  
        // Après un forward, plus rien ne peut être exécuté après !  
    //}
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        // Pratique pour décider de l'action à faire  
        String action = request.getParameter("action");  
        String forwardTo = "";  
        String message = "";
        
        
        if (action != null) { 
            
            System.out.println("ServletCliiiiiiients");
 
            if (action.equals("connexion"))  {
                forwardTo = "index.jsp?action=";
                message = "Connecté"; 
                session = request.getSession();
                login = (String) session.getAttribute("LOGIN");  
             }
            else if (action.equals("listerClients")) {
                Collection<Client> liste = gestionnaireClients.getClientsCurrentlyInHouse();  
                request.setAttribute("listeDesClients", liste);  
                forwardTo = "index.jsp?action=listerLesClients"; 
                message = "Liste des utilisateurs"; 

            } else if (action.equals("insererClient")) { 
                
                //http://localhost:8080/index.jsp/ProjetJEE/ServletClients&action=insererClient&nom=Hubert&prenom=Julien&heureArrivee=15:24&jourArrivee=31/05/2017&jourDepart=04/06/2017&aPaye=true&estArrive=true&chambre=simple
                //http://localhost:8080/index.jsp/ProjetJEE/ServletClients?nom=Hubert?prenom=Julien?heureArrivee=15:24?jourArrivee=31/05/2017?jourDepart=04/06/2017?aPaye=true?estArrive=true?chambre=simple&action=insererClient
                //http://localhost:8080/ProjetJEE/index.jsp/ServletClients?action=insererClient&nom=Hubert&prenom=Julien&heureArrivee=15:24&jourArrivee=31/05/2017&jourDepart=04/06/2017&aPaye=true&estArrive=true&chambre=simple
  
                //gestionnaireClients.fuckyou();
                
                // Transformation des String en Date
                String stringJourArrivee = request.getParameter("jourArrivee");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.FRANCE);
                LocalDate dateJourArrivee = LocalDate.parse(stringJourArrivee, formatter);
                
                String stringJourDepart = request.getParameter("jourDepart");
                LocalDate dateJourDepart = LocalDate.parse(stringJourDepart, formatter);
                
                System.out.println("jourArrivee : "+dateJourArrivee);
                System.out.println("jourDepart : "+dateJourDepart);
                
                // Transformation des String en Boolean
                Boolean aPaye = Boolean.valueOf(request.getParameter("aPaye"));
                Boolean estArrive = Boolean.valueOf(request.getParameter("estArrive"));
                
                gestionnaireClients.creeClient(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("heureArrivee"), dateJourArrivee, request.getParameter("chambre"), dateJourDepart, aPaye, estArrive);
                //creeClient(String nom, String prenom, Date heureArrivee, Date jourArrivee, String chambre, Date jourDepart, boolean aPaye, boolean estArrive)
                
                //Collection<Client> liste = gestionnaireClients.getClientsCurrentlyInHouse();  
                //request.setAttribute("listeDesClients", liste); 
                forwardTo = "index.jsp?action=listerLesClients";  
                message = "Insertion d'un client";
                
            } else if (action.equals("modifierClient")) {
                /*gestionnaireClients.updateClient(); 
                Collection<Client> liste = gestionnaireClients.getClientsCurrentlyInHouse(); 
                request.setAttribute("listeDesClients", liste);
                forwardTo = "index.jsp?action=listerLesClients";  
                message = "Modification du client "+request.getParameter(); */   
         
            } else if (action.equals("chercherClient")) {     
                /*Collection<Client> client = gestionnaireClients.chercherClient(); 
                request.setAttribute("listeDesUsers", client);  
                forwardTo = "index.jsp?action=listerLesClients";  
                message = "Client "+request.getParameter("login");*/

            } else {  
                forwardTo = "index.jsp?action=todo";  
                message = "La fonctionnalité pour le paramètre " + action + " est à implémenter !";  
            }   
        }
        
        /*if (login != null) {
            request.setAttribute("userlogin", login);
        }

        if (session.isNew()) {
            System.out.println("Not connected");
        } else {
            System.out.println("Connected "+(String) session.getAttribute("LOGIN"));
        }*/
  
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
