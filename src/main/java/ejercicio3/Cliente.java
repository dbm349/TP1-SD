package ejercicio3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Cliente {
	static String clienteIP="localhost";
	static int puerto=6000;
	static Scanner scanner = new Scanner(System.in);
	private int clienteID;
	private static Socket cs;

	public Cliente(int id, String clienteIP, int puerto) throws UnknownHostException, IOException {
		this.clienteID=id;
		this.cs= new Socket(clienteIP, puerto);	
	}	
	
	public void Escribir(int DestID, String msg) throws IOException {
		PrintStream salida = new PrintStream (cs.getOutputStream(),true);
		String msgCompleto = new String();
		msgCompleto = String.valueOf(DestID) + "|" + msg ;
		salida.println(msgCompleto);
	}
	
	public void Escribir(String msg) throws IOException {
		PrintStream salida = new PrintStream (cs.getOutputStream(),true);
		String msgCompleto = new String();
		msgCompleto = String.valueOf(this.clienteID) + "|" + msg ;
		salida.println(msgCompleto);
	}
	
	
	public static void EnviarMensaje(Cliente cliente) throws IOException{
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingresar ID de destino");
		int DestinoID = scanner.nextInt();
		
		System.out.println("Ingrese el mensaje: ");
		String mensaje = scan.nextLine();
	
		if (mensaje == null) { 
			System.err.println("Debe ingresar un mensaje.");
		}else{
			cliente.Escribir("SEND");
			cliente.Escribir(DestinoID, mensaje);
			System.out.println("Mensaje Enviado");
		}
	}
	

	public static void LeerMensaje(Cliente cliente) throws IOException{
		BufferedReader entrada = new BufferedReader (new InputStreamReader(cs.getInputStream()));
		if (cliente != null) {
			cliente.Escribir("RECV");
			String msg = entrada.readLine();
			int c = 1;
			while(!msg.equals("No.mas.mensajes.")) {
				System.out.println("---- MENSAJE " + c + "----");
				System.out.println(msg);
				msg = entrada.readLine();
				c++;
			}
			if (c > 1) {
				System.out.println("[!] No hay mas mensajes.");
			}else{
				System.out.println("[!] No hay mensajes.");
			}
		}
	}
	

	public static void main(String[] args) throws UnknownHostException, IOException{
		System.out.print("Ingrese el ID del nuevo cliente -> ");
		while ((!scanner.hasNextInt())) {
			scanner.next();
		}
		int c = scanner.nextInt();
		Cliente cliente = new Cliente(c,clienteIP,puerto);
		
		int opc = 0;
		while(opc!=3) {
			System.out.println();
			System.out.println("Bandeja del Cliente ID: " + cliente.clienteID);
			System.out.println("1- Enviar un mensaje a un cliente.");
			System.out.println("2- Leer mensajes");
			System.out.println("3- Salir.");
			System.out.println();
			opc = scanner.nextInt();
			
			if (opc==1) {
				cliente.EnviarMensaje(cliente);
			}else if (opc==2){
				cliente.LeerMensaje(cliente);
			}else if (opc==3) {
				System.out.println("Adios");
			}else {
				System.out.println("Ingrese una opcion valida");
			}
		}
	}
}
