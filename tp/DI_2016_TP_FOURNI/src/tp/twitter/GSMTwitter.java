package tp.twitter;

import java.io.IOException;

public class GSMTwitter implements Twitter {
	
	private Appendable out;

	public GSMTwitter(Appendable out) {
		this.out = out;
	}

	@Override
	public boolean send(String msg) {
		try {
			out.append("Message send by GSMTwitter : " + msg);
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}
