package ejercicio6;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;
import java.util.Scanner;


public class Cliente {
	
	public static void main(String[] args) {
	
		try {
			Registry ClienteRMI = LocateRegistry.getRegistry("127.0.0.1", 9999);
			String[] services=ClienteRMI.list();
		
			
			for (String service : services) {
				System.out.println("Servicio: " +service);
				
			}
			
			RemoteInt ri= (RemoteInt) ClienteRMI.lookup("Operaciones");
			
			 Random aleatorio= new Random();
			 int vector1[]= new int [9];
			 int vector2[]= new int[9];
			 int VectorAux[];
			 

				for(int x=0;x<=8;x++){
	                vector1[x]=(aleatorio.nextInt(50));
	                vector2[x]=(aleatorio.nextInt(50));	  	
	            }
	
			int valido=0;
			
			do {
				
				
				System.out.println();
	System.out.println("===============¿Que desea hacer?===============");
				System.out.println();
				    System.out.println("1.Sumar vectores");
			        System.out.println("2.Restar vectores");
			        System.out.println("3.Salir");
			        System.out.println();
			        System.out.println("Ingrese la opción elegida => ");
					Scanner miScanner = new Scanner(System.in);
					String opcion = miScanner.nextLine();
					
					
					switch (opcion) {
						
						case "1" : 
							    mostrarVectores(vector1,vector2 );
								System.out.println("-------------------------------------------");
								VectorAux=ri.SumaV(vector1, vector2);
								System.out.println("Resultado: ");
								mostrarResultado(VectorAux);
								System.out.println(); 
								break;
									
						case "2" :
								mostrarVectores(vector1,vector2 );
								System.out.println("-------------------------------------------");
								VectorAux=ri.RestaV(vector1, vector2);
								System.out.println("Resultado: ");
								mostrarResultado(VectorAux);
								System.out.println();
								break;
								
						case "3" :
								System.out.println("La ejecución ha finalizado"); 
								valido=1;
								break;
								
						default:
							System.out.println("¡ERROR AL ELEGIR UNA OPCION DEL MENU, INTENTE NUEVAMENTE!");
							System.out.println();
							
					}
				}while(valido!=1);
		    
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}
	
	
	
	public static void mostrarVectores(int vector1[], int vector2[]) {
		System.out.println("Vectores");
		
		for(int x=0;x<=8;x++){
            System.out.println("v1:"+x+"="+vector1[x]+"  v2:"+x+"="+vector2[x]);	  	
        }

	}

	
	public static void mostrarResultado(int vector[]) {
		
		for(int x=0;x<=8;x++){
            System.out.println("v:"+x+"="+vector[x]);	  	
        }
	}
	
	

}

