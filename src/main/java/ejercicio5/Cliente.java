package ejercicio5;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {

	 public static void main( String[] args ){
		 
		 
		try {
			Registry ClienteRMI = LocateRegistry.getRegistry("127.0.0.1", 9999);
			String[] services=ClienteRMI.list();//me trae los servicios
			
			for (String service : services) {
				
				System.out.println("Servicio: " +service);
				
			}
			
			
			RemoteInt ri= (RemoteInt) ClienteRMI.lookup("VerClima");//quiero crear un objeto de uno de esos servicios
			
			System.out.println("El clima es: "+ri.mostrarClima());
			
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        
	    }
	
	
}
