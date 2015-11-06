package cliente;

import servidor.*;
import java.util.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;

class ClienteChat {
    static public void main (String args[]) {
       String host = "localhost";
       int puerto = 54321 ;
       String apodo = "Christian";
       if (System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());

        try {
            //LocateRegistry.createRegistry(puerto);
            ServicioChat srv = (ServicioChat) Naming.lookup("//" + host + ":" + puerto + "/Chat");
            ClienteImpl c = new ClienteImpl();
            srv.alta(c);
            Scanner ent = new Scanner(System.in);
            System.out.print(apodo + "> ");
            while (ent.hasNextLine()) {
                srv.envio(c, apodo, ent.nextLine());
                System.out.print(apodo + "> ");
            }
            srv.baja(c);
            System.exit(0);
        }
        catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
        }
        catch (Exception e) {
            System.err.println("Excepcion en ClienteChat:");
            e.printStackTrace();
        }
    }
}
