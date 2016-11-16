package tp.twitter;

import java.io.IOException;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class MockTwitter implements Twitter {
	
	@Inject
	private Appendable out;
	
	@Override
	public boolean send(String msg) {
		try {
			out.append("Message send by MockTweeter : " + msg + "\n");
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}
