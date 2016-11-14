package injectionWithGuice;

import com.google.inject.Inject;

public class TwitterClient {
	@Inject
	private Shortener shortener;
	
	@Inject
	private Twitter twitter;
	
	
	/*public TwitterClient(Shortener shortener, Twitter twitter) {
		this.shortener = shortener;
		this.twitter = twitter;
	}*/



	public void post(String msg){
		if (msg.length() > 140){
			msg = shortener.shorten(msg);
		}
		
		if (msg.length() <= 140){
			twitter.send(msg);
		}
	}
	

}
