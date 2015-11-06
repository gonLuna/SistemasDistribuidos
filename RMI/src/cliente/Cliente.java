package cliente;



import java.rmi.*;

public interface Cliente extends Remote {
    void notificacion(String apodo, String m) throws RemoteException;
}
