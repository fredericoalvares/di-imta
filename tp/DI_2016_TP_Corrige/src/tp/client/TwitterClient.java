package tp.client;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import tp.login.Login;
import tp.shortener.Shortener;
import tp.twitter.Twitter;

public class TwitterClient {
	@Inject
	private Login loginManager;
	
	@Inject
	private Shortener shortener;
	
	@Inject
	private Twitter twitter;
	
	/*@Inject
	@Named("Twitter2")
	private Twitter twitter2;*/
	
	
	public void post(String msg){
		
		if (!this.loginManager.isLogged()){
			this.loginManager.login();
		}
		
		
		if (msg.length() > 140){
			msg = shortener.shorten(msg);
		}
		
		if (msg.length() <= 140){
			twitter.send(msg);
			/* if(!twitter.send(msg)){
				twitter2.send(msg);
			} */
		}
	}
	

}
