package ejercicio1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Servidor {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Inicio Servidor en puerto 9000
			ServerSocket ss = new ServerSocket(9000);
			boolean fin = false;
			while (!fin){
				System.out.println("Servidor iniciado en el puerto :"+"9000");
				//Acepto Cliente
				Socket cs = ss.accept();
				System.out.println("Se ha conectado el cliente : "+cs.getInetAddress().getCanonicalHostName()+":"+cs.getLocalPort());
				
				BufferedReader inFromClient = new BufferedReader (new InputStreamReader (cs.getInputStream()));
				PrintStream outToClient = new PrintStream (cs.getOutputStream(),true);
				
				//Se recibe mensaje desde el cliente
				String mensaje = inFromClient.readLine();
				System.out.println("Mensaje del cliente: "+mensaje);
				
				//Se muesta el mensaje en el servidor y se reenvia al cliente
				mensaje = "---"+mensaje+"--- Reenviado desde el servidor";
				outToClient.println(mensaje);
				
				System.out.println("Mensaje reenviado al cliente");
				//Cierro conexion del cliente
				cs.close();
				System.out.println("Conexion con el cliente cerrada.");
				
				int opc = 0;
				
				do{
				try {
					System.out.println("Ingrese opcion ");
					System.out.println("1- Seguir escuchando.");
					System.out.println("2- Salir");
					Scanner scan = new Scanner(System.in);
					opc = scan.nextInt();	
				}catch (InputMismatchException ex) {
		            System.out.println("Error!");
		        }
					switch (opc) {
					case 1:
						break;
					case 2:
						fin=true;
						System.out.println("Servidor finalizado");
						break;
					default:
						System.out.println("Debe ingresar una opcion valida");
						break;
					}
				}while ((opc!=1)&&(opc!=2));
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
