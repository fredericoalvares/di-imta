package tp.twitter;

import java.io.IOException;

public class MockTwitter implements Twitter {
	
	private Appendable out;
	
	public MockTwitter(Appendable out) {
		this.out = out;
	}

	@Override
	public boolean send(String msg) {
		try {
			out.append("Message send by MockTweeter : " + msg);
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}
