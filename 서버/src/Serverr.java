/*
 * ±Ë¿∫º±
 */
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Serverr {	
	public static ArrayList<ServerThread> threads = new ArrayList<ServerThread>();
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8850);
			while(true) {
				Socket socket = serverSocket.accept();
				ServerThread thread = new ServerThread(socket);
				threads.add(thread);
				thread.start();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
