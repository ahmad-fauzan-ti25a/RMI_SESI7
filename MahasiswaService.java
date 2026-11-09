package common;
import java.rmi.*;
import java.util.List;

public interface MahasiswaService extends Remote {
    List<Mahasiswa> getAll() throws RemoteException;
    Mahasiswa cariByNim(String nim) throws RemoteException;
    List<Mahasiswa> cariByNama(String nama) throws RemoteException;
    boolean tambah(Mahasiswa m) throws RemoteException;
    boolean hapus(String nim) throws RemoteException;
    int jumlah() throws RemoteException;
}