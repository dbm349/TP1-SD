package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Servidor {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = new ServerSocket(9000);
			//Servidor iniciado
			System.out.println("Servidor iniciado en el puerto :"+"9000");
			boolean fin = false;
			while (!fin){
				Socket cs = ss.accept();
				System.out.println("Se ha conectado el cliente : "+cs.getInetAddress().getCanonicalHostName()+":"+cs.getLocalPort());
				
				//Creo Hilo
				ThreadServer ts = new ThreadServer(cs);
				Thread tsThread = new Thread (ts);
				tsThread.start();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
