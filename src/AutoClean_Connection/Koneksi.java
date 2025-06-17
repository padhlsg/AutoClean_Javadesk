/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AutoClean_Connection;

/**
 *
 * @author MyBook Hype AMD
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/autoclean_javadesk";
            String user = "root";
            String password = ""; // Ganti jika kamu punya password MySQL

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi ke data base berhasil!");
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        connect(); // Untuk uji coba koneksi
    }
}
