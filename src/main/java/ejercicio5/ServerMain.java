package ejercicio5;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain {

	
	 public static void main( String[] args ){
		 
		 try {
			 
			Registry serverRMI = LocateRegistry.createRegistry(9999);
			ServerImplement si=new ServerImplement();
		 
			RemoteInt servicioA =(RemoteInt) UnicastRemoteObject.exportObject(si, 8000);
			
			serverRMI.rebind("VerClima", servicioA);
			
			System.out.println("Servidor corriendo");
			
		 } catch (RemoteException e) {
			e.printStackTrace();
		}
	        
		 
		 
		 
		 
		 
	    }
	
}
