package tp.twitter;

import java.io.IOException;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import tp.twitter.transmitter.Transmitter;

public class SmsTwitter implements Twitter {

	@Inject
	private Transmitter transmitter;
	
	@Inject
	@Named("AppendableDeSms")
	private Appendable out;
	
	

	@Override
	public boolean send(String msg) {
		try {
			out.append("Message sent by SmsTweeter : " + msg + "\n");
			transmitter.transmitDataPacket(msg.getBytes());
			return true;
		} catch (IOException e) {
			return false;
		}
		
		
	}

}
