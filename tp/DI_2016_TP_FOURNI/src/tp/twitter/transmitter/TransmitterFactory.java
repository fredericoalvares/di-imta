package tp.twitter.transmitter;

public class TransmitterFactory {
	
	private static Transmitter instance;
	
	public static Transmitter get(){
		if (instance == null){
			instance = new AndroidTransmitter(System.out);
		}
		
		return instance;
	}
	
	
}
