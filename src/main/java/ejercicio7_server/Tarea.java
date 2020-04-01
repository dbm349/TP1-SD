package ejercicio7_server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Tarea<T> extends Remote {
	T ejecutar () throws RemoteException;
	
	
	//Clases que implementen Tarea deben ser serializables!
}
