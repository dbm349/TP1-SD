package ejercicio6;

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
			
			serverRMI.rebind("Operaciones", servicioA);
		 	 
			System.out.println("Servidor corriendo");
			System.out.println();
			
			 
		 
		 } catch (RemoteException e) {
			e.printStackTrace();
		}
			
	 
	 
	 
	 
	 }
	 
}
