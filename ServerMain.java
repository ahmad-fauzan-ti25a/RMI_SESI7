package server;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerMain {
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1099);
        Naming.rebind("rmi://localhost:1099/MahasiswaService", new MahasiswaServiceImpl());
        System.out.println("RMI Server aktif di port 1099...");
    }
}