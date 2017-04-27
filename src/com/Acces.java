package com;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Acces {

    private String plaque;
    private Date date;
    private String operateur;
    private InputStream image;

    public Acces(String plaque, Date date, String operateur, InputStream image) {
        this.plaque = plaque;
        this.date = date;
        this.operateur = operateur;
        this.image = image;
    }

    public Acces() {
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOperateur() {
        return operateur;
    }

    public void setOperateur(String operateur) {
        this.operateur = operateur;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }

    public void insertAcces() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex1) {
            System.out.println("Pilote non trouvee!");
            System.exit(1);
        }
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/parking", "root", "");
        PreparedStatement ps = c.prepareStatement("INSERT INTO ACCES(plaque, date, operateur, image) VALUES (?,?,?,?);");
        ps.setString(1, plaque);
        ps.setDate(2, new java.sql.Date(date.getTime()));
        ps.setString(3, operateur);
        ps.setBlob(4, image);
        ps.executeUpdate();
        ps.close();
        c.close();
    }

}
