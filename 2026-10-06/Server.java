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

		} catch (Exception ex) {
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
			int x = 100;

			Student s1 = new Student();
			s1.id = 100;
			s1.name = "Sara";
			s1.gpa = 3.4f;

			var oos = new ObjectOutputStream(out);
			oos.writeObject(s1);

			var ois = new ObjectInputStream(socket.getInputStream());

			Object o = ois.readObject();
			if (o instanceof Student) {
				Student s = (Student) o;
				System.out.println(s.id);
				System.out.println(s.name);
			} else {
			}

			// DataOutputStream dos = new DataOutputStream(out);
			// dos.writeInt(x);
			// dos.writeLong(-100);

			// OutputStreamWriter writer = new OutputStreamWriter(out, "UTF8");
			// for (int i = 0; true; i++) {
			// writer.write("Hello SE355 " + i + "\n");
			// writer.flush();
			// }
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
}

class Student implements Serializable {
	int id;
	String name;
	float gpa;
	int[] courses = new int[10];
	Dept dept;
}

class Dept implements Serializable {
	String name;
	String chairName;
}
