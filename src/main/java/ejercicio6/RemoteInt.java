package ejercicio6;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemoteInt extends Remote{

	public int[] SumaV(int vector1[],int vector2[]) throws RemoteException;
	public int[] RestaV(int vector1[],int vector2[]) throws RemoteException;
}
