package com.model;

/**
 * Created with magic
 * User: elmoutaraji mohammed et houda boutbib
 * Date: 27/04/2017 19:14
 * Project: TPNoteArchitecture
 */
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;

public class Acces {

    int id;
    private String plaque;
    private Date date;
    private String operateur;
    private Blob image;

    /**
     * @param plaque date operateur image
     * constructor
     */
    public Acces(String plaque, Date date, String operateur, Blob image) {
        this.plaque = plaque;
        this.date = date;
        this.operateur = operateur;
        this.image = image;
    }

    /**
     * default constructor
     */
    public Acces() {
    }

     /**
     *@return plaque
     */
    public String getPlaque() {
        return plaque;
    }

    /**
     *@param plaque
     */
    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    /**
     *@return date
     */
    public Date getDate() {
        return date;
    }

    /**
     *@param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *@return operateur
     */
    public String getOperateur() {
        return operateur;
    }

    /**
     *@param operateur
     */
    public void setOperateur(String operateur) {
        this.operateur = operateur;
    }

    /**
     *@return image
     */
    public Blob getImage() {
        return image;
    }

    /**
     *@param image
     */
    public void setImage(Blob image) {
        this.image = image;
    }

    /**
     *@return id
     */
    public int getId() {
        return id;
    }

    /**
     *@rparam id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *save access
     */
    public int insertAcces(InputStream image) throws SQLException {
        int id;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex1) {
            System.out.println("Pilote non trouvee!");
            System.exit(1);
        }
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/parking", "root", "");
        //
        PreparedStatement ps = c.prepareStatement("INSERT INTO ACCES(plaque, date, operateur, image) VALUES (?,?,?,?);");
        ps.setString(1, plaque);
        ps.setDate(2, new java.sql.Date(date.getTime()));
        ps.setString(3, operateur);
        ps.setBlob(4, image);
        ps.executeUpdate();
        ps.close();
        //
        PreparedStatement preparedStatement = c.prepareStatement("SELECT LAST_INSERT_ID();");
        ResultSet set = preparedStatement.executeQuery();
        if (set.next()) {
            id = set.getInt(1);
        } else {
            id = -1;
        }
        set.close();
        preparedStatement.close();
        c.close();
        return id;
    }

    public static Acces find(int id) throws SQLException {
        Acces acces = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex1) {
            System.out.println("Pilote non trouvee!");
            System.exit(1);
        }
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/parking", "root", "");
        PreparedStatement ps = c.prepareStatement("SELECT plaque, date, operateur, image FROM Acces WHERE id=?;");
        ps.setInt(1, id);
        ResultSet set = ps.executeQuery();
        if (set.next()) {
            acces = new Acces(set.getString(1), set.getDate(2), set.getString(3), set.getBlob(4));
        }
        set.close();
        ps.close();
        c.close();
        return acces;
    }
    /**
     *trouver les acces entre deux date
     */

    public static List<Acces> findBetweenDates(Date date1, Date date2) throws SQLException {
        List<Acces> accesList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex1) {
            System.out.println("Pilote non trouvee!");
            System.exit(1);
        }
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/parking", "root", "");
        PreparedStatement ps = c.prepareStatement("SELECT id, plaque, date, operateur, image FROM Acces WHERE date BETWEEN ? AND ?;");
        ps.setDate(1, new java.sql.Date(date1.getTime()));
        ps.setDate(2, new java.sql.Date(date2.getTime()));
        ResultSet set = ps.executeQuery();
        while (set.next()) {
            Acces acces = new Acces(set.getString(2), set.getDate(3),
                    set.getString(4), set.getBlob(5));

            acces.setId(set.getInt(1));
            accesList.add(acces);
        }
        set.close();
        ps.close();
        c.close();
        return accesList;
    }
}
