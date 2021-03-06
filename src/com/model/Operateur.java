package com.model;

/**
 * Created with magic
 * User: elmoutaraji mohammed et houda boutbib
 * Date: 27/04/2017 19:14
 * Project: TPNoteArchitecture
 */
import java.sql.*;


public class Operateur {

    private String username;


    /**
     * @param username
     * constructor
     */
    public Operateur(String username) {
        this.username = username;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * verifier mot de passe 
     */
    public boolean checkPassword(String password) throws SQLException {
        boolean valid;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex1) {
            System.out.println("Pilote non trouvee!");
            System.exit(1);
        }
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/parking", "root", "");
        PreparedStatement ps = c.prepareStatement("SELECT * FROM Operateur WHERE username=? AND password=?;");
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet set = ps.executeQuery();
        valid = set.next();
        set.close();
        ps.close();
        c.close();
        return valid;
    }
}
