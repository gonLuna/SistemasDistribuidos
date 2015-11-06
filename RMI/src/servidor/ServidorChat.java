package servidor;


import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;

class ServidorChat  {
    static public void main (String args[]) {
        int puerto = 54321 ;
        
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            //System.setProperty("java.security.policy","file:./servidor.permisos");
            //LocateRegistry.createRegistry(puerto);
            ServicioChatImpl srv = new ServicioChatImpl();
            Naming.rebind("rmi://localhost:" + puerto + "/Chat", srv);
        }
        catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
            System.exit(1);
        }
        catch (Exception e) {
            System.err.println("Excepcion en ServidorChat:");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
