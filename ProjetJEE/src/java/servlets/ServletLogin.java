/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
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
//import static utilisateurs.modeles.Utilisateur.login;

/**
 *
 * @author cecile
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {
    @EJB
    private GestionnaireUtilisateurs gestionnaireUtilisateurs;


    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods. 
     * @param request servlet request 
     * @param response servlet response 
     * @throws ServletException if a servlet-specific error occurs 
     * @throws IOException if an I/O error occurs 
     */  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        // Pratique pour décider de l'action à faire  
        String action = request.getParameter("action");  
        String forwardTo = "";  
        String message = "";
        request.setAttribute("sessionConnectee", "no");   
  
        if (action != null) {
              if (action.equals("connexion")) {
                 String login = request.getParameter("login_connexion");
                 Collection<Utilisateur> user = gestionnaireUtilisateurs
                    .getOneUserByLoginAndLastName(
                        //récupération des paramètress de la requête
                        login,
                        request.getParameter("lastname_connexion")); 
                
                  
                
               // request.setAttribute("listeDesUsers", user); 
                
                isLoginValid(login);
                PrintWriter out = response.getWriter();
                if(!user.isEmpty() && !request.getParameter("login_connexion").isEmpty()) {
                    HttpSession session = request.getSession();
                    session.setAttribute("LOGIN", login); 
                    response.sendRedirect("ServletUsers?action=connexion");
                } else {
                    response.sendRedirect("invalidLogin.html"); 
                } 
                
                //soumettre les paramètres de la requête à la couche service et récupération du résultat
                    //Utilisateur user = new Utilisateur(login, pwd);
                    //forwardTo = "index.jsp?action=connexion=envoyer"; 
                    //réponse à l'utilisateur
                    
                
               // RequestDispatcher dispatcher = request.getRequestDispatcher("resultatLogin.jsp");
               // dispatcher.forward(request, response);
              }
        }
    }
    
    public boolean isLoginValid(String login) {
        Collection<Utilisateur> user = gestionnaireUtilisateurs
                    .getOneUserByLogin(
                        //récupération des paramètress de la requête
                        login
                        ); 
        
        if (user.contains(login)) {
        return true;
        } else {
            return false;
        }
    }
}
    
                 