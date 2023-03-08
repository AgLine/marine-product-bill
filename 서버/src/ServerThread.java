/*
 * ±Ë¿∫º±
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	private Socket socket;
	private String name;
	public PrintWriter pw;
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			pw = new PrintWriter(socket.getOutputStream());
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String text;
			while(true) {
				text=input.readLine();
				String[] message = text.split(":");
				if(message.length == 2 && message[0].equals("ID")) {
					for(int i=0;i<1;i++) {
						name = message[1];
						System.out.println(name+"¥‘¿Ã ∑Œ±◊¿Œ «œºÃΩ¿¥œ¥Ÿ.");
						Serverr.threads.get(i).pw.println(message[1]+"¥‘¿Ã ∑Œ±◊¿Œ «œºÃΩ¿¥œ¥Ÿ.");
						Serverr.threads.get(i).pw.flush();
					}
					}else if(message.length == 2 && message[0].equals("LOGOUT")) {
					for(int i=0;i<1;i++) {
						name = message[1];
						System.out.println(name+"¥‘¿Ã ∑Œ±◊æ∆øÙ «œºÃΩ¿¥œ¥Ÿ.");
						Serverr.threads.get(i).pw.println(message[1]+"¥‘¿Ã ∑Œ±◊æ∆øÙ «œºÃΩ¿¥œ¥Ÿ.");
						Serverr.threads.get(i).pw.flush();
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
