package zadaci;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Zadatak2 {
	
	public static void main(String[] args) throws SocketException {
		
		String s = "Домовина се брани лепотом, и чашћу и знањем. Домовина се брани животом и лепим васпитањем. Домовина се брани цветом, И пчелом на цвету, Маком и сунцокретом,И птицом у лету.";
		// da bismo mogli da napravimo datagram, ne možemo koristiti string, već samo bajtove
		// koristimo utf8 kodiranje da bismo mogli da koristimo ćirilicu
		try {
			byte[] data = s.getBytes("UTF-8");
			try (DatagramSocket socket = new DatagramSocket(0)){
				// ovo je broadcast za "ovu" moju mrežu
				InetAddress ia = InetAddress.getByName("192.168.8.255");
				int port = 7;
				DatagramPacket theOutput = new DatagramPacket(data, data.length, ia, port);
				socket.send(theOutput);
			}
			catch(UnknownHostException e){
				System.err.println("Unkown host: " + e);
			}
			catch (IOException ex) {
				System.err.println("Cant bind to socket.\n: " + ex);
			}
		} catch (UnsupportedEncodingException e1) {
			System.out.println("Unsuported coding.\n" + e1);
		}
		
		
	}

}
