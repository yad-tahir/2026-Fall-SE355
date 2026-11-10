import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZContext;

public class Client {
	public static void main(String... args) throws Exception {
		try (ZContext context = new ZContext()) {

			ZMQ.Socket socket = context.createSocket(SocketType.PUSH);

			socket.connect("tcp://127.0.0.1:5500");
			socket.connect("tcp://127.0.0.1:5501");

			int counter = 0;

			while (!Thread.currentThread().isInterrupted()) {
				String request = "Hello " + counter++;
				System.out.println("Sending " + request);
				socket.send(request.getBytes(ZMQ.CHARSET), 0);
				Thread.sleep(1000);
			}
		}

	}

}
