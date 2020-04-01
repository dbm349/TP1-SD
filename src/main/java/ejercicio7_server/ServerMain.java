package ejercicio7_server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain implements Calcular {

    public ServerMain() {
        super();
    }

    public <T> T calcularTarea(Tarea<T> t) {
        try {
			return t.ejecutar();
		} catch (RemoteException e) {
			System.err.println("Fallo al ejecutar tarea");
			e.printStackTrace();
		}
		return null;
	}

    public static void main(String[] args) {
    	
    	try {
    		 //Registro permite a los clientes obtener por referencia objetos remotos usando su nombre 
            Registry registro = LocateRegistry.createRegistry(15236);
            
            
    		//Mismo nombre que en cada Tarea individual
        	String nombre = "Calcular";
            Calcular procesador = new ServerMain();
            
            
            //Exporta el objeto dado para poder recibir llamadas de clientes remotos
            //0 es el puerto TCP a usar. 0 hace que el sistema operativo o el RMI decida en runtime
            Calcular stub = (Calcular) UnicastRemoteObject.exportObject(procesador, 0);
            
            registro.rebind(nombre, stub);
	        System.out.println("Hecho el bind del Procesador");
	        
	        
	        //Para cerrar registro
	        /*
	        if (registro != null) {
                UnicastRemoteObject.unexportObject(registro, true);
	        }
	        */
	    } catch (Exception e) {
	    	System.err.println("Error de Procesador: ");
	        e.printStackTrace();
	        
                
	    }
    }
}

