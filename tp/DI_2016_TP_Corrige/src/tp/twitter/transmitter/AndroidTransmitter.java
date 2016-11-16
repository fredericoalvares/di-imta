package tp.twitter.transmitter;

import java.io.IOException;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class AndroidTransmitter implements Transmitter {

	@Inject
	@Named("AppendableDeAndroid")
	private Appendable out;
	
	@Override
	public void transmitDataPacket(byte[] data) {
		try {
			out.append("iOS is transmitting " + data.length + " bytes\n");
		
			for (int i=0; i < data.length; i=i+32){
				int end = (data.length - i > 32) ? i+32 :  data.length;
				out.append((i+1) + " to " + end + " bytes\n");
			}
		} catch (IOException e) {}
	}

}
