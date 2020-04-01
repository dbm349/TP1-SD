package ejercicio7_cliente;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ejercicio7_server.Calcular;

public class CalcularPi {
	int port;
	int decimales;
	
	public CalcularPi (int port, int decimales) {
		super();
		this.port = port;
		this.decimales = decimales;
	}
		
	public void calculo (){
		try {
			//Mismo nombre que en Procesador
	       	String nombre = "Calcular";
	            
	        //Registro permite a los clientes obtener por referencia objetos remotos usando su nombre
	        Registry registro = LocateRegistry.getRegistry(port);
	        Calcular calc = (Calcular) registro.lookup(nombre);
	          
	        Pi tarea = new Pi(decimales);
	        BigDecimal pi = calc.calcularTarea(tarea);
	           
	        System.out.println(pi);
		} catch (Exception e) {
			System.err.println("Error de CalcularPi:");
			e.printStackTrace();
	    }
	}
}    

