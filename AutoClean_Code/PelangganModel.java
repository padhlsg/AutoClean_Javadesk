/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AutoClean_Code;

/**
 *
 * @author Fadhil
 */
public abstract class PelangganModel extends User implements UserAction {
    private String tipeKendaraan;
    private String merkKendaraan;
    private String platNomor;
    private String opsiCuci;
    private String jadwalCuci;

    public PelangganModel(String username, String nomorTelepon,
                          String tipeKendaraan, String merkKendaraan,
                          String platNomor, String opsiCuci, String jadwalCuci) {
        super(username, nomorTelepon); // panggil constructor User
        this.tipeKendaraan = tipeKendaraan;
        this.merkKendaraan = merkKendaraan;
        this.platNomor = platNomor;
        this.opsiCuci = opsiCuci;
        this.jadwalCuci = jadwalCuci;
    }

    // Override dari User
    @Override
    public void tampilkanInfo() {
        System.out.println("=== Data Pelanggan ===");
        System.out.println("Username       : " + getUsername()); 
        System.out.println("No. Telepon    : " + getNomorTelepon());
        System.out.println("Tipe Kendaraan : " + tipeKendaraan);
        System.out.println("Merk Kendaraan : " + merkKendaraan);
        System.out.println("Plat Nomor     : " + platNomor);
        System.out.println("Opsi Cuci      : " + opsiCuci);
        System.out.println("Jadwal Cuci    : " + jadwalCuci);
    }

    // Implementasi dari interface UserAction
    // Getter untuk akses dari Pelanggan.java (DB insert)
    
    
    public String getTipeKendaraan() {
        return tipeKendaraan;
    }

    public String getMerkKendaraan() {
        return merkKendaraan;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public String getOpsiCuci() {
        return opsiCuci;
    }

    public String getJadwalCuci() {
        return jadwalCuci;
    }
}
