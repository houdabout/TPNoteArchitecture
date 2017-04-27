package com.controller;

import com.model.Acces;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

/**
 * Created with magic
 * User: elmoutaraji mohammed et houda boutbib
 * Date: 27/04/2017 19:14
 * Project: TPNoteArchitecture
 */
public class ImageController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            Acces acces = Acces.find(Integer.parseInt(id));
            Blob image = acces.getImage();
            byte byteArray[] = image.getBytes(1, (int) image.length());

            response.setContentType("image/gif");
            OutputStream os = response.getOutputStream();
            os.write(byteArray);
            os.flush();
            os.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
