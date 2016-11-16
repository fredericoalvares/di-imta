package tp.shortener.connection;

import java.io.IOException;

import com.google.inject.Inject;

public class SoapConnection implements Connection {

	private String url = "http://ti.ny/soap";
	
	private Appendable out;
	
	
	@Inject
	public SoapConnection(Appendable out) {
		this.out = out;
	}

	@Override
	public String sendMessage(String msg) {
		String response;
		
		try {
			out.append("[SOAP] Connecting to "+url+"\n");
			out.append("[SOAP] Shortening message\n");
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
