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
import java.util.GregorianCalendar;
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
@WebServlet(name = "ServletAgenda", urlPatterns = {"/ServletAgenda"})
public class ServletAgenda extends HttpServlet {
    
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
            throws ServletException, IOException, ParseException {  
        // Pratique pour décider de l'action à faire  
        String action = request.getParameter("action");  
        String forwardTo = "";  
        String message = "";
        
        
        if (action != null) { 
            if (action.equals("connexion"))  {
                
                
                  
                
             }  else if (action.equals("datepicker")) {
                 
                try {
                    forwardTo = "index.jsp?action=datepicker";
                    message = "Connecté";
                    session = request.getSession(false);
                    login = (String) session.getAttribute("LOGIN");
                    String date = request.getParameter("datepicker");
                    System.out.println(date);
                    request.setAttribute("date", date);
                    String[] array = date.split("(?!^)");
                    int yearNb = 0;
                    int monthNb = 0;
                    int dayNb = 0;
                    for (int i = 0;i<array.length;i++) {
                        System.out.println(array[i]);
                        yearNb = Integer.parseInt(array[0]+array[1]+array[2]+array[3]);
                        monthNb = Integer.parseInt(array[5]+array[6]);
                        dayNb = Integer.parseInt(array[8]+array[9]);
                    }
                    monthNb = monthNb-1;
                    Calendar cal;
                    cal = new GregorianCalendar(yearNb,monthNb,dayNb);
                    
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
                    
                    // On récupère les clients dans les chambres les jours précédents et suivants en fonction de la date choisie
                    Collection<Client> liste = gestionnaireClients.getClientsInSimpleToday(date);
                    request.setAttribute("listeDesClientsSimpleToday", liste);
                    liste = gestionnaireClients.getClientsInSimpleTodayPlus1(date);
                    request.setAttribute("listeDesClientsSimpleTodayPlus1", liste);
                    liste = gestionnaireClients.getClientsInSimpleTodayPlus2(date);
                    request.setAttribute("listeDesClientsSimpleTodayPlus2", liste);
                    liste = gestionnaireClients.getClientsInSimpleTodayMoins1(date);
                    request.setAttribute("listeDesClientsSimpleTodayMoins1", liste);
                    liste = gestionnaireClients.getClientsInSimpleTodayMoins2(date);
                    request.setAttribute("listeDesClientsSimpleTodayMoins2", liste);
                    liste = gestionnaireClients.getClientsInSimpleTodayMoins3(date);
                    request.setAttribute("listeDesClientsSimpleTodayMoins3", liste);
                    
                    liste = gestionnaireClients.getClientsInZenToday(date);
                    request.setAttribute("listeDesClientsZenToday", liste);
                    liste = gestionnaireClients.getClientsInZenTodayPlus1(date);
                    request.setAttribute("listeDesClientsZenTodayPlus1", liste);
                    liste = gestionnaireClients.getClientsInZenTodayPlus2(date);
                    request.setAttribute("listeDesClientsZenTodayPlus2", liste);
                    liste = gestionnaireClients.getClientsInZenTodayMoins1(date);
                    request.setAttribute("listeDesClientsZenTodayMoins1", liste);
                    liste = gestionnaireClients.getClientsInZenTodayMoins2(date);
                    request.setAttribute("listeDesClientsZenTodayMoins2", liste);
                    liste = gestionnaireClients.getClientsInZenTodayMoins3(date);
                    request.setAttribute("listeDesClientsZenTodayMoins3", liste);
                    
                    liste = gestionnaireClients.getClientsInSwaziToday(date);
                    request.setAttribute("listeDesClientsSwaziToday", liste);
                    liste = gestionnaireClients.getClientsInSwaziTodayPlus1(date);
                    request.setAttribute("listeDesClientsSwaziTodayPlus1", liste);
                    liste = gestionnaireClients.getClientsInSwaziTodayPlus2(date);
                    request.setAttribute("listeDesClientsSwaziTodayPlus2", liste);
                    liste = gestionnaireClients.getClientsInSwaziTodayMoins1(date);
                    request.setAttribute("listeDesClientsSwaziTodayMoins1", liste);
                    liste = gestionnaireClients.getClientsInSwaziTodayMoins2(date);
                    request.setAttribute("listeDesClientsSwaziTodayMoins2", liste);
                    liste = gestionnaireClients.getClientsInSwaziTodayMoins3(date);
                    request.setAttribute("listeDesClientsSwaziTodayMoins3", liste);
                    
                    
                } catch (ParseException ex) {
                    Logger.getLogger(ServletAgenda.class.getName()).log(Level.SEVERE, null, ex);
                }
             } 
             else {  
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ServletAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
       
        
 

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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ServletAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
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
