package tp.twitter.transmitter;

import java.io.IOException;

import com.google.inject.Inject;

public class IosTransmitter implements Transmitter {
	
	@Inject
	private Appendable out;
	
	@Override
	public void transmitDataPacket(byte[] data) {
		try {
			out.append("iOS is transmitting " + data.length + " bytes\n");
		
			for (int i=0; i < data.length; i=i+16){
				int end = (data.length - i > 16) ? i+16 :  data.length;
				out.append((i+1) + " to " + end + " bytes\n");
			}
		} catch (IOException e) {}
	}

}
