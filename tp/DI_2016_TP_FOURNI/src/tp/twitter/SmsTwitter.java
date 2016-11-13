package tp.twitter;

import java.io.IOException;

import tp.twitter.transmitter.Transmitter;

public class SmsTwitter implements Twitter {

	private Transmitter transmitter;
	
	private Appendable out;
	
	public SmsTwitter(Transmitter transmitter, Appendable out) {
		this.transmitter = transmitter;
		this.out = out;
	}

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
