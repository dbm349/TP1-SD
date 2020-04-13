package ejercicio1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
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
					String [] numerosIP = IP.split("\\.");
					if (numerosIP.length==4) {
						esIP=true;
						for(String S:numerosIP) {
							if(Integer.parseInt(S)>255 || Integer.parseInt(S)<0) {
								esIP=false;
							}
						}
						if(!esIP) {
							System.out.println("La direccion IP ingresada no es valida");
						}
					}else {
						System.out.println("La direccion ingresada no es una IP");
					}
				}		
		}
		boolean portValidate = false;
		String port = "";
		int numPuerto = 0;
		while(!portValidate) {
			scanner = new Scanner(System.in);
			System.out.println("Ingrese puerto");//9000 para este ejemplo
			port = scanner.nextLine();
			try {
				numPuerto = Integer.parseInt(port);
				portValidate = true;
			} catch (Exception e) {
				System.out.println("Ingrese un numero de puerto valido");
			}
		}
		
		try {
			Socket cs = new Socket(IP,numPuerto);
			
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			PrintStream outToServer = new PrintStream(cs.getOutputStream());
			
			
			System.out.println("Cliente Iniciado");
			System.out.println("Ingresar Mensaje");
			Scanner scannerMsj = new Scanner(System.in);
			String mensaje =  scannerMsj.nextLine(); 
			//Envio el mensaje ingresado al servidor
			outToServer.println(mensaje);
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
