package tp.shortener.connection;

import java.io.IOException;

import com.google.inject.Inject;

public class RestConnection implements Connection {

	private String url = "http://ti.ny/rest";
	
	@Inject
	private Appendable out;
	
	

	@Override
	public String sendMessage(String msg) {
		String response;
		
		try {
			out.append("[REST] Connecting to "+url+"\n");
			out.append("[REST] Shortening message\n");
			String link = "http://ti.ny/fix";
			response = msg.substring(0, 135 - link.length()).concat("... " + link);
		} catch (IOException e) {
			response = e.getMessage();
		}
		
		return response;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
