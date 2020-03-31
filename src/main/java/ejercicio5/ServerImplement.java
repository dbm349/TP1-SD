package ejercicio5;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;

public class ServerImplement implements RemoteInt{

	public String mostrarClima() throws RemoteException {
		
		ArrayList<String> clima = new ArrayList<String>();
		
		clima.add("Tropical");
		clima.add("Árido");
		clima.add("Templado");
		clima.add("Frio");
		clima.add("Continental");
		
		Random aleatorio = new Random();
		String c =clima.get(aleatorio.nextInt(clima.size()));
		return c;
	}
	
	

}
