package tp.twitter;

import java.io.IOException;

import com.google.inject.Inject;

public class GSMTwitter implements Twitter {
	
	@Inject
	private Appendable out;

	

	@Override
	public boolean send(String msg) {
		try {
			out.append("Message send by GSMTwitter : " + msg + "\n");
			return false;
		} catch (IOException e) {
			return false;
		}
	}

}
