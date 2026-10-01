import java.io.*;
import java.net.*;

public class Client {
	public static void main(String... args) {
		Socket socket = null;

		try {
			socket = new Socket("dict.org", 2628);
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter writer = new OutputStreamWriter(out, "UTF8");

			InputStream in = socket.getInputStream();
			InputStreamReader reader = new InputStreamReader(in);

			writer.write("DEFINE english book \r\n");
			writer.flush();

			int c;
			while ((c = reader.read()) != -1) {
				System.out.print((char) c);
			}

			System.out.println();

		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
}
