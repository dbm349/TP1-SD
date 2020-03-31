package ejercicio5;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInt extends Remote{
	
	public String mostrarClima() throws RemoteException;

}
