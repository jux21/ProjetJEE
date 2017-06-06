/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Utilisateur
 */
public class ServletLogout extends HttpServlet {
    
    protected void doGet(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.setContentType("text/html");
        ServletOutputStream out =
          response.getOutputStream();
        out.println("<html><head>");
        out.println("<title>Logout</title></head>");
        out.println("<body>");
        out.println("<h1>Logout successfull.</h1>");
        out.println("</body></html>");
  }

    
}
