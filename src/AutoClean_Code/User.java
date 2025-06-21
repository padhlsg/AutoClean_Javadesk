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
    private String username;     
    private String nomorTelepon;

    public User(String username, String nomorTelepon) {
        this.username = username;
        this.nomorTelepon = nomorTelepon;
    }

    public String getUsername() {    
        return username;
    }

    public void setUsername(String username) {  
        this.username = username;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public void tampilkanInfo() {
        System.out.println("Username: " + username);
        System.out.println("Telepon: " + nomorTelepon);
    }
}
