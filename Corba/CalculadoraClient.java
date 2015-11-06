import CalculadoraApp.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import java.util.Scanner;

public class CalculadoraClient
{
  static Calculadora opImpl;

  public static void main(String args[])
    {
      try{
        ORB orb = ORB.init(args, null);

        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
 
        String name = "Calculadora";
        opImpl = CalculadoraHelper.narrow(ncRef.resolve_str(name));

	Scanner scan = new Scanner(System.in);
            
        System.out.println("Ingrese el primer parámetro: ");
        double a = scan.nextDouble();
        System.out.println("Ingrese el segundo parámetro: ");
        double b = scan.nextDouble();

        System.out.println(opImpl.add(a,b));
	System.out.println(opImpl.substract(a,b));
	System.out.println(opImpl.multiply(a,b));
        opImpl.shutdown();

        } catch (Exception e) {
          System.out.println("ERROR : " + e) ;
          e.printStackTrace(System.out);
          }
    }

}