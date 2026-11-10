import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZContext;
import java.io.*;

public class Client {
	public static void main(String... args) throws Exception {
		try (ZContext context = new ZContext()) {

			ZMQ.Socket socket = context.createSocket(SocketType.PUSH);

			socket.bind("tcp://127.0.0.1:5500");
			// socket.connect("tcp://127.0.0.1:5501");

			int counter = 0;

			while (!Thread.currentThread().isInterrupted()) {
				String request = "Hello " + counter++;
				System.out.println("Sending " + request);
				// byte[]
				ByteArrayOutputStream os = new ByteArrayOutputStream();

				DataOutputStream dos = new DataOutputStream(os);
				dos.writeFloat(1.1f);

				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(object);

				socket.send(os.toByteArray());
				// socket.send(request.getBytes(ZMQ.CHARSET), 0);
				Thread.sleep(1000);
			}
		}

	}

}
