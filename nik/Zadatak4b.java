import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Zadatak4b {
public static void main(String[] args) {
		
        String urla = "https://petljamediastorage.blob.core.windows.net/root/Media/Default/Problem/BCup3-Problem F Panuql.pdf";
        String urlb = "https://petljamediastorage.blob.core.windows.net/root/Media/Default/Problem/BCup3-Problem%20F%20Panuql.pdf";
        String decodeURLa = decode(urla);
        String decodeURLb = decode(urlb);
      String encodeURLa = encode(urla); 
      String encodeURLb = encode(urlb); 
        try {
			URL url1 = new URL(urla);
			String file1 = url1.getFile();
			URL url2 = new URL(decodeURLb);
			String file2 = url2.getFile();
			if(file1.equals(file2)) {
				System.out.println("DA");
			}
			else{
				System.out.println("NE");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String encode(String url2) {
		
		
		try {
			String encodeURL = URLEncoder.encode(url2, "UTF-8");
			return encodeURL;
		} catch (UnsupportedEncodingException e) {
			return "Greska enkodiranja";
		}
	}

	private static String decode(String url) {
		
		String prevURL = "";
		String decodeURL = url;
		try {
			while(!prevURL.equals(decodeURL)) {
				prevURL = decodeURL;
					decodeURL = URLDecoder.decode(decodeURL, "UTF-8");
				}
			return decodeURL;
		}
		catch (UnsupportedEncodingException e) {
				return "Greska prilikom dekodiranja";
			}
	}

}
