// Napisati mrežni program koji se povezuje na server https://petlja.org/, upucuje GET zahtev.
// Server potom obrađuje GET zahtev i ispisuje rezultat obrade zahteva na standardni izlaz u zasebnim redovima (u formatu koji je čitljiv ljudskom oku).

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class zad3 {

	public static void main(String[] args) {

		int port = 443; // - default https port
		String host = "petlja.org";

		try {
			SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
			SSLSocket socket = (SSLSocket) factory.createSocket(host, port);

			String[] supported = socket.getSupportedCipherSuites();
			socket.setEnabledCipherSuites(supported);

			Writer out = new OutputStreamWriter(socket.getOutputStream());

			out.write("GET http://" + host + "/ HTTP/1.1\r\n");
			out.flush();
			out.write("Host: " + host + "\r\n");
			out.flush();
			out.write("\r\n");
			out.flush();

			// read response
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// read the header
			String s;
			while (!(s = in.readLine()).equals("")) {
				System.out.println(s);
			}

			System.out.println();

			// read the length
			String contentLength = in.readLine();
			int length = Integer.MAX_VALUE;
			try {
				length = Integer.parseInt(contentLength.trim(), 16);
			} catch (NumberFormatException e) {

			}

			System.out.println(contentLength);

			int c;
			int i = 0;

			while ((c = in.read()) != -1 && i++ < length) {
				System.out.write(c);
			}

			System.out.println();

			out.close();
			in.close();
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
