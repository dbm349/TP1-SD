package ejercicio7_cliente;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;



public class Cliente {
	
	
	public static void main(String[] args) {
		boolean  finalizado=false;
		
		while (!finalizado) {	
			
			
			try {
				Registry clientRMI = LocateRegistry.getRegistry("127.0.0.1", 15236);
				String[] services = clientRMI.list();
				for (String service : services) {
					System.out.println("Servicio: " + service);
				}
			} catch (RemoteException e1) {
				System.err.println("Fallo al intentar obtener lista de servicios");
				e1.printStackTrace();
			}			
			
			System.out.println();
			System.out.println();
			System.out.println("---------------Elija tarea a ejecutar---------------");
			System.out.println();
			System.out.println("1. Calcular número aleatorio");
			//TODO: Calcular primo
			System.out.println("2. Calcular un número primo (No implementado)");
			System.out.println("3. Calcular Pi");			
		    System.out.println("0. Salir");
		    System.out.println();
		    System.out.println("Ingrese la opción elegida => ");
			Scanner miScanner = new Scanner(System.in);
			String opcion = miScanner.nextLine();
			
			long tiempoIni = 0;
			long tiempoFin = 0;
			long duracionNano = 0;
			long duracionMili = 0;
			
			
			switch (opcion) {
				case "1" :
					System.out.println();
					System.out.println("---------------Cálculo de número aleatorio---------------");
					System.out.println();
					
					int aux = 0;
					int cotaSuperior = 0;
					
					
					while (cotaSuperior == 0) {
						System.out.println("Ingrese número a usar de cota superior: ");
						try {
							aux = (Integer.parseInt(miScanner.nextLine()));
							if (aux > 0) {
								cotaSuperior = aux;
							} else {
								System.out.println("No es un número natural!");
								System.out.println();
							}
						} catch (Exception e) {
							System.out.println("No es un número natural!");
							System.out.println();
						}						
					}					
										
					aux = 0;
					int decimales = -1;
					
					while (decimales == -1) {
						System.out.println("Ingrese número de dígitos de la parte decimal: ");
						try {
							aux = (Integer.parseInt(miScanner.nextLine()));
							if (aux >= 0) {
								decimales = aux;
							} else {
								System.out.println("No es un número natural o 0!");
								System.out.println();
							}
						} catch (Exception e) {
							System.out.println("No es un número natural o 0!");
							System.out.println();
						}						
					}
					
					boolean inputValido = false;
					boolean negativos = false;
					String neg = "";
					while (!inputValido) {
						System.out.println("¿Desea espejar el rango para incluir negativos? [S/N] ");
						try {
							neg = miScanner.nextLine();
							inputValido = neg.equalsIgnoreCase("S") || neg.equalsIgnoreCase("N");
							if (!inputValido) {
								System.out.println("No es una entrada válida!");
								System.out.println();
							} else {
								if (neg.equalsIgnoreCase("S"))
									negativos = true;
							}
						} catch (Exception e) {
							System.out.println("---Algo se rompio en la entrada de negativos---");
							e.printStackTrace();
						}
					}
					
					//Asigno tiempo de inicio para calcular tiempo entre inicio y fin de proceso
					tiempoIni = System.nanoTime();
					
					//Puerto por defecto 15236		
					CalcularAleatorio aleatorio = new CalcularAleatorio(15236, cotaSuperior, decimales, negativos);
					aleatorio.calculo();
					
					//Asigno tiempo de fin de ejecución para calcular el tiempo tardado
					tiempoFin = System.nanoTime();
					
					//Duracion en nanosegundos. Dividir por 1000000 para obtener milisegundos
					//Dividir por 1000000000 para obtener segundos
					duracionNano = tiempoFin - tiempoIni;
					duracionMili = duracionNano /1000000;
					System.out.println();
					System.out.println("El proceso tardó: " + duracionMili + " milisegundos");
					
					System.out.println();
					System.out.println("Presione Enter para volver al menu");
					System.out.println(miScanner.nextLine());
					System.out.println();					
				break;
				

					
				case "3" :
					System.out.println();
					System.out.println("---------------Cálculo de Pi---------------");					
					int decimalesPi = -1;
					while (decimalesPi < 0) {
						System.out.println();
						System.out.println("Ingrese número de decimales a mostrar: ");
						try {
							int auxPi = (Integer.parseInt(miScanner.nextLine()));
							if (auxPi >= 0) {
								decimalesPi = auxPi;
							} else {
								System.out.println("No es un número natural o 0!");
								System.out.println();
							}
						} catch (Exception e) {
							System.out.println("No es un número natural o 0!");
							System.out.println();
						}						
					}
					
					//Asigno tiempo de inicio para calcular tiempo entre inicio y fin de proceso
					tiempoIni = System.nanoTime();					
					
					//Puerto por defecto 15236
					CalcularPi pi = new CalcularPi(15236, decimalesPi);
					pi.calculo();	
					
					//Asigno tiempo de fin de ejecución para calcular el tiempo tardado
					tiempoFin = System.nanoTime();
					
					//Duracion en nanosegundos. Dividir por 1000000 para obtener milisegundos
					//Dividir por 1000000000 para obtener segundos
					duracionNano = tiempoFin - tiempoIni;
					duracionMili = duracionNano /1000000;
					
					System.out.println();
					System.out.println("El proceso tardó: " + duracionMili + " milisegundos");
					
					System.out.println();
					System.out.println("Presione Enter para volver al menu");
					System.out.println(miScanner.nextLine());
					System.out.println();						
				break;
						
				
				case "0" :
					System.out.println("La ejecución ha finalizado");
					miScanner.close();
					finalizado=true;
				break;
				
							
				default:
					System.out.println("No es una opción válida. Presione Enter para volver al menu");
					System.out.println(miScanner.nextLine());
					System.out.println();						
				}
		}
	}
}
