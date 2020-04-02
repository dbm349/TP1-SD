package ejercicio3;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class Servidor {
	int port;
	private ArrayList<String> colaDeMensajes;
	
	public Servidor(int port) {
		this.port=port;
		this.colaDeMensajes= new ArrayList<String>();
		this.StartServer();
	}

	public void StartServer() {
		try {
			ServerSocket ss = new ServerSocket(port);
			//Servidor Escuchando puerto ingresado
			System.out.println("---Servidor iniciado, escuchando en puerto "+port+"---");
			while (true) {
				Socket cliente = ss.accept();
				System.out.println("Cliente conectado: "+cliente.getInetAddress().getCanonicalHostName()+" : "+cliente.getPort());
				HiloServidor hs = new HiloServidor(cliente,colaDeMensajes);
				Thread HSthread = new Thread(hs);
				HSthread.start();
			}
		} catch (IOException e) {
			System.out.println("Puerto en uso");
		}
	}
	
	public static void main(String[] args) {
		//Para el ejemplo utilizo puerto 6000
		Servidor servidor = new Servidor(6000);
	}

}
