import java.io.*;
import java.net.*;

public class Server {
	public static void main(String... args) throws Exception {

		ServerSocket server = new ServerSocket(8080);
		BasicGreetingServiceImpl greeting = new BasicGreetingServiceImpl(); // Tightly coupled; Ochhhhh!
		while (true) {
			System.out.println("Waiting for a client");
			Socket client = server.accept();

			ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
			Object request = ois.readObject();

			if (request instanceof SayHelloRequest) {
				SayHelloRequest hReq = (SayHelloRequest) request;
				System.out.println(greeting.sayHello(hReq.name));
				continue;
			}

			if (request instanceof SayByeRequest) {
				SayByeRequest hReq = (SayByeRequest) request;
				System.out.println(greeting.sayBye());
				continue;
			}
		}
	}
}
