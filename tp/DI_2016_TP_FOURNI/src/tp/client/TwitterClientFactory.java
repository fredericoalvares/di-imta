package tp.client;

import tp.login.Login;
import tp.login.LoginFactory;
import tp.shortener.Shortener;
import tp.shortener.ShortenerFactory;
import tp.twitter.Twitter;
import tp.twitter.TwitterFactory;

public class TwitterClientFactory {
	
	private static TwitterClient instance;
	
	public static TwitterClient get(){
		if (instance != null){
			return instance;
		}
		
		Login loginManager = LoginFactory.get();
		Shortener shortener = ShortenerFactory.create();
		Twitter twitter = TwitterFactory.get();
		
		
		return new TwitterClient(loginManager, 
				shortener, twitter);
	}
}
