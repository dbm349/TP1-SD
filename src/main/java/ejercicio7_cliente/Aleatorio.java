package ejercicio7_cliente;

import java.io.Serializable;
import java.util.Random;

import ejercicio7_server.Tarea;

public class Aleatorio implements Tarea<Double>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int cotaSuperior;
	private final int decimales;
	private final boolean negativos;
	
	public Aleatorio (int cotaSuperior, int decimales, boolean negativos) {
		this.cotaSuperior = cotaSuperior;
		this.decimales = decimales;
		this.negativos = negativos;
	}
	
	public Double ejecutar() {
		return calcularRandom(cotaSuperior, decimales, negativos);		
	}

	public static double calcularRandom(int cotaSuperior, int decimales, boolean negativos) {		
		
		//Inicio el seed de randoms
		Random rand = new Random();				
		
		
		//Genera un entero entre 0 (inclusive) y cotaSuperior (exclusive)
		int auxEntero = rand.nextInt(cotaSuperior);
		
			
		
		//Parte decimal
		double auxDecimales = 0;
		if (decimales > 0) {
			auxDecimales = rand.nextDouble();
		}
		
		
		//Sumo parte entera y parte decimal
		double resultado = auxEntero + auxDecimales;
		
		
				
		/*
		 * Toma numero de decimales, eleva a la 10 y usa ese valor para redondear la cantidad de decimales
		 * Ej.	Numero: 0.567890123
		 * 		4 decimales = 4^10 = 10000
		 * 		round(0.567890123 * 10000) / 10000
		 * 		round(5678.90123) / 10000
		 * 		5679 / 10000
		 * 		0.5679
		*/
		if (decimales > 0) {
			double escala = Math.pow(10, decimales); 
			resultado = (Math.round(resultado * escala)) / escala;
		}
				
		
		//Simple pedido de un booleano para definir si numero termina siendo positivo o negativo
		if (negativos) {
			if (rand.nextBoolean())
				resultado = resultado * -1;
		}
		
		
		
		return resultado;
	}

}
