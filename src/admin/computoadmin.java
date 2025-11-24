package admin;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import computo.computo;
import computo.Task;

public class computoadmin implements computo {

    public computoadmin() {
        super();
    }

    public <T> T executeTask(Task<T> t) {
        return t.execute();
    }

    public static void main(String[] args) {
        try {
            String name = "computo";
            computo admin = new computoadmin();
            computo stub =
                (computo) UnicastRemoteObject.exportObject(admin, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("admin listo");
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error");
            e.printStackTrace();
        }
    }
}