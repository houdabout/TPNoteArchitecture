package com;

import java.sql.*;

public class Voiture {

    private String plaque;
    private String marque;
    private String serie;
    private int proprietaire;

    public Voiture() {
    }

    public Voiture(String plaque, String marque, String serie, int proprietaire) {
        this.plaque = plaque;
        this.marque = marque;
        this.serie = serie;
        this.proprietaire = proprietaire;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(int proprietaire) {
        this.proprietaire = proprietaire;
    }

    public static Voiture find(String plaque) throws SQLException {
        Voiture voiture = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex1) {
            System.out.println("Pilote non trouvee!");
            System.exit(1);
        }
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/parking", "root", "");
        PreparedStatement ps = c.prepareStatement("SELECT plaque, marque, serie, proprietaire FROM Voiture WHERE plaque=?;");
        ps.setString(1, plaque);
        ResultSet set = ps.executeQuery();
        if (set.next()) {
            voiture = new Voiture(set.getString(1), set.getString(2),
                    set.getString(3), set.getInt(4));
        }
        set.close();
        ps.close();
        c.close();
        return voiture;
    }
}
