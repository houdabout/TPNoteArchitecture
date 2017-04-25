package com;

import java.sql.*;

public class Operateur {

    private String username;

    public Operateur(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean checkPassword(String password) throws SQLException {
        boolean valid;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex1) {
            System.out.println("Pilote non trouvee!");
            System.exit(1);
        }
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpnote", "root", "");
        PreparedStatement ps = c.prepareStatement("SELECT op FROM Operateur op WHERE username=? AND password=?;");
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
