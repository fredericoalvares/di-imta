package factoryAndInjection;

public class TwitterClientFactory {
	
	private static TwitterClient instance;
	
	public static TwitterClient get(){
		if (instance != null){
			return instance;
		}
		
		
		Shortener shortener = ShortenerFactory.get();
		Twitter twitter = TwitterFactory.get();
		
		return new TwitterClient(shortener, twitter);
	}
}
