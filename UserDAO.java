/*
 * Main.java
 * this is the main class
 * Author M.Zaihd Behardien(219233829)
 * 23 August 2022
 */
package za.ac.cput.adploginapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author zaihd
 */
public class UserDAO {
    private static final String DATABASE_URL = "jdbc:derby://localhost:1527/UserReg";
    private static final String DB_USERNAME = "administrator";
    private static final String DB_PASSWORD = "password";

    public static boolean authentication(User user) {
        boolean valid = true;

        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM UserRegistation WHERE email = ? AND password = ?";

        try {
            con = DriverManager.getConnection(DATABASE_URL, DB_USERNAME, DB_PASSWORD);

            statement = con.prepareStatement(sql);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());

            rs = statement.executeQuery();
            if (rs.next()) {
                user.set(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            } else {
                valid = false;
            }
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error: " + sqlException.getMessage());
        } catch (Exception e) {
            // Handle any other exceptions if needed
        } finally {
            // Close resources in a finally block
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqlException) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + sqlException.getMessage());
            }
        }

        return valid;
    }
}
