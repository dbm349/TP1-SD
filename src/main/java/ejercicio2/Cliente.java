package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner;
		boolean esIP = false;
		String IP = new String();

		while (!esIP) {
			scanner = new Scanner(System.in);
			System.out.println("Ingresar direccion del servidor (IP o localhost)");
			IP = scanner.nextLine();
				if (IP.equals("localhost")) {
					esIP=true;
				}else{
					String [] numerosIP = IP.split(".");
					if (numerosIP.length==4) {
						esIP=true;
					}else {
						System.out.println("La direccion ingresada no es una IP");
					}
				}		
		}
		scanner = new Scanner(System.in);
		System.out.println("Ingrese puerto");
		int port = scanner.nextInt();
	
		
		try {
			Socket cs = new Socket(IP,port);//Establecida la conexion
			int numCli = (int)(Math.random() * 1000) + 1; //Genero un identificador random de cliente para el ejemplo
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			PrintStream outToServer = new PrintStream(cs.getOutputStream());
			
			System.out.println("Cliente Iniciado");
			System.out.println("Ingresar Mensaje");
			Scanner scannerMsj = new Scanner(System.in);
			String mensaje =  scannerMsj.nextLine(); 
			mensaje = mensaje+" -Desde Cliente Nro: "+Integer.toString(numCli);
			outToServer.println(mensaje); //Envio el mensaje con el identificador ingresado al servidor
			System.out.println ("----Mensaje enviado----");
			
			//Recibo respuesta del servidor
			String respuestaServ = inFromServer.readLine();
			System.out.println("");
			System.out.println("Mensaje recibido del servidor:");
			System.out.println(respuestaServ);
			
			//Cierro
			cs.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
