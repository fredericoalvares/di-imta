package tp.twitter.transmitter;

import java.io.IOException;

public class IosTransmitter implements Transmitter {
	
	private Appendable out;
	
	public IosTransmitter(Appendable out) {
		this.out = out;
	}

	@Override
	public void transmitDataPacket(byte[] data) {
		try {
			out.append("iOS is transmitting " + data.length + " bytes");
		
			for (int i=0; i < data.length; i=i+16){
				int end = (data.length - i > 16) ? i+16 :  data.length;
				out.append(i + " to " + end + " bytes");
			}
		} catch (IOException e) {}
	}

}
