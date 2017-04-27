package com.model;
/**
 * Created with magic
 * User: elmoutaraji mohammed et houda boutbib
 * Date: 27/04/2017 19:14
 * Project: TPNoteArchitecture
 */
import java.sql.*;

public class Voiture {

    private String plaque;
    private String marque;
    private String serie;
    private int proprietaire;

    /**
     * default constructor
     */
    public Voiture() {
    }

    /**
     *@param plaque marque serie proprietaire
     */
    public Voiture(String plaque, String marque, String serie, int proprietaire) {
        this.plaque = plaque;
        this.marque = marque;
        this.serie = serie;
        this.proprietaire = proprietaire;
    }

    /**
     * @return plaque
     */
    public String getPlaque() {
        return plaque;
    }

    /**
     * @param plaque
     */
    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    /**
     * @return marque
     */
    public String getMarque() {
        return marque;
    }

    /**
     * @param marque
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }
    /**
     * @return serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * @return proprio
     */
    public int getProprietaire() {
        return proprietaire;
    }

    /**
     * @param proprio
     */
    public void setProprietaire(int proprietaire) {
        this.proprietaire = proprietaire;
    }

    /**
     * verifier plaque 
     */
    public static Voiture find(String plaque) throws SQLException {
        Voiture voiture = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex1) {
            System.out.println("Pilote non trouvee!");
            System.exit(1);
        }
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/parking", "root", "");
        PreparedStatement ps = c.prepareStatement("SELECT plaque, marque, serie, idProp FROM Voiture WHERE plaque=?;");
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
