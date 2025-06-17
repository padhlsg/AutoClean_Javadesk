/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AutoClean_Code;

/**
 *
 * @author Fadhil
 */
public class User {
    private String nama;
    private String nomorTelepon;

    public User(String nama, String nomorTelepon) {
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public void tampilkanInfo() {
        System.out.println("User: " + nama + ", Telepon: " + nomorTelepon);
    }
}
