package tp.twitter;

import tp.twitter.transmitter.Transmitter;
import tp.twitter.transmitter.TransmitterFactory;

public class TwitterFactory {
	
	private static Twitter instance;
	
	public static Twitter get(){
		if (instance == null){
			Transmitter transmitter = TransmitterFactory.get();
			instance = new SmsTwitter(transmitter, System.out);
		}
		
		return instance;
	}
	
	public static void set(Twitter twitter){
		instance = twitter;
	}
}
