package cliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.math.BigDecimal;
import computo.computo;

public class computopi {
    public static void main(String args[]) {
        // Security Manager ya no es necesario en Java moderno
        try {
            String name = "computo";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            computo comp = (computo) registry.lookup(name);
            Pi task = new Pi(Integer.parseInt(args[1]));
            BigDecimal pi = comp.executeTask(task);
            System.out.println(pi);
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error en el cliente");
            e.printStackTrace();
        }
    }    
}