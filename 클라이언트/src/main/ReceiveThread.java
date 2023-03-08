package main;
/*
 * ±Ë¿∫º±
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ReceiveThread extends Thread{
	private Socket socket;
	public ReceiveThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true) {
				String text = bf.readLine();
			}
			
		}catch(SocketException e) {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
