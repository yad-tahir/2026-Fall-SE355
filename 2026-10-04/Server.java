import java.io.*;
import java.net.*;

public class Server {
	public static void main(String... args) {

		try {
			ServerSocket server = new ServerSocket(5000);
			while (true) {

				Socket client = server.accept();
				ClientHandler handler = new ClientHandler(client);
				// handler.run();
				handler.start();

			}

		} catch (IOException ex) {
			System.err.println(ex);
		}

	}
}

class ClientHandler extends Thread {

	private Socket socket;

	public ClientHandler(Socket connection) {
		this.socket = connection;
	}

	public void run() {
		try {
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter writer = new OutputStreamWriter(out, "UTF8");
			for (int i = 0; true; i++) {
				writer.write("Hello SE355 " + i + "\n");
				writer.flush();
			}
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
}
