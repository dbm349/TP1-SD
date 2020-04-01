package ejercicio7_server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calcular extends Remote {
	<T> T calcularTarea(Tarea<T> t) throws RemoteException;
}
