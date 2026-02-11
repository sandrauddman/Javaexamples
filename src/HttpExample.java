package src;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.time.Duration;

public class HttpExample {
	
	public static void main(String args[] ) {
		
		String apiKey="dd2482985dd04517bfbabfd816908213";
		String url= "https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey="+ apiKey;
		
		HttpClient client= HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
				.connectTimeout(Duration.ofSeconds(10)).build();
		
		HttpRequest req = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
				
		try {
			HttpResponse<String> response=	client.send(req, HttpResponse.BodyHandlers.ofString());
			System.out.println("Response"+response);
			String reBody= response.body();
			System.out.println("body of response");
			System.out.println(reBody);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
