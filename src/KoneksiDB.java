
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ni Kadek Dwi Pratiwi
 * Nim : 2201010051
 * Kelas : U
 * UAS OOP
 */
public class KoneksiDB {
    public static Connection setKoneksi() throws SQLException {
        String konString = "jdbc:mysql://localhost:3306/go_grab";
        Connection koneksi = null;
        try {
            // Tidak perlu lagi memuat driver secara manual
            koneksi = (Connection) DriverManager.getConnection(konString, "root", "");
            System.out.println("Koneksi Berhasil");
        } catch (SQLException ex) {
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Koneksi Gagal");  
        }
        return koneksi;
    }
    
    public static int execute(String SQL) throws SQLException {
        int status = 0;
        Connection koneksi = setKoneksi();
        try {
            Statement st = koneksi.createStatement();
            status = st.executeUpdate(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    public static ResultSet executeQuery(String SQL) throws SQLException {
        ResultSet rs = null;
        Connection koneksi = setKoneksi();
        try {
            Statement st = koneksi.createStatement();
            rs = st.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}

