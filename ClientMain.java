package client;
import common.*;
import java.rmi.Naming;
import java.util.List;

public class ClientMain {
    public static void main(String[] args) {
        try {
            MahasiswaService s =
                (MahasiswaService) Naming.lookup("rmi://localhost:1099/MahasiswaService");
            System.out.println("Koneksi berhasil!");
            List<Mahasiswa> list = s.getAll();
            for (Mahasiswa m : list)
                System.out.println(m.getNim() + " | " + m.getNama() + " | " + m.getJurusan());
            System.out.println("Jumlah mahasiswa: " + s.jumlah());
        } catch (Exception e) {
            System.out.println("Koneksi GAGAL: server RMI tidak dapat dihubungi. " + e.getMessage());
        }
    }
}