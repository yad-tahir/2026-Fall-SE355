import java.net.*;
import java.io.*;

public class Client1 {
	public static void main(String... args) throws Exception {

		Socket toServer = new Socket("127.0.0.1", 8080);
		ObjectOutputStream oos = new ObjectOutputStream(toServer.getOutputStream());

		SayHelloRequest req = new SayHelloRequest();
		req.name = "Tara";

		oos.writeObject(req);
		oos.flush();
	}
}
