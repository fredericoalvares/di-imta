package tp.client;

import tp.login.Login;
import tp.shortener.Shortener;
import tp.twitter.Twitter;

public class TwitterClient {
	private Login loginManager;
	private Shortener shortener;
	private Twitter twitter;
	
	
	public TwitterClient(Login loginManager, 
			 			 Shortener shortener, 
			             Twitter twitter) {
		this.loginManager = loginManager;
		this.shortener = shortener;
		this.twitter = twitter;
		
	}
	

	
	public void post(String msg){
		
		if (!this.loginManager.isLogged()){
			this.loginManager.login();
		}
		
		
		if (msg.length() > 140){
			msg = shortener.shorten(msg);
		}
		
		if (msg.length() <= 140){
			twitter.send(msg);
		}
	}
	

}
