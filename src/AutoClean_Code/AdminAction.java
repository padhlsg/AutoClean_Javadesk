/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AutoClean_Code;

/**
 *
    * @author MyBook Hype AMD
 */



public interface AdminAction {
    void editBooking(String noTelp);
    void deleteBooking(String noTelp);
    void updateStatus(String noTelp, String status);

    // default method
    default void refreshTable(AutoClean_Form.AdminDashboard dashboard) {
        dashboard.refreshTable();
    }

    // static method
    static void showMessage(String msg) {
        javax.swing.JOptionPane.showMessageDialog(null, msg);
    }
}
