package com.login;

import com.Operateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
                response.sendRedirect("Acces.jsp");
            } else {
                session.setAttribute("authenticated", false);
                response.sendRedirect("login.jsp?error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
