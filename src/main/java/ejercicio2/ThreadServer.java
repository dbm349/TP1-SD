package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ThreadServer implements Runnable{
	Socket cs;
	
	public ThreadServer(Socket cs) {
		this.cs=cs;
	}
	
	public void run(){
		try {
			BufferedReader inFromClient = new BufferedReader (new InputStreamReader (cs.getInputStream()));
			PrintStream outToClient = new PrintStream (cs.getOutputStream(),true);
			
			//Leo mensaje del cliente
			String mensaje = inFromClient.readLine();
			System.out.println("Mensaje del cliente: "+mensaje);
			
			//Reenvio mensaje al cliente
			mensaje = "---"+mensaje+"--- Reenviado desde el servidor";
			outToClient.println(mensaje);
			System.out.println("Mensaje reenviado al cliente");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			cs.close();
			System.out.println("Conexion con el cliente cerrada.");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
