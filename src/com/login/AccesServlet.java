package com.login;

import com.Acces;
import com.Operateur;
import com.Proprietaire;
import com.Voiture;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;

/**
 * Servlet implementation class AccesServlet
 */

@MultipartConfig(maxFileSize = 16177215)
public class AccesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccesServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Part imagePart = request.getPart("img");
        String plaque = request.getParameter("plaque");
        Date date = new Date();
        Operateur operateur = (Operateur) session.getAttribute("operateur");
        if (imagePart != null && plaque != null) {
            InputStream filecontent = null;
            filecontent = imagePart.getInputStream();
            Acces acces = new Acces(plaque, date, operateur.getUsername(), filecontent);
            try {
                acces.insertAcces();
                request.setAttribute("acces", acces);
                Voiture voiture = Voiture.find(plaque);
                request.setAttribute("voiture", voiture);
                Proprietaire proprietaire = Proprietaire.find(voiture.getProprietaire());
                request.setAttribute("proprietaire", proprietaire);
                forward(request, response, "/Result.jsp");

            } catch (SQLException e) {
                request.setAttribute("error", e.getMessage());
                forward(request, response, "/Error.jsp");
            }
        } else {
            request.setAttribute("error", "image or plaque is null");
            forward(request, response, "/Error.jsp");
        }
    }

    private void forward(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(page);
        rd.forward(request, response);
    }
}
