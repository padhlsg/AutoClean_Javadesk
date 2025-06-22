/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AutoClean_Code;

/**
 *
    * @author MyBook Hype AMD
 */

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;


public interface AdminAction {

    // abstract method (WAJIB diimplement di AdminDashboard)
    void editBooking(String noTelp);
    void deleteBooking(String noTelp);
    void updateStatus(String noTelp, String status);

    // DEFAULT METHOD (boleh dipakai, ga wajib di-override)
    default void refreshTable(JTable table) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/autoclean_javadesk", "root", "");
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM pelanggan";
            ResultSet rs = stmt.executeQuery(sql);

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // clear table

            int no = 1;
            while (rs.next()) {
                Object[] row = {
                    no++,
                    rs.getString("username"),
                    rs.getString("no_telp"),
                    rs.getString("tipe_kendaraan"),
                    rs.getString("merk_kendaraan"),
                    rs.getString("plat_kendaraan"),
                    rs.getString("opsi_pencucian"),
                    rs.getString("jadwal_cuci"),
                    rs.getString("status")
                };
                model.addRow(row);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            showMessage("Error: " + e.getMessage());
        }
    }

    // STATIC METHOD (tinggal dipanggil AdminAction.showMessage("...");
    static void showMessage(String msg) {
        javax.swing.JOptionPane.showMessageDialog(null, msg);
    }
}
