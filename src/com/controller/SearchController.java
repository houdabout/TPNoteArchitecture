package com.controller;

import com.model.Acces;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date1 = format.parse(request.getParameter("date1"));
            Date date2 = format.parse(request.getParameter("date2"));
            List<Acces> accesList = Acces.findBetweenDates(date1, date2);
            request.setAttribute("accesList", accesList);
            System.out.println("waaaaaaayli : " + accesList.size());
            forward(request, response, "/operateur/listeacces.jsp");
        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void forward(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(page);
        rd.forward(request, response);
    }
}
