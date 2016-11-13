package tp.twitter.transmitter;

import java.io.IOException;

public class AndroidTransmitter implements Transmitter {

	private Appendable out;
	
	public AndroidTransmitter(Appendable out) {
		this.out = out;
	}
	
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
