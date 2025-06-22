/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package AutoClean_Code;
import AutoClean_Connection.Koneksi;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Fahriel
 */

public class AdminDashboard extends javax.swing.JFrame implements UserAction {


    private DefaultTableModel tableModel;

    public AdminDashboard() {
        initComponents();
        tableModel = (DefaultTableModel) tablePemesanan.getModel();
        reloadTable();
    }
    
    public class Pemesanan {
    private String noTelp;
    private String tipeKendaraan;

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getTipeKendaraan() {
        return tipeKendaraan;
    }

    public void setTipeKendaraan(String tipeKendaraan) {
        this.tipeKendaraan = tipeKendaraan;
    }
}

    private void initComponents() {
        jScrollPane1 = new JScrollPane();
        tablePemesanan = new JTable();
        btnEdit = new JButton("Edit");
        btnDelete = new JButton("Delete");
        btnReload = new JButton("Muat Ulang");
        btnBack = new JButton("Kembali");
        labelTitle = new JLabel("RIWAYAT PEMESANAN");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Dashboard");
        getContentPane().setLayout(null);

        labelTitle.setFont(new java.awt.Font("Segoe UI", 1, 18));
        labelTitle.setBounds(30, 20, 300, 30);
        getContentPane().add(labelTitle);

        tablePemesanan.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "No", "No Telp", "Tipe Kendaraan", "Merk Kendaraan", "Plat Kendaraan", "Opsi Pencucian", "Jadwal Cuci", "Status"
            }
        ));
        jScrollPane1.setViewportView(tablePemesanan);
        jScrollPane1.setBounds(30, 70, 800, 350);
        getContentPane().add(jScrollPane1);

        btnEdit.setBounds(30, 440, 100, 25);
        btnEdit.addActionListener(e -> editSelectedRow());
        getContentPane().add(btnEdit);

        btnDelete.setBounds(140, 440, 100, 25);
        btnDelete.addActionListener(e -> deleteSelectedRow());
        getContentPane().add(btnDelete);

        btnReload.setBounds(250, 440, 120, 25);
        btnReload.addActionListener(e -> reloadTable());
        getContentPane().add(btnReload);

        btnBack.setBounds(730, 20, 100, 25);
        btnBack.addActionListener(e -> this.dispose());
        getContentPane().add(btnBack);

        setSize(880, 540);
        setLocationRelativeTo(null);
    }

    private void reloadTable() {
        tableModel.setRowCount(0);
        try (Connection conn = Koneksi.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM pemesanan")) {
            int no = 1;
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    no++,
                    rs.getString("no_telp"),
                    rs.getString("tipe_kendaraan"),
                    rs.getString("merk_kendaraan"),
                    rs.getString("plat_kendaraan"),
                    rs.getString("opsi_pencucian"),
                    rs.getString("jadwal_cuci"),
                    rs.getString("status")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage());
        }
    }

    private void deleteSelectedRow() {
        int row = tablePemesanan.getSelectedRow();
        if (row != -1) {
            String plat = tableModel.getValueAt(row, 4).toString();
            int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus?", "Hapus", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try (Connection conn = Koneksi.getConnection();
                     PreparedStatement ps = conn.prepareStatement("DELETE FROM pemesanan WHERE plat_kendaraan = ?")) {
                    ps.setString(1, plat);
                    ps.executeUpdate();
                    reloadTable();
                    JOptionPane.showMessageDialog(this, "Berhasil dihapus!");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Gagal hapus: " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris terlebih dahulu.");
        }
    }

    private void editSelectedRow() {
        int row = tablePemesanan.getSelectedRow();
        if (row != -1) {
            String plat = tableModel.getValueAt(row, 4).toString();
            String noTelp = JOptionPane.showInputDialog(this, "Ubah No Telp", tableModel.getValueAt(row, 1));
            if (noTelp != null && !noTelp.isEmpty()) {
                try (Connection conn = Koneksi.getConnection();
                     PreparedStatement ps = conn.prepareStatement("UPDATE pemesanan SET no_telp = ? WHERE plat_kendaraan = ?")) {
                    ps.setString(1, noTelp);
                    ps.setString(2, plat);
                    ps.executeUpdate();
                    reloadTable();
                    JOptionPane.showMessageDialog(this, "Data berhasil diubah.");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Gagal mengubah: " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris terlebih dahulu.");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new AdminDashboard().setVisible(true));
    }

    // Variables declaration
    private JButton btnBack, btnDelete, btnEdit, btnReload;
    private JScrollPane jScrollPane1;
    private JLabel labelTitle;
    private JTable tablePemesanan;

    @Override
    public void login() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
