package com;

import java.sql.*;

public class Proprietaire {

    private int id;
    private String nom;
    private String prenom;
    private int age;

    public Proprietaire(int id, String nom, String prenom, int age) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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
