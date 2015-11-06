import CalculadoraApp.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

class CalculadoraImpl extends CalculadoraPOA {
  private ORB orb;

  public void setORB(ORB orb_val) {
    orb = orb_val; 
  }
  
  public double add ( double x , double y ){
    return x + y ;
  }

  public double substract ( double x , double y ){
    return x - y ;
  }

  public double multiply ( double x , double y ){
    return x * y ;
  }  
  public void shutdown() {
    orb.shutdown(false);
  }
}

public class CalculadoraServer {

  public static void main(String args[]) {
    try{
      ORB orb = ORB.init(args, null);

      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();

      CalculadoraImpl opImpl = new CalculadoraImpl ();
      opImpl.setORB(orb); 

      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(opImpl);
      Calculadora href = CalculadoraHelper.narrow(ref);
      
      org.omg.CORBA.Object objRef =orb.resolve_initial_references("NameService");
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

      String name = "Calculadora";
      NameComponent path[] = ncRef.to_name( name );
      ncRef.rebind(path, href);

      System.out.println("Servidor listo y a la espera de conexiones ...");
   
      orb.run();
    } 
        
      catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }
          
      System.out.println("Servidor apagandose ...");
        
  }
}