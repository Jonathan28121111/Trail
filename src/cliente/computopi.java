package cliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.math.BigDecimal;
import computo.computo;

public class computopi {
    public static void main(String args[]) {
        try {
            String name = "computo";
            String host = args[0];
            int port = Integer.parseInt(args[1]);
            Registry registry = LocateRegistry.getRegistry(host, port);
            computo comp = (computo) registry.lookup(name);
            Pi task = new Pi(Integer.parseInt(args[2]));
            BigDecimal pi = comp.executeTask(task);
            System.out.println(pi);
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error en el cliente");
            e.printStackTrace();
        }
    }    
}