package ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class HilosServidor implements Runnable {
	Socket cliente;
	private ArrayList<String> colaDeMensajes;
	
	public HilosServidor(Socket cliente,ArrayList<String> colaDeMensajes) {
		this.cliente=cliente;
		this.colaDeMensajes=colaDeMensajes;
	}
	
	public void run() {
		try {
			ArrayList<String> Eliminar = new ArrayList<String>();
			BufferedReader entrada = new BufferedReader (new InputStreamReader (this.cliente.getInputStream()));
			PrintStream salida = new PrintStream (this.cliente.getOutputStream(),true);
			while (!cliente.isClosed()) {
				String opcion = entrada.readLine();
				
				if (opcion.substring(opcion.indexOf("|")+1, opcion.length()).equals("SEND")) {
					//Leo del cliente y guardo en la cola
					colaDeMensajes.add(entrada.readLine());
				}else if (opcion.substring(opcion.indexOf("|")+1, opcion.length()).equals("RECV")) {
					//Extraigo el ID del cliente que realiza la peticion
					String srcId = opcion.substring(0, opcion.indexOf("|"));
					if (!this.colaDeMensajes.isEmpty()) {
						for (String str : colaDeMensajes) {
							//Recorro la cola y comparo el ID del cliente con los destinos de los mensajes
							//Envio mensaje al cliente si es igual
							String destinoID = str.substring(0, str.indexOf("|"));
							String MsgSEND = str.substring(str.indexOf("|")+1, str.length());
							if (destinoID.equals(srcId)) {
								salida.println(MsgSEND);
								
								String ack = entrada.readLine();
								String subAck = (ack.substring(ack.indexOf("|")+1, ack.length()));
								if (subAck.equals("ACK")) {
									//Si cliente confirma lectura, se agrega a cola para eliminar
									Eliminar.add(str);
								}
								System.out.println("Mensaje leido: "+MsgSEND);
							}
						
						}
					}
					String Final = "No.mas.mensajes.";
					salida.println(Final);	
					System.out.println("Fin de mensajes");
				}
				//Se eliminan de la cola los mensajes marcados
				for (String string : Eliminar) {
					colaDeMensajes.remove(string);
				}
			}
			this.cliente.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	

