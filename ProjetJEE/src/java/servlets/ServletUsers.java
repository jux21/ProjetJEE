/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
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
    
    HttpSession session;
    String login;
    
    boolean firstAccess = true;

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
                forwardTo = "index.jsp?action=connexion";
                message = "Connecté"; 
                session = request.getSession(false);
                login = (String) session.getAttribute("LOGIN");  
                Calendar cal = Calendar.getInstance();
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
                
                
                // On demande au ServeltClients de récupérer les clients actuellement dans les chambres
                
                if(firstAccess)
                {
                    firstAccess = false;
                    response.sendRedirect(request.getContextPath()+"/ServletClients?action=listerClients");
                    return;
                }
                  
                
             }  else if (action.equals("newResa")) {
                request.setAttribute("newResa", "newResa");  
                forwardTo = "index.jsp?action=newResa"; 
                message = "Liste des utilisateurs"; 

            }
            else if (action.equals("listerLesUtilisateurs")) {
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers();  
                request.setAttribute("listeDesUsers", liste);  
                request.setAttribute("numberOfUsers", gestionnaireUtilisateurs.getNumberOfUsers());
               
                forwardTo = "index.jsp?action=listerLesUtilisateurs"; 
                message = "Liste des utilisateurs"; 

           
                
            } else if (action.equals("creerUnUtilisateur")) {

                gestionnaireUtilisateurs.creeUtilisateur(request.getParameter("nom"),  request.getParameter("login"));
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers();  
                request.setAttribute("listeDesUsers", liste);  
                request.setAttribute("numberOfUsers", gestionnaireUtilisateurs.getNumberOfUsers());

                forwardTo = "index.jsp?action=listerLesUtilisateurs";  
                message = "Création de l'utilisateur "+request.getParameter("login");
                
            
                
            } else if (action.equals("chercherParLogin")) {     
                Collection<Utilisateur> user = gestionnaireUtilisateurs.getOneUserByLogin(request.getParameter("login")); 
                request.setAttribute("listeDesUsers", user);  
                request.setAttribute("numberOfUsers", gestionnaireUtilisateurs.getNumberOfUsers());
            
                forwardTo = "index.jsp?action=chercherParLogin";  
                message = "Utilisateur avec le login "+request.getParameter("login");
                
            } else if (action.equals("updateUtilisateur")) {   
                gestionnaireUtilisateurs.updateUtilisateur(request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("login")); 
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers();
                request.setAttribute("listeDesUsers", liste);
                request.setAttribute("numberOfUsers", gestionnaireUtilisateurs.getNumberOfUsers());
                
                forwardTo = "index.jsp?action=listerLesUtilisateurs";  
                message = "Modification de l'utilisateur "+request.getParameter("login");
                
            } else if (action.equals("deleteUtilisateur")) {     
                gestionnaireUtilisateurs.deleteUser(request.getParameter("login")); 
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers();
                request.setAttribute("listeDesUsers", liste); 
                request.setAttribute("numberOfUsers", gestionnaireUtilisateurs.getNumberOfUsers());
                
                forwardTo = "index.jsp?action=listerLesUtilisateurs";  
                message = "Suppression de l'utilisateur "+request.getParameter("login");
                   
            } else if (action.equals("getUsersPaginated")) {
          
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getUsersPaginated(Integer.parseInt(request.getParameter("start")),Integer.parseInt(request.getParameter("end")));  
                request.setAttribute("listeDesUsers", liste);  
                request.setAttribute("numberOfUsers", gestionnaireUtilisateurs.getNumberOfUsers());
                
                forwardTo = "index.jsp?action=listerLesUtilisateurs";
                message = "Liste des utilisateurs";
   
            } else {  
                forwardTo = "index.jsp?action=todo";  
                message = "La fonctionnalité pour le paramètre " + action + " est à implémenter !";  
            }  
            
         //   } else {
           //     message = "Veuillez-vous connecter";
            //}  
        }
        
        if (login != null) {
            request.setAttribute("userlogin", login);
        }

        /*if (session.isNew()) {
            System.out.println("Not connected");
        } else {
            System.out.println("Connected "+(String) session.getAttribute("LOGIN"));
        } */
  
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
