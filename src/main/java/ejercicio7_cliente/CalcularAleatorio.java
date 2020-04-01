package ejercicio7_cliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ejercicio7_server.Calcular;

public class CalcularAleatorio {
	int port;
	int cotaSuperior;
	int decimales;
	boolean negativos;

	public CalcularAleatorio (int port, int cotaSuperior, int decimales, boolean negativos) {
		super();
		this.port = port;
		this.cotaSuperior = cotaSuperior;
		this.decimales = decimales;
		this.negativos = negativos;
	}
	
	public void calculo (){
        try {
            //Mismo nombre que en Procesador
        	String nombre = "Calcular";
            
            //Registro permite a los clientes obtener por referencia objetos remotos usando su nombre
            Registry registro = LocateRegistry.getRegistry(port);
            Calcular calc = (Calcular) registro.lookup(nombre);
            
            Aleatorio tarea = new Aleatorio(cotaSuperior, decimales, negativos);
            double aleatorio = calc.calcularTarea(tarea);
                       
            if (decimales == 0) { 
            	System.out.println((int) aleatorio);
            } else {
            	System.out.println(aleatorio);
            }
            
        } catch (Exception e) {
            System.err.println("Error de CalcularAleatorio:");
            e.printStackTrace();
        }
	}
}
