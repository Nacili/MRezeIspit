package zadaci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Zadatak4a {

	public static void main(String[] args) {
		
		String address = "https://petlja.org/biblioteka/r/Problems/BBC3-F-panuql";
		
//		System.getProperties().put("proxyHost", "proxy.rcub.bg.ac.rs");
//		System.getProperties().put("proxyPort", "8080");
		
		try {
			URL url = new URL(address);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
			String inputLine;
			while((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}
			in.close();
		}
		catch(MalformedURLException e) {
			
		}
		catch (IOException e) {
			
		}

	}

}
