import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZContext;

public class Server2 {
	public static void main(String... args) throws Exception {
		try (ZContext context = new ZContext()) {
			ZMQ.Socket socket = context.createSocket(SocketType.PULL);

			socket.connect("tcp://localhost:5500");

			while (!Thread.currentThread().isInterrupted()) {
				byte[] reply = socket.recv(0);
				System.out.println("Server1: Received " +
						new String(reply, ZMQ.CHARSET));
			}
		}
	}

}
