package com.controller;

import com.model.Operateur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String pass = request.getParameter("password");

        Operateur op = new Operateur(username);

        try {
            if (op.checkPassword(pass)) {
                session.setAttribute("operateur", op);
                session.setAttribute("authenticated", true);
                forward(request, response, "/operateur/Acces.jsp");
            } else {
                session.setAttribute("authenticated", false);
                request.setAttribute("error", "Login did not work");
                forward(request, response, "/Error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void forward(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(page);
        rd.forward(request, response);
    }
}
