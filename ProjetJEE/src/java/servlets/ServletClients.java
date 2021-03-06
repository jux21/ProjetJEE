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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        // Pratique pour décider de l'action à faire  
        String action = request.getParameter("action");  
        String forwardTo = "";  
        String message = "";
        
        
        if (action != null) { 
            
            if (action.equals("connexion"))  {
                forwardTo = "index.jsp?action=";
                message = "Connecté"; 
                session = request.getSession();
                login = (String) session.getAttribute("LOGIN");  
             }
            else if (action.equals("listerClients")) {
                // On récupère la liste des clients actuellement présent dans la maison d'hote 
                forwardTo = "ServletUsers?action=connexion"; 
                message = "Liste des clients";

            } else if (action.equals("insererClient")) { 
                
                // Transformation des String en Date
                String stringJourArrivee = request.getParameter("jourA");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.FRANCE);
                LocalDate dateJourArrivee = LocalDate.parse(stringJourArrivee, formatter);
                
                String stringJourDepart = request.getParameter("jourD");
                LocalDate dateJourDepart = LocalDate.parse(stringJourDepart, formatter);
                
                // Transformation des String en Boolean
                Boolean aPaye = false,
                        estArrive = false;
                
                if (request.getParameterMap().containsKey("apaye"))
                {
                    if(request.getParameter("apaye").matches("on"))
                    {
                        aPaye = true;
                    }
                   
                }
                
                if (request.getParameterMap().containsKey("estarrive"))
                {
                    if(request.getParameter("estarrive").matches("on"))
                    {
                        estArrive = true;
                    }
                }
                
                
                gestionnaireClients.creeClient(request.getParameter("last_name"), request.getParameter("first_name"), request.getParameter("heureA"), dateJourArrivee, dateJourDepart, aPaye, estArrive, Float.valueOf(request.getParameter("prix")),request.getParameter("chambre")); 
                forwardTo = "ServletUsers?action=newResa"; 
                message = "Insertion d'un client";
                
            } else if (action.equals("listerClients")) {
                // On récupère la liste des clients actuellement présent dans la maison d'hote 
                forwardTo = "ServletUsers?action=connexion"; 
                message = "Liste des clients";

            } else if (action.equals("insererClient2")) { 
                
                // Transformation des String en Date
                String stringJourArrivee = request.getParameter("jourA");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.FRANCE);
                LocalDate dateJourArrivee = LocalDate.parse(stringJourArrivee, formatter);
                
                String stringJourDepart = request.getParameter("jourD");
                LocalDate dateJourDepart = LocalDate.parse(stringJourDepart, formatter);
                
                // Transformation des String en Boolean
                Boolean aPaye = false,
                        estArrive = false;
                
                if (request.getParameterMap().containsKey("apaye"))
                {
                    if(request.getParameter("apaye").matches("on"))
                    {
                        aPaye = true;
                    }
                   
                }
                
                if (request.getParameterMap().containsKey("estarrive"))
                {
                    if(request.getParameter("estarrive").matches("on"))
                    {
                        estArrive = true;
                    }
                }
                
                
                gestionnaireClients.updateClient(request.getParameter("last_name"), request.getParameter("first_name"), request.getParameter("heureA"), dateJourArrivee, dateJourDepart, aPaye, estArrive, Float.valueOf(request.getParameter("prix")),request.getParameter("chambre")); 
                forwardTo = "ServletUsers?action=newResa"; 
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
