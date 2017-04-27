package com.model;
/**
 * Created with magic
 * User: elmoutaraji mohammed et houda boutbib
 * Date: 27/04/2017 19:14
 * Project: TPNoteArchitecture
 */
import java.sql.*;

public class Proprietaire {

    private int id;
    private String nom;
    private String prenom;
    private int age;

    /**
     * default constructor
     */
    public Proprietaire() {
    }

    /**
     * @param id nom prenom age
     * consructor
     */
    public Proprietaire(int id, String nom, String prenom, int age) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    /**
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * get informations from proprietaire
     */
    public static Proprietaire find(int id) throws SQLException {
        Proprietaire proprietaire = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex1) {
            System.out.println("Pilote non trouvee!");
            System.exit(1);
        }
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/parking", "root", "");
        PreparedStatement ps = c.prepareStatement("SELECT id, nom, prenom, age FROM Proprietaire WHERE id=?;");
        ps.setInt(1, id);
        ResultSet set = ps.executeQuery();
        if (set.next()) {
            proprietaire = new Proprietaire(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4));
        }
        set.close();
        ps.close();
        c.close();
        return proprietaire;
    }
}
