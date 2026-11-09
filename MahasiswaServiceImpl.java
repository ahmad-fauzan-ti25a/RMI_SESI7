package server;
import common.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.stream.Collectors;

public class MahasiswaServiceImpl extends UnicastRemoteObject implements MahasiswaService {
    private final List<Mahasiswa> data = Collections.synchronizedList(new ArrayList<>());

    public MahasiswaServiceImpl() throws RemoteException {
        data.add(new Mahasiswa("20250040089", "Ahmad Fauzan", "Informatika"));
        data.add(new Mahasiswa("20250040074", "Memey Meilani", "Informatika"));
        data.add(new Mahasiswa("20250040184", "Anastasia Charalita Lodang", "Informatika"));
    }

    public List<Mahasiswa> getAll() { synchronized (data) { return new ArrayList<>(data); } }

    public Mahasiswa cariByNim(String nim) {
        synchronized (data) {
            return data.stream().filter(m -> m.getNim().equals(nim)).findFirst().orElse(null);
        }
    }

    public List<Mahasiswa> cariByNama(String nama) {
        synchronized (data) {
            return data.stream()
                .filter(m -> m.getNama().toLowerCase().contains(nama.toLowerCase()))
                .collect(Collectors.toList());
        }
    }

    public boolean tambah(Mahasiswa m) {
        synchronized (data) {
            if (cariByNim(m.getNim()) != null) return false; // NIM duplikat
            return data.add(m);
        }
    }

    public boolean hapus(String nim) {
        synchronized (data) { return data.removeIf(m -> m.getNim().equals(nim)); }
    }

    public int jumlah() { return data.size(); }
}