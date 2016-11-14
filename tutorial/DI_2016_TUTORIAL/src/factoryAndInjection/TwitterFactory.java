package factoryAndInjection;

public class TwitterFactory {
	
	private static Twitter instance;
	
	public static Twitter get(){
		if (instance == null){
			instance = new SmsTwitter();
		}
		
		return instance;
	}
	
	public static void set(Twitter twitter){
		instance = twitter;
	}
}
