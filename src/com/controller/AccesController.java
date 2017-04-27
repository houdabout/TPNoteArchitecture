package com.controller;

import com.model.Acces;
import com.model.Operateur;
import com.model.Proprietaire;
import com.model.Voiture;

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
 * Created with magic
 * User: elmoutaraji mohammed et houda boutbib
 * Date: 27/04/2017 19:14
 * Project: TPNoteArchitecture
 */

/**
 * Servlet implementation class AccesController
 */

@MultipartConfig(maxFileSize = 16177215)
public class AccesController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccesController() {
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
            Acces acces = new Acces(plaque, date, operateur.getUsername(), null);
            try {
                int id = acces.insertAcces(filecontent);
                request.setAttribute("accesID", id);
                request.setAttribute("plaque", plaque);
                request.setAttribute("operateur", operateur.getUsername());
                Voiture voiture = Voiture.find(plaque);
                request.setAttribute("marque", voiture.getMarque());
                request.setAttribute("serie", voiture.getSerie());
                Proprietaire proprietaire = Proprietaire.find(voiture.getProprietaire());
                request.setAttribute("nom", proprietaire.getNom());
                request.setAttribute("prenom", proprietaire.getPrenom());
                request.setAttribute("age", proprietaire.getAge());
                forward(request, response, "/operateur/Result.jsp");

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
